package Clase_01;

public class Hola {
    public int id;
    public String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Hola() {
    }

    public Hola(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public void mostrame_el_id(){
        System.out.println("El id es: " + this.id);
    }
}
