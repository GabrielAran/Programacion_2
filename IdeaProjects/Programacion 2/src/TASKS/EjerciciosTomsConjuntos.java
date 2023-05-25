package TASKS;

import NodosCosas.Set;

public class EjerciciosTomsConjuntos {
    public static void main(String[] args){
        //CONJUNTOS
        Set laCopio = copiaC(crearConjunto());
        mostrarConjunto(laCopio);

        Set comparte = new Set();
        comparte.add(5);
        comparte.add(7);
        comparte.add(23);
        System.out.println("Esta comparte dentro del conjunto? --> " + setEnSet(crearConjunto(), comparte));
    }

    public static Set crearConjunto(){
        Set conjunto = new Set();
        conjunto.add(426);
        conjunto.add(7);
        conjunto.add(5);
        conjunto.add(23);
        conjunto.add(800);
        return conjunto;
    }
    public static Set copiaC (Set original) { //GENERA UNA COPIA DE UN CONJUNTO
        Set copia = new Set();
        Set aux = new Set();
        int value = 0;
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

    public static void mostrarConjunto(Set mostro) { //PRINTEA UN CONJUNTO
        while (!mostro.isEmpty()){
            int val = mostro.choose();
            System.out.println("la copia: " + val);
            mostro.remove(val);
        }
    }

    public static boolean pertenece(Set conjunto, int value){
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
    public static boolean setEnSet(Set total, Set parteDelTotal) { //VERIFICA SI UN CONJUNTO ESTA COMPRENDIDO EN OTRO
        boolean comprendido = true;
        int valor = 0;
        if (parteDelTotal.isEmpty()){
            comprendido = false;
        }
        while (!parteDelTotal.isEmpty()){
            valor = parteDelTotal.choose();
            if (!pertenece(total, valor)){
                comprendido = false;
                break;
            }
            parteDelTotal.remove(valor);
        }
        return comprendido;
    }
}
