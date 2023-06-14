package Tp_progra.Ejercicio2;

public class Main {
    public static void main(String[] args) {
        // EJERCICIO 2A: invertirStack();
        // EJERCICIO 2B: copiarSetGenerico();
    }

    public static <T> Stackgenerico<T> invertirStack(Stackgenerico<T> pila) {
        Stackgenerico<T> pAux = new Stackgenerico<>();
        while (!pila.isEmpty()) {
            pAux.add(pila.getTop());
            pila.remove();
        }
        return pAux;
    }

    public static <T> SetGenerico<T> copiarSetGenerico(SetGenerico<T> original){
        SetGenerico<T> copia = new SetGenerico<>();
        SetGenerico<T> aux = new SetGenerico<>();

        while (!original.isEmpty()){ // hago que copia y aux sean iguales a original, pero se me vacio orignial
            T value = original.choose();
            copia.add(value);
            aux.add(value);
            original.remove(value);
        }
        while (!aux.isEmpty()){ // vacio aux, (pq no me importa), y vuelvo a llenar original
            T value = aux.choose();
            original.add(value);
            aux.remove(value);
        }
        return copia;
    }
}