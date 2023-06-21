package TPO.Ejercicio6;

public class Main {
    public static void main(String[] args){
        /* EJERCICIO 6:
        1. StackLimitada
        2. SuperSet
        3. LinkedCyclicQueue
        4. RepeatedSet
        */
        LinkedCyclicQueue colaLoca = new LinkedCyclicQueue();
        colaLoca.add(1);
        colaLoca.add(2);
        colaLoca.add(3);
        colaLoca.remove();
        colaLoca.add(4);

        while (!colaLoca.isEmpty()){
            System.out.println(colaLoca.getFirst());
            colaLoca.remove();
        }

    }
}
