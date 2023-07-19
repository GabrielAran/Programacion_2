package FinalDeEjemplo;

import Clase_03.Stack;
import NodosCosas.ColasDinamicas;
import NodosCosas.PriorityQueue;

import java.util.Random;

public class Main {
    public static void main(String[] args){
        /*PriorityQueue cp = new PriorityQueue();
        cp.add(1, 1000);
        cp.add(2, 2000);
        cp.add(3, 3000);
        //mostrarColaPrioridad(cp);// prioridad mas baja, aparece adelante (:
        Ejercicio2a(cp);
        // EJERCICIO 2B EN EJERCICIOS_TOMS_ARBOLES*/
        ColasDinamicas ejemplo = new ColasDinamicas();
        ejemplo.acolar(1);
        ejemplo.acolar(2);
        ejemplo.acolar(3);
        jumpTheQueue(ejemplo, 8);
        while (!ejemplo.estaVacio()){
            System.out.println(ejemplo.getPrimero());
            ejemplo.desacolar();
        }
    }

    public static void mostrarColaPrioridad(PriorityQueue full) { //PRINTEA EL CONTENIDO DE UNA COLA CON PRIORIDAD EN EL FORMATO "ELEMENTO(PRIORIDAD:)"
        while (!full.isEmpty()){
            System.out.println(full.getFirstValue() + "(" + full.getFirstPriority() + ")");
            full.remove();
        }
    }

    public static void Ejercicio2a(PriorityQueue cp){
        Stack values = new Stack();
        ColasDinamicas priorities = new ColasDinamicas();
        while (!cp.isEmpty()){
            values.add(cp.getFirstValue()); // lleno aux de values en pila para invertir
            priorities.acolar(cp.getFirstPriority()); // lleno aux de priorities en cola para mantener orden
            cp.remove();
        }
        while (!values.isEmpty()){
            cp.add(values.getTop(), priorities.getPrimero());
            values.remove();
            priorities.desacolar();
        }
        mostrarColaPrioridad(cp);
    }

    public static void jumpTheQueue(ColasDinamicas cola, int value){
        if (cola.estaVacio()){ // si esta vacia acola normal
            cola.acolar(value);
        } else {
            Random random = new Random();
            if (random.nextDouble() <= 0.3) { // tiene un 30% de probabilidad de que suceda jumpTheQueue
                int contElementos = 0;
                ColasDinamicas aux = new ColasDinamicas();
                while (!cola.estaVacio()) {
                    aux.acolar(cola.getPrimero());
                    cola.desacolar();
                    contElementos++; // cuantos elementos hay para la pos de colada xd
                }
                int position = random.nextInt(contElementos) + 1; // mas 1 así incluye
                int index = 0;
                while (!aux.estaVacio()) {
                    if (position == index) {
                        cola.acolar(value); // lo acolo en esa posicion random
                    }
                    cola.acolar(aux.getPrimero());
                    aux.desacolar();
                    index++;
                }
                if (position == index) { // por si caeria en el final, sad ):
                    cola.acolar(value);
                }
            }
        }
    }
}
