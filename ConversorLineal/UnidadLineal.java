package ConversorLineal;

import Abstract.Unidad;

public class UnidadLineal implements Unidad {
    private String nombre;
    private int identificador;

    public UnidadLineal(String nombre, int identificador) {
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
