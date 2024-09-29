# MotsCaches
Data Structure and algorithms project

Ce programme prend en parametre un fichier texte dans lequel , il y a une grille de mots bidimensionnelle
composée de M x N cellules, et les mots specifiques a rechercher. Sa tache consiste a identifier les mots 
de la liste fournie qui peuvent être formés en traversant des caractères adjacents sur la grille. 
Un caractère est considéré comme adjacent s'il est voisin horizontalement, verticalement ou en diagonale,
ce qui implique huit cellules possibles, ainsi que la cellule elle-même, formant un total de neuf
possibilités et permettant la création de boucles.De plus , un caractère (une cellule) peut être visité plusieurs  
fois au sein d'un mot. 
Ainsi le programme a pour objectif d'identifier toutes les occurrences des
mots donnés qui peuvent être formées en utilisant la règle d'adjacence, et
de produire en sortie ces mots et leurs chemins correspondants dans
l'ordre lexicographique.
