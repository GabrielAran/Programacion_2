package TASKS;

import Arboles.BinaryTree;
import Arboles.IBinaryTree;
import Arboles.ISearchBinaryTree;
import Arboles.SearchBinaryTree;
import NodosCosas.Set;

public class EjerciciosTomsArboles {
    public static void main(String[] args){
        //ARBOLES
        System.out.println("----- PRE ORDER -----");
        preOrden(crearArbolBinario());
        System.out.println("----- IN OREDER -----");
        inOrden(crearArbolBinario());
        System.out.println("----- POST ORDER -----");
        postOrden(crearArbolBinario());
        System.out.println("La cantidad de nodos del arbol son, (peso): " + pesoArbol(crearArbolBinario()));
        System.out.println("La cantidad de niveles del arbol son: " + calcularProfundidad(crearArbolBinario()));
        System.out.println("El valor esta en el nivel: " + queNivelEsta(crearArbolBinarioBusqueda(), 60));
        System.out.println("El valor esta en el arbol?? " + existeEnABB(crearArbolBinarioBusqueda(), 50));
        System.out.println("El valor es hoja? " + esHojaABB(crearArbolBinarioBusqueda(), 60));
        System.out.println("La cantidad de valores pares son: " + nodosParesEnABB(crearArbolBinarioBusqueda()));
        System.out.println("La cantidad de valores impares son: " + nodosImparesEnABB(crearArbolBinarioBusqueda()));
    }

    public static IBinaryTree crearArbolBinario(){
        IBinaryTree binarie = new BinaryTree();
        binarie.create(50);
        binarie.addLeft(20);
        binarie.addRight(60);
        binarie.getLeft().addLeft(10);
        binarie.getRight().addRight(70);
        binarie.getLeft().addRight(30);
        return binarie;
    }

    public static ISearchBinaryTree crearArbolBinarioBusqueda(){
        ISearchBinaryTree binariebusquede = new SearchBinaryTree();
        binariebusquede.add(50);
        binariebusquede.add(40);
        binariebusquede.add(30);
        binariebusquede.add(60);
        binariebusquede.add(70);
        binariebusquede.add(45);
        binariebusquede.add(55);
        return binariebusquede;
    }
    public static void preOrden (IBinaryTree arbolits) { // PRINT: RAIZ - IZQUIERDA - DERECHA
        // deberia printear: 50 - 20 - 10 - 30 - 60 - 70
        if (arbolits == null || arbolits.isEmpty()){ // caso base para terminar la recursividad
            return;
        }
        System.out.println(arbolits.getValueRoot());
        preOrden(arbolits.getLeft());
        preOrden(arbolits.getRight());
    }

    public static void inOrden (IBinaryTree arbolits) { // PRINT: IZQUIERDA - RAIZ - DERECHO
        // deberia printear: 10 - 20 - 30 - 50 - 60 - 70
        if (arbolits == null || arbolits.isEmpty()){ // caso base para terminar la recursividad
            return;
        }
        inOrden(arbolits.getLeft());
        System.out.println(arbolits.getValueRoot());
        inOrden(arbolits.getRight());
    }

    public static void postOrden (IBinaryTree arbolits) { // PRINT: IZQUIERDA - DERECHA - RAIZ
        // deberia printear: 10 - 30 - 20 - 70 - 60 - 50
        if (arbolits == null || arbolits.isEmpty()){ // caso base para terminar la recursividad
            return;
        }
        postOrden(arbolits.getLeft());
        postOrden(arbolits.getRight());
        System.out.println(arbolits.getValueRoot());
    }

    public static int pesoArbol(IBinaryTree a) { //CUENTA LA CANTIDAD DE NODOS DE UN ARBOL BINARIO
        if (a == null || a.isEmpty()){
            return 0;
        }
        return 1 + pesoArbol(a.getLeft()) + pesoArbol(a.getRight());
    }

    public static int calcularProfundidad (IBinaryTree a) { //CALCULA LOS NIVELES DE UN ARBOL BINARIO
        if (a == null || a.isEmpty()){
            return 0;
        }
        if (calcularProfundidad(a.getLeft()) > calcularProfundidad(a.getRight())){
            return 1 + calcularProfundidad(a.getLeft());
        } else {
            return 1 + calcularProfundidad(a.getRight());
        }
    }

    // ARBOL BINARIO DE BUSQUEDA
    public static int queNivelEsta(ISearchBinaryTree abb, int valorBuscar){ // DEVUELVE EL NIVEL EN EL QUE ESTA EL VALOR DEL ARBOL
        if (abb == null || abb.isEmpty()){
            return 0;
        }
        if (abb.getRoot() == valorBuscar){ // TOMANDO COMO QUE EL PRIMER NIVEL ES EL 1
            return 1;
        }
        if (abb.getRoot() > valorBuscar){
            return 1 + queNivelEsta(abb.getLeft(), valorBuscar);
        } else {
            return 1 + queNivelEsta(abb.getRight(), valorBuscar);
        }
    }

    public static boolean existeEnABB(ISearchBinaryTree abb, int valorBuscar) { //VERIFICA SI UN ELEMENTO FORMA PARTE DE UN ABB
        if (abb == null || abb.isEmpty()){
            return false;
        }
        if (abb.getRoot() == valorBuscar){ // TOMANDO COMO QUE EL PRIMER NIVEL ES EL 1
            return true;
        }
        if (abb.getRoot() > valorBuscar){
            return existeEnABB(abb.getLeft(), valorBuscar);
        } else {
            return existeEnABB(abb.getRight(), valorBuscar);
        }
    }

    public static boolean esHojaABB(ISearchBinaryTree arbolBinario, int value) { //VERIFICA SI UN ELEMENTO ES UNA HOJA DEL ABB
        // HOJA = NODO SIN HIJOS XD
        if (arbolBinario == null || arbolBinario.isEmpty()){
            return false;
        }
        if (arbolBinario.getRoot() == value && arbolBinario.getLeft() == null && arbolBinario.getRight() == null) {
            return true;
        } // si el root es = value y si los hijos left y right son null entonces: TRUE, (es hoja).
        if (arbolBinario.getRoot() > value){
            return esHojaABB(arbolBinario.getLeft(), value);
        } else {
            return esHojaABB(arbolBinario.getRight(), value);
        }
    }

    public static int nodosParesEnABB (ISearchBinaryTree beto) { //CUANTOS VALORES PARES DE UN ABB
        if (beto == null || beto.isEmpty()){
            return 0;
        }
        if (beto.getRoot() %2 == 0){
            return 1 + nodosParesEnABB(beto.getLeft()) + nodosParesEnABB(beto.getRight());
        }
        return nodosParesEnABB(beto.getLeft()) + nodosParesEnABB(beto.getRight());
    }

    public static int nodosImparesEnABB (ISearchBinaryTree beto) { //CUANTOS VALORES IMPARES DE UN ABB
        if (beto == null || beto.isEmpty()){
            return 0;
        }
        if (beto.getRoot() %2 != 0){
            return 1 + nodosImparesEnABB(beto.getLeft()) + nodosImparesEnABB(beto.getRight());
        }
        return nodosImparesEnABB(beto.getLeft()) + nodosImparesEnABB(beto.getRight());
    }
/*
    public static int MenorElementoABB(TDAABB a) { //DEVUELVE EL ELEMENTO MENOR DE UN ABB

    }

    public static int MayorElementoABB(TDAABB a) { //DEVUELVE EL ELEMENTO MAYOR DE UN ABB

    }

    public static int SumaElementosABB(TDAABB a) { //SUMA TODOS LOS ELEMENTOS DE UN ABB

    }

    public static int CantHojasABB(TDAABB a) { //DEVUELVE LA CANTIDAD DE HOJAS DE UN ABB

    }

    public static int AlturaABB(TDAABB a) {//DEVUELVE LA ALTURA DE UN ABB (VERIFICA TODAS LAS ALTURAS, AGARRA LA MAS GRANDE Y LE SUMA 1 POR LA RAIZ ORIGINAL

    }

    public static boolean MismaFormaABB(TDAABB a1, TDAABB a2) { //VERIFICA SI 2 ABBs TIENEN LA MISMA FORMA

    }

    public static boolean IgualesABB(TDAABB a1, TDAABB a2) { //VERIFICA SI 2 ABBs SON IGUALES, CON MISMA FORMA Y VALORES EN SUS RAICES

    }*/
}
