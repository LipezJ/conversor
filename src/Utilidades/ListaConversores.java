package Utilidades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import Base.Unidades;

public class ListaConversores {

    private int actual;
    private Map<String, Unidades> unidades;
    private ArrayList<String> nombres;

    public ListaConversores(ArrayList<Unidades> unidades, String[] nombres) {
        if (unidades.size() != nombres.length) 
            throw new IllegalArgumentException("Los Tamaños de los arreglos no coinciden");
        this.nombres = new ArrayList<String>(Arrays.asList(nombres));
        this.unidades = new java.util.HashMap<String, Unidades>();
        for (int i = 0; i < unidades.size(); i++) {
            this.unidades.put(this.nombres.get(i), unidades.get(i));
        }
    }
    public Unidades getConversor() {
        return this.unidades.get(this.nombres.get(actual));
    }
    public Unidades getConversor(String nombre) {
        actual = this.nombres.indexOf(nombre);
        return this.unidades.get(nombre);
    }
    public String getNombreActual() {
        return this.nombres.get(actual);
    }
    public String getNombreSiguiente() {
        return this.nombres.get(actual + 1);
    }
    public String getNombreAnterior() {
        return this.nombres.get(actual - 1);
    }
    public void siguiente() {
        actual ++;
        if (actual >= unidades.size()) actual = 0;
    }
    public void anterior() {
        actual --;
        if (actual < 0) actual = unidades.size() - 1;
    }
    public ArrayList<String> getNombres() {
        return this.nombres;
    }
    public void agregarConversor(String nombre, Unidades unidades) {
        this.unidades.put(nombre, unidades);
        this.nombres.add(nombre);
    }
}
