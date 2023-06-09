package Tp_progra;

import Clase_03.Stack;

public class Main {
    public static void main(String[] args){
        mostrarMatrizCuadrada(generarMatrizNxN(3));
        System.out.println("La traza da: " + calcularTraza(generarMatrizNxN(3), 1));
        mostrarMatrizCuadrada(traspuesta(generarMatrizNxN(3), 3));
    }

    public static int calcularTraza(QueueOfStacks mat, int indice){ // EJ_1
        int aux = mat.getPrimero().getTope();
        mat.desacolar();
        if (!mat.estaVacio() && mat.getPrimero() != null){
            for (int i = 0; i < indice; i++){
                mat.getPrimero().desapilar();
            }
            return aux + calcularTraza(mat, indice + 1);
        }
        return aux;
    }

    public static QueueOfStacks traspuesta(QueueOfStacks original, int largo){ // EJ_2
        QueueOfStacks alRevez = new QueueOfStacks(largo);
        int matrizReal[][] = new int[largo][largo];
        Stack stackAux[] = new Stack[largo]; // creo una lista de pilas
        int indiceAux = 0;

        // Lleno mi lista de stacks con las pilas de la cola
        while (!original.estaVacio()){
            stackAux[indiceAux] = new Stack();
            while (!original.getPrimero().isEmpty()){
                stackAux[indiceAux].add(original.getPrimero().getTope()); // los apilo para apilar de vuelta en orden
                original.getPrimero().desapilar();
            }
            indiceAux++;
            original.desacolar();
        }

        // Creo una matriz real igual a la cola de pilas
        for (int i = 0; i < stackAux.length; i++){
            for (int j = 0; j < stackAux.length; j++){
                matrizReal[i][j] = stackAux[j].getTop();
                stackAux[j].remove();
            }
        }

        // Acolo los elementos para que me quede la traspuesta de la original, en una nueva QueueOfStacks
        for (int i = 0; i < stackAux.length; i++){
            for (int j = 0; j < stackAux.length; j++){
                alRevez.acolar(matrizReal[i][j]);
            }
            System.out.println();
        }

        return alRevez;
    }
    public static QueueOfStacks generarMatrizNxN(int n){
        QueueOfStacks matriz = new QueueOfStacks(n); // n x n = 3 x 3
        matriz.acolar(9);
        matriz.acolar(6);
        matriz.acolar(3);

        matriz.acolar(8);
        matriz.acolar(5);
        matriz.acolar(2);

        matriz.acolar(7);
        matriz.acolar(4);
        matriz.acolar(1);
        return matriz;
    }
    public static void mostrarMatrizCuadrada(QueueOfStacks m){
        while (!m.estaVacio()){
            while (!m.getPrimero().isEmpty()){
                System.out.println(m.getPrimero().getTope());
                m.getPrimero().desapilar();
            }
            System.out.println();
            m.desacolar();
        }
    }
}
