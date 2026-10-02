package com.carbajal.tecsup_store.navigation

import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavegacion() {
    val navController = rememberNavController() // Crea y retiene la instancia de NavController
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ContenidoDrawer(
                rutaActual = "inicio", // Se hará dinámico en el siguiente commit
                onNavegar = { /* Pendiente de implementación */ }
            )
        }
    ) {
        Scaffold(
            topBar = { }
        ) { innerPadding ->
            // NavHost actuará como contenedor principal visual que aloja el gráfico de navegación[cite: 8]
            NavHost(navController = navController, startDestination = "inicio", modifier = Modifier.padding(innerPadding)) {
                // Tus rutas existentes composable("inicio") { ... }
            }
        }
    }
}

