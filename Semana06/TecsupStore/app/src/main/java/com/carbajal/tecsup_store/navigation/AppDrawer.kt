package com.carbajal.tecsup_store.navigation

import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.HorizontalDivider
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment


@Composable
fun ContenidoDrawer(
    rutaActual: String,
    onNavegar: (String) -> Unit
) {
    ModalDrawerSheet {
        // En el commit 6 agregaremos el encabezado del usuario aquí
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                shape = CircleShape,
                color = MaterialTheme.colorScheme.primaryContainer,
                modifier = Modifier.size(64.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text("MC", style = MaterialTheme.typography.titleLarge) // Iniciales
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text("Meliton Carbajal", style = MaterialTheme.typography.titleMedium) // Datos del usuario
            Text("carbajal@tecsup.edu.pe", style = MaterialTheme.typography.bodyMedium)
        }

        HorizontalDivider(modifier = Modifier.padding(bottom = 8.dp))

        // Destinos de navegacion
        NavigationDrawerItem(
            label = { Text("Inicio") },
            selected = rutaActual == "inicio",
            onClick = { onNavegar("inicio") },
            modifier = Modifier.padding(horizontal = 12.dp)
        )

        NavigationDrawerItem(
            label = { Text("Inicio") },
            selected = rutaActual == "inicio",
            onClick = { onNavegar("inicio") }
        )
        NavigationDrawerItem(
            label = { Text("Mis pedidos") },
            selected = rutaActual == "pedidos",
            onClick = { onNavegar("pedidos") }
        )
        NavigationDrawerItem(
            label = { Text("Favoritos") },
            selected = rutaActual == "favoritos",
            onClick = { onNavegar("favoritos") }
        )
        NavigationDrawerItem(
            label = { Text("Perfil") },
            selected = rutaActual == "perfil",
            onClick = { onNavegar("perfil") }
        )
        // Separador opcional para distinguir la acción de salida
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        NavigationDrawerItem(
            label = { Text("Cerrar sesión") },
            // "Cerrar sesión" normalmente actúa como un botón de acción y no se queda "seleccionado"
            selected = false,
            onClick = {
                onNavegar("login")
            }
        )
    }
}