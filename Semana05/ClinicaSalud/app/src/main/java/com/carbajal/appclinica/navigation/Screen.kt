package com.carbajal.appclinica.navigation
sealed class Screen(val route: String, val title: String) {
    data object Home : Screen("home", "Inicio")
    data object DoctorDetail : Screen("doctor_detail/{doctorId}", "Perfil del médico") {
        fun createRoute(doctorId: String) = "doctor_detail/$doctorId"
    }
    data object BookAppointment : Screen("book_appointment/{doctorId}", "Agendar cita") {
        fun createRoute(doctorId: String) = "book_appointment/$doctorId"
    }
    data object Confirmation : Screen("confirmation/{doctorId}/{date}/{time}", "Confirmación") {
        fun createRoute(doctorId: String, date: String, time: String) = "confirmation/$doctorId/$date/$time"
    }
    data object MyAppointments : Screen("my_appointments", "Mis citas")
    data object MedicalHistory : Screen("medical_history", "Historial médico")
}