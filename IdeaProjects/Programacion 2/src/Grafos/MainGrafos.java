package Grafos;

import Diccionarios.Dictionary;
import NodosCosas.ISet;
import NodosCosas.Set;

public class MainGrafos {
    public static void main(String[] args) {
        Dictionary dicc = new Dictionary();
        Grafo graf = new Grafo();
        DiccAristas(graf, dicc);
    }

    public static void DiccAristas(Grafo g, Dictionary d) {
        ISet pep;
        pep = g.Vertices();
        ISet aux;
        while (!pep.isEmpty()) {
            int i = pep.choose();
            aux = g.Vertices();
            int contador = 0;
            while (!aux.isEmpty()) {
                int j = aux.choose();
                if (g.ExisteArista(i, j)) {
                    contador += g.PesoArista(i, j);
                }
                aux.remove(j);
            }
            d.add(i, contador);
            pep.remove(i);
        }
    }

    public static ISet vecinos(GrafoTDA G, int n) {
        ISet aux = new Set();//Conjunto que almacenará los demás vertices
        ISet R = new Set(); //Conjunto que almacenará a los vertices vecinos de n

        aux = G.Vertices();//Copiamos el grafo a un conjunto auxiliar para ir recorriendo las aristas
        int vertPrincipal = n;

        if (pertenece(aux, vertPrincipal)) {
            aux.remove(vertPrincipal);//Sacamos al vertice principal de la copia del grafo para que el nodo no se identifique a si mismo como vecino en el caso de que se este apuntando
            while (!aux.isEmpty()) {
                int j = aux.choose();
                if (G.ExisteArista(vertPrincipal, j)) {
                    R.add(j);//En el caso de que exista una arista saliente hacia el nodo elegido de auxiliar, se guarda su mismo valor en el conjunto c
                }
                aux.remove(j);//Sacamos el nodo que ya analizamos para pasar al siguiente
            }
        }
        return R;
    }

    public static int calcularGrado(GrafoTDA G, int n) {
        int grado = 0;
        int vertPrincipal = n;
        ISet aux = new Set();
        aux = G.Vertices();

        if (pertenece(aux, vertPrincipal)) {
            aux.remove(vertPrincipal);
            while(!aux.isEmpty()) {
                int j = aux.choose();
                if (G.ExisteArista(vertPrincipal, j)) {
                    grado += G.PesoArista(vertPrincipal, j);
                }
                if (G.ExisteArista(j, vertPrincipal)) {
                    grado -= G.PesoArista(j, vertPrincipal);
                }
                aux.remove(j);
            }
        }
        return grado;
    }

    public static ISet VerticesPuentes(GrafoTDA G, int n, int h) {
        int vertUno = n;
        int vertDos = h;
        ISet puentes = new Set();
        ISet aux = new Set();

        if (pertenece(aux, vertUno) && pertenece(aux, vertDos)) {
            aux.remove(vertUno);
            aux.remove(vertDos);
            while(!aux.isEmpty()) {
                int j = aux.choose();
                if (G.ExisteArista(vertDos, j) && (G.ExisteArista(j, vertUno))) {
                    puentes.add(j);
                }
                aux.remove(j);
            }
        }
        return puentes;
    }

    public static boolean pertenece(ISet conjunto, int value){
        Set copion = copiaC(conjunto); // hago copia del conjunto asi no lo pierdo
        boolean pert = false;
        int aux = 0;
        while (!copion.isEmpty()){
            aux = copion.choose(); // agarro un valor del conjunto copia
            copion.remove(aux); // lo elimino del conjunto copia
            if (value == aux){ // si el value es = aux, entonces el value pertenece al conjunto
                pert = true;
                break;
            }
        }
        return pert;
    }

    public static Set copiaC (ISet original) { //GENERA UNA COPIA DE UN CONJUNTO
        Set copia = new Set();
        Set aux = new Set();
        int value = 0;
        while (!original.isEmpty()){ // hago que copia y aux sean iguales a original, pero se me vacio orignial
            value = original.choose();
            copia.add(value);
            aux.add(value);
            original.remove(value);
        }
        while (!aux.isEmpty()){ // vacio aux, (pq no me importa), y vuelvo a llenar original
            value = aux.choose();
            original.add(value);
            aux.remove(value);
        }
        return copia;
    }
}
