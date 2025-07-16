#  ADR 01: Choix d'srchitecture

## Statut :
    Accepté – 22 mai 2025

## Contexte :
    L’application expose une API REST et doit être modulaire.

## Décision :
    Utiliser une architecture de 3 couches :
    - Présentation : Controller
    - Logique métier : Service
    - Persistance : Repository

## Justification :
    - Séparation claire des responsabilités
    - Facile à tester et à maintenir

## Conséquences :
    - Utilisation potentielle de DTOs
    - Simplifie les tests unitaires

