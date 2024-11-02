FROM openjdk:17-oracle

# Configure working directory
RUN mkdir /app

COPY ./target/achievements-0.0.1-SNAPSHOT.jar /app/achievements.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "/app/achievements.jar" ]