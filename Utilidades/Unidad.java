package Utilidades;

public class Unidad {
    private String nombre;
    private int identificador;

    public Unidad(String nombre, int identificador) {
        this.nombre = nombre;
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdentificador() {
        return identificador;
    }
}