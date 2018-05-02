# XebiaMowerExerciceVQ

## Contexte

Résolution de l'exercice de la tondeuse pour l'entretien technique de Xebia (05/2018 - Vincent Queignec).

## Périmètre fonctionnel couvert

* Placement d'un élément (tondeuse) sur une carte et exécute une liste de commandes.
* Gestion des collisions (limites terrain et obstacle sur une case).
* Gestion légèrement plus avancée de l'état d'une case que demandé dans l'énoncé (tondu ou pas par exemple).

## Technologies utilisées

* Java 1.8
* Cucumber
* Lombok (à rajouter à l'IDE si nécessaire !)

## Points notables

* Commentaires en anglais dans le code.
* Les données en entrée sont injectées par les tests cucumber (fichier .feature) qui sont a exécuter.
* Gestion finale des exceptions primaire (simple printing) pour simplifier l'exemple.
