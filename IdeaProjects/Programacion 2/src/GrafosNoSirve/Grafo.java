package GrafosNoSirve;

import NodosCosas.ISet;
import NodosCosas.Set;

public class Grafo {
    NodoGrafo origen;
    public void InicializarGrafo() {
        origen = null;
    }

    public void AgregarVertice(int v) {  //el vertice se inserta al inicio de la lista de nodos
        NodoGrafo aux = new NodoGrafo();
        aux.nodo = v;
        aux.arista = null;
        aux.sigNodo = origen;
        origen = aux;
    }

    private NodoGrafo Vert2Nodo (int v) { //Dado un valor, busca el nodo correspondiente
        NodoGrafo aux = origen;
        while (aux != null && aux.nodo != v)
            aux = aux.sigNodo;
        return aux;
    }

    public void AgregarArista(int v1, int v2, int peso) {
        NodoGrafo n1 = Vert2Nodo(v1); //Buscamos el nodo origen
        NodoGrafo n2 = Vert2Nodo(v2); //...y el nodo destino
        NodoArista aux = new NodoArista(); //La arista va al inicio de la lista...
        aux.etiqueta = peso;               //... de aristas salientes de v1
        aux.nodoDestino = n2;
        aux.sigArista = n1.arista;
        n1.arista = aux;
    }

    private void EliminarAristaNodo (NodoGrafo nodo, int v) {
        NodoArista aux = nodo.arista;  //Elimina de nodo las aristas hacia v
        if (aux != null) {
            if (aux.nodoDestino.nodo == v) {  //Hay que eliminar la primera arista
                nodo.arista = aux.sigArista;
            } else {                          //No es la primera, la buscamos
                while (aux.sigArista != null && aux.sigArista.nodoDestino.nodo != v)
                    aux = aux.sigArista;
                if (aux.sigArista != null) {  //Eliminamos la arista
                    aux.sigArista = aux.sigArista.sigArista;
                }
            }
        }
    }

    public void EliminarVertice(int v) {
        if (origen.nodo == v)                                   //Es el origen
            origen = origen.sigNodo;                            //Se borra el origen
        NodoGrafo aux = origen;                                 //No es el origen, lo buscamos
        while (aux != origen) {
            this.EliminarAristaNodo(aux, v);
            if (aux.sigNodo != null && aux.sigNodo.nodo == v)
                aux.sigNodo = aux.sigNodo.sigNodo;             //Si es el nood, chau nodo
            aux = aux.sigNodo;                                 //Sigue eliminando aristas
        }
    }

    public void EliminarArista (int v1, int v2) {
        NodoGrafo n1 = Vert2Nodo(v1);
        EliminarAristaNodo(n1,v2);                     //Listo
    }

    public int PesoArista(int v1, int v2) {
        NodoGrafo n1 = Vert2Nodo(v1);
        NodoArista aux = n1.arista;
        while(aux.nodoDestino.nodo != v2)
            aux = aux.sigArista;                       //Buscamos la arista
        return aux.etiqueta;
    }

    public boolean ExisteArista (int v1, int v2) {
        NodoGrafo n1 = Vert2Nodo(v1);
        NodoArista aux = n1.arista;
        while (aux != null && aux.nodoDestino.nodo != v2)
            aux = aux.sigArista;    //Buscamos la arista
        return (aux != null);
    }

    public ISet Vertices() {
        ISet c = new Set();
        NodoGrafo aux = origen;
        while (aux != null) {
            c.add(aux.nodo);
            aux = aux.sigNodo;
        }
        return c;
    }
}
