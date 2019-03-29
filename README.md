# Batch du projet 7

[![CodeFactor](https://www.codefactor.io/repository/github/vawi/projet_7_batch/badge)](https://www.codefactor.io/repository/github/vawi/projet_7_batch)

Cette partie de l'application permet d'envoyer automatiquement des emails de relance aux utilisateurs ayant des emprunts en retard. 
Ce batch a deux objectifs : 
- Dans un premier temps, le plus important, envoyé des emails aux utilisateurs qui ont des ouvrages non rendus dans les temps.
- Dans un second temps, il enverra les informations au service pour modifier le statut d'un emprunt au sein de la db afin que celui ci soit explicitement marqué comme "en retard"

Cette partie de l'application a été généré avec Apache CXF, on y trouve aussi spring pour l'inversion de dépendances l'envoie d'emails
Cette application fonctionne automatiquement a l'aide d'un thread, qui enverra un email toutes les 24h aux utilisateurs ayant un ouvrage non rendu en retard.

Le batch est packagé a l'aide de maven assembly. les fichiers de configuration de l'email et les dépendances sont toutes présentes dans le zip généré en sortie.
Pour generer le zip en question il suffit d'utiliser la commande suivante a la racine du projet

    mvn package 

Pour facilité le lancement du programme on trouve dans le zip généré un fichier startup qui se charge de lancer le batch.

Cette partie ne se connecte pas directement a la db, pour fonctionner le service doit d'abord être lancé sur le port 8080
