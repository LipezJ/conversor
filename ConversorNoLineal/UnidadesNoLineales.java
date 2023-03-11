package ConversorNoLineal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import Utilidades.Unidad;

public class UnidadesNoLineales {
    private Map<String, Unidad> unidades = new HashMap<String, Unidad>();
    private FuncionesNoLineales tasas = new FuncionesNoLineales();

    public boolean agregarUnidad(String nombre, ArrayList<Function<Double, Double>> tasas, ArrayList<Function<Double, Double>> nuevasInversas) {
        this.unidades.put(nombre, new Unidad(nombre, this.tasas.getSize()));
        this.tasas.setTasas(tasas, nuevasInversas);
        return true;
    }

    public double cambiar(String origen, String destino, double cantidad) {
        Unidad o = this.unidades.get(origen);
        Unidad d = this.unidades.get(destino);
        if (o == null || d == null) {
            throw new IllegalArgumentException("Unidad no encontrada.");
        }
        Function<Double, Double> function = this.tasas.getTasa(o, d);
        return function.apply(cantidad);
    }

    public Set<String> getUnidades(){
        return this.unidades.keySet();
    }
}
