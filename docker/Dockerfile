# Utilisez l'image eclipse-temurin:17 comme image de base pour le constructeur
FROM eclipse-temurin:17 as builder

# Définissez le répertoire de travail dans le conteneur
WORKDIR application

# Définissez une variable d'argument pour le nom de l'artefact
ARG ARTIFACT_NAME

# Copiez le fichier jar de l'artefact dans le conteneur
COPY target/${ARTIFACT_NAME}.jar app.jar

# Exécutez la commande java pour extraire les couches du jar
RUN java -Djarmode=layertools -jar application.jar extract

# Utilisez l'image eclipse-temurin:17 comme image de base pour l'image finale
FROM eclipse-temurin:17

# Définissez le répertoire de travail dans le conteneur
WORKDIR application

# Définissez une variable d'argument pour le port exposé
ARG EXPOSED_PORT

# Exposez le port spécifié
EXPOSE ${EXPOSED_PORT}

# Définissez la variable d'environnement SPRING_PROFILES_ACTIVE à docker
ENV SPRING_PROFILES_ACTIVE docker

# Copiez les dépendances de l'image du constructeur à l'image finale
COPY --from=builder application/dependencies/ ./

# Copiez le chargeur de démarrage de Spring Boot de l'image du constructeur à l'image finale
COPY --from=builder application/spring-boot-loader/ ./

# Copiez les dépendances instantanées de l'image du constructeur à l'image finale
COPY --from=builder application/snapshot-dependencies/ ./

# Copiez l'application de l'image du constructeur à l'image finale
COPY --from=builder application/application/ ./

# Définissez le point d'entrée pour l'image finale
ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]

#Ce Dockerfile est utilisé pour créer une image Docker pour une application Java avec Spring Boot. Il utilise l'outil de couches de jar pour séparer l'application en différentes couches, ce qui permet d'optimiser l'utilisation du cache Docker lors de la construction de l'image.