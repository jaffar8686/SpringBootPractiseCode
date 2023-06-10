FROM maven:latest as maven
WORKDIR /app
COPY . /app
RUN mvn package


FROM openjdk:11
WORKDIR /app
COPY --from=maven /app/target/springbootdemo-0.0.1-SNAPSHOT.jar /app/target/demo.jar
EXPOSE 8181
ENTRYPOINT ["java" ,"-jar","/app/target/demo.jar"]