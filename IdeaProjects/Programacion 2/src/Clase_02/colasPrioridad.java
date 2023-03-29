package Clase_02;

public interface colasPrioridad {
    void acolarPrioridad(char a, int priori);

    void desacolarPrioridad();
    /*
     * Precondicion: La pila debe estar inicializada
     * return true si la pila esta vacia, false en otro caso
     */
    boolean estaVacioPrioridad();

    char getPrimeroPrioridad();
}
