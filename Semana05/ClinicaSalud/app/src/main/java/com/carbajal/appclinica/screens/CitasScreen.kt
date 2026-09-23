package com.carbajal.appclinica.screens

package com.clinicasalud.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.clinicasalud.app.data.AppointmentItem
import com.clinicasalud.app.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppointmentsScreen(onOpenDrawer: () -> Unit) {
    val appointments = listOf(
        AppointmentItem("Dra. Ana Torres", "Viernes 27", "10:30 am", "Confirmada"),
        AppointmentItem("Dr. Luis Vega", "Ayer", "8:00 am", "Completada")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mis citas", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onOpenDrawer) {
                        Icon(Icons.Default.Menu, contentDescription = "Menú Lateral")
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(appointments) { item ->
                AppointmentCard(item)
            }
        }
    }
}

@Composable
fun AppointmentCard(appointment: AppointmentItem) {
    val isConfirmed = appointment.status == "Confirmada"

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = SaludCardBackground),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Indicador de barra lateral de color
            Box(
                modifier = Modifier
                    .width(4.dp)
                    .height(40.dp)
                    .background(
                        if (isConfirmed) SaludPurplePrimary else Color.Gray,
                        shape = RoundedCornerShape(2.dp)
                    )
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = appointment.doctorName,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = "${appointment.date}, ${appointment.time}",
                    fontSize = 13.sp,
                    color = SaludTextSecondary
                )
            }

            Surface(
                color = if (isConfirmed) SaludPurpleLight else Color(0xFFE0E0E0),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = appointment.status,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                    fontSize = 12.sp,
                    color = if (isConfirmed) SaludPurplePrimary else Color.DarkGray,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}