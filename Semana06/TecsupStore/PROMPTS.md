## Laboratorio 6: Menu - Navegacion
**Estudiante**: Meliton Carbajal 


## Promt de Mejora con IA:**
**1.- Modifica mi código en Jetpack Compose para agregar un 'Badge' con un contador numérico en el ítem 'Favoritos' del ModalNavigationDrawer. 
El número debe incrementarse automáticamente cada vez que el usuario haga clic en la opción 'Favoritos' del DropdownMenu de cualquier tarjeta de producto.
Aplica la técnica de State Hoisting (elevación de estado) para compartir y gestionar este contador entre ambos componentes.**
---
**Resultado:**
<img width="280" height="650" alt="Captura desde 2026-10-02 19-32-43" src="https://github.com/user-attachments/assets/531a6ae9-26af-45e3-a5b3-40dc3b34e4a9" />

---
**2.- Rol: Eres un profesional en desarrollo movil. Tarea: Mejora la interfaz utilizando Material3. Modifica especificamente el codigo que me permita 
aumentar el contador cada vez que haga clic en favoritos de un producto asegurate de que sea 100% funcional. 
FInalmente agrega un margen de color morado al Card donde se muestra la informacion del Producto.**

---
**3.- Actualiza el código de este componente en Jetpack Compose implementando rememberSaveable. El objetivo es gestionar el estado del color del ícono de corazón entre favorito/no favorito para que sobreviva tanto a las recomposiciones automáticas de la interfaz como a los cambios de configuración (como la rotación de pantalla).
FInalmente. Documentame que cambiaste y porque. Restricciones. NO modifiques la estructura de mis archivos, realiza la tarea especificamente y manten el codigo simple y limpio.**

**Resultado:**

<img width="280" height="650" alt="imagen" src="https://github.com/user-attachments/assets/1a4f21f2-a859-4b01-9229-012ab70dcb42" />
<img width="280" height="650" alt="Captura desde 2026-10-02 19-32-49" src="https://github.com/user-attachments/assets/2d81fb9d-3d1a-4773-9aaa-4a9a5b2607cb" />

---
###  Requerimientos funcionales
- Cada tarjeta de producto  tiene un ícono de 3 puntos (⋮) a la derecha.
- Al tocarlo, se despliega un DropdownMenu con mínimo 3 opciones: "Favoritos", "Compartir", "Reportar" 
- Cada opción del DropdownMenu tiene su ícono correspondiente (leadingIcon).
- Un ícono ☰ en la topBar abre un NavigationDrawer con mínimo 4 destinos: Inicio, Mis pedidos, Favoritos, Perfil +
Cerrar sesión
- El encabezado del drawer muestra el iniciales y datos básicos del usuario.
-  El destino activo del drawer se resalta visualmente color de fondo distinto al resto.
- El icono de Favoritos cambia de color a rojo cada ves que se hace clic
- Hay un contador que lleva la cantidad de favoritos seleccionados
- El icono de Favoritos en visible en la pantalla de Inicio
- EL Usuario puede quitar de favoritos el producto seleccionado
  
