import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

import Utilidades.*;
import ConversorLineal.*;
import ConversorNoLineal.*;

public class Main {
    public static void main(String[] args) {

        Unidades monedas = inicializarMonedas();
        Unidades logitudes = inicializarLongitudes();
        UnidadesNoLineales temperatura = inicializarTemperaturas();

        double cambio1 = monedas.cambiar("EUR", "USD", 5.89);
        double cambio2 = logitudes.cambiar("metro", "kilometro", 23);
        double cambio3 = temperatura.cambiar("Celsius", "Fahrenheit", 15);

        System.out.println(cambio1);
        System.out.println(cambio2);
        System.out.println(cambio3);

    }
    public static Unidades inicializarMonedas() {
        Unidades monedas = new UnidadesLineales();
        monedas.agregarUnidad("EUR", new Double[]{});
        monedas.agregarUnidad("USD", new Double[]{0.94});
        monedas.agregarUnidad("JPY", new Double[]{0.0070, 0.0074});
        monedas.agregarUnidad("MXN", new Double[]{0.051, 0.054, 7.3});
        monedas.agregarUnidad("COP", new Double[]{0.0002, 0.00021, 0.029, 0.0039});
        return monedas;
    }
    public static Unidades inicializarLongitudes() {
        Unidades fisica = new UnidadesLineales();
        fisica.agregarUnidad("metro", new Double[]{});
        fisica.agregarUnidad("pie", new Double[]{0.3048});
        fisica.agregarUnidad("kilometro", new Double[]{1000.0, 3280.84});
        fisica.agregarUnidad("milla", new Double[]{1609.339999, 5279.98687, 1.60934});
        fisica.agregarUnidad("yarda", new Double[]{0.914397, 2.999992, 0.000914, 0.0005681});
        return fisica;
    }
    public static UnidadesNoLineales inicializarTemperaturas() {
        UnidadesNoLineales temperatura = new UnidadesNoLineales();
        temperatura.agregarUnidad("Celsius", new ArrayList<Function<Double, Double>>(), new ArrayList<Function<Double, Double>>(Arrays.asList()));
        temperatura.agregarUnidad("Kelvin", new ArrayList<Function<Double, Double>>(Arrays.asList(valor -> valor - 273.15)), new ArrayList<Function<Double, Double>>(Arrays.asList(valor -> valor + 273.15)));
        temperatura.agregarUnidad("Fahrenheit", new ArrayList<Function<Double, Double>>(Arrays.asList(valor -> (valor - 32) * 5/9, valor -> (valor - 32) * 5/9 + 273.15)), new ArrayList<Function<Double, Double>>(Arrays.asList(valor -> (valor * 9/5) + 32, valor -> (valor - 273.15) * 9/5 + 32)));
        return temperatura;
    }
}