package com.carbajal.lab03registroproducto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.carbajal.lab03registroproducto.ui.theme.Lab03RegistroProductoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab03RegistroProductoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaRegistro(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun PantallaRegistro(modifier: Modifier = Modifier) {
    // Declaración de variables de estado
    var nombre by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }
    var cantidad by remember { mutableStateOf("") }
    var errorMsg by remember { mutableStateOf("") }
    var mostrarResumen by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Encabezado con jerarquía tipográfica
        Text(
            text = "Nuevo producto",
            style = MaterialTheme.typography.headlineSmall,
            color = Color.Blue

        )
        Text(
            text = "Completa los datos correctamente y presiona Agregar",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.outline
        )
        Spacer(modifier = Modifier.height(24.dp))

        // Campo de entrada para Nombre
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre del producto") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Fila compartida para Precio y Cantidad usando weight(1f)
        Row(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = precio,
                onValueChange = { precio = it },
                label = { Text("Precio (S/)") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))

            OutlinedTextField(
                value = cantidad,
                onValueChange = { cantidad = it },
                label = { Text("Cantidad") },
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))
        // Botones de acción
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = {
                    val p = precio.toDoubleOrNull()
                    val c = cantidad.toIntOrNull()
                    if (nombre.isBlank() || p == null || c == null) {
                        errorMsg = "Error: Todos los campos son obligatorios y deben ser válidos."
                        mostrarResumen = false
                    } else {
                        errorMsg = ""
                        mostrarResumen = true
                    }
                },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4CAF50) //Agrege el valor del color Verde
                )
            ) {
                Text("AGREGAR")
            }
            Spacer(modifier = Modifier.width(16.dp))

            OutlinedButton(
                onClick = {
                    nombre = ""
                    precio = ""
                    cantidad = ""
                    errorMsg = ""
                    mostrarResumen = false
                },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                )
            ) {
                Text("LIMPIAR")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Mensaje de error
        if (errorMsg.isNotEmpty()) {
            Text(
                text = errorMsg,
                color = Color.Red,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        // Card de resumen condicional
        if (mostrarResumen) {
            val precioNum = precio.toDoubleOrNull() ?: 0.0
            val cantidadNum = cantidad.toIntOrNull() ?: 0
            val importe = precioNum * cantidadNum

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = nombre,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text("Precio: S/ ${String.format("%.2f", precioNum)}")
                    Text("Cantidad: $cantidadNum")
                    Text(
                        text = "Importe total: S/ ${String.format("%.2f", importe)}",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            // Mensaje de confirmación verde
            Text(
                text = "✓ Producto registrado correctamente",
                color = Color(0xFF2E7D32)
            )
        }
    }
}
