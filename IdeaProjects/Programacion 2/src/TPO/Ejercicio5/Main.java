package TPO.Ejercicio5;

import Arboles.ISearchBinaryTree;
import Arboles.SearchBinaryTree;
import Clase_03.Stack;
import NodosCosas.Set;

import java.util.Random;

public class Main {
    public static void main(String[] args){
        // EJERCICIO 5, ALGORITMO 1: ordenerStack
        // Complejidad = O(n log n)

        // 2. Defina una región cuadrada en el primer cuadrante: dentro de Montecarlo.java

        // 4. Cree un conjunto de coordenadas y agreguele elementos hasta que su cardinal sea 1000, de forma
        //aleatoria:
        agregarCoordenadasSet();
        System.out.println("Aproximacion de pi: " + aproximarPi(1000000));
    }

    public static Stack ordenerStack(Stack pila){
        Set set = new Set();
        Stack stackFinal = new Stack();

        while (!pila.isEmpty()){ // paso a un set para sacar los repetidos
            set.add(pila.getTop());
            pila.remove();
        }

        ISearchBinaryTree arbolito = new SearchBinaryTree();
        while (!set.isEmpty()){ // pongo los elementos en un abb
            int valor = set.choose();
            arbolito.add(valor);
            set.remove(valor);
        }

        stackFinal = orderAbbStack(arbolito, stackFinal); // ordeno los elementos del abb y los apilo
        return stackFinal;
    }
    public static Stack orderAbbStack (ISearchBinaryTree arbolits, Stack pila) { // PRINT: IZQUIERDA - RAIZ - DERECHO
        if (arbolits == null || arbolits.isEmpty()){ // caso base para terminar la recursividad
            return null;
        }
        orderAbbStack(arbolits.getRight(), pila);
        pila.add(arbolits.getRoot());
        orderAbbStack(arbolits.getLeft(), pila);
        return pila;
    }

    public static void agregarCoordenadasSet(){
        SetCoordenadas cardinal1000 = new SetCoordenadas();
        Random random = new Random();
        for (int i = 0; i < 1000; i++){
            Coordenadas cordenada = new Coordenadas(random.nextDouble(), random.nextDouble());
            cardinal1000.add(cordenada);
        }
    }

    public static double aproximarPi(int aproximaciones){
        double contHits = 0;
        for (int i = 0; i < aproximaciones; i++){
            double x = Math.random();
            double y = Math.random();

            if (x*x + y*y <=1){
                contHits++;
            }
        }
        double pi = 4.0 * contHits / aproximaciones; // CALCULA PI
        return pi;
    }
}
