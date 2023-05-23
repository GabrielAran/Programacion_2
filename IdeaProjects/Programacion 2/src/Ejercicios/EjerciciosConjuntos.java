package Ejercicios;

import Clase_03.Conjuntos;

public class EjerciciosConjuntos {
    public static void main(String[] args){
        Conjuntos conj1 = new Conjuntos();
        conj1.add(7);
        conj1.add(5);
        conj1.add(2);

        Conjuntos conj2 = new Conjuntos();
        conj2.add(7);
        conj2.add(5);
        //conj2.Agregar(9); descomentar la linea para comprobar que da falso (:

        System.out.println(Incluye(conj1, conj2));
    }

    public static boolean Incluye(Conjuntos c1, Conjuntos c2) {
        //RETORNA TRUE SI LOS ELEMENTOS DE C2, ESTAN EN C1
        int valor = 0;
        boolean incluye = true;
        while (!c2.isEmpty() && incluye) { // c2 no vacio y incluye = true
            valor = c2.choose(); // --> Agarra un elemento random del c2.
            if (!c1.Pertenece(valor)) { // Si ese valor no esta en el c1, entonces incluye = FALSE.
                incluye = false;
            } else { // Si el valor si esta en el c1, entonces lo saca del c2.
                c2.remove(valor);
            }
        }
        /* ENTONCES:
        El while recorre mientras q los valores de c2 esten en c1 y mientras c2 tenga valores,
        ya que cada vez q encuentra uno lo saca.
        Si hay un valor de c2 q no esta en c1, entonces el while termina.
        Si el c2 quedo vacio quiere decir q c1 incluye c2.
         */
        return incluye;
    }

    // HACER EJERCICIOS DE CONJUNTOS DE TIPO: UNION, INTERSECCION Y DIFERENCIA
}
