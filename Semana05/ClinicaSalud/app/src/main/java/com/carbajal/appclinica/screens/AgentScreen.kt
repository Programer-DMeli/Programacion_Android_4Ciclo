package com.carbajal.appclinica.screens
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.clinicasalud.app.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookAppointmentScreen(
    doctorId: String,
    onBackClick: () -> Unit,
    onConfirmClick: (String, String, String) -> Unit
) {
    val dates = listOf("Jue 25", "Vie 27", "Sáb 20")
    val times = listOf("9:00", "10:30", "3:00")

    var selectedDate by remember { mutableStateOf("Vie 27") }
    var selectedTime by remember { mutableStateOf("10:30") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Agendar cita", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Atrás")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp)
        ) {
            Text(
                text = "Selecciona fecha",
                fontSize = 14.sp,
                color = SaludTextSecondary,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                dates.forEach { date ->
                    val isSelected = date == selectedDate
                    Button(
                        onClick = { selectedDate = date },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isSelected) SaludPurplePrimary else SaludCardBackground,
                            contentColor = if (isSelected) Color.White else SaludTextPrimary
                        ),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(date)
                    }
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                text = "Selecciona hora",
                fontSize = 14.sp,
                color = SaludTextSecondary,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                times.forEach { time ->
                    val isSelected = time == selectedTime
                    Button(
                        onClick = { selectedTime = time },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isSelected) SaludPurplePrimary else SaludCardBackground,
                            contentColor = if (isSelected) Color.White else SaludTextPrimary
                        ),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(time)
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { onConfirmClick(doctorId, selectedDate, selectedTime) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = SaludPurplePrimary)
            ) {
                Text("Confirmar cita", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}