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
