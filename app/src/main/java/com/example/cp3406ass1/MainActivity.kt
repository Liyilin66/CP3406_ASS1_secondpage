package com.example.cp3406ass1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CP3406ASS1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    StudyManagementScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun StudyManagementScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF1A237E), Color(0xFF3F51B5), Color(0xFF7986CB))
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
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(20.dp))

        // Header Section
        HeaderSection()
        Spacer(modifier = Modifier.height(20.dp))

        // Priority Matrix
        SectionTitle("📌 Priority Matrix")
        PriorityMatrix()
        Spacer(modifier = Modifier.height(14.dp))

        // Central Timeline View
        SectionTitle("⏳ Daily Schedule")
        StudyTaskCard("🟦 Classes", "📖 Lecture sessions", "🕒 9:00 AM - 12:00 PM", Brush.horizontalGradient(
            colors = listOf(Color(0xFF1976D2), Color(0xFF64B5F6))
        ))
        StudyTaskCard("🟧 Work Shifts", "💼 Part-time job", "🕒 2:00 PM - 5:00 PM", Brush.horizontalGradient(
            colors = listOf(Color(0xFFD84315), Color(0xFFFF7043))
        ))
        StudyTaskCard("🟪 Study Sessions", "📚 Focused study time", "🕒 6:00 PM - 8:00 PM", Brush.horizontalGradient(
            colors = listOf(Color(0xFF8E24AA), Color(0xFFBA68C8))
        ))
    }
}

@Composable
fun HeaderSection() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Good morning, Lisa! Ready to tackle Wednesday?", fontSize = 22.sp, color = Color.White, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Text("📆 Upcoming deadlines: 3", fontSize = 18.sp, color = Color.White)
        Text("⏳ Uncompleted tasks: 5", fontSize = 18.sp, color = Color.White)
        Text("🎯 Weekly study goal: 12/20 hrs", fontSize = 18.sp, color = Color.White)
    }
}

@Composable
fun PriorityMatrix() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        StudyTaskCard("🔴 Urgent & Important", "⚠ Due today/tomorrow", "Complete immediately", Brush.horizontalGradient(
            colors = listOf(Color(0xFFC62828), Color(0xFFE57373))
        ))
        StudyTaskCard("🟡 Important Not Urgent", "📅 Long-term projects", "Plan ahead & schedule", Brush.horizontalGradient(
            colors = listOf(Color(0xFFFFA000), Color(0xFFFFD54F))
        ))
        StudyTaskCard("🔵 Coursework & Assignments", "📝 Exam Preparation", "Review notes & practice questions", Brush.horizontalGradient(
            colors = listOf(Color(0xFF1976D2), Color(0xFF64B5F6))
        ))
        StudyTaskCard("⚪ Study & Review", "📚 Optional reading & practice", "", Brush.horizontalGradient(
            colors = listOf(Color(0xFF757575), Color(0xFFE0E0E0))
        ))
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
fun StudyTaskCard(title: String, subtitle: String, description: String, backgroundBrush: Brush, expanded: Boolean = false) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 14.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .background(backgroundBrush, RoundedCornerShape(16.dp))
                .padding(if (expanded) 24.dp else 20.dp)
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

@Preview(showBackground = true)
@Composable
fun StudyManagementScreenPreview() {
    CP3406ASS1Theme {
        StudyManagementScreen()
    }
}
