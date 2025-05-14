# Étape 1 : Utilise l'image officielle Maven pour construire l'application
FROM maven:3.9.6-eclipse-temurin-21-alpine AS builder

WORKDIR /labos

# Copie le pom.xml et les sources
COPY pom.xml .
COPY checkstyle.xml .
COPY src ./src

# Compile l'application et crée un jar (avec dépendances)
RUN mvn clean package -DskipTests

# Étape 2 : Image minimaliste avec juste le JAR
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /labos

# Copie le jar depuis l'image "builder"
COPY --from=builder /labos/target/*.jar labos.jar

# Port exposé (modifie si besoin)
EXPOSE 8080

# Commande de lancement
ENTRYPOINT ["java", "-jar", "labos.jar"]