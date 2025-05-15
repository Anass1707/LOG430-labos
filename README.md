# LOG430-labos
LOG430-labo est un projet spring-boot très simple qui affiche un message "Hello, World!".

# Démarage
Pour pouvoir exécuter cette application localement il y a des prérequis nécessaires.
## Prérequis
1. S'assurer d'avoir java 21 installé (vous pouvez utiliser la commde "java -version" pour vérifier votre version) .
2. Une version maven 3.9+ installée (vous pouvez utiliser la commde "mvn -v" pour vérifier votre version).
3. Docker et Docker-compose installés.
4. Cloner le projet et se placer à ce niveau "~/projects/LOG430-labos"

## Lancer l'application
1. "mvn clean install": pour compiler le projet et regénerer le dossier traget.
2. "mvn spring-boot:run": pour lancer localement l'application.
3. Ouvrir votre navigateur web avec http://localhost:8080


## Construire et lancer le conteneur à l’aide de Docker-Compose
Il suffit de lancer la commande "docker-compose up --build" pour reconstruire l'image du projet et son conteneur et lancer le service.

### Note
Si vous lancer l'application via une VM linux, que ça soit avec les commandes mvn ou docker, une étape de plus est nécessaire avant d'ouvrir votre navigateur: 

* Sur windows, ouvrir un CMD et lancer la commande "ssh -L 8080:localhost:8080 log430@10.194.32.178". Ensuite, une saisie du mot de passe est necessaire. Une fois la connexion est réussie, un tunnel est établi avec la VM et vous pouvez ouvrir votre navigateur et accéder à http://localhost:8080

# Workflow ci-java
Un workflow a été mis en place afin d'automatiser les étapes de vérification du code. Le workflow est composé de trois jobs, "Lint", "Build and test" et "Build and push Docker image".
- L'étape "Lint":  vérifie la conformiter du code avec les régles de checkstyle.
- L'étape "Build and test": cette étape est lancée uniquement si l'étape "Lint" est réussie. Lors de cette étape le projet est compilé et tous les tests sont lancés. Tous les tests doivent passés pour que cette étape soit réussie.
- L'étape "Build and push Docker image": cette étape est lancée uniquement si l'étape "Build and test" est réussie. Lors de cette étape une image docker est créée et est publiée sur Docker Hub.

Voici une éxecution du workflow: 
![Exécution du workflow CI](img/ci-java.png)

# Architecture du projet
Ce projet suit une architecture classique d’application Spring Boot :

- Spring Boot: gère la configuration, le cycle de vie de l’application et expose les endpoints REST.
- Maven: pour la gestion des dépendances, la compilation, les tests unitaires et le packaging.
- GitHub Actions: workflow qui permet de faire la vérification des règles checkstyle, compilation et tests du code et déploiement d’une image Docker.
- Docker: permet de containeriser l’application pour faciliter le déploiement.

# Structure du projet
Voici une représentation de ce projet Spring Boot.

```
LOG430-labos/
├── .github/
│   └── workflows/
│       └── ci-java.yml           # Workflow CI/CD GitHub Actions
├── src/
│   ├── main/
│   │   └── java/                 # Code source Java
│   │       └── ...               # (fichiers sources Java)
│   └── test/
│       └── java/                 # Tests unitaires Java
│           └── ...               # (fichiers de test)
├── .dockerignore                 # Fichiers/dossiers ignorés par docker
├── .gitignore                    # Fichiers/dossiers ignorés par git
├── pom.xml                       # Configuration Maven
├── README.md                     # Documentation du projet
├── Dockerfile                    # Image Docker de l'application
└── docker-compose.yml            # Orchestration multi-conteneurs
```