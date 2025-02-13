package com.example.cp3406ass1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cp3406ass1.ui.theme.CP3406ASS1Theme

val PurpleDark = Color(0xFF4A148C)
val PurpleLight = Color(0xFF7B1FA2)

class MainActivity4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CP3406ASS1Theme {
                CourseworkAndAssignmentsScreen(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun CourseworkAndAssignmentsScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(colors = listOf(PurpleDark, PurpleLight)))
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                "📚 Coursework & Assignments",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(12.dp))
        }

        // 学术任务
        item {
            Text(
                "📝 Academic Tasks",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
        item { TaskCard4("Complete Research Paper", "Due: Next Monday", "Focus on data analysis section.") }
        item { TaskCard4("Prepare Group Presentation", "Team meeting at 3 PM", "Finalize slides and rehearse key points.") }
        item { TaskCard4("Revise for Midterm", "Subjects: Math & Computer Science", "Cover core concepts and problem-solving techniques.") }

        // 兼职 & 社交活动
        item {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "💼 Part-Time Job & Social Activities",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
        item { TaskCard4("Library Assistant Shift", "Today 2 PM - 6 PM", "Assist students and organize book sections.") }
        item { TaskCard4("Coding Club Meeting", "Tomorrow at 5 PM", "Discuss app development strategies.") }
        item { TaskCard4("Volunteer Event", "Saturday at 10 AM", "Help organize a charity fundraiser.") }
    }
}

@Composable
fun TaskCard4(title: String, deadline: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(title, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(4.dp))
            Text(deadline, fontSize = 14.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                description,
                fontSize = 14.sp,
                color = Color.Black.copy(alpha = 0.8f),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseworkAndAssignmentsScreenPreview() {
    CP3406ASS1Theme {
        CourseworkAndAssignmentsScreen(modifier = Modifier.fillMaxSize())
    }
}
