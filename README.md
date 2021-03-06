# UnitTestingProjectUASB
[![Build Status](https://travis-ci.org/claudiasg/UnitTestingProjectUASB.svg?branch=master)](https://travis-ci.org/claudiasg/UnitTestingProjectUASB)

## Pruebas_Unitarias_Sentimiento

### Contexto
El análisis del sentimiento es una tarea del campo de la lingüística computacional que busca determinar la actitud general de una determinada pieza de texto. Por ejemplo, nos gustaría tener un programa que pueda ver el texto "Esta tarea fue alegre y un placer" y darse cuenta de que fue una afirmación positiva, mientras que "Me hizo querer sacarme el pelo" es negativo.

Un algoritmo que podemos usar para esto es asignar un valor numérico a cualquier palabra dada en función de qué tan positiva o negativa es esa palabra y luego determinar el sentimiento general de la declaración en función de los valores promedio de las palabras.

Para determinar el sentimiento de una palabra individual, podemos usar un corpus de enunciados, cada uno de los cuales tiene un puntaje general ya asignado. El sentimiento de una palabra individual es igual al promedio de las declaraciones en las que aparece esa palabra.

Por ejemplo:

--------------------------------------------------------------------------------

0 This was not as much fun as I thought it would be .

1 I had a lot of fun on this and learned a lot .

-1 It would be more fun if we had more time to work on it .

2 I didn’t think programming in Java could be so much fun !

-2 I would have preferred an easier assignment .

2 I can’t think of anything more fun than learning Java !

----------------------------------------------------------------------------------

Cada declaración está etiquetada con un puntaje de -2 a 2 de la siguiente manera:

-2: muy negativo

-1: algo negativo

 0: neutral

1: algo positivo

2: muy positivo

------------------------------------------------------------------------------------------------------------------

Para determinar el sentimiento general de la palabra "fun",  tomamos el promedio de las oraciones en las que aparece. En este caso, sería (0 + 1 + -1 + 2 + 2) / 5 = 0.8.
