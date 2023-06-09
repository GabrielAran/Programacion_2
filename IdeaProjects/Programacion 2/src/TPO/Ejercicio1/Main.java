package TPO.Ejercicio1;

import Clase_03.Stack;

public class Main {
    public static void main(String[] args){
        /*
        * La complejidad computacional de los algoritmos es:
        * Ejercicio a: O(n²)
        * Ejercicio b: O(n²)
        * Ejercicio c: O(n²)
        * */
    }
    public static QueueOfStacks sumaMatricial(QueueOfStacks m1, QueueOfStacks m2, int largo){
        QueueOfStacks matrizSumada = new QueueOfStacks(largo);
        Stack listaAux1[] = new Stack[largo];
        Stack listaAux2[] = new Stack[largo];

        for (int i = 0; i < largo; i++){ // creo una lista de pilas
            listaAux1[i] = new Stack();
            listaAux2[i] = new Stack();
            for (int j = 0; j < largo; j++){
                listaAux1[i].add(m1.getPrimero().getTope());
                listaAux2[i].add(m2.getPrimero().getTope());
                m1.getPrimero().desapilar();
                m2.getPrimero().desapilar();
            }
            m1.desacolar();
            m2.desacolar();
        }

        for (int i = 0; i < largo; i++){ // agarro los elementos de ambas pilas y los sumo, luego acolo
            for (int j = 0; j < largo; j++){
                int suma = listaAux1[i].getTop() + listaAux2[i].getTop();
                matrizSumada.acolar(suma);
                listaAux1[i].remove();
                listaAux2[i].remove();
            }
        }
        return matrizSumada;
    }
    public static int calcularTraza(QueueOfStacks mat, int indice){ // EJ_1a
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
    public static QueueOfStacks traspuesta(QueueOfStacks original, int largo){ // EJ_1b
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
}
