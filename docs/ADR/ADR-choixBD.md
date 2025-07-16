
# ADR 02: Choix de la base de données

## Statut :
   Accepté – 22 mai 2025

## Contexte :
    Le système doit stocker des entités bien structurées
    (produits, ventes, retours, utilisateurs), avec des relations claires.

## Décision :
    Utiliser une base de données relationnelle PostgreSQL

## Justification :
    - Structure correspond aux données du projet
    - Cohérence et transactions ACID
    - Première expérience avec PostgreSQL

## Conséquences :
    - Requêtes complexes possibles en SQL
    - Possibilité de faire des jointures efficaces entre entités liées
    - Connexions via JDBC très stables et bien supportées.
