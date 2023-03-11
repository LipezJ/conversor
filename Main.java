import Abstract.*;
import ConversorLineal.*;

public class Main {
    public static void main(String[] args) {

        Unidades monedas = inicializarMonedas();

        double cambio1 = monedas.cambiar("EUR", "USD", 2);
        double cambio2 = monedas.cambiar("USD", "EUR", 1);

        Double[] list = {2.0,0.0,0.0,0.0,0.0};

        monedas.agregarUnidad("GBP", list);

        double cambio3 = monedas.cambiar("GBP", "EUR", 1);
        double cambio4 = monedas.cambiar("EUR", "GBP", 1);

        System.out.println(cambio1);
        System.out.println(cambio2);
        System.out.println(cambio3);
        System.out.println(cambio4);
    }
    public static Unidades inicializarMonedas() {
        Unidades monedas = new UnidadesLineales();
        monedas.agregarUnidad("EUR", new Double[]{});
        monedas.agregarUnidad("USD", new Double[]{0.0});
        monedas.agregarUnidad("JPY", new Double[]{0.0, 0.0});
        monedas.agregarUnidad("MXN", new Double[]{0.0, 0.0, 0.0,});
        monedas.agregarUnidad("COP", new Double[]{0.0, 0.0, 0.0, 0.0});
        return monedas;
    }
}