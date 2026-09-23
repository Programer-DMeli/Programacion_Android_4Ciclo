# Laboratorio Semana 05: Navegación en Jetpack Compose

> **Curso:** Programacion Móviles  
> **Estudiante:** Meliton Carbajal  
> **Proyecto:** NavLab App  
---
## 📝 Descripción del Proyecto

Este laboratorio se centró en la refactorización e implementación de un sistema de navegación moderno, robusto en Android utilizando **Jetpack Compose** y **Material Design 3**.

La aplicación **NavLab** simula un portal académico interactivo compuesto por 5 pantallas principales. Su interfaz visual sigue una línea estética *premium*, basada en fondos con degradados sofisticados (morado a blanco hueso), tarjetas elevadas (*Containers*) con bordes redondeados y carga dinámica de avatares remotos.

---
## 🚀 Funcionalidades Principales

* **Autenticación e Inicio de Sesión (`LoginScreen`):** Formulario con tarjetas flotantes y validación visual de campos.
* **Menú Principal (`HomeScreen`):** Dashboard centralizado con acceso a módulos y un diseño con degradado unificado.
* **Directorio de Alumnos (`DirectoryScreen`):** Lista dinámica de estudiantes con avatares cargados asíncronamente desde internet.
* **Expediente Académico (`DetailScreen`):** Vista de detalle que recibe parámetros dinámicos (ID de estudiante) a través de la ruta de navegación.
* **Perfil de Usuario (`ProfileScreen`):** Configuración personal y académica estructurada en secciones con acciones de cierre de sesión seguro mediante `ButtonBar`.
---

**Evidencias antes de Ejecutar el Promt**

---
<img width="393" height="894" alt="Captura desde 2026-09-22 22-08-19" src="https://github.com/user-attachments/assets/b8fd7ce2-0768-4b28-a879-e1d0419ce764" />

---
**PROMT PARA MEJORAR CON IA**
Rol: Actúa como un Desarrollador Android Senior, Arquitecto de Software y Diseñador UX/UI experto en Material Design 3 y Jetpack Compose.
Contexto: Estoy refactorizando la navegación de mi app Android. Adjunto imágenes del diseño final esperado.
Por favor, analiza las imágenes y ejecuta el trabajo paso a paso siguiendo estas tareas:
Tarea 1: Estilos y Layout Base (UI/UX)
    Replica la estética premium, moderna y limpia de la imagen.
    Colores: Implementa el degradado de fondo (desde un morado vibrante/profundo hasta un blanco suave/hueso).
    Tipografía: Establece una jerarquía textual visualmente equilibrada.
Tarea 2: Arquitectura de Navegación (Clean Code)
    Crea una navegación 100% nativa en Compose, separando estrictamente la lógica de la UI.
    Implementa rutas seguras (Type-Safe) usando una Sealed Class.
    Utiliza NavHost, NavController y el componente de navegación M3 adecuado según el diseño adjunto (NavigationBar, NavigationRail o ModalNavigationDrawer).
Tarea 3: Construcción de Pantallas y Casos Específicos
    ProfileScreen: Implementa el botón de Cerrar sesión utilizando un ButtonBar.
    HomeScreen: Envuelve el botón de Cerrar sesión en un Column secundario para mantener el gradiente de fondo unificado.
Tarea 4: Integración de Imágenes (Coil)
    Actualiza las Data Classes necesarias añadiendo el campo imageUrl: String.
    En DirectoryScreen, DetailScreen y ProfileScreen: Reemplaza los placeholders (Icons.Default.Person) por avatares reales mediante Coil (usa URLs de prueba como https://randomuser.me/api/portraits/men/1.jpg).
    Proporciona las dependencias exactas que debo añadir a mi build.gradle para Coil y la navegación.
Entregables Finales:
Genera el código completo de todos los archivos necesarios. Restricción estricta: El código debe ser modular, estar listo para producción, respetar una buena estructura de paquetes y NO debe contener placeholders (como // TODO). Desarrolla la lógica completa.

---
**Despues de Ejecutar el Promt para mejora con IA**

<img width="390" height="900" alt="Captura desde 2026-09-23 09-25-22" src="https://github.com/user-attachments/assets/044d48c4-dde3-4e29-ae74-b0f8933eaa6d" />

---
## 📂 Estructura del Proyecto

```text
com.carbajal.navlab/
├── navigation/
│   ├── Screen.kt              # Definición de rutas tipo-seguras (Sealed Class)
│   └── AppNavigation.kt       # Grafo centralizado de navegación (NavHost)
├── ui/
│   ├── theme/
│   │   ├── Color.kt           # Paleta de colores y degradados
│   │   └── Theme.kt           # Configuración del tema Material 3
│   └── screens/
│       ├── LoginScreen.kt     # Pantalla de acceso
│       ├── HomeScreen.kt      # Dashboard principal
│       ├── DirectoryScreen.kt  # Lista de estudiantes
│       ├── DetailScreen.kt     # Expediente detallado
│       └── ProfileScreen.kt    # Perfil y configuración
└── MainActivity.kt            # Punto de entrada de la aplicación



