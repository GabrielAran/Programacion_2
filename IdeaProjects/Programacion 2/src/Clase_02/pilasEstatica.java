package Clase_02;
// USAR LA OTRA INTERFAZ DE PILA EN CLASE_03
public interface pilasEstatica {  // LA INTERFEZ DEFINE Q METODOS VA A TENER LA CLASE PILA, SI O SI
    /*
        * Precondicion: La pila debe estar inicializada
        * Postcondicion: Coloca un numero en la pila
    */
    void apilar(int a);

    void desapilar();
    /*
        * Precondicion: La pila debe estar inicializada
        * return true si la pila esta vacia, false en otro caso
    */
    boolean isEmpty();

    int getTope();
}
