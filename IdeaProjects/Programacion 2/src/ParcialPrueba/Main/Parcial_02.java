package ParcialPrueba.Main;

import Arboles.IBinaryTree;
import Clase_02.Colas;
import Clase_02.PIla;
import Clase_03.Stack;
import NodosCosas.ColasDinamicas;
import NodosCosas.Set;

import java.awt.*;

public class Parcial_02 {
    public static void main(String[] args){
        // ESTATICO
       /* MaximumRestrictedStack pilaEstatica = new MaximumRestrictedStack();
        pilaEstatica.apilar(8);
        pilaEstatica.apilar(7);
        pilaEstatica.apilar(6);
        pilaEstatica.apilar(10);
        pilaEstatica.apilar(15);
        pilaEstatica.apilar(5);
        while (!pilaEstatica.isEmpty()){
            System.out.println("Pila: " + pilaEstatica.getTope());
            pilaEstatica.desapilar();
        }

        System.out.println("\n");

        // DINAMICO
        MaximumRestrictedStackDinamic pilaDinamica = new MaximumRestrictedStackDinamic();
        pilaDinamica.add(8);
        pilaDinamica.add(7);
        pilaDinamica.add(6);
        pilaDinamica.add(15);
        pilaDinamica.add(4);
        pilaDinamica.add(5);
        while (!pilaDinamica.isEmpty()){
            System.out.println("EL PEPE: " + pilaDinamica.getTop());
            pilaDinamica.remove();
        }

        System.out.println("\n");
        System.out.println("Desarrolle una funcion que recibe una pila y una cola y devuelve true si\n" +
                "los elementos de ambas estructuras son los mismos (sin importar orden ni\n" +
                "repeticion).");

        Stack pila = new Stack();
        pila.add(1);
        pila.add(2);
        pila.add(3);

        ColasDinamicas cola = new ColasDinamicas();
        cola.acolar(1);
        cola.acolar(2);
        cola.acolar(3);
        System.out.println("Tienen los mismos elementos? " + mismosElementos(pila, cola)); */

        // COMO SABER CUANTOS NODOS TIENE UN ARBOL:
        /*
        public static int pesoArbol(IBinaryTree a) { //CUENTA LA CANTIDAD DE NODOS DE UN ARBOL BINARIO
            if (a == null || a.isEmpty()){
                return 0;
            }
            return 1 + pesoArbol(a.getLeft()) + pesoArbol(a.getRight());
        } */

        // arbol degerado es q tenga un solo hijo x lado tope
    }

    public static boolean mismosElementos(Stack pila1, ColasDinamicas cola1){
        Stack pilaCopy = copiarPila(pila1);
        ColasDinamicas colaCopy = copiarCola(cola1);
        boolean pertenecenAmbos = true;

        // chequo si los de la pila estan en la cola
        while (!pilaCopy.isEmpty()){
            if (!perteneceLaCola(copiarCola(cola1), pilaCopy.getTop())){ // pertenece a la cola?
                pertenecenAmbos = false;
                break;
            }
            pilaCopy.remove();
        }
        // chequo si los de la cola estan en la pila
        if (pertenecenAmbos) { // SI YA ES FALSE NI CHEQUEO
            while (!colaCopy.estaVacio()) {
                if (!perteneceLaPila(copiarPila(pila1), colaCopy.getPrimero())){ // pertenece a la cola?
                    pertenecenAmbos = false;
                    break;
                }
                colaCopy.desacolar();
            }
        }
        return pertenecenAmbos;
    }

    public static Stack copiarPila(Stack pilaOrigen) {
        Stack pilaFinal = new Stack();
        Stack pilaAux = new Stack();
        while (!pilaOrigen.isEmpty()){
            pilaAux.add(pilaOrigen.getTop());
            pilaOrigen.remove();
        }
        while (!pilaAux.isEmpty()){
            pilaFinal.add(pilaAux.getTop());
            pilaOrigen.add(pilaAux.getTop());
            pilaAux.remove();
        }
        return pilaFinal;
    }

    public static ColasDinamicas copiarCola(ColasDinamicas origen) { //PASA EL CONTENIDO DE UNA COLA A OTRA MANTENIENDO EL ORDEN
        ColasDinamicas destino = new ColasDinamicas();
        ColasDinamicas aux = new ColasDinamicas();
        while (!origen.estaVacio()){
            destino.acolar(origen.getPrimero());
            aux.acolar(origen.getPrimero());
            origen.desacolar();
        }
        while (!destino.estaVacio()){
            origen.acolar(destino.getPrimero());
            destino.desacolar();
        }
        return aux;
    }

    public static boolean perteneceLaCola(ColasDinamicas cola, int value){
        boolean pertenece = false;
        while (!cola.estaVacio()){
            if (value == cola.getPrimero()){
                pertenece = true;
                break;
            }
            cola.desacolar();
        }
        return pertenece;
    }

    public static boolean perteneceLaPila(Stack pila, int value){
        boolean pertenece = false;
        while (!pila.isEmpty()){
            if (value == pila.getTop()){
                pertenece = true;
                break;
            }
            pila.remove();
        }
        return pertenece;
    }
}
