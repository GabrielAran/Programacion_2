package NodosCosas;

public class Main {
    public static void main(String[] args) {
        // Cola Prioridad Dinamica
        PriorityQueue cola = new PriorityQueue();
        cola.add(156, 10);
        System.out.println("El primero es: " + cola.getFirstValue());
        cola.add(256, 30);
        System.out.println("El primero es: " + cola.getFirstValue());
        cola.add(356, 20);
        System.out.println("El primero es: " + cola.getFirstValue());
        cola.remove();
        System.out.println("El primero es: " + cola.getFirstValue());
        cola.remove();
        System.out.println("El primero es: " + cola.getFirstValue());

        // Set Dinamico
        Set conj = new Set();
        conj.add(45);
        conj.add(8);
        conj.add(17);
        System.out.println("Vacio?: " + conj.isEmpty());
        System.out.println("random: " + conj.choose());
        conj.remove(8);
        System.out.println("random - 1: " + conj.choose());
        conj.remove(17);
        System.out.println("unico valor xd: " + conj.choose());
        conj.remove(45);
        System.out.println("Vacio?: " + conj.isEmpty());
    }
}
