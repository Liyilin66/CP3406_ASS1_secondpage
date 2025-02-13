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

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CP3406ASS1Theme {
                UrgentAndImportantScreen()
            }
        }
    }
}

@Composable
fun UrgentAndImportantScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFFC62828), Color(0xFFE57373))
                )
            )
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "🔥 Urgent & Important Tasks",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 26.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(20.dp))

        TaskCard("Complete Assignment", "Due today at 11:59 PM", "Ensure all sections are well written and formatted.")
        TaskCard("Prepare for Exam", "Review notes and practice questions", "Allocate at least 3 hours to revise core concepts.")
        TaskCard("Project Deadline", "Submit group project by 5 PM", "Review final document and confirm all contributions.")

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            "💼 Work & Social Commitments",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 22.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(20.dp))

        TaskCard("Part-time Job Shift", "Today from 4 PM - 8 PM", "Assist customers and manage store inventory.")
        TaskCard("Dinner with Friends", "Tonight at 7:30 PM", "Catch up and enjoy quality time at the cafe.")
        TaskCard("Networking Event", "Tomorrow at 6 PM", "Attend and connect with industry professionals.")
    }
}

@Composable
fun TaskCard(title: String, deadline: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 14.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(title, fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(6.dp))
            Text(deadline, fontSize = 16.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(4.dp))
            Text(description, fontSize = 16.sp, color = Color.Black.copy(alpha = 0.8f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UrgentAndImportantScreenPreview() {
    CP3406ASS1Theme {
        UrgentAndImportantScreen()
    }
}
