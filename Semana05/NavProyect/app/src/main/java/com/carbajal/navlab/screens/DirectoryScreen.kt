package com.carbajal.navlab.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.carbajal.navlab.ui.theme.*

data class Student(val id: Int, val name: String, val career: String, val imageUrl: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DirectoryScreen(onBack: () -> Unit, onStudentClick: (Int) -> Unit) {
    val students = listOf(
        Student(1, "Juan León", "Ingeniería de Sistemas", "https://randomuser.me/api/portraits/men/1.jpg"),
        Student(2, "María García", "Arquitectura", "https://randomuser.me/api/portraits/women/1.jpg"),
        Student(3, "Carlos Pérez", "Medicina", "https://randomuser.me/api/portraits/men/3.jpg"),
        Student(4, "Ana López", "Derecho", "https://randomuser.me/api/portraits/women/4.jpg"),
        Student(5, "Luis Ramírez", "Administración", "https://randomuser.me/api/portraits/men/5.jpg")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Directorio de Alumnos", fontWeight = FontWeight.Bold, color = PurplePrimary) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = BackgroundLight)
            )
        },
        containerColor = BackgroundLight
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(students.size) { index ->
                val student = students[index]
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onStudentClick(student.id) },
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = SurfaceWhite),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .clip(CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            AsyncImage(
                                model = student.imageUrl,
                                contentDescription = "Avatar de ${student.name}",
                                modifier = Modifier
                                    .size(48.dp)
                                    .clip(CircleShape),
                                contentScale = ContentScale.Crop
                            )
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(student.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                            Text(student.career, fontSize = 13.sp, color = PurplePrimary)
                        }
                        Icon(Icons.Default.ChevronRight, contentDescription = null, tint = Color.Gray)
                    }
                }
            }
        }
    }
}