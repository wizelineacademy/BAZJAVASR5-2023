# Transacciones y resiliencia

# :hammer_and_wrench:  Requisitos
- Java 11+
- IDE
    * [Visual Studio Code](https://code.visualstudio.com/download)
    * [IntelliJ](https://www.jetbrains.com/idea/download)

# :pencil: Actividad
## Resiliencia
1. Configura un proyecto con SpringBoot para utilizar SpringRetry
2. Elige un API de esta página [REST APIs](https://jsonplaceholder.typicode.com/)
3. Construye un cliente con FeignClient que se conecte a esta API
4. Agrega un servicio y un controlador en tu proyecto, que interactúen con el cliente del paso anterior
5. Implementa una estrategia de reintentos para fallos transitorios