package com.example.cp3406ass1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cp3406ass1.ui.theme.CP3406ASS1Theme

enum class AppScreen {
    MAIN,
    URGENT
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CP3406ASS1Theme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    var currentScreen by remember { mutableStateOf(AppScreen.MAIN) }
    Surface(modifier = Modifier.fillMaxSize()) {
        when (currentScreen) {
            AppScreen.MAIN -> {
                StudyManagementScreen(onNavigateToUrgent = { currentScreen = AppScreen.URGENT })
            }
            AppScreen.URGENT -> {
                UrgentAndImportantScreen(onBackToMain = { currentScreen = AppScreen.MAIN })
            }
        }
    }
}

@Composable
fun StudyManagementScreen(
    onNavigateToUrgent: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF1A237E),
                        Color(0xFF3F51B5),
                        Color(0xFF7986CB)
                    )
                )
            )
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "📚 Lisa's Study & Time Manager",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 40.8.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(20.dp))
        HeaderSection()
        Spacer(modifier = Modifier.height(20.dp))
        SectionTitle("📌 Priority Matrix")
        PriorityMatrix(onNavigateToUrgent = onNavigateToUrgent)
        Spacer(modifier = Modifier.height(14.dp))
        SectionTitle("⏳ Daily Schedule")
        StudyTaskCard(
            title = "🟦 Classes",
            subtitle = "📖 Lecture sessions",
            description = "🕒 9:00 AM - 12:00 PM",
            backgroundBrush = Brush.horizontalGradient(
                colors = listOf(Color(0xFF1976D2), Color(0xFF64B5F6))
            )
        )
        StudyTaskCard(
            title = "🟧 Work Shifts",
            subtitle = "💼 Part-time job",
            description = "🕒 2:00 PM - 5:00 PM",
            backgroundBrush = Brush.horizontalGradient(
                colors = listOf(Color(0xFFD84315), Color(0xFFFF7043))
            )
        )
        StudyTaskCard(
            title = "🟪 Study Sessions",
            subtitle = "📚 Focused study time",
            description = "🕒 6:00 PM - 8:00 PM",
            backgroundBrush = Brush.horizontalGradient(
                colors = listOf(Color(0xFF8E24AA), Color(0xFFBA68C8))
            )
        )
    }
}

@Composable
fun HeaderSection() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Good morning, Lisa! Ready to tackle Wednesday?",
            fontSize = 22.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text("📆 Upcoming deadlines: 3", fontSize = 18.sp, color = Color.White)
        Text("⏳ Uncompleted tasks: 5", fontSize = 18.sp, color = Color.White)
        Text("🎯 Weekly study goal: 12/20 hrs", fontSize = 18.sp, color = Color.White)
    }
}

@Composable
fun PriorityMatrix(onNavigateToUrgent: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        StudyTaskCard(
            title = "🔴 Urgent & Important",
            subtitle = "⚠ Due today/tomorrow",
            description = "Complete immediately",
            backgroundBrush = Brush.horizontalGradient(
                colors = listOf(Color(0xFFC62828), Color(0xFFE57373))
            ),
            onClick = onNavigateToUrgent
        )
        StudyTaskCard(
            title = "🟡 Important Not Urgent",
            subtitle = "📅 Long-term projects",
            description = "Plan ahead & schedule",
            backgroundBrush = Brush.horizontalGradient(
                colors = listOf(Color(0xFFFFA000), Color(0xFFFFD54F))
            )
        )
        StudyTaskCard(
            title = "🔵 Coursework & Assignments",
            subtitle = "📝 Exam Preparation",
            description = "Review notes & practice questions",
            backgroundBrush = Brush.horizontalGradient(
                colors = listOf(Color(0xFF1976D2), Color(0xFF64B5F6))
            )
        )
        StudyTaskCard(
            title = "⚪ Study & Review",
            subtitle = "📚 Optional reading & practice",
            description = "",
            backgroundBrush = Brush.horizontalGradient(
                colors = listOf(Color(0xFF757575), Color(0xFFE0E0E0))
            )
        )
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable
fun StudyTaskCard(
    title: String,
    subtitle: String,
    description: String,
    backgroundBrush: Brush,
    onClick: (() -> Unit)? = null
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .let { if (onClick != null) it.clickable { onClick() } else it },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 14.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .background(backgroundBrush, RoundedCornerShape(16.dp))
                .padding(20.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 19.sp, color = Color.White)
                Spacer(modifier = Modifier.height(6.dp))
                Text(subtitle, fontSize = 17.sp, color = Color.White.copy(alpha = 0.9f))
                Spacer(modifier = Modifier.height(4.dp))
                Text(description, fontSize = 16.sp, color = Color.White.copy(alpha = 0.8f))
            }
        }
    }
}

@Composable
fun UrgentAndImportantScreen(onBackToMain: () -> Unit, modifier: Modifier = Modifier) {
    Scaffold(
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Button(
                    onClick = { onBackToMain() },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Text("Back to Main", color = Color.Black, fontSize = 12.sp)
                }
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color(0xFFC62828), Color(0xFFE57373))
                    )
                )
                .padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            item {
                Text(
                    "🔥 Urgent & Important Tasks",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
            items(5) { index ->
                when (index) {
                    0 -> TaskCard(
                        "Complete Assignment",
                        "Due today at 11:59 PM",
                        "Ensure all sections are well written and formatted."
                    )
                    1 -> TaskCard(
                        "Prepare for Exam",
                        "Review notes and practice questions",
                        "Allocate at least 3 hours to revise core concepts."
                    )
                    2 -> TaskCard(
                        "Project Deadline",
                        "Submit group project by 5 PM",
                        "Review final document and confirm all contributions."
                    )
                }
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    "💼 Work & Social Commitments",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
            items(5) { index ->
                when (index) {
                    0 -> TaskCard(
                        "Part-time Job Shift",
                        "Today from 4 PM - 8 PM",
                        "Assist customers and manage store inventory."
                    )
                    1 -> TaskCard(
                        "Dinner with Friends",
                        "Tonight at 7:30 PM",
                        "Catch up and enjoy quality time at the cafe."
                    )
                }
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun TaskCard(title: String, deadline: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = deadline, fontSize = 12.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = description, fontSize = 12.sp, color = Color.Black.copy(alpha = 0.8f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppNavigationPreview() {
    CP3406ASS1Theme {
        AppNavigation()
    }
}
