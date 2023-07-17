package GrafosNoSirve;

import NodosCosas.ISet;
public interface GrafoTDA {
    void InicializarGrafo(); //Sin precondiciones
    void AgregarVertice(int v); //Grafo inicializado y NO existe nodo v
    void EliminarVertice(int v); //Grafo inicializado y existe nodo v
    void AgregarArista(int v1, int v2, int p); //Grafo inicializado y NO existe arista v1 y v2
    void EliminarArista(int v1, int v2); //Grafo inicializado y existe arista v1 y v2
    int PesoArista(int v1, int v2); //Grafo inicializado y existe arista v1 y v2
    ISet Vertices(); //Grafo inicializado
    boolean ExisteArista(int v1, int v2); //Grafo inicializado y existen nodos v1 y v2

}
