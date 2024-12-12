# Projet Android RoomDAO

## Description

Ce projet démontre l’intégration de la base de données Room dans une application Android écrite en Kotlin. Il inclut une interface UserDao pour gérer les opérations CRUD sur une entité User. 
L’application utilise les composants Lifecycle d’Android et prend en charge LiveData pour observer les modifications de la base de données en temps réel.

## Fonctionnalités

- Intégration de Room Database : Stockage local efficace des données.

- Opérations DAO :

             - Insertion, mise à jour, suppression des utilisateurs.

             - Requête pour récupérer tous les utilisateurs avec prise en charge de LiveData.

- Lifecycle Android : Intégration avec LiveData pour l’observation des données.

  

## Structure du projet

### Composants principaux

1. Entités :

    - User : Représente la table utilisateur dans la base de données.

2. DAO :

    - UserDao : Contient les méthodes d’accès à la base de données (insertion, mise à jour, suppression, requête).

3. Base de données :

   - UserDatabase : Classe abstraite représentant la base de données Room.

4. ViewModel :

   - Utilisé pour observer LiveData et communiquer entre l’interface utilisateur et la base de données.


## Installation

### Prérequis

- Android Studio : Arctic Fox (2020.3.1) ou version ultérieure.

- Support Kotlin : Assurez-vous que le JDK est installé.

- Version de Gradle : Compatible avec le plugin Android Gradle 8.2.1.

### Étapes

- Clonez le dépôt :

           git clone https://github.com/votre-repository.git

- Ouvrez le projet dans Android Studio.

- Synchronisez Gradle en cliquant sur File > Sync Project with Gradle Files.

- Compilez le projet :

./gradlew build

- Lancez l’application sur un émulateur ou un appareil physique.

## Configuration

### Paramètres Gradle

Dans build.gradle :

- Assurez-vous que les versions des dépendances Room et Lifecycle sont correctes :

           implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.6.0"
           implementation "androidx.lifecycle:lifecycle-runtime-ktx:2.6.0"
           implementation "androidx.room:room-runtime:2.5.2"
           kapt "androidx.room:room-compiler:2.5.2"

- Définissez compileSdk et targetSdk :

           compileSdk 34
           targetSdk 34

## Configuration de la base de données

- Annotez la classe User avec @Entity.

- Définissez primaryKey et les autres colonnes.

- Exemple :

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val email: String
)

## Utilisation

### Insérer un utilisateur

  val user = User(name = "John Doe", email = "johndoe@example.com")
  userDao.insert(user)

### Requêter les utilisateurs

  val users: LiveData<List<User>> = userDao.getAllUsers()
  users.observe(this) { userList ->
        // Mettre à jour l’interface utilisateur
  }

### Mettre à jour un utilisateur

  val updatedUser = user.copy(name = "Jane Doe")
  userDao.updateUser(updatedUser)

### Supprimer un utilisateur

  userDao.deleteUser(user)

## Dépannage

Problèmes courants

- Erreurs d’annotation Room :
Assurez-vous que les annotations @Entity, @Dao, @Database sont correctement appliquées.

- Compile SDK non pris en charge :
Mettez à jour compileSdk vers une version supportée ou supprimez les avertissements dans gradle.properties :

android.suppressUnsupportedCompileSdk=34

- Problèmes avec les coroutines :
Utilisez des fonctions suspend pour les méthodes DAO si vous utilisez les coroutines Kotlin.

## Contribution 

Forkez le dépôt.

Créez une branche pour votre fonctionnalité.

Validez les modifications et poussez-les dans votre fork.

Créez une pull request.

## Contributeurs 
- Salamata Nourou MBAYE
- Celaire Idriss OKA
- Chaimae MOUHDA
