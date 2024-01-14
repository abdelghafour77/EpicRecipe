# Stage 1: Build the application
FROM maven:3.8.1-openjdk-17-slim AS build
WORKDIR /workspace
COPY . .
RUN mvn package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /workspace/target/*.jar app.jar
EXPOSE 8081
CMD ["java", "-jar", "app.jar"]

# FROM eclipse-temurin:17-jdk-alpine
# VOLUME /tmp
# WORKDIR /app
# COPY target/*.jar app.jar
# EXPOSE 8081
# ENTRYPOINT ["java","-jar","app.jar"]