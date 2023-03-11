package Abstract;
import java.util.Set;

public interface Unidades {
    public void agregarUnidad(String nombre, Double[] tasas);
    public double cambiar(String origen, String destino, double cantidad);
    public Set<String> getUnidades();
}