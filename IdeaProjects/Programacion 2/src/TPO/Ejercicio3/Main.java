package TPO.Ejercicio3;

import Clase_02.Colas;

public class Main {
    public static void main(String[] args){

    }

    public static QueueOfQueue generarQueues(){
        QueueOfQueue cola = new QueueOfQueue();
        Colas col = new Colas();
        Colas col2 = new Colas();
        col.acolar(2);
        col.acolar(3);
        col.acolar(4);

        col2.acolar(5);
        col2.acolar(6);
        col2.acolar(7);
        cola.acolar(col);
        cola.acolar(col2);
        return cola;
    }
    public static void mostrarCola(QueueOfQueue cola){
        while (!cola.estaVacio()){
            while (!cola.getPrimero().estaVacio()){
                System.out.println("p: " + cola.getPrimero().getPrimero());
                cola.getPrimero().desacolar();
            }
            cola.desacolar();
        }
    }

    public static QueueOfQueue concatenar(QueueOfQueue c1, QueueOfQueue c2){
        QueueOfQueue nueva = new QueueOfQueue();
        while (!c1.estaVacio()){ // lleno la nueva con la primera
            nueva.acolar(c1.getPrimero());
            c1.desacolar();
        }
        while (!c2.estaVacio()){
            nueva.acolar(c2.getPrimero());
            c2.desacolar();
        }
        return nueva;
    }

    public static Colas flat(QueueOfQueue c){
        Colas colaFlat = new Colas();
        while (!c.estaVacio()){
            while (!c.getPrimero().estaVacio()){
                colaFlat.acolar(c.getPrimero().getPrimero());
                c.getPrimero().desacolar();
            }
            c.desacolar();
        }
        return colaFlat;
    }

    public static QueueOfQueue reverseWithDepth(QueueOfQueue cola) { // terminar, no esta bien
        Colas[] listaColas;
        while (!cola.estaVacio()){

            cola.desacolar();
        }
        invertirQueueOfQueue(cola); // invierto la QueueOfQueue
        return cola;
    }

    public static void invertirCola(Colas cola){
        if (cola.estaVacio()){
            return;
        }
        int temporal = cola.getPrimero();
        cola.desacolar();
        invertirCola(cola);
        cola.acolar(temporal);
    }

    public static void invertirQueueOfQueue(QueueOfQueue cola){
        if (cola.estaVacio()){
            return;
        }
        Colas temporal = cola.getPrimero();
        cola.desacolar();
        reverseWithDepth(cola);
        cola.acolar(temporal);
    }
}
