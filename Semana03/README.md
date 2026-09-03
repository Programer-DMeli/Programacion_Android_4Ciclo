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


