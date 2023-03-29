package Clase_02;

public class Main {
    public static void main(String[] args) {
        System.out.println("PILAS, COLAS Y COLAS CON PRIORIDAD");

        //COLAS_PRIORIDAD COLAS_PRIORIDAD COLAS_PRIORIDAD COLAS_PRIORIDAD COLAS_PRIORIDAD COLAS_PRIORIDAD

        ColasConPrioridad colita = new ColasConPrioridad();

        colita.acolarPrioridad('a', 2);
        System.out.println(colita.getPrimeroPrioridad());
        colita.acolarPrioridad('b', 10);
        System.out.println(colita.getPrimeroPrioridad());
        colita.acolarPrioridad('c', 8);
        System.out.println(colita.getPrimeroPrioridad());

        System.out.println("\n");

        colita.desacolarPrioridad();
        System.out.println("Desacole " + colita.getPrimeroPrioridad());
        colita.desacolarPrioridad();
        System.out.println("Desacole " + colita.getPrimeroPrioridad());
        colita.desacolarPrioridad();
        System.out.println("Desacole --> " + colita.estaVacioPrioridad());

        //PILASPILASPILASPILASPILASPILASPILASPILASPILASPILASPILASPILASPILASPILASPILASPILASPILAS

        PIla pila = new PIla(); // CLASE OBJETO = NUEVO OBJETO DE TIPO CLASE

        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(3);

        System.out.println("El tope es: " + pila.getTope());
        pila.desapilar();
        System.out.println(pila.getTope());
        pila.apilar(9);
        System.out.println(pila.getTope());
        System.out.println(pila.isEmpty());

        PIla pila2 = copia(pila);
        System.out.println(pila2.getTope());
        System.out.println(pila.getTope());

        //COLASCOLASCOLASCOLASCOLASCOLASCOLASCOLASCOLASCOLASCOLASCOLASCOLASCOLASCOLASCOLASCOLAS

        Colas coto = new Colas();

        coto.acolar(1);
        coto.acolar(2);
        coto.acolar(3);

        System.out.println("Colas wacho: " + coto.getPrimero());
        coto.desacolar();
        System.out.println("desacolo: " + coto.getPrimero());
        coto.desacolar();
        System.out.println("desacolo otra vez: " + coto.getPrimero());
        coto.desacolar();
        System.out.println("desacolo otra vez");
        System.out.println("Esta vacio? --> " + coto.estaVacio());

        coto.acolar(86);
        coto.acolar(27);
        System.out.println("Primero post desacolacion: " + coto.getPrimero());
        coto.desacolar();
        System.out.println("desacolo: " + coto.getPrimero());
        System.out.println("Esta vacio? --> " + coto.estaVacio());
        coto.desacolar();
        System.out.println("Esta vacio? --> " + coto.estaVacio());
    }

    public static PIla copia(PIla banana){ // COPIAR LA PILA PA TENER UN AUXILIAR APARTE
        PIla aux = new PIla();

        while (!banana.isEmpty()){ // while banana.isEmpty() != True: MIENTRAS BANANA NO ESTE VACIO:
            int tope = banana.getTope();
            aux.apilar(tope);
            banana.desapilar();
        }  // ESTO CREA UNA PILA INVERTIDA

        PIla result = new PIla();
        while (!aux.isEmpty()){
            int tope = aux.getTope();
            result.apilar(tope);
            banana.apilar(tope);
            aux.desapilar();
        }
        return result;
    }
}