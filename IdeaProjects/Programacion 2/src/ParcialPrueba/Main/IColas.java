package ParcialPrueba.Main;
/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface IColas {
    /**
     * Postcondicion: Acola (coloca en el final de la cola) un valor n veces.
     *
     * @param a valor a acolar.
     * @param n cuantas veces acolar a.
     */
    void acolar(int a, int n);

    /**
     * Precondicion: La cola no esta vacia y que pueda desacolar n elementos
     * Postcondicion: Desacola (quita n veces el elemento).
     * @param n cuantos valores desacolar.
     */
    void desacolar(int n);

    /**
     * @return <code>true</code> si la cola esta vacia, <code>false</code> en otro caso.
     */
    boolean estaVacio();

    /**
     * @return Devuelve el primero.
     */
    int getPrimero();
}
