FROM eclipse-temurin:17-jdk-alpine
ADD target/testing-service-1.0.0.jar testing-service.jar
EXPOSE 9902
ENTRYPOINT ["java", "-jar", "testing-service.jar"]