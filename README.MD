# Ajedrez vikinga: Hnefatafl

El [**Hnefatafl**](https://es.wikipedia.org/wiki/Hnefatafl) es un juego de mesa muy antiguo. Se desarrolla en un **tablero** de 11 filas y 11 columnas. El juego se compone de dos jugadores, un **atacante** y un **defensor**. En la
imagen, el defensor tiene las fichas azules y la ficha amarilla que es el **Rey**. La casilla donde se encuentra el **Rey** se denomina **Trono**. El atacante tiene las fichas rojas y es el que empieza la partida. Cada jugador puede ser un usuario o una máquina.

-----

La disposición inicial del tablero es la siguiente:



<p align="center">
 <img alt="Tablero Inicial" width="400px" src="/doc/resources/eclipse_board.png" />
</p>

----

Todas las fichas, incluido el rey, se mueven como las torres del ajedrez, en vertical y horizontal cualquier cantidad de casillas libres. Los jugadores realizan un movimiento por turno. El tablero tendrá que mostrarse en consola por cada movimiento realizado, pintando de un color diferente el último movimiento (casilla origen y casilla destino) para poder apreciar cuál ha sido el movimiento de esa jugada.

El **Trono** y las casillas de **las 4 esquinas** se consideran **casillas especiales** por lo que tendrán que dibujarse de manera diferente al resto. Estas casillas especiales **solamente pueden ser ocupadas por el Rey**.

Una **ficha** _(excepto el rey)_ es **capturada** y sacada del tablero cuando el oponente ocupa ambas casillas adyacentes en horizontal o vertical. Ahora bien, las capturas sólo se efectúan cuando ha sido el atacante el que encierra a su rival y no cuando éste coloca una de sus piezas entre dos enemigas. También se pueden utilizar el Trono (cuando esté vacío) y las casillas de las esquinas que ejercen como una pieza aliada a la hora de atrapar a un rival.

El **rey** es **capturado** si se cumple una de las siguientes circunstancias:

- Las cuatro casillas alrededor de él en horizontal y en vertical son ocupadas por
fichas enemigas.

- Si está rodeado por tres lados por fichas enemigas (en horizontal y en vertical) y en
la cuarta está el Trono.

El objetivo del defensor es lograr que el rey se escape saliendo por alguna de las 4
esquinas del tablero. El objetivo del atacante es atrapar al rey. También perderá el
jugador que no pueda realizar ningún movimiento.

----

Juego en acción:

<p align="center">
 <img alt="CPU jugando contra otra CPU" width="400px" src="/doc/resources/eclipse_testgame.gif" />
</p>


----

## Entrega

La **entrega** del proyecto se realizará en **GitHub**.

> (Tenéis que poner al profesor [<img style="vertical-align:middle; border-radius: 50%;" src="https://avatars.githubusercontent.com/u/93053595" width="20px"> `epermac856`](https://github.com/epermac856/) como colaborador). 

Cada entrega tiene que ir con su correspondiente
commit.

El alumno tiene que realizar los siguientes **apartados**: (Se indica en cada apartado en qué asignatura se va a evaluar y en qué fecha es la entrega):

  1. [**Diagrama de casos de uso**](/diagrams/UseCaseDiagram.drawio.png). (Entornos de desarrollo, **09/04/2024**) Si se realiza algún cambio en el diagrama después de esta fecha, hay que hacer un commit especificando en el mensaje el motivo del cambio realizado.

  2. [**Diagrama de clases**](/diagrams/ClassDiagram.drawio.png). (Entornos de desarrollo, **09/04/2024**) Si se realiza algún cambio en el diagrama después de esta fecha, hay que hacer un commit especificando en el mensaje el motivo del cambio realizado.

  3. [**Código de Programación en Java.**](/src/) (Programación, **08/05/2024**) El alumno no podrá empezar a programar hasta que no tenga realizado los dos apartados anteriores. Hay que utilizar lo aprendido en el segundo trimestre, es decir, herencia, colecciones, programación funcional utilizando lambdas y referencias a métodos y Streams. Para la comunicación con el usuario hay que utilizar la práctica `ConsoleInput` como una librería `.jar` . El código tiene que estar programado en inglés.

  4. [**Documentación en JavaDoc**](/doc/) del código de todo el Proyecto. (Entornos de
  desarrollo, **08/05/2024**)
  
  5. [**Pruebas de caja negra**](/blackBoxes/MovesBlackBox.xlsx) y [**JUnits**](/src/test/MoveTest.java). (Entornos de desarrollo, **20/05/2024**) Se prueba si un movimiento es válido.

  6. **Torneo entre máquinas.** (Entornos de desarrollo y Programación) Se realizará en grupo formado por toda la clase. Se compone de dos fases:

     * Realización del diagrama de clases y el código java necesario para preparar el torneo. (**21/05/2024 - 28/05/2024**)
    
     * Realización del torneo. (**29/05/2024**)

### 📅 Resumen de entregas:

| Apartado  | Fecha de entrega |
| :----------- | :-----------: |
| Diagrama de casos de uso        | 16/04/2024 |
| Diagrama de clases              | 16/04/2024 |
| Código de Programación en Java  | 08/05/2024 |
| Documentación en JavaDoc        | 08/05/2024 |
| Pruebas de caja negra y  JUnits | 22/05/2024 |
| Torneo entre máquinas           | 21/05/2024 - 28/05/2024 |
| Realización del torneo          | 29/05/2024 |

*** 

### 📁 Distribución de carpetas

La **distribución de las carpetas** debe ser la siguiente:

* 📁 [`Carpeta principal`](/): es el proyecto en Java. Se debe llamar Hnefatafl .

* Dentro de la carpeta principal, habrá varias subcarpetas:
 
    * 📁 [`src`](/src/) : código del juego organizado en paquetes. En un paquete test tendrán que estar los Junits.
     
    * 📁 [`diagrams`](/diagrams/) : diagrama de casos de uso y diagrama de clases.
     
    * 📁 [`blackBoxes`](/blackBoxes/) : cajas negras.
     
    * 📁 [`doc`](/doc/)  : documentación en JavaDoc.
