# 🎻 Antonio Vivaldi AI

<div align="center">

![Antonio Vivaldi AI](https://img.shields.io/badge/Antonio%20Vivaldi-AI%20Companion-8B5CF6?style=for-the-badge&logo=music&logoColor=white)
![Platform](https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-100%25-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-Modern%20UI-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)

**Experience the genius of Antonio Vivaldi through AI-powered conversations and explore the masterpieces of the Baroque era**

[Download on Google Play](https://play.google.com/store/apps/details?id=com.kreggscode.antoniovivaldi) • [Documentation](./docs) • [Report Bug](https://github.com/kreggscode/Antonio-Vivaldi-Ai/issues)

</div>

---

## 📖 About

**Antonio Vivaldi AI** is a premium Android application that brings the legendary Baroque composer Antonio Vivaldi to life through artificial intelligence. Explore his masterworks, learn about his life and innovations, chat with an AI embodiment of the Red Priest himself, and immerse yourself in the beauty of Baroque music.

### ✨ Key Features

- 🤖 **AI Chat with Vivaldi** - Converse with an AI-powered Antonio Vivaldi about music, composition, and the Baroque era
- 🎼 **Comprehensive Biography** - Explore Vivaldi's life from Venice to Vienna
- 🎻 **Major Works** - Deep dive into The Four Seasons, Gloria, L'estro armonico, and more
- 📜 **Historical Letters** - Read Vivaldi's correspondence and personal writings
- 📚 **Musical Essays** - Learn about concerto form, programmatic music, and Venetian style
- 💭 **Daily Affirmations** - Musical wisdom and inspiration from Vivaldi
- ⭐ **Favorites System** - Save and organize your favorite quotes and insights
- 🌙 **Dark Mode** - Beautiful glassmorphic UI with dark theme support
- 🔔 **Daily Notifications** - Receive musical inspiration every day

---

## 🎨 Design Philosophy

Antonio Vivaldi AI features a **premium glassmorphic design** inspired by Baroque aesthetics and modern Material Design 3 principles:

- **Color Palette**: Indigo (#6366F1) → Purple (#8B5CF6) → Pink (#EC4899) gradients
- **Glassmorphic UI**: Frosted glass effects with blur and transparency
- **Smooth Animations**: Spring physics and 400ms transitions
- **Edge-to-Edge**: Immersive full-screen experience
- **Premium Components**: Custom-designed cards, buttons, and navigation

---

## 🛠️ Technical Stack

### Architecture
- **MVVM Pattern** - Clean separation of concerns
- **Jetpack Compose** - Modern declarative UI
- **Kotlin Coroutines** - Asynchronous programming
- **StateFlow** - Reactive state management

### Key Technologies
- **Kotlin** 2.2.10
- **Jetpack Compose** BOM 2025.10.00
- **Material Design 3** - Modern UI components
- **Room Database** - Local data persistence
- **DataStore** - Preferences management
- **WorkManager** - Background task scheduling
- **Retrofit** - REST API communication
- **OkHttp** - HTTP client
- **Gson** - JSON parsing
- **KSP** - Kotlin Symbol Processing

### AI Integration
- **Pollinations AI** - OpenAI-compatible API
- **Temperature**: 1.0 for balanced creativity
- **System Prompt**: Specialized for Antonio Vivaldi persona
- **Context-Aware**: Maintains conversation history

---

## 📱 Screenshots

<div align="center">

| Home Screen | Chat with Vivaldi | Works Explorer | Biography |
|------------|-------------------|----------------|-----------|
| ![Home](screenshots/home.png) | ![Chat](screenshots/chat.png) | ![Works](screenshots/works.png) | ![Bio](screenshots/bio.png) |

</div>

---

## 🚀 Getting Started

### Prerequisites
- Android Studio Hedgehog or later
- Android SDK 26+ (Android 8.0 Oreo)
- Kotlin 2.2.10
- Gradle 8.x

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/kreggscode/Antonio-Vivaldi-Ai.git
   cd Antonio-Vivaldi-Ai
   ```

2. **Open in Android Studio**
   - Open Android Studio
   - Select "Open an Existing Project"
   - Navigate to the cloned directory

3. **Build the project**
   ```bash
   ./gradlew build
   ```

4. **Run on device/emulator**
   - Connect an Android device or start an emulator
   - Click "Run" in Android Studio or use:
   ```bash
   ./gradlew installDebug
   ```

---

## 📦 Project Structure

```
Antonio-Vivaldi-Ai/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/kreggscode/antoniovivaldi/
│   │   │   │   ├── data/              # Data layer
│   │   │   │   │   ├── QuoteDatabase.kt
│   │   │   │   │   ├── QuoteRepository.kt
│   │   │   │   │   ├── WorksDataLoader.kt
│   │   │   │   │   └── PollinationsApiService.kt
│   │   │   │   ├── model/             # Data models
│   │   │   │   ├── ui/
│   │   │   │   │   ├── components/    # Reusable UI components
│   │   │   │   │   ├── screens/       # App screens
│   │   │   │   │   └── theme/         # Theme & styling
│   │   │   │   ├── viewmodel/         # ViewModels
│   │   │   │   ├── navigation/        # Navigation graph
│   │   │   │   └── MainActivity.kt
│   │   │   ├── assets/                # JSON data files
│   │   │   │   ├── vivaldi_biography.json
│   │   │   │   ├── vivaldi_major_works.json
│   │   │   │   ├── vivaldi_essays.json
│   │   │   │   ├── vivaldi_letters.json
│   │   │   │   ├── vivaldi_papers.json
│   │   │   │   └── vivaldi_affirmations.json
│   │   │   └── res/                   # Resources
│   │   └── AndroidManifest.xml
│   └── build.gradle.kts
├── docs/                              # Documentation
│   ├── index.html
│   ├── privacy.html
│   └── terms.html
├── screenshots/                       # App screenshots
├── README.md
└── LICENSE
```

---

## 🎯 Features in Detail

### 🤖 AI Chat
Powered by Pollinations AI, the chat feature provides an immersive conversation experience with Antonio Vivaldi. The AI is trained with a comprehensive system prompt that includes:
- Vivaldi's biographical details and historical context
- His musical philosophy and compositional techniques
- Knowledge of his major works and innovations
- Venetian Baroque cultural context
- Personality traits and speaking style

### 🎼 Works Explorer
Explore Vivaldi's masterpieces with detailed information:
- **The Four Seasons** - Complete analysis of all four concertos
- **L'estro armonico** - The work that brought international fame
- **Gloria in D Major** - His most famous sacred composition
- **La stravaganza** - Virtuosic violin concertos

### 📚 Learning Resources
- **Biography**: Comprehensive life story from birth to legacy
- **Essays**: Musical treatises on concerto form and programmatic music
- **Letters**: Historical correspondence revealing personal insights
- **Papers**: Technical writings on violin technique and Venetian style

### 💭 Daily Inspiration
Receive daily musical wisdom through:
- Push notifications with Vivaldi quotes
- Customizable notification times
- Affirmations organized by category
- Beautiful notification design

---

## 🔧 Configuration

### API Configuration
The app uses Pollinations AI API (no API key required):
```kotlin
private const val BASE_URL = "https://text.pollinations.ai/"
private const val TEMPERATURE = 1.0
```

### Database
Room database with automatic migrations:
```kotlin
@Database(entities = [Quote::class], version = 1)
abstract class QuoteDatabase : RoomDatabase()
```

### Notifications
WorkManager for reliable daily notifications:
```kotlin
val dailyWorkRequest = PeriodicWorkRequestBuilder<DailyQuoteWorker>(
    1, TimeUnit.DAYS
).build()
```

---

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### Code Style
- Follow Kotlin coding conventions
- Use meaningful variable and function names
- Add comments for complex logic
- Write composable functions for UI components

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 👨‍💻 Developer

**Kregg**
- Email: kreg9da@gmail.com
- GitHub: [@kreggscode](https://github.com/kreggscode)
- More Apps: [Kregg on Google Play](https://play.google.com/store/apps/developer?id=Kregg)

---

## 🙏 Acknowledgments

- **Antonio Vivaldi** - For creating timeless music that continues to inspire
- **Pollinations AI** - For providing the AI chat capabilities
- **Material Design** - For design guidelines and components
- **Jetpack Compose** - For modern Android UI development
- **The Baroque Music Community** - For preserving and celebrating Vivaldi's legacy

---

## 📱 Download

<div align="center">

[![Get it on Google Play](https://play.google.com/intl/en_us/badges/static/images/badges/en_badge_web_generic.png)](https://play.google.com/store/apps/details?id=com.kreggscode.antoniovivaldi)

**Antonio Vivaldi AI** - Experience the genius of the Red Priest

</div>

---

## 📞 Support

- **Email**: kreg9da@gmail.com
- **Issues**: [GitHub Issues](https://github.com/kreggscode/Antonio-Vivaldi-Ai/issues)
- **Documentation**: [docs/](./docs)

---

<div align="center">

**Made with ❤️ and 🎻 by Kregg**

*"Music is the language of the soul, speaking what cannot be expressed in words." - Antonio Vivaldi*

</div>
