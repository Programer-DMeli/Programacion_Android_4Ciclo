package com.carbajal.appclinica.data

//Nos sirve para declarar las variables que tendra como atributos nuestra clase Doctor
data class Doctor(
    val id: String,
    val name: String,
    val specialty: String,
    val rating: Double,
    val experience: String,
    val reviewsCount: Int,
    val bio: String
)

data class AppointmentItem(
    val doctorName: String,
    val date: String,
    val time: String,
    val status: String // "Confirmada" o "Completada"
)

object DoctorRepository {
    val doctors = listOf(
        Doctor(
            id = "doc1",
            name = "Dra. Ana Torres",
            specialty = "Cardióloga",
            rating = 4.9,
            experience = "12 años exp.",
            reviewsCount = 126,
            bio = "Especialista en arritmias e hipertensión, formación en la Clínica Mayo."
        ),
        Doctor(
            id = "doc2",
            name = "Dr. Luis Vega",
            specialty = "Pediatra",
            rating = 4.7,
            experience = "8 años exp.",
            reviewsCount = 94,
            bio = "Atención integral infantil y desarrollo neonatólogo con amplia experiencia."
        ),
        Doctor(
            id = "doc3",
            name = "Dra. Rosa Diaz",
            specialty = "Dermatóloga",
            rating = 4.8,
            experience = "10 años exp.",
            reviewsCount = 110,
            bio = "Especialista en dermatología clínica, estética y tratamientos láser."
        )
    )

    fun getDoctorById(id: String): Doctor? = doctors.find { it.id == id }
}