# Examen Final Práctico: BiblioExpress 📚

**Materia:** Programación III - UNLaR
**Alumno:** Francisco Antonio Gonzalez

En este repositorio presento mi solución para el examen práctico "BiblioExpress". A continuación, detallo las decisiones de diseño que tomé para cumplir con todas las reglas de negocio y adjunto las evidencias de funcionamiento.

## 🏗️ Arquitectura y Decisiones Técnicas

*   **Separación en Capas:** Estructuré el proyecto estrictamente en paquetes (`controller`, `service`, `repository`, `model`, `dto` y `exception`). Ninguna entidad de dominio toca los controladores directamente; todo el tráfico de entrada y salida está protegido por DTOs.
*   **Persistencia en Memoria:** Tal como se solicitó, no utilicé bases de datos ni dependencias JPA. Simulé la capa de datos en la clase `MaterialRepository` utilizando `HashMap` para garantizar búsquedas eficientes (complejidad O(1)) al buscar materiales por código o socios por ID.
*   **Manejo de Excepciones:** Implementé un `@RestControllerAdvice` global para capturar errores de negocio (como intentar prestar un material ya prestado o no encontrar un socio) y devolver respuestas HTTP estructuradas (400 Bad Request, 404 Not Found) en lugar de exponer las trazas internas del servidor.

## 🧠 Patrones y Estructuras Aplicadas

*   **Patrón Strategy (Unidad 3):** Para el cálculo de las multas en devoluciones atrasadas, evité la anidación de condicionales. Creé la interfaz `MultaStrategy` con tres implementaciones inyectadas por Spring (`MultaNormal`, `MultaCampania`, `MultaFinDeSemana`). El `PrestamoService` recibe el identificador de la estrategia desde el request JSON y aplica el cálculo correspondiente dinámicamente.
*   **HashSet para Deduplicación (Unidad 4):** En el endpoint de depuración de socios, implementé la interfaz `Set` (específicamente `HashSet`) para procesar la lista entrante de DNIs. Esto me permitió eliminar todos los elementos duplicados en una sola pasada de forma nativa.
*   **Herencia y Polimorfismo (Unidad 1):** Apliqué herencia en las jerarquías de `Material` (Libro/Revista) y `Socio` (SocioRegular/SocioPremium). El cálculo de descuentos se resuelve polimórficamente delegando la responsabilidad a cada tipo de socio mediante el método abstracto `aplicarBeneficio()`.

## 📸 Evidencias de Funcionamiento (Postman)

*(A continuación se adjuntan las capturas probando los 4 endpoints obligatorios)*

### 1. Obtener Materiales Disponibles (GET)
Comprobación de que la estructura inicial basada en HashMaps carga y filtra correctamente los recursos.


### 2. Prestar Material (POST)
Registro de un préstamo validando la disponibilidad previa del material y la existencia del socio.


### 3. Devolver Material con Multa - Strategy (POST)
Prueba devolviendo el material con atraso. Se observa la aplicación de la estrategia dinámica seleccionada y el descuento correspondiente según la categoría del socio.


### 4. Depurar DNIs Duplicados - HashSet (POST)
Prueba enviando un arreglo de DNIs con elementos repetidos. El sistema retorna la lista limpia procesada en una sola iteración.


---
*Nota: La colección completa de Postman (`.json`) con estas peticiones preconfiguradas se encuentra exportada en la raíz de este repositorio para su ejecución y verificación.*
