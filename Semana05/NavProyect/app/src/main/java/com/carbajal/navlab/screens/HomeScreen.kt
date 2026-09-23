package com.carbajal.navlab.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.carbajal.navlab.ui.theme.*

@Composable
fun HomeScreen(
    onNavigateDirectory: () -> Unit,
    onNavigateProfile: () -> Unit,
    onLogout: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(PurpleGradientStart, PurpleGradientEnd, BackgroundLight),
                    startY = 0f,
                    endY = 2000f
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Bienvenido,\nMeliton Carbajal",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                lineHeight = 36.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
            Text(
                text = "¿Qué deseas gestionar hoy?",
                fontSize = 16.sp,
                color = Color.White.copy(alpha = 0.8f),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 40.dp)
            )

            MenuCard(
                title = "Directorio de Alumnos",
                subtitle = "Ver y gestionar estudiantes",
                icon = Icons.Default.Group,
                onClick = onNavigateDirectory
            )

            Spacer(modifier = Modifier.height(16.dp))

            MenuCard(
                title = "Mi Perfil Académico",
                subtitle = "Datos personales y progreso",
                icon = Icons.Default.Person,
                onClick = onNavigateProfile
            )

            Spacer(modifier = Modifier.height(32.dp))

            TextButton(
                onClick = onLogout,
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Icon(Icons.AutoMirrored.Filled.ExitToApp, contentDescription = null, tint = LogoutRed)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Cerrar Sesión Segura", color = LogoutRed, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun MenuCard(title: String, subtitle: String, icon: ImageVector, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceWhite),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(IconBackground, RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(icon, contentDescription = null, tint = PurplePrimary)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = TextPrimary)
                Text(subtitle, fontSize = 13.sp, color = TextSecondary)
            }
        }
    }
}