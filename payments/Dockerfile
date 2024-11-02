FROM openjdk:17-oracle

# Configure working directory
RUN mkdir /app

COPY ./target/payments-0.0.1-SNAPSHOT.jar /app/payments.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "/app/payments.jar" ]