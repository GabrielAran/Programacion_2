package TPO.Ejercicio6;

import NodosCosas.Set;

import java.util.Random;

public class SuperSet {
    private int[] conjunto; //el contenido del conjunto
    private int cont; //la cantidad de elementos

    public SuperSet() {
        this.conjunto = new int[100];
        this.cont = 0;
    }

    public boolean subconjunto(Set instanciaSet) { //VERIFICA SI UN CONJUNTO ESTA COMPRENDIDO EN OTRO
        boolean comprendido = true;
        int valor;
        if (instanciaSet.isEmpty()){
            comprendido = false;
        }
        while (!instanciaSet.isEmpty()){
            valor = instanciaSet.choose();
            if (!pertenece(valor)){
                comprendido = false;
                break;
            }
            instanciaSet.remove(valor);
        }
        return comprendido;
    }

    public SuperSet conjuntoComplementario(Set instanciaSet) {
        SuperSet setComplemento = new SuperSet();
        if (!subconjunto(instanciaSet)) { // no puede ser complemento si es subconjunto
            int valor;
            while (!instanciaSet.isEmpty()) {
                valor = instanciaSet.choose();
                if (!pertenece(valor)) {
                    setComplemento.add(valor);
                }
                instanciaSet.remove(valor);
            }
        }
        return setComplemento;
    }

    public void add(int x) { // no se puede agregar un elemento que ya exista (:
        if (!pertenece(x)) { //verifiacion de no pertenencia
            this.conjunto[this.cont] = x;
            this.cont++; //nuevo elemento
        }
    }

    public boolean isEmpty() {
        return (this.cont == 0);
    }

    public int choose() {
        if (this.cont == 0){
            System.out.println("No se puede elegir un elemento de un conjunto vacio");
            return -1;
        }
        int randomIndex = (new Random()).nextInt(this.cont); // agarro un num random
        return this.conjunto[randomIndex]; // agarro del conjunto, la pos del random (:
    }

    public boolean pertenece(int x) {
        int i = 0;
        while (i < this.cont && this.conjunto[i] != x) {
            // LO Q HACE ES: RECORRE Y SUMA 'i', SI 'i' ES MENOR A CONT, ENTONCES ESTA DENTRO DEL CONJUNTO (:
            i++;
        }
        return (i < this.cont); // si i < cont entonces retorna true
    }

    public void remove(int x) { // no se puede borrar un elemento que no esta, obvio (:
        int i = 0;
        while (i < this.cont && this.conjunto[i] != x) { // MISMO Q PERTENECE, PERO NECESITO 'i'
            i++;
        }
        if (i < this.cont) { // si es true, el elemento pertenece al conjunto
            this.conjunto[i] = this.conjunto[this.cont - 1]; // REEMPLAZA X EL ULTIMO YA Q NO HAY ORDEN XD
            this.cont--; // al restarle una al contador ya no se tendra en cuenta el elemento borrado
        }
    }
}
