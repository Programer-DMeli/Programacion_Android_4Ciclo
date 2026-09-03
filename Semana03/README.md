# Lab 03: Registro de Producto

 Estudiante: Meliton Carbajal  
#### Curso: Programación en Móviles  

**Descripción**
Aplicación desarrollada en Jetpack Compose para el registro de productos. Permite ingresar el nombre, precio y cantidad, gestionando el estado con remember  y mutableStateOf para calcular el importe total y mostrar una tarjeta de resumen.


## Capturas de Pantalla

**Pantalla Inicial**
<img width="1361" height="716" alt="Captura de pantalla 2026-09-02 a las 5 15 42 p  m" src="https://github.com/user-attachments/assets/f0b2ca2b-a78d-4d38-ac96-ec0808b07971" />
**Producto Registrado**
 <img width="1324" height="669" alt="Captura de pantalla 2026-09-02 a las 5 23 11 p  m" src="https://github.com/user-attachments/assets/265f2dce-9309-4134-bd6c-7b3eddfe434e" />

## Pregunta de Reflexión

**¿Qué pasaría si declaras las variables de los campos SIN remember?**

Si se declaran las variables del estado sin remember, el valor de la variable se reconfigura e inicializa nuevamente en su estado original en cada recomposición de la pantalla. En la práctica, esto provoca que cada vez que el usuario intenta escribir una letra en el campo de texto, el valor introducido se borre al instante y la interfaz sea incapaz de conservar lo escrito."


### Mejora con IA
**Prompt que usé**: 
Rol: Actúa como un desarrollador experto en Android con Jetpack Compose. Contexto: Necesito aplicar una mejora específica al composable PantallaRegistro en el archivo existente del proyecto MainActivity.kt. Tarea: ¿Dónde realizar el cambio? Modifica únicamente la función composable PantallaRegistro. No crees archivos nuevos ni modifiques la estructura temática, temas, colores globales o componentes externos.
Requerimientos y comportamiento exacto:
Validación de campos vacíos: Al presionar el botón AGREGAR, evalúa los campos de entrada (nombre, precioText, cantidadText). Si alguno está vacío o no contiene una entrada numérica válida, oculta la Card de resumen y muestra en su lugar un mensaje de error explícito en texto de color rojo (Color.Red). Si todos los campos son válidos, limpia el mensaje de error y despliega la Card con los cálculos correspondientes.

Botón Limpiar: Agrega un nuevo botón secundario de tipo OutlinedButton etiquetado como LIMPIAR al lado del botón AGREGAR. Al ser presionado, debe reiniciar a su estado original todas las variables de los campos, ocultar la Card de resumen y remover cualquier mensaje de error visible.
Qué NO tocar:
No modifiques la lógica previa de cálculo de precios totales dentro de la Card. No cambies la función PantallaRegistro. No alteres las importaciones existentes que no sean estrictamente necesarias"** 

**Qué generó Gemini**: 
Un código completo del composable `PantallaRegistro` con variables de estado adicionales mensajeError, lógica condicional en el botón **AGREGAR**, el botón secundario **LIMPIAR** y un `Text` con color Color.Red para el mensaje de error.  
<img width="1919" height="1053" alt="Captura desde 2026-09-02 23-11-49" src="https://github.com/user-attachments/assets/bbbeda7a-a692-4ae6-af78-5aee2cdd4681" />



**Qué acepté o corregí**: 
**Agrege colores al texto principal y los botones, para que sean intuitivos con el UX** Tambien aseguré que las importaciones de Compose se mantuvieran alineadas con el paquete del proyecto. 

**Evidencias:**
<img width="1414" height="809" alt="Captura desde 2026-09-02 23-41-25" src="https://github.com/user-attachments/assets/ec7d455d-2c77-4be6-83d4-25277abe7510" />

