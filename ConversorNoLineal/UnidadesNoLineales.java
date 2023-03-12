package ConversorNoLineal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import Utilidades.Unidad;
import Utilidades.Unidades;

public class UnidadesNoLineales implements Unidades {
    private Map<String, Unidad> unidades = new HashMap<String, Unidad>();
    private FuncionesNoLineales tasas = new FuncionesNoLineales();

    public void agregarUnidadN(String nombre, ArrayList<Function<Double, Double>> tasas, ArrayList<Function<Double, Double>> nuevasInversas) {
        this.unidades.put(nombre, new Unidad(nombre, this.tasas.getSize()));
        this.tasas.setTasas(tasas, nuevasInversas);
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

    public String[] getUnidades(){
        Set<String> unidadesSet = this.unidades.keySet();
        String[] unidadesArray = new String[unidadesSet.size()];
        unidadesSet.toArray(unidadesArray);
        return unidadesArray;
    }
}
