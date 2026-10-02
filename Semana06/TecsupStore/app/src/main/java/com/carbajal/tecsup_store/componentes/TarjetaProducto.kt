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
    }
}