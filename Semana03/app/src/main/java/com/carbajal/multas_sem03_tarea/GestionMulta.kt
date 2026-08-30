package com.carbajal.multas_sem03_tarea

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.Locale
import java.util.Scanner
@RequiresApi(Build.VERSION_CODES.O)
fun calcularDiasRetraso(textoEntrega: String, textoDevolucion: String, formatter: DateTimeFormatter): Long {
    //1 convertimos el string a objeto Date
    val fechaEntrega = LocalDate.parse(textoEntrega, formatter) //transforma en un onjeto de fecha real
    val fechaDevolucion = LocalDate.parse(textoDevolucion, formatter)
    return ChronoUnit.DAYS.between(fechaEntrega, fechaDevolucion)
}
@RequiresApi(Build.VERSION_CODES.O)  //anotacion de compatitibilidad de Android
fun main() {
    val scanner = Scanner(System. `in`)
    //formato para leer fechas e imprimir
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    println("--INGRESO DE DATOS---\n")
    println("Ingresa el titulo del LIbro: ")
    val tituloLibro: String = scanner.nextLine()
    print("Ingresa el tipo de Usuario Alumno/Docente: ")
    val tipoUsuario: String = scanner.nextLine()
    print("Ingrese la fecha de Prestamo: ")
    val fechaPrestamo: String = scanner.nextLine()
    print("Ingrese la fecha de Entrega: ")
    val textoEntrega = scanner.nextLine()
    print("Ingresa fecha devolucion: ")
    val textoDevolucion = scanner.nextLine()

    val tarifaDiaria: Double = if (tipoUsuario.equals("Docente", ignoreCase = true)){
        3.00
    }else {
        1.50
    }
    var multaAcumulada: Double = 0.0
    val diasAtraso = calcularDiasRetraso(textoEntrega, textoDevolucion, formatter)
    val fechaBaseEntrega = LocalDate.parse(textoEntrega, formatter)
    //calculamos los dias
    println()

    println("===============================================")
    println("SISTEMA DE DEVOLUCION DE LIBROS ")
    println("==============================================")
    println("Titulo del Libro: $tituloLibro")
    println("Tipo de Usuario:   $tipoUsuario")
    println("Fecha de Prestamo:  $fechaPrestamo")
    println("Fecha de Entrega:   $textoEntrega")
    println("Fecha de Devolucion:  $textoDevolucion")
    println("Estado: Devuelto con $diasAtraso dias de atraso")
    println()
    println("----------------------------------")
    println("----------Detalle de Multa--------")
    println("----------------------------------")
    println("Dias  | Fecha          | Multa Diaria   | Multa Acumulada")
    println("----------------------------------")
    for (i in 1..diasAtraso){
        multaAcumulada += tarifaDiaria
        val fechafila = fechaBaseEntrega.plusDays(i).format(formatter)
        println(String.format(Locale.US, "%-4d  | %-12s  | S/ %-9.2f  | S/ %.2f", i,fechafila, tarifaDiaria, multaAcumulada))
    }
    println("---------------------------------------")
    println(String.format(Locale.US, "TOTAL A PAGAR: S/ %.2f soles", multaAcumulada))
    println("---------------------------------------")
    scanner.close()
}
