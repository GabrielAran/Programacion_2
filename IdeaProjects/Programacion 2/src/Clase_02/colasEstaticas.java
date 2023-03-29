package Clase_02;

public interface colasEstaticas {
    void acolar(int a);

    void desacolar();
    /*
     * Precondicion: La pila debe estar inicializada
     * return true si la pila esta vacia, false en otro caso
     */
    boolean estaVacio();

    int getPrimero();
}
