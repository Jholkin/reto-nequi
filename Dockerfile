FROM eclipse-temurin:17.0.15_6-jre-noble

LABEL authors="jholkin"
LABEL maintainer="jhil.palacios@unas.edu.pe"

WORKDIR /app

# Copiar los archivos de configuración de Gradle
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

# Descargar las dependencias
RUN ./gradlew dependencies

# Copiar el código fuente
COPY src ./src

# Set the default command to run the Java application
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Xmx524M", "-jar", "/app.jar"]