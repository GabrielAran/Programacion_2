package Clase_03;

public class Conjuntos {
    private int[] conjunto; //el contenido del conjunto
    private int cont; //la cantidad de elementos

    public void InicializarConjunto() {
        this.conjunto = new int[100];
        this.cont = 0;
    }

    public void Agregar(int x) {
        if (!this.Pertenece(x)) { //verifiacion de no pertenencia
            conjunto[cont] = x;
            cont++; //nuevo elemento
        }
    }

    public boolean ConjuntoVacio() {
        return (cont == 0);
    }

    public int Elegir() {
        return conjunto[cont - 1]; //esto es arbitrario; podria ser cualquiera
    }

    public boolean Pertenece(int x) {
        int i = 0;
        while (i < cont && conjunto[i] != x) { // LA VERDA RE PIOLA AMIGO
            // LO Q HACE ES: RECORRE Y SUMA 'i', SI 'i' ES MENOR A CONT, ENTONCES ESTA DENTRO DEL CONJUNTO (:
            i++;
        }
        return (i < cont);
    }

    public void Sacar(int x) {
        int i = 0;
        while (i < cont && conjunto[i] != x) { // MISMO Q PERTENECE, PERO NECESITO 'i'
            i++;
        }
        if (i < cont) { //elemento encontrado
            conjunto[i] = conjunto[cont - 1]; // REEMPLAZA X EL ULTIMO YA Q NO HAY ORDEN XD
            cont--;
        }
    }
}
