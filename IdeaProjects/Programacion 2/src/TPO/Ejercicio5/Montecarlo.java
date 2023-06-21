package TPO.Ejercicio5;

public class Montecarlo {
    private Coordenadas[] cuadrado;
    private Coordenadas[] dentroCuadrado;
    private int count;


    public Montecarlo(){
        this.cuadrado = generarCuadrado();
        this.count = 0;
        this.dentroCuadrado = new Coordenadas[100];
    }

    public Coordenadas[] generarCuadrado(){
        // genero x e y para hacer un cuadrado en primer cuadrante:
        Coordenadas[] cuadrado = new Coordenadas[4];
        for (Coordenadas coordenadas : cuadrado) {
            coordenadas.setX(Math.random());
            coordenadas.setY(Math.random());
        }
        return cuadrado;
    }

    public void dentroDelCuadrado(Coordenadas cordenada){
        if (cordenada.getX() * cordenada.getX() + cordenada.getY() * cordenada.getY() <= 1){
            this.dentroCuadrado[this.count] = cordenada;
            this.count++;
        }
    }
}
