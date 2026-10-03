package com.carbajal.tecsup_store.componentes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class Producto(
    val id: Int,
    val nombre: String,
    val precio: String
)

@Composable
fun TarjetaProducto(
    producto: Producto,
    onAgregarFavorito: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Estado para el menú desplegable (DropdownMenu)
    var expanded by remember { mutableStateOf(false) }

    // Tarjeta con borde morado de Material3
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary), // Borde morado de la tarjeta
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Contenedor visual para el ícono del producto
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.ShoppingBag,
                        contentDescription = producto.nombre,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(28.dp)
                    )
                }

                // Información del producto (Nombre y Precio)
                Column {
                    Text(
                        text = producto.nombre,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = producto.precio,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            // Botón de 3 puntos y DropdownMenu desplegable
            Box {
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
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.FavoriteBorder,
                                contentDescription = null
                            )
                        },
                        onClick = {
                            expanded = false
                            onAgregarFavorito() // Incrementa el contador mediante State Hoisting
                        }
                    )
                    HorizontalDivider()
                    DropdownMenuItem(
                        text = { Text("Compartir") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = null
                            )
                        },
                        onClick = { expanded = false }
                    )
                    DropdownMenuItem(
                        text = { Text("Reportar") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Warning,
                                contentDescription = null
                            )
                        },
                        onClick = { expanded = false }
                    )
                }
            }
        }
    }
}
