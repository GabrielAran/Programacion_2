package ParcialPrueba.Main;

import Arboles.ISearchBinaryTree;
import Diccionarios.Dictionary;

public class Parcial_01 {
    public static void main(String[] args){
        QueueParcial nuestraCola = new QueueParcial();
        nuestraCola.acolar(8, 3);
        nuestraCola.acolar(19, 2);
        nuestraCola.acolar(14, 1);
        nuestraCola.desacolar(4);

        while (!nuestraCola.estaVacio()){
            System.out.println("Cola: " + nuestraCola.getPrimero());
            nuestraCola.desacolar(1); // le paso 1 pa q se printee bien
        }

        // Utilización de los TDAs
        /* A) Decimos que n2 es ancestro de n1
         si n1 esta en alguna de las ramas de n2
        Desarrolle un metodo estatico que reciba un ABB y devolver un Diccionario Simple donde cada clave
        del diccionario es un nodo que no es hoja, y como valor asociado a la clave la suma de los
        ancentros de este nodo. */

        /* 3)
        Explique la diferencia de complejidad computacional
        de buscar un elemento en un arbol binario y un arbol binario de busqueda.

        RESPUESTA:
        En un arbol binario que no es de busqueda, buscar un elemento requiere
        recorrer cada nodo al menos una vez. Su complejidad entonces es como minimo
        lineal. Cuando tenemos un SBT, la complejidad es logaritmica, aunque mientras
        mas se incrementa su total de nodos su complejidad tiende a lineal. Esto se puede
        solucionar manteniendo el arbol balanceado.
        */
    }

    public static Dictionary ejercicioA(ISearchBinaryTree arbol){
        if (arbol == null){
            return null;
        }
        Dictionary diccio = new Dictionary();
        diccio.add(arbol.getRoot(), 0);
        pepo(arbol.getLeft(), diccio, arbol.getRoot());
        pepo(arbol.getRight(), diccio, arbol.getRoot());
        return diccio;
    }

    public static void pepo(ISearchBinaryTree arbol, Dictionary dic, int sum){
        if (arbol == null || arbol.getLeft() == null && arbol.getRight() == null){
            return;
        }
        dic.add(arbol.getRoot(), sum);
        pepo(arbol.getLeft(), dic, sum + arbol.getRoot());
        pepo(arbol.getRight(), dic, sum + arbol.getRoot());
    }
}
