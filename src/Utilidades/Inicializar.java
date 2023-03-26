package Utilidades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;
import ConversorLineal.UnidadesLineales;
import ConversorNoLineal.UnidadesNoLineales;
import Base.Unidades;

public class Inicializar {

    public static String[] nombres = { "Monedas", "Logitudes", "Temperaturas"};

    public static ArrayList<Unidades> inicializarUnidades() {
        return new ArrayList<Unidades>(Arrays.asList(monedas(), longitudes(), temperaturas()));
    }

    private static Unidades monedas() {
        Unidades monedas = new UnidadesLineales();
        monedas.agregarUnidad("EUR", new Double[]{});
        monedas.agregarUnidad("USD", new Double[]{0.94});
        monedas.agregarUnidad("JPY", new Double[]{0.0070, 0.0074});
        monedas.agregarUnidad("MXN", new Double[]{0.051, 0.054, 7.3});
        monedas.agregarUnidad("COP", new Double[]{0.0002, 0.00021, 0.029, 0.0039});
        monedas.agregarUnidad("GBP", new Double[]{1.33, 1.22, 159.62, 22.52, 5808.11});
        monedas.agregarUnidad("KRW", new Double[]{0.00072, 0.00077, 0.1, 0.014, 3.67, 0.00063});
        return monedas;
    }
    private static Unidades longitudes() {
        Unidades fisica = new UnidadesLineales();
        fisica.agregarUnidad("metro", new Double[]{});
        fisica.agregarUnidad("pie", new Double[]{0.3048});
        fisica.agregarUnidad("kilometro", new Double[]{1000.0, 3280.84});
        fisica.agregarUnidad("milla", new Double[]{1609.339999, 5279.98687, 1.60934});
        fisica.agregarUnidad("yarda", new Double[]{0.914397, 2.999992, 0.000914, 0.0005681});
        fisica.agregarUnidad("año luz", new Double[]{9.461e+15, 3.104e+16, 9.461e+15, 5.879e+12, 1.035e+16});
        return fisica;
    }
    private static Unidades temperaturas() {
        Unidades temperatura = new UnidadesNoLineales();
        temperatura.agregarUnidadN("Celsius", new ArrayList<Function<Double, Double>>(), new ArrayList<Function<Double, Double>>(Arrays.asList()));
        temperatura.agregarUnidadN("Kelvin", new ArrayList<Function<Double, Double>>(Arrays.asList(valor -> valor - 273.15)), new ArrayList<Function<Double, Double>>(Arrays.asList(valor -> valor + 273.15)));
        temperatura.agregarUnidadN("Fahrenheit", new ArrayList<Function<Double, Double>>(Arrays.asList(valor -> (valor - 32) * 5/9, valor -> (valor - 32) * 5/9 + 273.15)), new ArrayList<Function<Double, Double>>(Arrays.asList(valor -> (valor * 9/5) + 32, valor -> (valor - 273.15) * 9/5 + 32)));
        return temperatura;
    }
}
