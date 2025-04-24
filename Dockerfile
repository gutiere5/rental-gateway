FROM openjdk:17
COPY build/libs/rental-gateway-service.jar rental-gateway-service.jar
ENTRYPOINT ["java", "-jar", "/rental-gateway-service.jar"]