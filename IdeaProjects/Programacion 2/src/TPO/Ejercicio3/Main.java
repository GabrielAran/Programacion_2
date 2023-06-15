package TPO.Ejercicio3;

import Clase_02.Colas;
public class Main {
    public static void main(String[] args){
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
        QueueOfQueue queueinvertida = new QueueOfQueue();
        while (!cola.estaVacio()){
            invertirCola(cola.getPrimero());
            queueinvertida.acolar(cola.getPrimero()); // invierto cada cola y la acolo en una nueva QueueOfQueue
            cola.desacolar();
        }
        invertirQueueOfQueue(queueinvertida); // invierto la QueueOfQueue total (:
        return queueinvertida;
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

    public static void invertirQueueOfQueue(QueueOfQueue queue){
        if (queue.estaVacio()){
            return;
        }
        Colas temporal = queue.getPrimero();
        queue.desacolar();
        invertirQueueOfQueue(queue);
        queue.acolar(temporal);
    }
}
