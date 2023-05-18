package Recursividad;

public class Main {
    public static void main(String[] args) {
        System.out.println("RECURSIVIDAD");
        int paco = 2;
        int paco2 = 3;
        System.out.println(suma(paco, paco2)); //suma

        System.out.println(times(paco, paco2)); //multiplicacion

        System.out.println(pow(paco, paco2)); //elevar

        System.out.println(factorial(4)); //factorial

        System.out.println(fibonacci(4)); //fibonashe

        System.out.println(gcd(16, 4));
    }

    public static int suma(int a, int b) {
        if (b == 0) { //caso base
            System.out.println("paco " + a);
            return a;
        }
        return suma(a, b - 1) + 1;
    }

    public static int times(int a, int b) { //ESTO ES MULTIPLICAR
        if (b == 0) { //caso base
            return 0;
        }
        return a + times(a, b - 1);
    }

    public static int pow(int a, int b) { //ESTO ES ELEVAR
        if (b == 0) { //caso base
            return 1;
        }
        return a * pow(a, b - 1);
    }

    public static int factorial(int n) { //ESTO ES FACTORIAL, SOLO FUNCIONA CN POSITIVOS
        if (n == 0) { //caso base
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int fibonacci(int n) { // N = NUMERO EN LA SECUENCIA DE FIBONACCI: 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89
        System.out.println("el numero es: " + n);
        if (n <= 1) {
            return n; // Casos base: Fibonacci(0) = 0, Fibonacci(1) = 1
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int gcd(int a, int b) { // 16 y 4
        if (b == 0) { //caso base
            return a;
        }
        return gcd(b, a % b);  // B SE GUARDA EN EL PRIMER PARAMETRO, ENTONCES A PASA A VALER 4 Y B VALE 0, ENTONCES RETORNA 4
    }
}
