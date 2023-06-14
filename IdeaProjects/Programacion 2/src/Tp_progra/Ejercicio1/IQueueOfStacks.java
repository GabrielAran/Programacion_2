package Tp_progra.Ejercicio1;

import Clase_02.PIla;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface IQueueOfStacks {
    /**
     * Postcondicion: Acola (coloca el valor en una stack).
     *
     * @param a valor a acolar.
     */
    void acolar(int a);

    /**
     * Precondicion: La cola no esta vacia.
     * Postcondicion: Desacola: (quita el tope de la primer pila). Si la pila esta quedo vacia, desacola.
     */
    void desacolar();

    /**
     * @return <code>true</code> si la cola esta vacia, <code>false</code> en otro caso.
     */
    boolean estaVacio();

    /**
     * @return Devuelve la primer pila.
     */
    PIla getPrimero();
}
