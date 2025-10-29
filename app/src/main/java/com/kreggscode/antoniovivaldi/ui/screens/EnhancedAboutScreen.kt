package com.kreggscode.antoniovivaldi.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import com.kreggscode.antoniovivaldi.ui.components.*
import com.kreggscode.antoniovivaldi.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnhancedAboutScreen(
    onBackClick: () -> Unit,
    onWorkClick: ((String) -> Unit)? = null
) {
    var selectedTab by rememberSaveable { mutableIntStateOf(0) }
    val tabs = listOf("Biography", "Works", "Legacy", "Timeline", "Policies")
    
    // Handle back button - if on another tab, go to Biography first, then exit
    BackHandler(enabled = selectedTab != 0) {
        if (selectedTab != 0) {
            selectedTab = 0
        } else {
            onBackClick()
        }
    }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        PremiumColors.DeepSpace,
                        PremiumColors.MidnightBlue,
                        PremiumColors.DeepSpace
                    )
                )
            )
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            "About Antonio Vivaldi",
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = onBackClick) {
                            Icon(
                                Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.White
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent
                    )
                )
            },
            containerColor = Color.Transparent
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                // Tabs
                PrimaryScrollableTabRow(
                    selectedTabIndex = selectedTab,
                    containerColor = Color.Transparent,
                    contentColor = Color.White,
                    edgePadding = 16.dp
                ) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTab == index,
                            onClick = { selectedTab = index },
                            text = {
                                Text(
                                    title,
                                    fontWeight = if (selectedTab == index) FontWeight.Bold else FontWeight.Normal
                                )
                            }
                        )
                    }
                }
                
                // Content
                when (selectedTab) {
                    0 -> BiographyTab()
                    1 -> WorksTab(onWorkClick = onWorkClick)
                    2 -> LegacyTab()
                    3 -> TimelineTab()
                    4 -> PoliciesTab()
                }
            }
        }
    }
}

@Composable
fun BiographyTab() {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            GlassmorphicCard(
                modifier = Modifier.fillMaxWidth(),
                glowColor = PremiumColors.ElectricPurple,
                animateGlow = true
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("🎻", fontSize = 64.sp)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "Antonio Vivaldi",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        "1678 - 1741",
                        style = MaterialTheme.typography.titleMedium,
                        color = PremiumColors.ImperialYellow
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "The Great Teacher & Founder of Baroque composition",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White.copy(alpha = 0.7f)
                    )
                }
            }
        }
        
        item {
            InfoCard(
                title = "Early Life",
                icon = "👶",
                content = "Born Antonio Lucio Vivaldi on March 4, 1678, in Venice, Republic of Venice. Baptized immediately after birth due to poor health. His father, Giovanni Battista, was a professional violinist who taught young Antonio. Showed exceptional musical talent from early age, learning violin and composition."
            )
        }
        
        item {
            InfoCard(
                title = "Priesthood & The Pietà (1703-1740)",
                icon = "⛪",
                content = "Ordained as Catholic priest in 1703, earning nickname 'Il Prete Rosso' (The Red Priest) due to red hair. Appointed maestro di violino at Ospedale della Pietà orphanage. Composed hundreds of concertos and sacred works for the all-female ensemble, creating music tailored to showcase their talents."
            )
        }
        
        item {
            InfoCard(
                title = "Operatic Career & Travels",
                icon = "🎭",
                content = "Composed over 40 operas performed throughout Italy and Europe. Traveled extensively to Vienna, Prague, Rome, and Mantua presenting his works. Served as Maestro di Cappella in Mantua (1717-1720). His operas were celebrated for brilliant orchestration and dramatic power."
            )
        }
        
        item {
            InfoCard(
                title = "The Four Seasons & Peak Fame",
                icon = "🎻",
                content = "Published Il cimento dell'armonia e dell'inventione (Op. 8) in 1725, containing The Four Seasons - his most famous work. These programmatic violin concertos depicted scenes from nature with unprecedented vividness. Became one of the most celebrated composers in Europe."
            )
        }
        
        item {
            InfoCard(
                title = "Final Years & Legacy",
                icon = "🌟",
                content = "Faced declining popularity as Baroque style fell out of fashion. Traveled to Vienna in 1740 seeking employment but Emperor Charles VI died shortly after. Vivaldi died in poverty on July 28, 1741, buried in simple grave. His music was rediscovered in 20th century and is now celebrated worldwide."
            )
        }
    }
}

@Composable
fun WorksTab(onWorkClick: ((String) -> Unit)? = null) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            HighlightCard(
                title = "The Four Seasons",
                subtitle = "Le Quattro Stagioni",
                description = "Vivaldi's most famous work - four violin concertos depicting Spring, Summer, Autumn, and Winter. Revolutionary programmatic music with sonnets describing each scene. Showcases Vivaldi's genius for musical storytelling.",
                gradient = listOf(PremiumColors.ElectricPurple, PremiumColors.CosmicIndigo)
            )
        }
        
        item {
            Text(
                "Major Works",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
        
        val works = listOf(
            Work("L'estro armonico (Op. 3)", "1711", "12 concertos for various instruments that established Vivaldi's international reputation. Influenced J.S. Bach who transcribed several", "🎼", null),
            Work("La stravaganza (Op. 4)", "1714", "12 violin concertos showcasing virtuosic technique and expressive range", "🎻", null),
            Work("Il cimento (Op. 8)", "1725", "12 concertos including The Four Seasons - programmatic masterpieces depicting nature", "🌸", null),
            Work("Gloria in D (RV 589)", "~1715", "Sacred choral masterwork - one of Vivaldi's most performed sacred compositions", "⛪", null),
            Work("Stabat Mater (RV 621)", "1712", "Deeply expressive sacred vocal work for alto and strings", "🙏", null),
            Work("Orlando furioso (RV 728)", "1727", "Opera based on Ariosto's epic poem - showcases Vivaldi's dramatic genius", "🎭", null)
        )
        
        items(works) { work ->
            WorkCard(work = work, onClick = {
                work.id?.let { id -> onWorkClick?.invoke(id) }
            })
        }
    }
}

@Composable
fun LegacyTab() {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            InfoCard(
                title = "Musical Innovation",
                icon = "🎼",
                content = "Revolutionized the concerto form with the three-movement fast-slow-fast structure. Pioneered programmatic music with The Four Seasons. Composed over 500 concertos, establishing the solo concerto as a major genre. Influenced Bach, Handel, and countless composers."
            )
        }
        
        item {
            InfoCard(
                title = "Violin Virtuosity",
                icon = "🎻",
                content = "Expanded violin technique with unprecedented demands for speed, range, and expression. His concertos pushed boundaries of what was considered playable. Established the violin as the premier solo instrument of the Baroque era."
            )
        }
        
        item {
            InfoCard(
                title = "Operatic Contributions",
                icon = "🎭",
                content = "Composed over 40 operas that were performed throughout Europe. Innovated in orchestration and dramatic expression. His operas featured brilliant arias and ensemble writing that influenced the development of opera seria."
            )
        }
        
        item {
            InfoCard(
                title = "Sacred Music Legacy",
                icon = "⛪",
                content = "Composed magnificent sacred works including Gloria, Magnificat, and Stabat Mater. His sacred music combined theatrical drama with spiritual depth. Works like Gloria RV 589 remain staples of choral repertoire worldwide."
            )
        }
        
        item {
            InfoCard(
                title = "20th Century Rediscovery",
                icon = "🌟",
                content = "Music largely forgotten after death, rediscovered in early 1900s. The Four Seasons became one of the most recorded pieces in classical music. Today recognized as one of the greatest Baroque composers. His music performed and celebrated globally."
            )
        }
    }
}

@Composable
fun TimelineTab() {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        val timeline = listOf(
            TimelineEvent("1678", "Born in Venice on March 4", "👶"),
            TimelineEvent("1703", "Ordained as priest - 'Il Prete Rosso'", "⛪"),
            TimelineEvent("1703", "Appointed maestro at Ospedale della Pietà", "🎻"),
            TimelineEvent("1711", "Published L'estro armonico (Op. 3)", "🎼"),
            TimelineEvent("1713", "First opera Ottone in villa premiered", "🎭"),
            TimelineEvent("1717", "Moved to Mantua as Maestro di Cappella", "👑"),
            TimelineEvent("1723", "Composed The Four Seasons", "🌸"),
            TimelineEvent("1725", "Published Il cimento (Op. 8)", "📜"),
            TimelineEvent("1740", "Left Venice for Vienna", "🚶"),
            TimelineEvent("1741", "Died in Vienna on July 28", "🌟")
        )
        
        items(timeline) { event ->
            TimelineCard(event)
        }
    }
}

data class Work(
    val title: String,
    val year: String,
    val description: String,
    val icon: String,
    val id: String? = null
)

data class TimelineEvent(
    val year: String,
    val event: String,
    val icon: String
)

@Composable
fun InfoCard(title: String, icon: String, content: String) {
    GlassmorphicCard(
        modifier = Modifier.fillMaxWidth(),
        glowColor = PremiumColors.CyberBlue
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(icon, fontSize = 32.sp)
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                content,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White.copy(alpha = 0.9f),
                lineHeight = 24.sp
            )
        }
    }
}

@Composable
fun HighlightCard(
    title: String,
    subtitle: String,
    description: String,
    gradient: List<Color>
) {
    PremiumGlassCard(
        modifier = Modifier.fillMaxWidth(),
        gradientColors = gradient
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                title,
                style = MaterialTheme.typography.displayMedium,
                fontWeight = FontWeight.Black,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                subtitle,
                style = MaterialTheme.typography.titleMedium,
                color = Color.White.copy(alpha = 0.9f),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                description,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White.copy(alpha = 0.85f),
                textAlign = TextAlign.Center,
                lineHeight = 24.sp
            )
        }
    }
}

@Composable
fun WorkCard(work: Work, onClick: (() -> Unit)? = null) {
    val modifier = if (onClick != null && work.id != null) {
        Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    } else {
        Modifier.fillMaxWidth()
    }
    
    GlassmorphicCard(
        modifier = modifier,
        glowColor = if (work.id != null) PremiumColors.ElectricPurple else PremiumColors.ElectricPurple.copy(alpha = 0.5f)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(work.icon, fontSize = 32.sp)
                Spacer(modifier = Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        work.title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        work.year,
                        style = MaterialTheme.typography.labelMedium,
                        color = PremiumColors.CyberBlue
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        work.description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White.copy(alpha = 0.8f)
                    )
                }
            }
            
            if (work.id != null) {
                Icon(
                    imageVector = Icons.Default.ChevronRight,
                    contentDescription = "View details",
                    tint = PremiumColors.ElectricPurple,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Composable
fun TimelineCard(event: TimelineEvent) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(androidx.compose.foundation.shape.CircleShape)
                    .background(PremiumColors.ElectricPurple),
                contentAlignment = Alignment.Center
            ) {
                Text(event.icon, fontSize = 20.sp)
            }
            if (event != TimelineEvent("322 BC", "Dies in Chalcis at age 62", "⭐")) {
                Box(
                    modifier = Modifier
                        .width(2.dp)
                        .height(60.dp)
                        .background(PremiumColors.ElectricPurple.copy(alpha = 0.3f))
                )
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        GlassmorphicCard(
            modifier = Modifier.weight(1f),
            glowColor = PremiumColors.CyberBlue
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    event.year,
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = PremiumColors.CyberBlue
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    event.event,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun PoliciesTab() {
    var selectedPolicy by rememberSaveable { mutableStateOf<String?>(null) }
    
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        if (selectedPolicy != null) {
            // Back button
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { selectedPolicy = null }
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = PremiumColors.ElectricPurple
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        "Back to Policies",
                        style = MaterialTheme.typography.titleMedium,
                        color = PremiumColors.ElectricPurple,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            
            // Show selected policy content
            if (selectedPolicy == "privacy") {
                privacyPolicyContent()
            } else if (selectedPolicy == "terms") {
                termsAndConditionsContent()
            }
        } else {
            // Show policy selection
            item {
                GlassmorphicCard(
                    modifier = Modifier.fillMaxWidth(),
                    glowColor = PremiumColors.ElectricPurple,
                    animateGlow = true
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("📋", fontSize = 64.sp)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            "Policies & Legal",
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            "Read our privacy policy and terms of service",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.White.copy(alpha = 0.7f),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
            
            item {
                PolicyCard(
                    title = "Privacy Policy",
                    icon = "🔒",
                    description = "Learn how we protect your data and respect your privacy",
                    onClick = { selectedPolicy = "privacy" }
                )
            }
            
            item {
                PolicyCard(
                    title = "Terms & Conditions",
                    icon = "📜",
                    description = "Read the terms of service for using Antonio Vivaldi AI",
                    onClick = { selectedPolicy = "terms" }
                )
            }
            
            item {
                GlassmorphicCard(
                    modifier = Modifier.fillMaxWidth(),
                    glowColor = PremiumColors.CyberBlue
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("ℹ️", fontSize = 32.sp)
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            "App Version",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            "1.0",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.White.copy(alpha = 0.8f)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun PolicyCard(
    title: String,
    icon: String,
    description: String,
    onClick: () -> Unit
) {
    GlassmorphicCard(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        glowColor = PremiumColors.CyberBlue
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(icon, fontSize = 32.sp)
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        title,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White.copy(alpha = 0.8f)
                    )
                }
            }
            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = "View",
                tint = PremiumColors.ElectricPurple,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

fun LazyListScope.privacyPolicyContent() {
    item {
        GlassmorphicCard(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    "🔒 Privacy Policy",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    "Last Updated: October 18, 2025",
                    style = MaterialTheme.typography.labelMedium,
                    color = PremiumColors.CyberBlue
                )
            }
        }
    }
    
    item {
        PolicySection(
            title = "1. Information We Collect",
            content = "Antonio Vivaldi AI is designed with privacy in mind. We collect minimal information:\n\n• Favorites Data: Your saved favorite quotes are stored locally on your device\n• App Preferences: Settings like dark mode and notification preferences\n• Usage Analytics: Anonymous data about app crashes and performance to improve the app"
        )
    }
    
    item {
        PolicySection(
            title = "2. Information We Don't Collect",
            content = "We respect your privacy and do NOT collect:\n\n• Personal identification information (name, email, phone number)\n• Location data\n• Contacts or photos\n• Any data that can personally identify you"
        )
    }
    
    item {
        PolicySection(
            title = "3. Data Storage",
            content = "All your data (favorites, preferences) is stored locally on your device. We do not store your personal data on external servers. Your information stays with you."
        )
    }
    
    item {
        PolicySection(
            title = "4. Third-Party Services",
            content = "Antonio Vivaldi AI may use Google Play Services for app distribution and updates, and Android WorkManager for scheduling daily notifications. These services have their own privacy policies."
        )
    }
    
    item {
        PolicySection(
            title = "5. Children's Privacy",
            content = "Antonio Vivaldi AI is suitable for all ages. We do not knowingly collect personal information from children under 13. The app does not require any personal information to function."
        )
    }
    
    item {
        PolicySection(
            title = "6. Your Rights",
            content = "You have the right to:\n\n• Access your data (all stored locally on your device)\n• Delete your data (uninstall the app or clear app data)\n• Disable notifications at any time\n• Clear cache from the app settings"
        )
    }
    
    item {
        PolicySection(
            title = "7. Contact",
            content = "If you have any questions about this Privacy Policy, please contact us at: kreg9da@gmail.com"
        )
    }
}

fun LazyListScope.termsAndConditionsContent() {
    item {
        GlassmorphicCard(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    "📜 Terms & Conditions",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    "Last Updated: October 18, 2025",
                    style = MaterialTheme.typography.labelMedium,
                    color = PremiumColors.CyberBlue
                )
            }
        }
    }
    
    item {
        PolicySection(
            title = "1. Acceptance of Terms",
            content = "By downloading, installing, or using Antonio Vivaldi AI, you agree to be bound by these Terms and Conditions. If you do not agree to these terms, please do not use the app."
        )
    }
    
    item {
        PolicySection(
            title = "2. License to Use",
            content = "We grant you a limited, non-exclusive, non-transferable, revocable license to use Antonio Vivaldi AI for personal, non-commercial purposes. You may not:\n\n• Modify, reverse engineer, or decompile the app\n• Remove any copyright or proprietary notices\n• Use the app for any illegal purposes\n• Attempt to gain unauthorized access to the app's systems"
        )
    }
    
    item {
        PolicySection(
            title = "3. Content Ownership",
            content = "All quotes, texts, and content related to Vivaldi's works are in the public domain. The app's design, code, and original content are © 2025 Kreggscode. All rights reserved."
        )
    }
    
    item {
        PolicySection(
            title = "4. User Conduct",
            content = "You agree to use Antonio Vivaldi AI responsibly and in accordance with all applicable laws. You will not use the app to:\n\n• Harass, abuse, or harm others\n• Distribute malware or harmful code\n• Violate any intellectual property rights\n• Engage in any fraudulent activity"
        )
    }
    
    item {
        PolicySection(
            title = "5. Disclaimer of Warranties",
            content = "Antonio Vivaldi AI is provided \"as is\" without warranties of any kind, either express or implied. We do not guarantee that the app will be error-free, secure, or uninterrupted."
        )
    }
    
    item {
        PolicySection(
            title = "6. Limitation of Liability",
            content = "To the maximum extent permitted by law, Kreggscode shall not be liable for any indirect, incidental, special, consequential, or punitive damages arising from your use of Antonio Vivaldi AI."
        )
    }
    
    item {
        PolicySection(
            title = "7. Changes to Terms",
            content = "We reserve the right to modify these Terms and Conditions at any time. Continued use of the app after changes constitutes acceptance of the modified terms."
        )
    }
    
    item {
        PolicySection(
            title = "8. Termination",
            content = "We may terminate or suspend your access to Antonio Vivaldi AI at any time, without prior notice, for conduct that we believe violates these Terms or is harmful to other users."
        )
    }
    
    item {
        PolicySection(
            title = "9. Governing Law",
            content = "These Terms shall be governed by and construed in accordance with applicable laws, without regard to conflict of law provisions."
        )
    }
    
    item {
        PolicySection(
            title = "10. Contact Information",
            content = "For questions about these Terms and Conditions, please contact us at: kreg9da@gmail.com"
        )
    }
}

@Composable
fun PolicySection(title: String, content: String) {
    GlassmorphicCard(
        modifier = Modifier.fillMaxWidth(),
        glowColor = PremiumColors.CyberBlue.copy(alpha = 0.3f)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = PremiumColors.QuantumGold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                content,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White.copy(alpha = 0.9f),
                lineHeight = 22.sp
            )
        }
    }
}
