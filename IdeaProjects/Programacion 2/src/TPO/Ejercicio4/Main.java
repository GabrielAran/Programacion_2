package TPO.Ejercicio4;

public class Main {
    public static void main(String[] args){
        //Investigue el patrón Builder. Modifique la estructura Set y la estructura Stack para que tengan un
        //método add por medio de este patrón.
        ISetBuilder zeta = new SetBuilder();
        zeta.add(8).add(4).add(16).add(88);

        IStackBuilder stack = new StackBuilder();
        stack.add(78).add(45).add(16);

        //Escriba otro método addAll que pertenezca al mismo builder, que
        //reciba una instancia de Set y agregue todos sus elementos sin modificar la instancia de Set.
        ISetBuilder dedo = new SetBuilder();
        dedo.add(41).add(80).add(47);
        zeta.addAll(dedo);

        //Modifique la estructura Queue para que tenga un constructor con cantidad de parámetros variables, de
        //tal forma que instancie la estructura con datos dentro.

        QueueBuilder quue = new QueueBuilder(1, 4, 6, 16);
    }
}
