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

class MainActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CP3406ASS1Theme {
                UrgentNotImportantScreen(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun UrgentNotImportantScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF1565C0), Color(0xFF64B5F6))
                )
            )
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "🔵 Urgent but Not Important Tasks",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(12.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            TaskCard3("Check Professor Emails", "Reply to pending questions", "Respond to emails regarding upcoming assignment clarifications and project deadlines.", Modifier.weight(1f))
            Spacer(modifier = Modifier.width(6.dp))
            TaskCard3("Organize Study Notes", "Sort last week's lecture notes", "Highlight key points and group materials by topic for efficient review.", Modifier.weight(1f))
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            TaskCard3("Update University Portal", "Confirm class schedules", "Check for updates on classroom changes and upcoming assessments.", Modifier.weight(1f))
            Spacer(modifier = Modifier.width(6.dp))
            TaskCard3("Review Presentation Slides", "Practice for seminar", "Prepare key talking points and refine visual content for upcoming seminar.", Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "💼 Part-Time Job & Social Commitments",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(12.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            TaskCard3("Library Shift", "Work from 2 PM - 6 PM", "Assist students in finding books, manage check-ins, and maintain quiet study zones.", Modifier.weight(1f))
            Spacer(modifier = Modifier.width(6.dp))
            TaskCard3("Tutoring Session", "Help classmates with calculus", "Guide students through problem-solving techniques for upcoming test preparation.", Modifier.weight(1f))
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            TaskCard3("Dinner with Study Group", "Meet at 7 PM", "Discuss upcoming exam strategies and unwind with friends over dinner.", Modifier.weight(1f))
            Spacer(modifier = Modifier.width(6.dp))
            TaskCard3("Student Club Meeting", "Plan fundraising event", "Coordinate logistics for upcoming charity drive with fellow club members.", Modifier.weight(1f))
        }
    }
}

@Composable
fun TaskCard3(title: String, deadline: String, description: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(vertical = 4.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(title, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(3.dp))
            Text(deadline, fontSize = 12.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(3.dp))
            Text(description, fontSize = 12.sp, color = Color.Black.copy(alpha = 0.8f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UrgentNotImportantScreenPreview() {
    CP3406ASS1Theme {
        UrgentNotImportantScreen(modifier = Modifier.fillMaxSize())
    }
}