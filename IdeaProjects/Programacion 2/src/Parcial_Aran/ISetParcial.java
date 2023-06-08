package Parcial_Aran;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface ISetParcial {

    /**
     * Postcondicion: Agrega un boolean al conjunto.
     * SOLO PODRA HABER 2 VALORES YA QUE LOS ELEMENTOS NO SE PUEDEN REPETIR
     * @param a boolean a agregar.
     */
    void add(boolean a);

    /**
     * Postcondicion: Quita el boolean indicado si existe, de lo contrario no hace nada.
     *
     * @param a boolean a quitar.
     */
    void remove(boolean a);

    /**
     * @return <code>true</code> si es el conjunto vacio, <code>false</code> en otro caso.
     */
    boolean isEmpty();

    /**
     * @return Devuelve uno de los 2 elementos del conjunto, (true of false).
     */
    boolean choose();

}
