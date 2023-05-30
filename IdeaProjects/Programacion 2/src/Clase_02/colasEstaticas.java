package Clase_02;
/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface colasEstaticas {
    /**
     * Postcondicion: Acola (coloca en el final de la cola) un valor.
     *
     * @param a valor a acolar.
     */
    void acolar(int a);

    /**
     * Precondicion: La cola no esta vacia.
     * Postcondicion: Desacola (quita el primer elemento).
     */
    void desacolar();

    /**
     * @return <code>true</code> si la cola esta vacia, <code>false</code> en otro caso.
     */
    boolean estaVacio();

    /**
     * @return Devuelve el primero.
     */
    int getPrimero();
}
