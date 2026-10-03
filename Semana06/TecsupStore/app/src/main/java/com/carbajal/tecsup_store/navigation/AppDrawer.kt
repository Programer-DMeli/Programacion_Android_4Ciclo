package com.carbajal.tecsup_store.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.Badge
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ContenidoDrawer(
    rutaActual: String,
    contadorFavoritos: Int,
    onNavegar: (String) -> Unit
) {
    ModalDrawerSheet {
        // Encabezado con foto/iniciales del usuario
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
                    Text("MC", style = MaterialTheme.typography.titleLarge) // Iniciales del usuario
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text("Meliton Carbajal", style = MaterialTheme.typography.titleMedium)
            Text("carbajal@tecsup.edu.pe", style = MaterialTheme.typography.bodyMedium)
        }

        HorizontalDivider(modifier = Modifier.padding(bottom = 8.dp))

        // Opciones de navegación con íconos e indicadores de selección
        NavigationDrawerItem(
            label = { Text("Inicio") },
            icon = { Icon(Icons.Default.Home, contentDescription = null) },
            selected = rutaActual == "inicio",
            onClick = { onNavegar("inicio") },
            modifier = Modifier.padding(horizontal = 12.dp)
        )

        NavigationDrawerItem(
            label = { Text("Mis pedidos") },
            icon = { Icon(Icons.Default.ShoppingBag, contentDescription = null) },
            selected = rutaActual == "pedidos",
            onClick = { onNavegar("pedidos") },
            modifier = Modifier.padding(horizontal = 12.dp)
        )

        NavigationDrawerItem(
            label = { Text("Favoritos") },
            icon = { Icon(Icons.Default.Favorite, contentDescription = null) },
            selected = rutaActual == "favoritos",
            onClick = { onNavegar("favoritos") },
            badge = {
                Badge {
                    Text(contadorFavoritos.toString())
                }
            },
            modifier = Modifier.padding(horizontal = 12.dp)
        )

        NavigationDrawerItem(
            label = { Text("Perfil") },
            icon = { Icon(Icons.Default.Person, contentDescription = null) },
            selected = rutaActual == "perfil",
            onClick = { onNavegar("perfil") },
            modifier = Modifier.padding(horizontal = 12.dp)
        )

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

        NavigationDrawerItem(
            label = { Text("Cerrar sesión") },
            icon = { Icon(Icons.AutoMirrored.Filled.ExitToApp, contentDescription = null) },
            selected = false,
            onClick = { onNavegar("login") },
            modifier = Modifier.padding(horizontal = 12.dp)
        )
    }
}
