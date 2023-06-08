package Tp_progra;

public class Main {
    public static void main(String[] args){
        //mostrarMatrizCuadrada(generarMatrizNxN(3));
        System.out.println("La traza da: " + calcularTraza(generarMatrizNxN(3), 1));
    }

    public static int calcularTraza(QueueOfStacks mat, int indice){
        System.out.println("p" + mat.getPrimero().getTope());
        int aux = mat.getPrimero().getTope();
        mat.desacolar();
        if (!mat.estaVacio() && mat.getPrimero() != null){
            for (int i = 0; i < indice; i++){
                mat.getPrimero().desapilar();
            }
            return aux + calcularTraza(mat, indice + 1);
        }
        return aux;
    }
    public static QueueOfStacks generarMatrizNxN(int n){
        QueueOfStacks matriz = new QueueOfStacks(n); // n x n = 3 x 3
        matriz.acolar(9);
        matriz.acolar(6);
        matriz.acolar(3);

        matriz.acolar(8);
        matriz.acolar(5);
        matriz.acolar(2);

        matriz.acolar(7);
        matriz.acolar(4);
        matriz.acolar(1);
        return matriz;
    }
    public static void mostrarMatrizCuadrada(QueueOfStacks m){
        while (!m.estaVacio()){
            while (!m.getPrimero().isEmpty()){
                System.out.println(m.getPrimero().getTope());
                m.getPrimero().desapilar();
            }
            System.out.println();
            m.desacolar();
        }
    }
}
