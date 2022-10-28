PURPOSE OF PROJECT:
VERSION or DATE:
HOW TO START THIS PROJECT:
AUTHORS:
USER INSTRUCTIONS:

# Projet Zuul

Un projet créer en JAVA dans le cadre de mes études à l'école d'ingénieur ESIEE Paris.

## Prérequis

## Installation

## Scénario

Le squelette d'un skateur légendaire répondant au nom de **Dem BONES** reprend vie et souhaite de nouveau "vivre" sa passion, **le skateboard**.\
Pour cela, il devra dans un premier temps réunir toutes les pièces nécessaires pour remonter une planche de skateboard complète, c'est à dire :
- 1 plateau
- 1 grip
- 2 trucks
- 8 roulements à billes
- 4 roues
- la visserie

Pour chacune de ces pièces, des défis devront être réalisés.

Une fois la nouvelle planche de skateboard montée, Dem BONES devra **se rendre sur des spots** de skateboard connus pour **réaliser des tricks** (figures) et revivre sa passion.

### Réunir toutes les pièces du skateboard

#### **Le plateau et le grip**

Le vendeur **prête un plateau** de skateboard à Dem BONES et lui demande de **réaliser quelques tricks**. Si tous les tricks sont réalisés, alors le vendeur **offre le plateau** et **le grip** à Dem BONES

**OU**

Dem BONES **achète** la plateau avec de **l'argent** et le vendeur lui **offre le grip**.

***Dépend de la conversation entre les 2 personnages***

#### **Les 2 trucks**

#### **Les roulements à billes**

#### **Les roues**

#### **La visserie**

### Liste des spots et des figures à réaliser

#### Figuress

|Nom de la figure       |Commande   |
|:----------------------|:---------:|
|Ollie                  |```sz```   |
|Nollie                 |```zs```   |
|Pop Shuvit             |```sd```   |
|FS Pop Shuvit          |```sq```   |
|Nollie Pop Shuvit      |```zq```   |
|Nollie FS Pop Shuvit   |```zd```   |
|Kickflip               |```se```   |
|Heelflip               |```sa```   |

#### Lieux

- Palais de Tokyo, Paris
- Place de la République, Paris
- Place de la Bastille, Paris
- Cosanostra Skatepark, Chelles
- Skatepark intérieur boutique

---
## Rapport

**Dem BONES SB**

### I.A) Auteur(s)

HOUEE Adrien, E3T année 2022 - 2023

### I.B) Thème (phrase-thème validée)

Dans une boutique de skateboard, Dem Bones doit monter sa nouvelle planche de skateboard

### I.C) Résumé du scénario (complet)

### I.D) Plan (complet, avec indication de la partie "réduit" si exercice 7.3.3)

### I.E) Scénario détaillé (complet, avec indication de la partie "réduit" si exercice 7.3.3)

### I.F) Détail des lieux, items, personnages

### I.G) Situations gagnantes et perdantes

### I.H) Eventuellement énigmes, mini-jeux, combats, etc.

### I.I) Commentaires (ce qui manque, reste à faire, ...)

### II. Réponses aux exercices (à partir de l'exercice 7.5 inclus)

#### Exercice 7.5

1. L'exercice 7.4 est bien terminé. 

4. Nous avons apporter cette modification afin d'optimiser le code et de ne pas le répéter. 
    De plus, si nous devons effectué un changement dans l'affichage des information de la pièce (Room) courante, en changeant cette fonction seulement, la modification sera répercuté à tous les endroits nécessaires.

#### Exercice 7.6

1. Quoi qu'il arrive une valeur sera affecté à chaque attribut, donc que la valeur soit null en paramètre ou null par défaut, cela ne change pas grand chose.

#### Exercice 7.7

1. Les sorties d'une pièce (Room), sont relative à la pièce, elle n'ont donc aucun intéret à ne pas être dans la classe Room.

#### Exercice 7.8

4. La procédure setExits est devenue inutile car elle n'est pas assez généraliste et limite les évolutions que l'on peut apporté au projet. Elle a été remplacer par setExit.

#### Exercice 7.9

3. la fonction keySet nous retourne l'ensemble des clés d'une HashMap

### III. Mode d'emploi (si nécessaire, instructions d'installation ou pour démarrer le jeu)

### IV. Déclaration obligatoire anti-plagiat (*)

### V, VI, etc... : tout ce que vous voulez en plus