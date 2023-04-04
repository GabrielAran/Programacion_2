package Ejercicios;

import Clase_02.ColasConPrioridad;

public class EjerciciosColasConPrioridad {
    public static void main(String[] args){
        //EJ 1:
        ColasConPrioridad cp1 = new ColasConPrioridad();
        ColasConPrioridad cp2 = new ColasConPrioridad();

        cp1.acolarPrioridad('E', 2);
        cp1.acolarPrioridad('C', 4);
        cp1.acolarPrioridad('A', 6);

        cp2.acolarPrioridad('D', 10);
        cp2.acolarPrioridad('F', 11);
        cp2.acolarPrioridad('B', 6);

        merge(cp1, cp2); // Acola 2 colas distintas con prioridad, (<Los de cp1 tienen mas prioridad q cp2)

        //EJ 2:
        ColasConPrioridad igual1 = new ColasConPrioridad();
        ColasConPrioridad igual2 = new ColasConPrioridad();

        igual1.acolarPrioridad('Z', 10);
        igual1.acolarPrioridad('Y', 4);

        igual2.acolarPrioridad('Z', 10);
        igual2.acolarPrioridad('Y', 8);

        System.out.println("Son iguales las Colas con Prioridad? " + iguales(igual1, igual2));
    }

    public static void merge(ColasConPrioridad c1, ColasConPrioridad c2){
        ColasConPrioridad cp3 = new ColasConPrioridad();
        while (!c1.estaVacioPrioridad()){
            cp3.acolarPrioridad(c1.getPrimeroPrioridad(), c1.getPrimeroPrioridadPrioridad());
            c1.desacolarPrioridad();
        }

        while (!c2.estaVacioPrioridad()){
            cp3.acolarPrioridad(c2.getPrimeroPrioridad(), c2.getPrimeroPrioridadPrioridad());
            c2.desacolarPrioridad();
        }

        while (!cp3.estaVacioPrioridad()){
            System.out.println("Cp3: " + cp3.getPrimeroPrioridad() + " Su prioridad es: " + cp3.getPrimeroPrioridadPrioridad());
            cp3.desacolarPrioridad();
        }
    }

    public static boolean iguales(ColasConPrioridad messi, ColasConPrioridad diego){
        boolean igualitos = true;
        while (true){
            if (messi.estaVacioPrioridad() && diego.estaVacioPrioridad()) {
                break;
            }
            if (messi.estaVacioPrioridad() != diego.estaVacioPrioridad()){
                igualitos = false;
                break;
            }
            if (messi.getPrimeroPrioridad() != diego.getPrimeroPrioridad()){
                igualitos = false;
                break;
            }
            messi.desacolarPrioridad();
            diego.desacolarPrioridad();
        }
        return igualitos;
    }
}
