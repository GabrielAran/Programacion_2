package TPO.Ejercicio6;

import NodosCosas.Set;

public class Main {
    public static void main(String[] args){
        /* EJERCICIO 6:
        1. StackLimitada
        2.
        */
        SuperSet c = new SuperSet();
        Set c2 = new Set();
        c.add(3);
        c.add(2);
        c.add(1);

        c2.add(2);
        c2.add(1);
        c2.add(4);
        System.out.println(c.subconjunto(c2));
        mostrarConjunto(c.conjuntoComplementario(c2));
    }
    public static void mostrarConjunto(SuperSet mostro) { //PRINTEA UN CONJUNTO
        while (!mostro.isEmpty()){
            int val = mostro.choose();
            System.out.println("la copia: " + val);
            mostro.remove(val);
        }
    }
}
