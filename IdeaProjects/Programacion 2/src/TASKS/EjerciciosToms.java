package TASKS;

import Clase_02.PIla;

public class EjerciciosToms { // aca van todos los ejercicios del coso de toms
    public static void main(String[] args){
        //PILAS
        invertirPila(crearPilas());

    }

    public static PIla crearPilas(){
        PIla unaPila = new PIla();
        unaPila.apilar(8);
        unaPila.apilar(21);
        unaPila.apilar(9);
        unaPila.apilar(19);
        return unaPila;
    }
    //PILAS
    public static PIla invertirPila(PIla pilaOriginal) { //PASA EL CONTENIDO DE UNA PILA A OTRA INVIRTIENDO EL ORDEN. EL RESULTADO ES UNA PILA ESTATICA.
        PIla pilaFinal = new PIla();


        return pilaFinal;
    }
/*
    public static PIla CopiaPilaAOtra(PIla PilaOrigen, PIla PilaResultado) { //PASA EL CONTENIDO DE UNA PILA A OTRA MANTENIENDO EL ORDEN. EL RESULTADO ES UNA PILA ESTATICA.

    }

    public static PIla CopiarPila(PIla Pila) { //GENERA UNA COPIA DE UNA PILA. EL RESULTADO ES UNA PILA ESTATICA.

    }

    public static void InvertirPila(PIla Pila) { //INVIERTE EL CONTENIDO DE UN PILA

    }

    public static int ContarElementosPila(PIla Pila) { //CUENTA LOS ELEMENTOS DE UNA PILA

    }

    public static int SumarElementosPila(PIla Pila) { //SUMA LOS ELEMENTOS DE UNA PILA

    }

    public static void pilasIguales (PIla P1 , PIla P2) { //VERIFICA SI 2 PILAS SON IGUALES EN CONTENIDO Y ORDEN

    }

    public static void pilasMismosElementos (PIla P1 , PIla P2) { //VERIFICA SI 2 PILAS TIENEN EL MISMO CONTENIDO, PUEDE HABER REPETIDOS Y NO IMPORTA EL ORDEN

    }*/
}
