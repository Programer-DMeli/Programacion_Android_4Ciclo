# Clínica Salud+ — Sistema de Reserva de Citas Médicas

> **Curso:** Programación en Móviles   
> **Estudiante:** Meliton Carbajal  
> **Tecnología:** Kotlin · Jetpack Compose · Material Design 3  

---

## 📝 Descripción del Proyecto

**Clínica Salud+** es una aplicación móvil nativa para Android desarrollada en **Jetpack Compose** que integra todos los conocimientos adquiridos entre las semanas 1 y 6. La aplicación ofrece un flujo intuitivo y moderno para la consulta de médicos especialistas, agendamiento de citas médicas y revisión de historial.

El desarrollo se enfoca en el uso exclusivo de **estado local** (`remember` / `mutableStateOf`) sin arquitectura MVVM[cite: 2], combinado con un sistema de navegación dual: **navegación secuencial** por parámetros tipo-seguros (`NavHost`) y **navegación secundaria** mediante un menú lateral deslizante (`ModalNavigationDrawer`)[cite: 2].

---

## ⚙️ Requisitos Funcionales — Opción A

La aplicación en su etapa funcional permite realizar las siguientes acciones a través de sus 6 pantallas integradas[cite: 2]:

### 1. Pantalla de Inicio (`HomeScreen`)
* **Navegación Secundaria:** Botón de menú hamburguesa (☰) en el banner superior para desplegar el `ModalNavigationDrawer`[cite: 2].
* **Filtro de Especialidades:** `LazyRow` interactivo con chips de selección ("Cardiología", "Pediatría", "Dermatología")[cite: 2].
* **Lista de Médicos Disponibles:** `LazyColumn` que renderiza tarjetas de médicos con su nombre, especialidad y calificación promedio (estrellas)[cite: 2].

### 2. Perfil del Médico (`DoctorDetailScreen`)
* **Recepción de Parámetros:** Obtiene de forma dinámica el ID del médico seleccionado a través de la ruta de navegación[cite: 2].
* **Detalle del Profesional:** Muestra avatar, años de experiencia, total de reseñas y biografía médica.
* **Acción Principal:** Botón destacado "Agendar cita" que redirige al flujo de reserva[cite: 2].

### 3. Agendar Cita (`BookAppointmentScreen`)
* **Selección Única de Fecha:** Panel con 3 opciones de fechas (ej. Jue 25, Vie 27, Sáb 20) que actúa bajo lógica de selección exclusiva[cite: 2].
* **Selección Única de Hora:** Panel con 3 opciones de horarios (ej. 9:00, 10:30, 3:00) de selección única[cite: 2].
* **Confirmación de Selección:** Botón para procesar el agendamiento con los datos seleccionados[cite: 2].

### 4. Confirmación de Cita (`ConfirmationScreen`)
* **Resumen de Cita:** Muestra un diseño de éxito con ícono de verificación (check verde), indicando el médico, la fecha y la hora elegidas[cite: 2].
* **Retorno Funcional:** Botón "Ver mis citas" para redirige al usuario a su listado general[cite: 2].

### 5. Mis Citas (`MyAppointmentsScreen`)
* **Acceso desde Drawer:** Accesible en cualquier momento desde el menú lateral[cite: 2].
* **Listado de Citas:** `LazyColumn` con las citas del usuario[cite: 2].
* **Diferenciación Visual de Estado:** Badges e indicadores laterales de color para diferenciar citas **Confirmadas** (Púrpura) y **Completadas** (Gris)[cite: 2].

### 6. Historial Médico (`MedicalHistoryScreen`)
* **Acceso desde Drawer:** Destino secundario para consulta de registros médicos anteriores[cite: 2].

---
**Promt Usados**
Rol: Actúa como un Desarrollador Android Senior, Arquitecto de Software y Diseñador UX/UI experto en Material Design 3 y Jetpack Compose. Tu tarea es Analizar Detalladamente las imagenes de la Opcion A y de acuerdo a su rubro y 6 pantallas de Navegacion dame la estructura de la carpetas y seguidamente el Codigo completo de todos los archivos para que salga tal cual La Imagen que te estoy Abjuntando, Punto 1.- Con Estilos y Layout Base (UI/UX), Replica la estética premium, moderna y limpia de la imagen. Punto 2.- Implementa rutas seguras (Type-Safe) usando una Sealed Class.
Punto 3.- Utiliza NavHost, NavController y el componente de navegación M3 adecuado según el diseño adjunto (NavigationBar, NavigationRail o ModalNavigationDrawer), punto 4.- Manten los mismos paletas de colores que la imagen de la Opcion A, Jerarquia visual de texto y interfaz.

**Imagenes de promt de Mejora**


<img width="472" height="670" alt="Captura desde 2026-09-23 11-47-33" src="https://github.com/user-attachments/assets/1595ec22-6adf-4a4c-a83f-cd527e5b334c" />

---


**Evidencias**

---

## 📂 Estructura de Carpetas

```text
com.clinicasalud.app/
├── data/
│   └── DoctorData.kt           # Modelos de datos y repositorio estático
├── navigation/
│   ├── Screen.kt               # Sealed Class para rutas tipo-seguras
│   └── AppNavigation.kt        # NavHost y ModalNavigationDrawer
├── ui/
│   ├── theme/
│   │   ├── Color.kt            # Paleta de colores oficial
│   │   ├── Type.kt             # Jerarquía tipográfica Material 3
│   │   └── Theme.kt            # Tema principal de la app
│   └── screens/
│       ├── HomeScreen.kt             # Inicio (Filtros + Lista de Médicos)
│       ├── DoctorDetailScreen.kt     # Perfil de Médico
│       ├── BookAppointmentScreen.kt  # Agendamiento (Fecha y Hora)
│       ├── ConfirmationScreen.kt     # Pantalla de Confirmación
│       ├── MyAppointmentsScreen.kt   # Mis Citas (Estado Confirmada/Completada)
│       └── MedicalHistoryScreen.kt   # Historial Médico
└── MainActivity.kt             # Punto de entrada de la aplicación
