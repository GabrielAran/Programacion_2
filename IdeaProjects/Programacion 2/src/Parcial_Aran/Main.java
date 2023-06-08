package Parcial_Aran;

import Clase_03.IStack;
import Clase_03.Stack;
import Diccionarios.Dictionary;
import NodosCosas.ISet;
import NodosCosas.Set;

public class Main {
    public static void main(String[] args){
        System.out.println("Parcial");

        // 1
        System.out.println("Ejercicio 1.A en clase: BinaryTreeParcial.java");

        System.out.println("Ejercicio 1.B en clase: SetEstaticoParcial.java y en interfaz: ISetParcial");
        // chequeo que funcione
        SetEstaticoParcial conjuntoBool = new SetEstaticoParcial();
        conjuntoBool.add(true);
        conjuntoBool.add(false);
        mostrarConjunto(conjuntoBool);
        conjuntoBool.remove(true);
        conjuntoBool.remove(false);
        System.out.println("Quedo vacio? " + conjuntoBool.isEmpty());

        // 2.A
        System.out.println();
        System.out.println("Ejercicio 2A, utilización de los tdas");

        Dictionary diccionario = new Dictionary();
        diccionario.add(2, 78);
        diccionario.add(20, 88);
        diccionario.add(8, 98);
        diccionario.add(1, 108);
        System.out.println("La menor clave par de un diccionario es: " + menorClavePar(diccionario)); // trae la menor clave que sea par

        // 2.B
        System.out.println();
        System.out.println("Ejercicio 2B, utilización de los tdas");

        IStack[] arrayStacks = new Stack[3]; // array de stacks cn 3 lugares
        IStack p1 = new Stack(); // seteo cda pos del array cn una pila
        IStack p2 = new Stack();
        IStack p3 = new Stack();

        p1.add(18);
        p1.add(1);
        p1.add(2);
        p1.add(3);

        p2.add(1);
        p2.add(2);
        p2.add(18);

        p3.add(1);
        p3.add(2);
        p3.add(18);

        arrayStacks[0] = p1;
        arrayStacks[1] = p2;
        arrayStacks[2] = p3;

        IStack pilaComunElementos = elementosEnComunStacks(arrayStacks);
        while (!pilaComunElementos.isEmpty()){
            System.out.println("LA PILA CON LOS ELEMENTOS EN COMUN: " + pilaComunElementos.getTop());
            pilaComunElementos.remove();
        }
    }

    public static int menorClavePar(Dictionary d1){
        ISet keys = d1.getKeys(); // agarro en un set las keys
        int claveUnica;
        int menorPar = 100000000;
        while (!keys.isEmpty()){ // deco.isEmpty() == False
            claveUnica = keys.choose(); // agarro una clave
            keys.remove(claveUnica); // la saco del set de claves ya que no volvera a ser usada otra vez
            if (claveUnica %2 == 0 && claveUnica < menorPar){
                menorPar = claveUnica;
            }
        }
        return menorPar;
    }

    public static IStack elementosEnComunStacks(IStack[] pila){
        IStack stackElementosEnComun = new Stack();
        ISet conjuntoAux = new Set();
        for (int i = 0; i < pila.length; i++){
            IStack copy = crearCopiaPila(pila[i]); // uso una copia asi no pierdo los elementos
            while (!copy.isEmpty()){ // vacio la copia en el conjunto
                conjuntoAux.add(copy.getTop());
                copy.remove();
            }
        } // pongo todos los elementos en un set: 1, 2, 3

        while (!conjuntoAux.isEmpty()){ // me fijo si los vals del set estan en todas las pilas
            boolean esta = true;
            int val = conjuntoAux.choose();
            for (int j = 0; j < pila.length; j++){
                IStack copy2 = crearCopiaPila(pila[j]); // agarro una copia para no perder org
                if (!estaEnPila(copy2, val)){ // si el valor no esta en todas las pilas, no lo agrega
                    esta = false;
                }
            }
            if (esta){ // EL VALOR ESTA EN LAS 3 PILAS
                stackElementosEnComun.add(val);
            }
            conjuntoAux.remove(val);
        }
        return stackElementosEnComun;
    }

    public static IStack crearCopiaPila(IStack pilaOrigen) { //PASA EL CONTENIDO DE UNA PILA A OTRA MANTENIENDO EL ORDEN. EL RESULTADO ES UNA PILA ESTATICA.
        IStack pilaFinal = new Stack();
        IStack pilaAux = new Stack();
        while (!pilaOrigen.isEmpty()){
            pilaAux.add(pilaOrigen.getTop());
            pilaOrigen.remove();
        }
        while (!pilaAux.isEmpty()){
            pilaFinal.add(pilaAux.getTop());
            pilaOrigen.add(pilaAux.getTop());
            pilaAux.remove();
        }
        return pilaFinal;
    }

    public static boolean estaEnPila(IStack p, int v){
        IStack copia = crearCopiaPila(p);
        while (!copia.isEmpty()){
            if (copia.getTop() == v){
                return true;
            }
            copia.remove();
        }
        return false;
    }
    public static void mostrarConjunto(SetEstaticoParcial mostro) { //PRINTEA UN CONJUNTO
        while (!mostro.isEmpty()){
            boolean val = mostro.choose();
            System.out.println("EL SET: " + val);
            mostro.remove(val);
        }
    }
}
