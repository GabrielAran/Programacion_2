package FinalDeEjemplo;

import Clase_03.Stack;
import NodosCosas.ColasDinamicas;
import NodosCosas.PriorityQueue;

public class Main {
    public static void main(String[] args){
        PriorityQueue cp = new PriorityQueue();
        cp.add(1, 1000);
        cp.add(2, 2000);
        cp.add(3, 3000);
        //mostrarColaPrioridad(cp);// prioridad mas baja, aparece adelante (:
        Ejercicio2a(cp);
        // EJERCICIO 2B EN EJERCICIOS_TOMS_ARBOLES
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
}
