package Clase_01;

public class Persona {
    public int dni;
    public String nombre;
    public String apellido;

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String DecimeQueEsTomi() {
        return "Tomi es un poco GAY";
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Persona() { //CONSTRUCTOR VACIO
    }

    public Persona(int dni, String nombre, String apellido) { //CONSTRUCTOR
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
