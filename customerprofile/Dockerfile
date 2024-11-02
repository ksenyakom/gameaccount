FROM openjdk:17-oracle

# Configure working directory
RUN mkdir /app

COPY ./target/customerprofile-0.0.1-SNAPSHOT.jar /app/customerprofile.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "/app/customerprofile.jar" ]