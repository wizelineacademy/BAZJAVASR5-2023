# Contenedores y Orquestación
Recursos y pasos importantes para el curso

## Antes del curso
Es importante que antes del curso se estudie por cuenta propia los siguientes recursos:
* [SDKMan](https://sdkman.io/install) (Sólo en caso de que se requiera cambiar la versión del SDK)
* [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download) (Se puede usar otro IDE, se recomienda este para mayor facilidad)
* [Docker Desktop](https://docs.docker.com/engine/install/)
* [Docker Compose](https://docs.docker.com/compose/)
* [Minikube](https://minikube.sigs.k8s.io/docs/start/) (Versión local de un cluster de Kubernetes para probar la orquestación de los microservicios)

# :computer:  Actividades

## Antes de empezar :exclamation:
Para realizar esta actividad es importante tener Java 19 para poder trabajar con la última versión viable del SDK, en caso de tener que cambiar de versión se recomienda usar SDKMan. Se debe contar con Docker Desktop para poder probar los despliegues y Minikube para probar la orquestación de los microservicios en Kubernetes.

## Primer Entregable: MVP usando Spring Boot basado en Java 19 con Gradle
Debemos obtener una aplicación de Spring Boot de Spring Initializr como se muestra a continuación: 

![Initializr](img/Spring%20Initializr.png)

Tomando esta aplicacion como base podemos simplemente agregar la siguiente anotacion en la clase principal para que funcione con Spring Web MVC:

``` java
@EnableWebMvc
```

Y despues crear un controlador que contenga esto:

```java
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/k8s")
public class K8sController {

    @GetMapping("/hello")
    public ResponseEntity<String> helloK8S() {
        System.out.println("Saying Hello World!");
        return new ResponseEntity<>("Hello World!", HttpStatusCode.valueOf(200));
    }


}
```

Con eso y debido a que Spring Initializr hace la configuracion de Gradle por nosotros ya debemos de ser capaces de ejecutar el microservicio, acceder a la ruta http://localhost:8080/k8s/hello y obtener respuesta.

## Segundo Entregable: Microservicio desplegado en contenedor multi-etapa de Docker con un JAR en capas
Ahora que tenemos el microservicio que queremos desplegar, debemos crear un Dockerfile que le permita construirse usando Gradle (de preferencia tomandolo de la imagen base) y copiando el resultado a una carpeta desde la cual levantar el microservicio. El Dockerfile debe lucir similar a esto:

```Dockerfile
#Step 1: Build the app using a Gradle image as base
FROM gradle:jdk19 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

#Step 2: Copy the built app to where it will execute
FROM amazoncorretto:19-alpine
EXPOSE 8080
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/spring-boot-application.jar
ENTRYPOINT ["java","-jar", "spring-boot-application.jar"]
```

De esta manera nos estamos asegurando de poder desplegarlo sin mayor complicacion. Sin embargo, la forma mas eficiente de desplegar una aplicacion escrita en Java siempre va a ser con su version por capas cuya generacion soporta Gradle por defecto y que podemos aprovechar para que Docker guarde en cache los contenidos de cada una. Esto nos va a permitir ahorrar tiempo al introducir cambios al contenedor y hace que el Dockerfile ahora luzca asi:

```Dockerfile
#Step 1: Build the app using a Gradle image as base
FROM gradle:jdk19 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

#Step 2: Copy the built app to where it will execute and extract its layers
FROM amazoncorretto:19-alpine AS builder
EXPOSE 8080
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/spring-boot-application.jar
RUN java -Djarmode=layertools -jar /app/spring-boot-application.jar extract

#Step 3: Layering application to cache steps
FROM amazoncorretto:19-alpine
COPY --from=builder dependencies/ ./
COPY --from=builder snapshot-dependencies/ ./
COPY --from=builder spring-boot-loader/ ./
COPY --from=builder application/ ./
ENTRYPOINT ["java","org.springframework.boot.loader.JarLauncher"]
```

Al haberlo separado por etapas (cada FROM es una etapa) podemos agrupar mejor la logica y permitirle a Docker guardar etapas completas en cache.

## Tercer Entregable: Archivo de Docker Compose para controlar el ciclo de vida del contenedor
Para poder automatizar las actividades de construccion, despliegue y desmontado de un contenedor se recomienda usar Docker Compose. La intencion es manejar una version MVP de esta tecnologia que no complique en vano su configuracion y que nos permita ejecutar comandos facilmente. Una version muy simple de este archivo luce asi:

```yaml
version: "3"
services:
  app:
    #Optional
    image: k8s:latest
    #Optional
    container_name: k8s
    build:
      context: .
      dockerfile: Dockerfile-Layered
    ports:
      - "8080:8080"
```

Al hacer esto debemos poder ejecutar los comandos habituales que nos permiten manipular al contenedor:

```bash
docker-compose build
docker-compose up
docker-compose down
```

## Cuarto Entregable: Archivo de despliegue en Minikube para instalar un despliegue en un pod de un cluster de Kubernetes
Kubernetes se emplea para administrar mejor los contenedores que creamos con Docker. La idea es que a traves de hacer este despliegue nosotros podamos mantener sincronizados los microservicios que componen al cluster y agregar mas recursos o modificar su configuracion muy facilmente; un archivo normalmente deberia lucir asi:

```yaml
WIP
```

# :books: Para aprender mas
* [Spring Boot con Gradle](https://luiscualquiera.medium.com/spring-boot-gradle-docker-c310f2a12ab0)
* [Dockerizar una aplicacion de Spring Boot](https://www.baeldung.com/dockerizing-spring-boot-application)
* [Creando imagenes de Docker usando Gradle (Primera Opcion)](https://codefresh.io/docs/docs/example-catalog/ci-examples/gradle/)
* [Creando imagenes de Docker usando Gradle (Segunda Opcion)](https://ashoksubburaj.medium.com/build-docker-image-using-spring-boot-buildimage-gradle-ac5bc1f71303)
* [Instalando JARs en capas en Docker](https://www.baeldung.com/spring-boot-docker-images)
* [El Daemon de Gradle](https://docs.gradle.org/8.0.2/userguide/gradle_daemon.html#sec:disabling_the_daemon)
* [Habilitar rapidamente una aplicacion de Spring Boot para funcionar en Docker](https://www.docker.com/blog/kickstart-your-spring-boot-application-development/)
* [Docker Compose con Spring Boot](https://www.bezkoder.com/docker-compose-spring-boot-mysql/)
* [Spring Boot con Kubernetes](https://spring.io/guides/gs/spring-boot-kubernetes/)
