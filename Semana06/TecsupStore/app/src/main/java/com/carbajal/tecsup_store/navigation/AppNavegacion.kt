package com.carbajal.tecsup_store.navigation

import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@Composable
fun AppNavegacion() {
    val navController = rememberNavController() // Crea y retiene la instancia de NavController
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val rutaActual = navBackStackEntry?.destination?.route ?: "inicio"

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ContenidoDrawer(
                rutaActual = rutaActual,
                onNavegar = { ruta ->
                    navController.navigate(ruta) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                    // Cierra el menú al seleccionar una opción
                    coroutineScope.launch { drawerState.close() }
                }
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

