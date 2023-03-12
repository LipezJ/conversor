package Utilidades;

import java.util.ArrayList;
import java.util.Arrays;

public class ListaConversores {

    private int actual;
    private ArrayList<Unidades> unidades;
    private ArrayList<String> nombres;

    public ListaConversores(Unidades[] unidades, String[] nombres) {
        if (unidades.length != nombres.length) 
            throw new IllegalArgumentException("Los Tamaños de los arreglos no coinciden");
        this.unidades = new ArrayList<Unidades>(Arrays.asList(unidades));
        this.nombres = new ArrayList<String>(Arrays.asList(nombres));
    }
    public Unidades getUnidades() {
        return this.unidades.get(actual);
    }
    public String getNombreActual() {
        return this.nombres.get(actual);
    }
    public void siguiente() {
        actual ++;
        if (actual >= unidades.size()) actual = 0;
    }
    public void agregarUnidades(String nombre, Unidades unidades) {
        this.unidades.add(unidades);
        this.nombres.add(nombre);
    }
}
