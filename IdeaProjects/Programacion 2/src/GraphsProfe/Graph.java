package GraphsProfe;

import Diccionarios.Dictionary;
import Diccionarios.IDictionary;
import NodosCosas.ISet;

public class Graph implements IGraph {
    private static final int MAX_NODES = 15;
    private final int[][] adjacencyMatrix;
    private final IDictionary dictionary;
    private int contValues;

    public Graph() {
        this.adjacencyMatrix = new int[MAX_NODES][MAX_NODES]; // para ver si hay aristas
        this.dictionary = new Dictionary(); // Asumo que el límite es mayor a MAX_NODES
        this.contValues = 0;
    }

    @Override
    public void addNode(int val) {
        if(this.contValues == 0) { // grafo vacio -->
            this.dictionary.add(val, this.contValues); // key = 5, value = 0 --> primer valor
            this.contValues++;
            return;
        }

        // Esto se puede colocar dentro de un condicional this.totalNodes != 0
        ISet nodes = this.dictionary.getKeys(); // creo un SET con las keys del diccionario, (key = val(5))
        while(!nodes.isEmpty()) { // chequeo que el vertice no exista previamente
            int current = nodes.choose();
            if(current == val) {
                throw new RuntimeException("El nodo ya existe");
            }
            nodes.remove(current);
        }
        // si el valor no existe en el grafo -->
        this.dictionary.add(val, this.contValues); // key = 3, value = cantValores
        this.contValues++;
    }

    @Override
    public void removeNode(int value) { // borrar un vertice
        if(this.contValues == 0) { // Greedy
            throw new RuntimeException("El nodo no existe");
        }

        // Esto se puede colocar dentro de un condicional this.totalNodes != 0
        int auxCantVals = this.contValues; // aux con cant de vertices
        ISet vertices = this.dictionary.getKeys(); // set con vertices
        int indexVertice = this.dictionary.getValue(value); // pos del vertice en el diccionario
        int aux = -1;

        while(!vertices.isEmpty()) {
            int current = vertices.choose();
            if(this.dictionary.getValue(current) == auxCantVals - 1) { // cant values del vertice == cantValuesActual
                aux = current; // aux = vertice random
            }
            if(current == value) { // si este es el q queres borrar -->
                this.dictionary.remove(value, indexVertice); // fuiste
                this.contValues--;
            }
            vertices.remove(current);
        }
        int after = this.contValues; // aux con cantidad de vertices actuales, post borrar value

        if (auxCantVals != after) { // Evito complejidad cúbica
            for(int i = 0; i < auxCantVals; i++) {
                this.adjacencyMatrix[i][indexVertice] = this.adjacencyMatrix[i][after];
                this.adjacencyMatrix[indexVertice][i] = this.adjacencyMatrix[after][i];
            } // borro la arista

            this.dictionary.remove(aux, this.dictionary.getValue(aux));
            this.dictionary.add(aux, indexVertice);
            return;
        }
        throw new RuntimeException("El nodo no existe");
    }

    @Override
    public ISet nodes() { //set con los vertices
        return this.dictionary.getKeys();
    }

    @Override
    public void addEdge(int from, int to, int weight) { // agregar ariste(verticeDesde, verticeHasta, peso)
        if(this.notIn(from) || this.notIn(to)) { // si alguno de los dos vertices no existe == ERROR -->
            throw new RuntimeException("No existe alguno de los nodos");
        }
        // agarro las posiciones de los vertices en el diccionario
        int indexFrom = this.dictionary.getValue(from);
        int indexTo = this.dictionary.getValue(to);

        if(this.adjacencyMatrix[indexFrom][indexTo] != 0) { // chequea que no exista la arista
            throw new RuntimeException("Ya existe la arista");
        }
        // si no existe la arista -->
        this.adjacencyMatrix[indexFrom][indexTo] = weight; // y le setea un weight
    }

    private boolean notIn(int node) { // devuelve true si el vertice no existe
        ISet nodes = this.dictionary.getKeys(); // set con los vertices
        while(!nodes.isEmpty()) {
            int current = nodes.choose();
            if(current == node) {
                return false; // ya existe el vertice en el graph
            }
            nodes.remove(current);
        }
        return true; // no existe el value
    }

    @Override
    public void removeEdge(int from, int to) { // borra arista(verticeDesde, verticeHasta) -->
        if(!edgeExists(from, to)) { // si no existe la arista no la puedo borrar...
            throw new RuntimeException("No existe la arista");
        }

        int indexFrom = this.dictionary.getValue(from);
        int indexTo = this.dictionary.getValue(to);

        this.adjacencyMatrix[indexFrom][indexTo] = 0; // seteo el weight como 0 --> no existe tal arista (:
    }

    @Override
    public boolean edgeExists(int from, int to) {
        if(notIn(from) || notIn(to)) {
            return false;
        }

        int indexFrom = this.dictionary.getValue(from);
        int indexTo = this.dictionary.getValue(to);

        return this.adjacencyMatrix[indexFrom][indexTo] != 0;
    }

    @Override
    public int weight(int from, int to) {
        if(!edgeExists(from, to)) {
            throw new RuntimeException("No existe la arista");
        }

        int indexFrom = this.dictionary.getValue(from);
        int indexTo = this.dictionary.getValue(to);

        return this.adjacencyMatrix[indexFrom][indexTo];
    }
}
