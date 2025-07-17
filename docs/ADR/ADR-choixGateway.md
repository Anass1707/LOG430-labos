#  ADR 04: Choix d'API Gateway

## Statut :
    Accepté – 15 juillet 2025

## Contexte :
    
Dans le cadre du projet LOG430, l’architecture cible repose sur plusieurs microservices déployés via Docker :

- un service monolithique (app),

- un service de gestion des ventes (ventes-service),

- potentiellement d’autres services à venir.

Il est nécessaire de mettre en place une API Gateway afin de centraliser :

- les entrées réseau vers les services backend,

- la gestion du routing,

- la sécurité (CORS, authentification),

- le logging des requêtes,

- la scalabilité future.
## Décision :
J'ai choisi d'intégrer Spring Cloud Gateway comme API Gateway.

## Justification :
Les raisons principales de ce choix sont :

- Intégration native avec Spring Boot

    - Compatible avec tous les microservices Spring Boot du projet.

    - Configuration simple via application.properties ou Java.
- Personnalisation simple

    - Développement de filtres Java très accessible pour gérer CORS, sécurité, logs, etc.
- Déploiement facile en Docker

    - Il peut directement router vers les services par nom (ventes-service, app, etc.).

## Conséquences :

- Le port exposé pour l’accès aux services sera désormais centralisé via l’API Gateway (ex: localhost:8088/api/v1/...).

- Les services ne seront plus exposés directement aux clients.

- Les futures optimisations comme le caching, ou l’authentification OAuth2 pourront être ajoutées facilement via des filtres Gateway.

## Alternatives considérées :

- Nginx: Nécessite une configuration plus complexe et séparée et moins dynamique.
- Kong: Puissant, mais complexe à configurer et surdimensionné pour un projet académique.