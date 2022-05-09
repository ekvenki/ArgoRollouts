FROM openjdk:11
EXPOSE 8090
COPY target/orchestrator-service-1.0.0.jar orchestrator-service.jar
ENTRYPOINT ["java","-jar","/orchestrator-service.jar"]