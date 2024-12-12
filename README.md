# Projet Android RoomDAO

## Description

Ce projet démontre l’intégration de la base de données Room dans une application Android écrite en Kotlin. Il inclut une interface UserDao pour gérer les opérations CRUD sur une entité User. 
L’application utilise les composants Lifecycle d’Android et prend en charge LiveData pour observer les modifications de la base de données en temps réel.

## Fonctionnalités

- Intégration de Room Database : Stockage local efficace des données.

    -Opérations DAO :

Insertion, mise à jour, suppression des utilisateurs.

Requête pour récupérer tous les utilisateurs avec prise en charge de LiveData.

Lifecycle Android : Intégration avec LiveData pour l’observation des données.

Structure du projet

Composants principaux

Entités :

User : Représente la table utilisateur dans la base de données.

DAO :

UserDao : Contient les méthodes d’accès à la base de données (insertion, mise à jour, suppression, requête).

Base de données :

UserDatabase : Classe abstraite représentant la base de données Room.

ViewModel :

Utilisé pour observer LiveData et communiquer entre l’interface utilisateur et la base de données.

Structure des dossiers
