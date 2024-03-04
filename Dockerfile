FROM amazoncorretto:17-alpine

WORKDIR /app

COPY ./target/Postgres-0.0.1-SNAPSHOT.jar /app

CMD ["java", "-jar", "Postgres-0.0.1-SNAPSHOT.jar"]