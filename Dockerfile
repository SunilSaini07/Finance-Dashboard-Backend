# Build stage with Maven + JDK 25
FROM maven:3.9.6-eclipse-temurin-25 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Runtime stage with JRE 25
FROM eclipse-temurin:25-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Render sets $PORT automatically
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
