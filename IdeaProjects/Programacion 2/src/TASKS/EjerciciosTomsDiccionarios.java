package TASKS;

import Diccionarios.Dictionary;
import Diccionarios.MultipleDictionary;
import NodosCosas.ISet;

public class EjerciciosTomsDiccionarios {
    public static void main(String[] args){
        // DICCIONARIOS
        mostrarDicSimple(crearDiccio());
        mostrarDicMultiple(crearDiccioMultiple());
        MultipleDictionary pepe = new MultipleDictionary();
        pepe.add(8, 300);
        pepe.add(8, 400);
        //pepe.add(8, 400); NO PUEDO PONER 2 VALORES IGAULES XQ SE GUARDAN EN UN SET
        //Y UN SET NO ADMITE REPETICION DE VALORES (: wow
        mostrarDicMultiple(juntarDicciosMultiples(crearDiccioMultiple(), pepe));
    }

    public static Dictionary crearDiccio(){
        Dictionary dick = new Dictionary();
        dick.add(8, 100);
        dick.add(9, 200);
        dick.add(10, 300);
        return dick;
    }

    public static MultipleDictionary crearDiccioMultiple(){
        MultipleDictionary dicto = new MultipleDictionary();
        dicto.add(8, 100);
        dicto.add(9, 200);
        dicto.add(10, 300);
        dicto.add(10, 400);
        dicto.add(10, 500);
        return dicto;
    }
    public static void mostrarDicSimple(Dictionary deco) { //PRINTEA EL CONTENIDO DE UN DICCIONARIO SIMPLE
        ISet keys = deco.getKeys();
        int key;
        int value;
        while (!deco.isEmpty()){ // deco.isEmpty() == False
            key = keys.choose();
            keys.remove(key);
            value = deco.getValue(key);
            deco.remove(key, value);
            System.out.println("El valor es: " + value);
        }
    }

    //DICCIONARIOS MULTIPLES
    public static MultipleDictionary juntarDicciosMultiples (MultipleDictionary dick1, MultipleDictionary dick2) { //JUNTA EL CONTENIDO DE 2 DICCIONARIOS MULTIPLES
        ISet clavesDick2 = dick2.getKeys();
        ISet valuesOfKey;
        int key;
        int value;
        while (!clavesDick2.isEmpty()){
            key = clavesDick2.choose(); // AGARRO UNA KEY DEL SET DE KEYS DEL DICCIONARIO
            valuesOfKey = dick2.getValues(key); // set con los valores del key
            while (!valuesOfKey.isEmpty()){
                value = valuesOfKey.choose();
                dick1.add(key, value);
                valuesOfKey.remove(value);
            }
            clavesDick2.remove(key); // ELIMINO ESA KEY ASI NO VUELVE A SALIR
        }
        return dick1;
    }

    public static void mostrarDicMultiple(MultipleDictionary multipleDictionary) { //PRINTEA EL CONTENIDO DE UN DICCIONARIO MULTIPLE
        ISet keysDiccioMultiple = multipleDictionary.getKeys(); // AGARRO LAS KEYS DEL DICCIO MULTIPLE
        ISet valuesOfKey;
        int key;
        int value;
        while (!keysDiccioMultiple.isEmpty()){
            key = keysDiccioMultiple.choose(); // AGARRO UNA KEY DEL SET DE KEYS DEL DICCIONARIO
            valuesOfKey = multipleDictionary.getValues(key); // set con los valores del key
            System.out.println("Los valores de la key: " + key + " son: ");
            while (!valuesOfKey.isEmpty()){
                value = valuesOfKey.choose();
                System.out.println(value);
                valuesOfKey.remove(value);
//              multipleDictionary.remove(key, value); ESTO ME CAUSABA EL ERROR
            }
            keysDiccioMultiple.remove(key); // ELIMINO ESA KEY ASI NO VUELVE A SALIR
        }
    }
}
