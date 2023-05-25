package TASKS;

import Clase_02.Colas;
import Clase_02.PIla;

public class EjerciciosTomsColas {
    public static void main(String[] args){
        //COLAS
        pasarCola(crearColas());
        invertirColaConPila(crearColas());
        invertirColaRecursivo(crearColas());
        System.out.println("La cola es capicua? -> " + compararCapicua(crearColas()));
        Colas inversa = new Colas();
        inversa.acolar(28);
        inversa.acolar(18);
        inversa.acolar(8);
        System.out.println("Las colas son inversas? -> " + colasInversas(crearColas(), inversa));
    }
    public static Colas crearColas(){
        Colas unaCola = new Colas();
        unaCola.acolar(8);
        unaCola.acolar(18);
        unaCola.acolar(28);
        return unaCola;
    }
    public static void pasarCola(Colas origen) { //PASA EL CONTENIDO DE UNA COLA A OTRA MANTENIENDO EL ORDEN
        Colas destino = new Colas();
        while (!origen.estaVacio()){
            destino.acolar(origen.getPrimero());
            origen.desacolar();
        }
        System.out.println("EL primero de la nueva es: " + destino.getPrimero());
    }

    public static void invertirColaRecursivo(Colas cola) { //INVIERTE EL CONTENIDO DE UNA COLA SIN CREAR NADA AUXILIAR
        //RECURSIVIDAD si o si
        if (cola.estaVacio()){ // caso base para q no quede en bucle infinito
            return;
        }
        int temporal = cola.getPrimero(); // t = 1 || t = 2 || t = 3
        cola.desacolar(); // cola = 2 - 3 || cola = 3 || -
        invertirColaRecursivo(cola); // (2 - 3) || (3) || -
        cola.acolar(temporal); // t = 3 || t = 2 || t = 1+
    }

    public static void invertirColaConPila(Colas cola) { //INVIERTE UNA COLA USANDO UNA PILA AUXILIAR
        PIla aux = new PIla();
        while (!cola.estaVacio()){
            aux.apilar(cola.getPrimero());
            cola.desacolar();
        }
        while (!aux.isEmpty()){
            cola.acolar(aux.getTope());
            aux.desapilar();
        }
        while (!cola.estaVacio()){
            System.out.println("La cola invertida es: " + cola.getPrimero());
            cola.desacolar();
        }
    }

    public static boolean compararCapicua(Colas colaCapicua) { //VERIFICA SI UNA COLA ES CAPICUA
        boolean capicua = true;
        Colas copia = new Colas();
        Colas aux = new Colas();
        while (!colaCapicua.estaVacio()){
            copia.acolar(colaCapicua.getPrimero());
            aux.acolar(colaCapicua.getPrimero());
            colaCapicua.desacolar();
        }
        invertirColaRecursivo(aux); // invierto aux
        while (!aux.estaVacio()){
            if (aux.getPrimero() != copia.getPrimero()){
                capicua = false;
                break;
            }
            aux.desacolar();
            copia.desacolar();
        }
        return capicua;
    }
    public static boolean colasInversas(Colas colaBien, Colas colaInversa) { //VERIFICA SI 2 COLAS SON INVERSAS
        boolean inversas = true;
        invertirColaRecursivo(colaInversa);
        while (!colaBien.estaVacio() && !colaInversa.estaVacio()){
            if (colaBien.getPrimero() != colaInversa.getPrimero()){
                inversas = false;
                break;
            }
            colaBien.desacolar();
            colaInversa.desacolar();
        }
        return inversas;
    }
}
