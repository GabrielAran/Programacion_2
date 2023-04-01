package Ejercicios;

import Clase_02.Colas;
import Clase_02.PIla;

public class EjerciciosColas {
    public static void main(String[] args){
        System.out.println("Ejercicios Colas");

        pasarElementos(crearCola());
        invertirColaConPila(crearCola());

        Colas cola = new Colas();
        cola.acolar(1);
        cola.acolar(2);
        cola.acolar(3);

        invertirColaSola(cola);

        while (!cola.estaVacio()) {
            System.out.println(cola.getPrimero());
            cola.desacolar();
        }

        System.out.println("La Cola es CAPICUA?: " + capicua(crearCola()));
    }

    public static Colas crearCola(){
        Colas cola = new Colas();
        cola.acolar(1);
        cola.acolar(5);
        cola.acolar(10);
        cola.acolar(5);
        cola.acolar(1);
        return cola;
    }
    public static void pasarElementos(Colas original){ // EJ 1
        Colas colaNueva = new Colas();
        while (!original.estaVacio()){
            colaNueva.acolar(original.getPrimero());
            original.desacolar();
        }
    }

    public static void invertirColaConPila(Colas original){ // EJ 2
        PIla pilaAux = new PIla();
        while (!original.estaVacio()){
            pilaAux.apilar(original.getPrimero());
            original.desacolar();
        }

        while (!pilaAux.isEmpty()){
            original.acolar(pilaAux.getTope());
            pilaAux.desapilar();
        }
    } // ESTA FUNCION UTILIZA UNA PILA AUXILIAR PARA DAR VUELTA UNA COLA.
    // DESACOLO UNA COLA Y LA APILO EN UNA PILA, ENTONCES LOS ELEMENTOS SE DAN VUELTA. (:

    public static void invertirColaSola(Colas cola) { // FUNCION RECURSIVA PARA INVERTIR UNA COLAS
        if (cola.estaVacio()) {
            return;
        }
        int temporal = cola.getPrimero();
        cola.desacolar();
        invertirColaSola(cola);
        cola.acolar(temporal);
    }

    public static boolean capicua(Colas col){
        boolean capi = true;
        Colas aux1 = new Colas();
        Colas aux2 = new Colas();
        while (!col.estaVacio()){
            aux1.acolar(col.getPrimero());
            aux2.acolar(col.getPrimero());
            col.desacolar();
        }
        invertirColaSola(aux2);
        while (!aux1.estaVacio()){
            if (aux1.getPrimero() != aux2.getPrimero()){
                capi = false;
                break;
            }
            aux1.desacolar();
            aux2.desacolar();
        }

        return capi;
    }
}
