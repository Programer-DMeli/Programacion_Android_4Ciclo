package com.carbajal.tecsup_store.componentes
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun TarjetaProducto(producto: Producto) {
    // Definimos el estado para el menú
    var expanded by remember { mutableStateOf(false) }

    // Dentro del diseño de tu tarjeta (probablemente un Row o Column), agrega:
    Box {
        // Ícono de 3 puntos a la derecha de la tarjeta
        IconButton(onClick = { expanded = true }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "Opciones del producto"
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text("Favoritos") },
                onClick = {
                    // Lógica futura para favoritos
                    expanded = false
                }
            )
            DropdownMenuItem(
                text = { Text("Compartir") },
                onClick = { expanded = false }
            )
            DropdownMenuItem(
                text = { Text("Reportar") },
                onClick = { expanded = false }
            )
        }
    }
}