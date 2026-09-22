## Laboratorio 04: Mi Carrito TECSUP con LazyColumn y LazyRow

**Estudiante:** Meliton Carbajal Levizaca
**Curso:** Programación en Móviles - TECSUP  

## Descripción del Proyecto
Aplicación móvil en Jetpack Compose que implementa un carrito de compras. Permite registrar productos mediante un formulario, visualizarlos en una lista dinámica mediante `LazyColumn`, eliminarlos individualmente y calcular el subtotal, IGV (18%) y total acumulado en tiempo real.

## Cuestionario Téorico

1. **¿Por qué `mutableStateListOf` y no una `MutableList` normal?**  
   Una `MutableList` estándar no notifica a Jetpack Compose cuando su contenido cambia. Con `mutableStateListOf`, cualquier adición o eliminación de elementos desencadena automáticamente la recomposición de los componentes visuales vinculados.

2. **¿Por qué la lista se declara con `val` si aún así podemos agregarle elementos?**  
   La palabra clave `val` especifica que la referencia del objeto lista no puede reasignarse a otra variable. Sin embargo, el estado interno del objeto en sí sigue siendo mutable, permitiendo invocar métodos como `.add()` o `.remove()`.

3. **¿Qué hace `Modifier.weight(1f)` en la `LazyColumn` / `Box`?**  
   Ocupa todo el espacio vertical disponible que queda libre dentro de la `Column` principal. Esto permite que el panel de totales se mantenga siempre fijo en la parte inferior de la pantalla sin importar la cantidad de productos.


**Evidencias en Imagen sin Producto**
<img width="340" height="594" alt="image" src="https://github.com/user-attachments/assets/127161f6-bac2-490b-9320-020b8b1910a5" />

**Evidencias de Imagen con Producto**
<img width="326" height="571" alt="image" src="https://github.com/user-attachments/assets/dbf5917d-8aab-48b8-b335-8a8a1912b860" />
