package com.carbajal.appclinica.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.clinicasalud.app.data.DoctorRepository
import com.clinicasalud.app.ui.theme.*

@Composable
fun ConfirmationScreen(
    doctorId: String,
    date: String,
    time: String,
    onViewAppointmentsClick: () -> Unit
) {
    val doctor = DoctorRepository.getDoctorById(doctorId)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape)
                .background(SaludGreenLight),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = null,
                tint = SaludGreenConfirm,
                modifier = Modifier.size(48.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "¡Cita agendada!",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = SaludTextPrimary
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = doctor?.name ?: "Médico",
            fontSize = 15.sp,
            color = SaludTextSecondary
        )
        Text(
            text = "Viernes $date, $time am",
            fontSize = 14.sp,
            color = SaludTextSecondary
        )

        Spacer(modifier = Modifier.height(48.dp))

        Button(
            onClick = onViewAppointmentsClick,
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .height(48.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = SaludCardBackground,
                contentColor = SaludTextPrimary
            )
        ) {
            Text("Ver mis citas", fontWeight = FontWeight.Medium)
        }
    }
}