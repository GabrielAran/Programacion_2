package GraphsProfe;

import Diccionarios.Dictionary;
import Diccionarios.IDictionary;
import NodosCosas.ISet;
import NodosCosas.Set;

public class EjerciciosGrafosToms {
    public static void main(String args[]){
        /*mostrarGrafo(generarGraph());
        vecinosGrafos(generarGraph(), 12);
        System.out.println("El mayor peso es: " + aristaSalienteMayorPeso(generarGraph(), 4));
        mostrarDicSimple(graphToDictionary(generarGraph()));*/
        GrafoHamiltoneano graph = generarHamilton();
        System.out.println("Es hamiltoniano no ciclico? " + graph.isPossiblyAnOrderedList());
    }
    public static GrafoHamiltoneano generarHamilton(){
        GrafoHamiltoneano grafo = new GrafoHamiltoneano();
        grafo.addNode(1);
        grafo.addNode(3);
        grafo.addNode(4);
        grafo.addNode(8);
        grafo.addNode(9);

        grafo.addEdge(1, 3, 100);
        grafo.addEdge(3, 4, 200);
        grafo.addEdge(4, 8, 300);
        grafo.addEdge(8, 9, 400);
        //grafo.addEdge(1, 9, 500);
        return grafo;
    }
    public static IGraph generarGraph(){
        IGraph grafo = new Graph();
        grafo.addNode(4);
        grafo.addNode(8);
        grafo.addNode(12);

        grafo.addEdge(4, 8, 100);
        grafo.addEdge(8, 12, 200);
        return grafo;
    }
    public static void mostrarGrafo(IGraph a) { //PRINTEA UN GRAFO ENTERO
        ISet v1 = a.nodes(); // set con los vertices
        while (!v1.isEmpty()) {
            int x1 = v1.choose(); // valor random
            v1.remove(x1); // lo saco del set

            ISet v2 = a.nodes(); // set2 con los vertices
            while (!v2.isEmpty()) {
                int x2 = v2.choose(); // valor random 2
                v2.remove(x2); // lo saco del set
                if (a.edgeExists(x1, x2)) {// existe una arista entre el vertice1 y vertice2
                    System.out.print(x1 + " -> (" + a.weight(x1, x2) + ") -> " + x2); // peso
                    System.out.println("");
                }
            }
        }
    }
    public static ISet vecinosGrafos(IGraph g, int v) {
        //DEVUELVE UN CONJUNTO CON LOS VERTICES VECINOS A UN VERTICE DE UN GRAFO G,
        //SIENDO VECINOS LOS QUE ESTEN CONECTADO CON ESTE VERTICE
        ISet vertices = g.nodes(); // vertices del graph
        ISet vecinos = new Set();

        while (!vertices.isEmpty()) {
            int vert = vertices.choose(); // agarro un vertice
            vertices.remove(vert);
            if (g.edgeExistsBothSides(v, vert)) { // uso BothSides ya que quiero ver si hay algun arista entre ambos,
                // sin importar la direccion
                vecinos.add(vert);
                System.out.println("vecino: " + vert);
            }
        }
        return vecinos;
    }
    public static int aristaSalienteMayorPeso(IGraph g, int v) { //DEVUELVE EL PESO DE LA ARISTA DE MAYOR PESO DE UN VERTICE V
        ISet verticesGraph = g.nodes();
        g.addEdge(4, 12, 300); // hay de 4 a 8 y de 4 a 12, la mayor es esta. (;
        int mayorWeight = 0;

        while (!verticesGraph.isEmpty()){
            int val = verticesGraph.choose(); // me tengo q fijar si existe conexion con "v"
            verticesGraph.remove(val);
            if (g.edgeExists(v, val)){
                if (g.weight(v, val) > mayorWeight){
                    mayorWeight = g.weight(v, val);
                }
            }
        }
        return mayorWeight;
    }
    public static IDictionary graphToDictionary(IGraph g) {
        //CONVIERTE UN GRAFO EN UN DIC SIMPLE EN EL QUE LAS CLAVES SON LOS VERTICES
        //Y LOS VALORES LA SUMATORIA DE SUS ARISTAS SALIENTES
        g.addEdge(12, 4, 400);
        g.addEdge(4, 12, 700);
        IDictionary dicc = new Dictionary();
        ISet vertices = g.nodes();

        while (!vertices.isEmpty()){
            int k = vertices.choose(); // key --> un vertice
            int v = 0; // v --> suma de aristas salientes
            vertices.remove(k);
            ISet aux = g.nodes(); // agarro devuelta las aristas xq sino las pierdo
            while (!aux.isEmpty()){
                int end = aux.choose();
                aux.remove(end);
                if (g.edgeExists(k, end)) { // si existe arista de k -->
                    v += g.weight(k, end); // acumulo el peso
                }
            }
            dicc.add(k, v);
        }
        return dicc;
    }
    public static void mostrarDicSimple(IDictionary deco) { //PRINTEA EL CONTENIDO DE UN DICCIONARIO SIMPLE
        ISet keys = deco.getKeys();
        int key;
        int value;
        while (!deco.isEmpty()){ // deco.isEmpty() == False
            key = keys.choose();
            keys.remove(key);
            value = deco.getValue(key);
            deco.remove(key, value);
            System.out.println("VerticeKey: " + key + ", SumatoriaAristasValue: " + value);
        }
    }
}
