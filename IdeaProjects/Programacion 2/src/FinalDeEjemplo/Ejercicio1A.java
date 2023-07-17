package FinalDeEjemplo;

import Diccionarios.Dictionary;
import Diccionarios.IDictionary;
import GraphsProfe.IGraph;
import NodosCosas.ISet;
/*
A. Modificar la implementacion de Graph para que, si es posible ir de v1 a
v2, y es posible ir de v2 a v3, y el metodo que elimina un nodo recibe
por parametro que se quiere borrar v2, entonces borre v2 pero agregue
una arista de v1 a v3 con peso igual a la suma de los pesos de las aristas
v1v2 +v2v3. Solo debe hacerse esto si no existia previamente una arista de
v1 a v3.
*/
public class Ejercicio1A implements IGraph {
    private static final int MAX_NODES = 15;
    private final int[][] adjacencyMatrix;
    private final IDictionary dictionary;
    private int contValues;

    public Ejercicio1A() {
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
        ISet vertices = this.dictionary.getKeys(); // creo un SET con las keys del diccionario, (key = val(5))
        while(!vertices.isEmpty()) { // chequeo que el vertice no exista previamente
            int current = vertices.choose();
            if(current == val) {
                throw new RuntimeException("El nodo ya existe");
            }
            vertices.remove(current);
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
        int auxCantVals = this.contValues; // aux con cant de vertices pre remove(value)
        ISet vertices = this.dictionary.getKeys(); // set con vertices
        int indexVertice = this.dictionary.getValue(value); // pos del vertice en el diccionario
        int aux = -1;



        while (!vertices.isEmpty()) {
            int current = vertices.choose(); // agarro un vertice del graph
            if (this.dictionary.getValue(current) == auxCantVals - 1) { // cant values del vertice == cantValuesActual
                aux = current; // aux = v2
            }
            if (current == value) { // si este es el q queres borrar -->
                this.dictionary.remove(value, indexVertice); // fuiste
                this.contValues--;
            }
            vertices.remove(current);
        }
        int after = this.contValues; // aux con cantidad de vertices actuales, post borrar value

        for (int i = 0; i < this.adjacencyMatrix.length; i++) {
            for (int j = 0; j < this.adjacencyMatrix.length; j++) {
                if (this.adjacencyMatrix[i][indexVertice] != 0 && this.adjacencyMatrix[indexVertice][j] != 0) {
                     if (this.adjacencyMatrix[i][j] != 0) {
                         this.adjacencyMatrix[i][j] = this.adjacencyMatrix[i][indexVertice] + this.adjacencyMatrix[indexVertice][j];
                     }
                }
            }
        }

        if (auxCantVals != after) { // --> borre algo -->
            for (int i = 0; i < auxCantVals; i++) {
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

    public boolean edgeExistsBothSides(int from, int to) {
        if(notIn(from) || notIn(to)) {
            return false;
        }

        int indexFrom = this.dictionary.getValue(from);
        int indexTo = this.dictionary.getValue(to);

        return this.adjacencyMatrix[indexFrom][indexTo] != 0 || this.adjacencyMatrix[indexTo][indexFrom] != 0;
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