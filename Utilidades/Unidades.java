package Utilidades;

import java.util.ArrayList;
import java.util.function.Function;

public interface Unidades {
    default void agregarUnidad(String nombre, Double[] tasas){};
    default void agregarUnidadN(String nombre, ArrayList<Function<Double, Double>> tasas, ArrayList<Function<Double, Double>> nuevasInversas){};
    double cambiar(String origen, String destino, double cantidad);
    String[] getUnidades();
}