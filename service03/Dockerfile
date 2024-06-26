FROM eclipse-temurin:17-jdk-alpine
ADD target/sample-service-1.0.0.jar sample-service.jar
EXPOSE 9902
ENTRYPOINT ["java", "-jar", "sample-service.jar"]