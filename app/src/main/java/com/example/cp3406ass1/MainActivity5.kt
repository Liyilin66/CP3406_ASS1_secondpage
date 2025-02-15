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

class MainActivity5 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CP3406ASS1Theme {
                StudyAndReviewScreen(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun StudyAndReviewScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF1B5E20), Color(0xFF66BB6A))
                )
            )
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "📖 Study & Review",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            "📊 Exam Performance Analysis",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))

        PerformanceAnalysisCard("Mathematics", 85, "Strong problem-solving skills, but needs to improve calculation speed.")
        PerformanceAnalysisCard("Computer Science", 90, "Excellent in algorithms, work on better code optimization techniques.")
        PerformanceAnalysisCard("Physics", 75, "Good grasp of concepts, needs more numerical practice.")
        PerformanceAnalysisCard("English", 80, "Strong writing skills, improve grammar and comprehension.")
        Spacer(modifier = Modifier.height(14.dp))

        Text(
            "🎯 Personalized Study Plan",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        StudyPlanCard("Mathematics", "Practice timed quizzes daily to boost calculation speed.")
        StudyPlanCard("Computer Science", "Solve real-world coding challenges to optimize efficiency.")
        StudyPlanCard("Physics", "Focus on solving past-year numerical problems.")
        StudyPlanCard("English", "Read and summarize articles to improve comprehension and vocabulary.")
    }
}

@Composable
fun PerformanceAnalysisCard(subject: String, score: Int, feedback: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 3.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(subject, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(2.dp))
            Text("Score: $score%", fontSize = 12.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(2.dp))
            Text(feedback, fontSize = 10.sp, color = Color.Black.copy(alpha = 0.8f))
        }
    }
}

@Composable
fun StudyPlanCard(subject: String, recommendation: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 3.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(subject, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(2.dp))
            Text(recommendation, fontSize = 10.sp, color = Color.Black.copy(alpha = 0.8f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StudyAndReviewScreenPreview() {
    CP3406ASS1Theme {
        StudyAndReviewScreen(modifier = Modifier.fillMaxSize())
    }
}
