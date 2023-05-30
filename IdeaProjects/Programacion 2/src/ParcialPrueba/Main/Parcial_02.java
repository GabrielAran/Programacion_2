package ParcialPrueba.Main;

public class Parcial_02 {
    public static void main(String[] arga){
        MaximumRestrictedStack pila = new MaximumRestrictedStack();
        pila.apilar(8);
        pila.apilar(7);
        pila.apilar(6);
        pila.apilar(10);
        pila.apilar(15);
        pila.apilar(5);

        while (!pila.isEmpty()){
            System.out.println("Pila: " + pila.getTope());
            pila.desapilar();
        }
    }
}
