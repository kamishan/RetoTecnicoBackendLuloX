## Automatización de API REST Backend

Este proyecto se centra en la automatización de pruebas de un API REST utilizando Serenity BDD Screenplay y Cucumber. El objetivo es demostrar la capacidad de realizar interacciones con diferentes verbos HTTP (GET, POST, DELETE) y validar las respuestas obtenidas del API.  Se ha utilizado un API pública para realizar operaciones de consulta, creación y eliminación de empleados, implementando validaciones exhaustivas en cada interacción.

### Stack Técnico Utilizado

Para el desarrollo de este proyecto, se ha empleado el siguiente stack tecnológico, ampliamente recomendado para la automatización de pruebas y con ejemplos documentados en la web (como se puede ver en [https://serenity-bdd.github.io/theserenitybook/latest/cucumber.html](https://serenity-bdd.github.io/theserenitybook/latest/cucumber.html)):

*   **Java 17 o superior:** Se requiere Java 17 o una versión más reciente para garantizar la compatibilidad con las últimas funcionalidades y librerías.

*   **Gradle:**  Se ha elegido Gradle como herramienta de gestión de dependencias y construcción del proyecto. Gradle simplifica la gestión de librerías externas y la automatización del proceso de build.

*   **Serenity BDD Screenplay 4 o superior:** Framework principal de automatización, Serenity BDD Screenplay, facilita la creación de tests robustos y mantenibles. Su patrón Screenplay promueve la escritura de pruebas centradas en las acciones del usuario, mejorando la legibilidad y el mantenimiento.

*   **Serenity BDD Screenplay Webdriver 4 o superior:**  Aunque este proyecto se centra en la automatización de APIs Backend,  se incluye Serenity BDD Screenplay Webdriver como parte del stack técnico base de Serenity BDD y podría ser utilizado en futuras expansiones del proyecto para automatización Frontend si fuera necesario.

*   **Cucumber 4 o superior con Serenity BDD:** Cucumber se utiliza para definir los escenarios de prueba en lenguaje Gherkin (lenguaje natural). Esto permite una mejor colaboración entre equipos técnicos y no técnicos, al describir las pruebas de manera clara y concisa. La integración con Serenity BDD asegura una ejecución fluida de los escenarios y la generación de reportes detallados.

*   **Rest Assured con Serenity BDD Screenplay:** Rest Assured es una librería Java para la automatización de pruebas de APIs REST. Su integración con Serenity BDD Screenplay permite realizar peticiones HTTP de manera sencilla y realizar validaciones sobre las respuestas del API de forma declarativa y legible.

*   **Hamcrest:** Hamcrest se utiliza para realizar aserciones y validaciones de manera fluida y expresiva dentro de las pruebas automatizadas, tanto para el body de las respuestas como para otros aspectos.

### Backend Automatizado: Interacción con API REST Pública

El objetivo principal del backend automatizado es interactuar con un API REST pública que expone endpoints para la gestión de empleados. Se han implementado pruebas para los verbos HTTP más comunes (GET, POST, DELETE) para demostrar un flujo completo de interacción con un API.

Las API's utilizadas son públicas y están disponibles en internet, diseñadas para practicar la automatización de APIs REST.  La documentación completa del API se puede encontrar en [http://dummy.restapiexample.com/](http://dummy.restapiexample.com/).

Se han automatizado las siguientes operaciones sobre los endpoints proporcionados:

*   **Consultar Empleados (GET /api/v1/employees):**  Se realiza una petición GET al endpoint `http://dummy.restapiexample.com/api/v1/employees` para obtener la lista de todos los empleados.  Se valida el código de estado de la respuesta (esperando un 200 OK) y el body de la respuesta para asegurar que la lista de empleados se devuelve correctamente.

*   **Crear Empleado (POST /api/v1/create):**  Se realiza una petición POST al endpoint `http://dummy.restapiexample.com/api/v1/create` para crear un nuevo empleado.  En la petición, se incluye un body con los datos del nuevo empleado.  Se valida el código de estado de la respuesta (esperando un 200 OK o 201 Created, según la especificación del API) y el body de la respuesta para verificar que el empleado se ha creado correctamente y se reciben los datos del empleado creado.

*   **Consultar Empleado por ID (GET /api/v1/employee/{id}):** Se realiza una petición GET al endpoint `http://dummy.restapiexample.com/api/v1/employee/1` (ejemplo con ID 1) para obtener la información de un empleado específico. Se valida el código de estado de la respuesta (esperando un 200 OK) y el body de la respuesta para asegurar que los datos del empleado consultado son correctos.

*   **Eliminar Empleado (DELETE /api/v1/delete/{id}):** Se realiza una petición DELETE al endpoint `http://dummy.restapiexample.com/api/v1/delete/2` (ejemplo con ID 2) para eliminar un empleado existente. Se valida el código de estado de la respuesta (esperando un 200 OK o 204 No Content, según la especificación del API) y el body de la respuesta para confirmar que la eliminación se ha realizado con éxito.

### Validación de Respuestas y Escenarios de Prueba

Un aspecto fundamental de este proyecto es la validación exhaustiva de las respuestas del API.  Para cada endpoint y verbo HTTP automatizado, se han creado escenarios de prueba específicos que incluyen:

*   **Validación del Status Code:**  Se verifica que el código de estado HTTP de la respuesta sea el esperado para cada operación. Por ejemplo, se espera un código 200 OK para las peticiones GET exitosas, un 201 Created para la creación de un recurso (POST), y un 200 OK o 204 No Content para la eliminación (DELETE).

*   **Validación del Body de la Respuesta:** Se valida la estructura y el contenido del body de la respuesta utilizando Hamcrest.  Esto incluye verificar que los campos esperados estén presentes, que los tipos de datos sean correctos y, en algunos casos, que los valores sean los esperados o sigan un patrón definido.  Para las listas, se pueden realizar validaciones sobre el tamaño, el contenido de elementos específicos, etc.

Se ha creado **un escenario de prueba por cada endpoint**, asegurando que cada acción (GET empleados, POST crear empleado, GET empleado por ID, DELETE empleado) tenga su propia prueba dedicada con validaciones completas sobre la respuesta obtenida. Esto facilita la identificación de errores y asegura la calidad de la automatización.

Este proyecto proporciona una base sólida para la automatización de pruebas de APIs REST utilizando Serenity BDD Screenplay y Cucumber, demostrando la capacidad de interactuar con diferentes verbos HTTP, enviar datos en las peticiones y validar exhaustivamente las respuestas del API.
