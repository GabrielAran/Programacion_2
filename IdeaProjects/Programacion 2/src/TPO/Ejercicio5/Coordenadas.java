package TPO.Ejercicio5;

public class Coordenadas {
    private double x;
    private double y;

    public Coordenadas(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double calcularDistanciaCentro(double x, double y){
        double distancia = Math.sqrt(x * x + y * y);
        return distancia;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
