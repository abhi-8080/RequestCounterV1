FROM openjdk:17-alpine
COPY target/counter-0.0.1-SNAPSHOT.jar counter-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/counter-0.0.1-SNAPSHOT.jar"]
