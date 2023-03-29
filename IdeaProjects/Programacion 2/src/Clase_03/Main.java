package Clase_03;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("NODOS --- DINAMICAS");

        Stack taki = new Stack();

        taki.add(8);
        System.out.println(taki.getTop());
        taki.add(29);
        taki.add(9);

        randomes();
    }

    public static void randomes(){
        long init = System.currentTimeMillis();
        double min = 70;
        double max = 72;

        int random = (int) (Math.random() * (max - min) + min); // RANDOM: [MIN ; MAX)
        System.out.println("Con Math: " + random);

        Random objetoRandom = new Random();
        int randomInt = objetoRandom.nextInt(); // UN NUMERO RANDOM XD
        System.out.println("Con Random: " + randomInt);

        if(randomInt < 0) { // SUPONGO QUE HACE POSITIVO EL NUM EN CASO Q SEA NEGATIVO
            randomInt = -randomInt;
        }
        randomInt = randomInt % ((int) max); // AGARRA EL RESTO DE RANDOM/MAX
        System.out.println("Con Random: " + randomInt);
        randomInt += (int) min; // LE SUMA EL MIN
        System.out.println("Con Random: " + randomInt);

        int randomInt2 = objetoRandom.nextInt((int) (max - min)) + ((int) min);
        // MISMA COSA Q ANTES PERO AHORA CN CLASE RANDOM: [MIN ; MAX)
        // [INCLUYEN] ------ (NO INCLUYEN)
        System.out.println("Con Random 2: " + randomInt2);

        long end = System.currentTimeMillis();
        System.out.println("Tiempo inicial: " + init);
        System.out.println("Tiempo final: " + end);
        System.out.println("Cuanto tiempo tardo: " + (end - init));
    }
}