# Étape 1 : construire le projet avec Maven (ou Gradle)
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copier les fichiers Maven et télécharger les dépendances
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copier le code source et construire l’application
COPY src ./src
RUN mvn clean package -DskipTests

# Étape 2 : créer l’image exécutable
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copier le jar généré depuis l’étape précédente
COPY --from=build /app/target/*.jar app.jar

# Exposer le port de Spring Boot
EXPOSE 8989

# Démarrer l’application
ENTRYPOINT ["java", "-jar", "app.jar"]
