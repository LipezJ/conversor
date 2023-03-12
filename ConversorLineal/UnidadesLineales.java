package ConversorLineal;

import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import Base.*;

public class UnidadesLineales implements Unidades {
    private Map<String, Unidad> unidades = new HashMap<String, Unidad>();
    private Tasas tasas = new TasasLineales();

    public void agregarUnidad(String nombre, Double[] tasas) {
        this.unidades.put(nombre, new Unidad(nombre, this.tasas.getSize()));
        this.tasas.setTasas(new ArrayList<Double>(Arrays.asList(tasas)));
    }

    public double cambiar(String origen, String destino, double cantidad) {
        Unidad o = this.unidades.get(origen);
        Unidad d = this.unidades.get(destino);
        if (o == null || d == null) {
            throw new IllegalArgumentException("Unidad no encontrada.");
        }
        double tasa = this.tasas.getTasa(o, d);
        return cantidad * tasa;
    }

    public String[] getUnidades(){
        Set<String> unidadesSet = this.unidades.keySet();
        String[] unidadesArray = new String[unidadesSet.size()];
        unidadesSet.toArray(unidadesArray);
        return unidadesArray;
    }
}