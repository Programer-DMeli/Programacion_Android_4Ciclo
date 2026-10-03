package com.carbajal.tecsup_store.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.carbajal.tecsup_store.componentes.Producto
import com.carbajal.tecsup_store.componentes.TarjetaProducto
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavegacion() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    // State Hoisting con rememberSaveable para sobrevivir a cambios de configuración (rotación de pantalla)
    var contadorFavoritos by rememberSaveable { mutableIntStateOf(0) }

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val rutaActual = navBackStackEntry?.destination?.route ?: "inicio"

    // Lista de productos demostrativos segun la imagen de referencia
    val productos = remember {
        listOf(
            Producto(1, "Audifonos", "S/ 89.00"),
            Producto(2, "Smartwatch", "S/ 199.00"),
            Producto(3, "Funda celular", "S/ 25.00"),
            Producto(4, "SmartPhone", "S/ 1999.00"),
            Producto(5, "Audifonos", "S/ 99.00")
        )
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ContenidoDrawer(
                rutaActual = rutaActual,
                contadorFavoritos = contadorFavoritos,
                onNavegar = { ruta ->
                    if (ruta != "login") {
                        navController.navigate(ruta) {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                    coroutineScope.launch { drawerState.close() }
                }
            )
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Column {
                            Text(
                                text = "TECSUP Store",
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                            Text(
                                text = "Mas vendidos",
                                fontSize = 14.sp,
                                color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f)
                            )
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = { coroutineScope.launch { drawerState.open() } }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Abrir menú de navegación"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary,
                        navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = "inicio",
                modifier = Modifier.padding(innerPadding)
            ) {
                composable("inicio") {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(productos) { producto ->
                            TarjetaProducto(
                                producto = producto,
                                onAgregarFavorito = {
                                    // Incrementamos el contador a traves del State Hoisting
                                    contadorFavoritos++
                                }
                            )
                        }
                    }
                }

                composable("pedidos") {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Pantalla Mis Pedidos",
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }

                composable("favoritos") {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Pantalla Favoritos (Total: $contadorFavoritos)",
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }

                composable("perfil") {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Pantalla Perfil",
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }
            }
        }
    }
}
