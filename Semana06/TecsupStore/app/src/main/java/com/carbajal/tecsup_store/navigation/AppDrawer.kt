package com.carbajal.tecsup_store.navigation

import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.HorizontalDivider
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp

@Composable
fun ContenidoDrawer(
    rutaActual: String,
    onNavegar: (String) -> Unit
) {
    ModalDrawerSheet {
        // En el commit 6 agregaremos el encabezado del usuario aquí

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