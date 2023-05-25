package TASKS;
import Clase_02.Colas;
import NodosCosas.PriorityQueue;

public class EjerciciosTomsColasPrioridad {
    public static void main(String[] args){
        //COLAS CON PRIORIDAD
        valsYprios(crearColasPrioridad());
        mostrarColaPrioridad(crearColasPrioridad());
        copiarColaPrioridad(crearColasPrioridad());
    }

    public static PriorityQueue crearColasPrioridad(){
        PriorityQueue colaPrio = new PriorityQueue();
        colaPrio.add(45, 1);
        colaPrio.add(55, 2);
        colaPrio.add(65, 3);
        return colaPrio;
    }
    public static void valsYprios(PriorityQueue priorityQueue) { //CONVIERTE UNA COLA CON PRIORIDAD EN 2 COLAS, UNA DE VALORES Y UNA DE PRIORIDADES
        Colas valores = new Colas();
        Colas prioridades = new Colas();
        while (!priorityQueue.isEmpty()){
            valores.acolar(priorityQueue.getFirstValue()); //acolo valores
            prioridades.acolar(priorityQueue.getFirstPriority()); //acolo prioridades
            priorityQueue.remove(); //desacolo
        }
        /* ESTO ES PA VER Q FUNCIONE -->
        while (!valores.estaVacio()){
            System.out.println(valores.getPrimero());
            System.out.println(prioridades.getPrimero());
            valores.desacolar();
            prioridades.desacolar();
        } */
    }

    public static void mostrarColaPrioridad(PriorityQueue full) { //PRINTEA EL CONTENIDO DE UNA COLA CON PRIORIDAD EN EL FORMATO "ELEMENTO(PRIORIDAD:)"
        while (!full.isEmpty()){
            System.out.println(full.getFirstValue() + "(" + full.getFirstPriority() + ")");
            full.remove();
        }
    }

    public static void copiarColaPrioridad(PriorityQueue cola) { //GENERA UNA COPIA DE UNA COLA CON PRIORIDAD
        PriorityQueue copia = new PriorityQueue();
        PriorityQueue aux = new PriorityQueue();
        while (!cola.isEmpty()){
            copia.add(cola.getFirstValue(), cola.getFirstPriority());
            aux.add(cola.getFirstValue(), cola.getFirstPriority());
            cola.remove();
        }
        while (!aux.isEmpty()){
            cola.add(aux.getFirstValue(), aux.getFirstPriority());
            aux.remove();
        }
        // mostrarColaPrioridad(cola); chequeamos q funione
        // mostrarColaPrioridad(copia); chequeamos q funione
    }
}
