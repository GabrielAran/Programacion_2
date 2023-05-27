package TASKS;
import Diccionarios.Dictionary;
import Diccionarios.MultipleDictionary;
import NodosCosas.ISet;
import NodosCosas.Set;

public class EjerciciosTomsDiccionarios {
    public static void main(String[] args){
        // DICCIONARIOS
        mostrarDicSimple(crearDiccio());
        mostrarDicMultiple(crearDiccioMultiple());
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
    /*
    public static Dictionary twoDicMul2oneDicMul () { //JUNTA EL CONTENIDO DE 2 DICCIONARIOS MULTIPLES

    }*/

    public static void mostrarDicMultiple(MultipleDictionary multipleDictionary) { //PRINTEA EL CONTENIDO DE UN DICCIONARIO MULTIPLE
        ISet keys = multipleDictionary.getKeys();
        ISet valores;
        int key;
        int value = 0;
        while (!multipleDictionary.isEmpty()){
            try {
                key = keys.choose();
                keys.remove(key);
                valores = multipleDictionary.getValues(key); // set con los valores del key
                System.out.println("Los valores de la key: " + key + " son: ");
                while (!valores.isEmpty()){
                    value = valores.choose();
                    System.out.println(value);
                    valores.remove(value);
                    multipleDictionary.remove(key, value);
                }
            } catch (Exception e){
                System.out.println(e.getCause());
            }
        }
    }
}
