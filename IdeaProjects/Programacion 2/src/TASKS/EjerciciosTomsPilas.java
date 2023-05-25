package TASKS;

import Clase_02.PIla;
import Clase_03.Conjuntos;

public class EjerciciosTomsPilas { // aca van todos los ejercicios del coso de toms
    public static void main(String[] args){
        //PILAS
        invertirPila(crearPilas());
        copiaPilaAOtra(crearPilas());
        System.out.println("La cantidad de elementos es: " + ContarElementosPila(crearPilas()));
        System.out.println("La suma de los elementos es: " + SumarElementosPila(crearPilas()));
        System.out.println("Las pilas son iguales? -> " + pilasIguales(crearPilas(), crearPilas()));
        PIla pilaMismos = new PIla();
        pilaMismos.apilar(8);
        pilaMismos.apilar(21);
        pilaMismos.apilar(22);
        System.out.println("Las pilas tienen el mismo contenido? -> " + pilasMismosElementos(crearPilas(), pilaMismos));
    }

    public static PIla crearPilas(){
        PIla unaPila = new PIla();
        unaPila.apilar(8);
        unaPila.apilar(21);
        unaPila.apilar(8);
        return unaPila;
    }
    //PILAS
    public static PIla invertirPila(PIla pilaOriginal) { //PASA EL CONTENIDO DE UNA PILA A OTRA INVIRTIENDO EL ORDEN. EL RESULTADO ES UNA PILA ESTATICA.
        PIla pilaFinal = new PIla();
        while (!pilaOriginal.isEmpty()){ // ! es lo mismo que pilaOriginal.isEmpty() == false
            pilaFinal.apilar(pilaOriginal.getTope());
            pilaOriginal.desapilar();
        }
        return pilaFinal;
    }

    public static PIla copiaPilaAOtra(PIla pilaOrigen) { //PASA EL CONTENIDO DE UNA PILA A OTRA MANTENIENDO EL ORDEN. EL RESULTADO ES UNA PILA ESTATICA.
        PIla pilaFinal = new PIla();
        PIla pilaAux = new PIla();
        while (!pilaOrigen.isEmpty()){
            pilaAux.apilar(pilaOrigen.getTope());
            pilaOrigen.desapilar();
        }
        while (!pilaAux.isEmpty()){
            pilaFinal.apilar(pilaAux.getTope());
            pilaOrigen.apilar(pilaAux.getTope());
            pilaAux.desapilar();
        }
        return pilaFinal;
    }


    public static int ContarElementosPila(PIla pila) { //CUENTA LOS ELEMENTOS DE UNA PILA
        int cont = 0;
        while (!pila.isEmpty()){
            cont ++;
            pila.desapilar();
        }
        return cont;
    }

    public static int SumarElementosPila(PIla pila) { //SUMA LOS ELEMENTOS DE UNA PILA
        int acum = 0;
        while (!pila.isEmpty()){
            acum += pila.getTope();
            pila.desapilar();
        }
        return acum;
    }

    public static boolean pilasIguales (PIla p1 , PIla p2) { //VERIFICA SI 2 PILAS SON IGUALES EN CONTENIDO Y ORDEN
        boolean iguales = true;
        while (!p1.isEmpty() && !p2.isEmpty()){
            if (p1.getTope() != p2.getTope()){
                iguales = false;
                break;
            }
            if ((p1.isEmpty() && !p2.isEmpty()) || !p1.isEmpty() && p2.isEmpty()){
                iguales = false;
                break;
            }
            p1.desapilar();
            p2.desapilar();
        }
        return iguales;
    }

    public static boolean pilasMismosElementos (PIla p1 , PIla p2) { //VERIFICA SI 2 PILAS TIENEN EL MISMO CONTENIDO, PUEDE HABER REPETIDOS Y NO IMPORTA EL ORDEN
        boolean mismoContenido = true;
        Conjuntos conjP1 = new Conjuntos();
        Conjuntos conjP2 = new Conjuntos();
        PIla copiaP1 = copiaPilaAOtra(p1); // hago copias de p1 y p2 pero no se pierden wow
        PIla copiaP2 = copiaPilaAOtra(p2);

        while (!p1.isEmpty() || !p2.isEmpty()){ // agrego ambas pilas a sus SETS correspondientes
            conjP1.add(p1.getTope());
            conjP2.add(p2.getTope());
            p1.desapilar();
            p2.desapilar();
        }

        while (!copiaP1.isEmpty() && !copiaP2.isEmpty()){
            // me fijo si cada elemento de la copia_pila 1 esta en el SET 2
            // me fijo si cada elemento de la copia_pila 2 esta en el SET 1
            if (!conjP1.Pertenece(copiaP2.getTope()) || !conjP2.Pertenece(copiaP1.getTope())){
                mismoContenido = false;
                break;
            }
            copiaP1.desapilar();
            copiaP2.desapilar();
        }
        return mismoContenido;
    }
}
