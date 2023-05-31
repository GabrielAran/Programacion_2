package ParcialPrueba.Main;

import Diccionarios.Dictionary;
import Diccionarios.MultipleDictionary;
import NodosCosas.ISet;
import NodosCosas.Set;

public class Parcial_03 {
    public static void main(String[] args){
        /*
        * 2A)
        * Desarrolle un metodo estatico que reciba un Diccionario multiple y un
            Diccionario simple como parametro. Debe retornar true si para cada clave
            repetida en ambos diccionarios, mantiene la relacion de que la suma de los
            valores del diccionario multiple dan como resultado el valor del diccionario
            simple.
        * */
        Dictionary d1 = new Dictionary();
        MultipleDictionary d2 = new MultipleDictionary();
        d1.add(1, 10);
        d1.add(2, 20);

        d2.add(1, 5);
        d2.add(1, 3);
        d2.add(1, 2);
        d2.add(2, 10);
        d2.add(2, 9);
        d2.add(2, 1);
        System.out.println("Es verdadero? " + relacionDeSuma(d1, d2));
    }

    public static boolean relacionDeSuma(Dictionary diSimple, MultipleDictionary diMultiple){
        ISet clavesSimple = diSimple.getKeys();
        ISet clavesMultiple = diMultiple.getKeys();
        int keyUnica;
        int valSumar;
        while (!clavesSimple.isEmpty()){ // mientras q el set d claves no este vacio
            keyUnica = clavesSimple.choose(); // agarro una d las keys
            clavesSimple.remove(keyUnica); // la borro del set d keys
            int suma = 0; // declaro suma aca asi se resetea cda vez q entro x nueva clave
            if (pertenece(keyUnica, clavesMultiple)){ // si la key esta en el otro diccionario, entonces:
                ISet values = diMultiple.getValues(keyUnica); // agarro el set de valores para esa key
                while (!values.isEmpty()){ // mientras q el set no este vacio
                    valSumar = values.choose(); // agarro un valor del set
                    suma += valSumar; // acumulo el valor
                    values.remove(valSumar); // lo borro del set de valores del dicMultiple
                }
                if (suma != diSimple.getValue(keyUnica)){ // si la suma de los valores es distinta a el valor del dicSimple
                    return false; // retorno false
                }
            }
        }
        return true;
    }

    public static boolean pertenece(int value, ISet conjunto){
        Set copion = copiaC(conjunto); // hago copia del conjunto asi no lo pierdo
        boolean pert = false;
        int aux = 0;
        while (!copion.isEmpty()){
            aux = copion.choose(); // agarro un valor del conjunto copia
            copion.remove(aux); // lo elimino del conjunto copia
            if (value == aux){ // si el value es = aux, entonces el value pertenece al conjunto
                pert = true;
                break;
            }
        }
        return pert;
    }

    public static Set copiaC (ISet original) { //GENERA UNA COPIA DE UN CONJUNTO
        Set copia = new Set();
        Set aux = new Set();
        int value;
        while (!original.isEmpty()){ // hago que copia y aux sean iguales a original, pero se me vacio orignial
            value = original.choose();
            copia.add(value);
            aux.add(value);
            original.remove(value);
        }
        while (!aux.isEmpty()){ // vacio aux, (pq no me importa), y vuelvo a llenar original
            value = aux.choose();
            original.add(value);
            aux.remove(value);
        }
        return copia;
    }
}
