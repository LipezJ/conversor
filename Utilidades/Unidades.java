package Utilidades;

import java.util.Set;

public interface Unidades {
    void agregarUnidad(String nombre, Double[] tasas);
    double cambiar(String origen, String destino, double cantidad);
    Set<String> getUnidades();
}