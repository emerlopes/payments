FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY build/libs/*.jar app.jar
EXPOSE 8084
CMD ["java", "-jar", "app.jar"]