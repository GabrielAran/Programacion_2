package Ejercicios;

import Clase_02.PIla;

public class EjerciciosPilas {
    public static void main(String[] args) {
        System.out.println("EJERCICIOS DE PILA");

        pasarPila(generarPila());
        copiarPila(generarPila());
        invertirPila(generarPila());
        contarElementosPila(generarPila());
        acumularElementosPila(generarPila());
        promedioElementosPila(generarPila());

        System.out.println("EJERCICIOS DE PILA TERMINADOS (5.1.2 - 5.1.7)");
    }

    public static PIla generarPila(){
        PIla pila = new PIla();
        pila.apilar(8);
        pila.apilar(9);
        pila.apilar(1);
        pila.apilar(10);
        pila.apilar(100);
        pila.apilar(88);
        return pila;
    }

    public static PIla pasarPila(PIla pilaInicial){ // EJ 1
        int aux = 0;
        PIla pilaFinal = new PIla();

        while (!pilaInicial.isEmpty()){ // pilaInicial.isEmpty() == false
            aux = pilaInicial.getTope();
            pilaFinal.apilar(aux);
            pilaInicial.desapilar();
        }
        return pilaFinal;
    }

    public static void copiarPila(PIla pilaAux){ // EJ 2
        pilaAux = pasarPila(pilaAux);
        pilaAux = pasarPila(pilaAux);
        System.out.println("Copiar la pila: " + pilaAux.getTope());
    }

    public static void invertirPila(PIla pilaOutsider){ // EJ 3
        pilaOutsider = pasarPila(pilaOutsider);
        pilaOutsider = pasarPila(pilaOutsider);
        pilaOutsider = pasarPila(pilaOutsider);
        System.out.println("Invertir la pila: " + pilaOutsider.getTope());
    }

    public static void contarElementosPila(PIla cuentoPila){ // EJ 4 = Ej (5.1.5)
        PIla aux = new PIla();
        int contador = 0;

        while (!cuentoPila.isEmpty()){
            aux.apilar(cuentoPila.getTope());
            cuentoPila.desapilar();
            contador++;
        }

        cuentoPila = pasarPila(aux);
        System.out.println("La pila original no se perdio: " + cuentoPila.getTope());
        System.out.println("La cantidad de elementos de la pila es: " + contador);
    }

    public static void acumularElementosPila(PIla cuentoPila){ // EJ 4 = Ej (5.1.5)
        PIla aux = new PIla();
        int acumulador = 0;

        while (!cuentoPila.isEmpty()){
            aux.apilar(cuentoPila.getTope());
            acumulador += cuentoPila.getTope();
            cuentoPila.desapilar();
        }

        cuentoPila = pasarPila(aux);
        System.out.println("La pila original no se perdio: " + cuentoPila.getTope());
        System.out.println("La suma de los elementos de la pila es: " + acumulador);
    }

    public static void promedioElementosPila(PIla cuentoPila){ // EJ 4 = Ej (5.1.5)
        PIla aux = new PIla();
        int promedio = 0;
        int cantidad = 0;

        while (!cuentoPila.isEmpty()){
            aux.apilar(cuentoPila.getTope());
            promedio += cuentoPila.getTope();
            cuentoPila.desapilar();
            cantidad ++;
        }

        cuentoPila = pasarPila(aux);
        promedio = promedio / cantidad;
        System.out.println("La pila original no se perdio: " + cuentoPila.getTope());
        System.out.println("El promedio de los elementos de la pila es: " + promedio);
    }
}
