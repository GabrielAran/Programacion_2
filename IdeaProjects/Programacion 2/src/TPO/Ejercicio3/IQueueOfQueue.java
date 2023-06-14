package TPO.Ejercicio3;

import Clase_02.Colas;
/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface IQueueOfQueue {
    /**
     * Postcondicion: Acola (coloca una cola al final de la cola).
     *
     * @param a cola a acolar.
     */
    void acolar(Colas a);

    /**
     * Precondicion: La cola no esta vacia.
     * Postcondicion: Desacola (quita la primer cola).
     */
    void desacolar();

    /**
     * @return <code>true</code> si la cola esta vacia, <code>false</code> en otro caso.
     */
    boolean estaVacio();

    /**
     * @return Devuelve la primer cola.
     */
    Colas getPrimero();
}
