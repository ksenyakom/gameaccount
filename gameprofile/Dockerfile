FROM openjdk:17-oracle

# Configure working directory
RUN mkdir /app

COPY ./target/gameprofile-0.0.1-SNAPSHOT.jar /app/gameprofile.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "/app/gameprofile.jar" ]