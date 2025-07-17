#  ADR 03: Choix de cache

## Statut :
    Accepté – 15 juillet 2025

## Contexte :
Dans le cadre du projet LOG430, les microservices manipulent des données provenant de bases de données relationnelles (PostgreSQL).
Certaines de ces données sont consultées très fréquemment (produits, ventes, etc), mais peu modifiées.
Afin d’améliorer les performances, réduire la charge sur la base de données, et accélérer les temps de réponse, il fallait mettre en place une stratégie de cache efficace.

## Décision :
J'ai choisi d’utiliser Redis comme système de cache distribué pour ce projet.

## Justification :
Les raisons de ce choix sont les suivantes :
- Support natif dans Spring Boot: Intégration facile avec les annotations @Cacheable, @CachePut, @CacheEvict.
- Facile à déployer avec Docker: Une simple image Redis suffit, ajoutée au docker-compose.yml du projet.
- Cache distribué: Redis peut être utilisé par plusieurs microservices connectés dans le même réseau Docker.

## Conséquences :
- Redis sera démarré dans Docker via le service redis dans docker-compose.yml.

- Chaque microservice pourra accéder à Redis en utilisant SPRING_REDIS_HOST=redis.

- Les données mises en cache devront être explicitement marquées via les annotations @Cacheable, etc.


## Alternatives considérées :
- Ehcache: Fonctionne uniquement en mémoire locale, non adapté à un environnement Docker multi-services.
- Memcached: Moins flexible, ne gère pas nativement la persistance et les structures complexes.