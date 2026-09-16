package com.lab04_carrito_carbajal



data class Producto(
    val nombre: String,
    val precio: Double,
    val cantidad: Int
) {
    // Propiedad calculada para el importe individual
    val importe: Double
        get() = precio * cantidad
}