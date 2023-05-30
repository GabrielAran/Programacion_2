package Clase_02;
/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface colasPrioridad {
    /**
     * Postcondicion: Acola (coloca en el final de la cola) un valor, respecto a su prioridad.
     *
     * @param a        valor a acolar.
     * @param priori prioridad del valor a agregar.
     */
    void acolarPrioridad(char a, int priori);
    /**
     * Precondicion: La cola no esta vacia.
     * Postcondicion: Desacola (quita el primer elemento).
     */
    void desacolarPrioridad();
    /**
     * @return <code>true</code> si la cola esta vacia, <code>false</code> en otro caso.
     */
    boolean estaVacioPrioridad();
    /**
     * @return Devuelve la prioridad del primero.
     */
    char getPrimeroPrioridad();
}
