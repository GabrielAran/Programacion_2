package Clase_01;

public class Main {
    public static void main(String[] args) {
        String gabi = "SOY LA G de pares, ";
        for(int i = 1; i < 11; i++) {
            if (i % 2 == 0) {
                System.out.println(gabi + "n°: " + i);
            }
        }
        Persona personita = funcion();
        System.out.println(personita.getDni());
        hacerArrayes();
        System.out.println(personita.DecimeQueEsTomi());

        //CREO MI MATRIZ
        int[][] matriz = new int[][] {
                new int[] {1,2,3},
                new int[] {4,5,6},
                new int[] {7,8,9}
        };
        print(matriz);
        /*
        //RECURSIVIDAD
        Scanner wow = new Scanner(System.in);

        int[] llenar = new int[5];
        for(int h = 0; h < llenar.length; h++){
            llenar[h] = wow.nextInt();
        }
        printtt(llenar, 0);*/

        Hola tuki = new Hola();
        tuki.setId(800);
        tuki.mostrame_el_id();
    }

    public static void print(int[][] matrix){
        int [][] modified = new int[matrix.length][];

        int traza = 0;

        for (int i = 0; i < matrix.length; i++){
            modified[i] = new int[matrix.length];
            traza += matrix[i][i];
            for (int j = 0; j < matrix.length; j++){
                modified[i][j] = matrix[i][j] * 2;
                //System.out.print(matrix[i][j]);
                System.out.print(modified[i][j]);
                System.out.print("\t");
            }
            System.out.print("\n");
        }
        System.out.print("traza: " + traza + "\n"); //MUESTRA LA SUMA DE LA DIAGONAL
    }

    public static void printtt(int[] array, int index){ //RECURSIVIDAD
        //System.out.println("Cual verga me llega: " + index);
        if (index == array.length - 1) {
            System.out.println(array[index]);
            return;
        }
        System.out.println(array[index]);
        index++;
        printtt(array, index);
    }

    public static Persona funcion(){
        Persona tomi = new Persona(); //OBJETO

        tomi.setDni(44566970);
        tomi.setNombre("TOMAS");
        tomi.setApellido("ANDRADA");
        return tomi;
    }

    public static void hacerArrayes(){
        int[] arraya = new int[] {1,2,3,4,5};
        int acumulo = 0;

        for (int i = 0; i < arraya.length; i++){
            acumulo += arraya[i];
        }
        System.out.println("El array suma: " + acumulo);
    }
}
