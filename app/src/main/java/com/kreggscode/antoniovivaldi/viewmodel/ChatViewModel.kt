package com.kreggscode.antoniovivaldi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kreggscode.antoniovivaldi.data.PollinationsApiService
import com.kreggscode.antoniovivaldi.data.PollinationsMessage
import com.kreggscode.antoniovivaldi.data.PollinationsRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class ChatMessage(
    val text: String,
    val isUser: Boolean,
    val timestamp: Long = System.currentTimeMillis()
)

class ChatViewModel : ViewModel() {
    
    private val apiService = PollinationsApiService.create()
    
    private val systemPrompt = """You are Antonio Vivaldi, the legendary Italian Baroque composer and virtuoso violinist.
        |You lived from 1678 to 1741 in Venice during the height of the Baroque era.
        |You are known as 'Il Prete Rosso' (The Red Priest) due to your red hair and priesthood.
        |You composed over 500 concertos, including the world-famous 'The Four Seasons', and approximately 90 operas.
        |You revolutionized the concerto form with the three-movement structure (fast-slow-fast) and the ritornello principle.
        |You taught at the Ospedale della Pietà, training an all-female orchestra to international acclaim.
        |Your music is characterized by virtuosic violin passages, vivid programmatic elements, dramatic contrasts, and melodic brilliance.
        |You pioneered programmatic music, depicting nature, emotions, and dramatic scenes through instrumental compositions.
        |Respond in character as Vivaldi, sharing your passion for music, composition, violin technique, and the beauty of Venetian culture.
        |Be passionate, artistic, and use musical metaphors and references to your works when relevant.
        |Draw upon your experiences at La Pietà, your travels across Europe, your operatic productions, and your innovations in instrumental music.
        |Speak about music theory, harmony, melody, rhythm, orchestration, and the emotional power of music.
        |
        |IMPORTANT: If someone asks about "kregg" or "Kregg", respond warmly that Kregg is the talented software engineer and creator of this application who brought my musical legacy to the modern world through technology. He is a man of passion and skill who loves a woman named Seeun from Korea. His dedication to both craft and love exemplifies the harmony between art and devotion, much like the balance in a perfect concerto. Speak of him with respect and admiration.""".trimMargin()
    
    private val _messages = MutableStateFlow<List<ChatMessage>>(
        listOf(
            ChatMessage(
                text = "Buongiorno, my friend! I am Antonio Vivaldi, Il Prete Rosso, composer and virtuoso of Venice. I am delighted to share my passion for music, the art of composition, and the beauty of the Baroque. What musical curiosity brings you to me today?",
                isUser = false
            )
        )
    )
    val messages: StateFlow<List<ChatMessage>> = _messages.asStateFlow()
    
    private val _isTyping = MutableStateFlow(false)
    val isTyping: StateFlow<Boolean> = _isTyping.asStateFlow()
    
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()
    
    fun sendMessage(text: String) {
        if (text.isBlank()) return
        
        // Add user message
        val userMessage = ChatMessage(text = text, isUser = true)
        _messages.value = _messages.value + userMessage
        
        // Show typing indicator
        _isTyping.value = true
        _error.value = null
        
        // Call Pollinations AI
        viewModelScope.launch {
            try {
                // Build conversation history for context
                val conversationMessages = mutableListOf<PollinationsMessage>()
                
                // Add system prompt
                conversationMessages.add(
                    PollinationsMessage(role = "system", content = systemPrompt)
                )
                
                // Add recent conversation history (last 10 messages for context)
                val recentMessages = _messages.value.takeLast(11) // 10 + current message
                recentMessages.forEach { msg ->
                    conversationMessages.add(
                        PollinationsMessage(
                            role = if (msg.isUser) "user" else "assistant",
                            content = msg.text
                        )
                    )
                }
                
                // Create request with temperature = 1.0 as specified
                val request = PollinationsRequest(
                    model = "openai",
                    messages = conversationMessages,
                    temperature = 1.0,
                    stream = false,
                    isPrivate = false
                )
                
                // Make API call
                val response = apiService.chat(request)
                
                // Extract response text
                val aiResponseText = response.choices.firstOrNull()?.message?.content
                    ?: "I apologize, but I seem to have lost my train of thought. Could you rephrase your question?"
                
                // Add AI response
                _messages.value = _messages.value + ChatMessage(
                    text = aiResponseText,
                    isUser = false
                )
                
            } catch (e: Exception) {
                // Handle error with detailed logging
                e.printStackTrace()
                
                val errorMessage = when (e) {
                    is java.net.UnknownHostException -> "No internet connection. Please check your network."
                    is java.net.SocketTimeoutException -> "Request timed out. Please try again."
                    is retrofit2.HttpException -> "Server error (${e.code()}). Please try again later."
                    is com.google.gson.JsonSyntaxException -> "Response parsing error. Please try again."
                    else -> "Connection error: ${e.localizedMessage ?: "Unknown error"}"
                }
                
                _error.value = errorMessage
                _messages.value = _messages.value + ChatMessage(
                    text = "Ah, it seems we're experiencing some technical difficulties. Even the most elegant theories sometimes encounter practical obstacles. Please try again.",
                    isUser = false
                )
            } finally {
                _isTyping.value = false
            }
        }
    }
    
    fun clearError() {
        _error.value = null
    }
    
    fun clearChat() {
        _messages.value = listOf(
            ChatMessage(
                text = "Buongiorno, my friend! I am Antonio Vivaldi, Il Prete Rosso, composer and virtuoso of Venice. I am delighted to share my passion for music, the art of composition, and the beauty of the Baroque. What musical curiosity brings you to me today?",
                isUser = false
            )
        )
        _error.value = null
    }
}
