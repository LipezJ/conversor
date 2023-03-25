package Base;

import java.util.ArrayList;

public interface Tasas {
    public double getTasa(Unidad unidadOrigen, Unidad unidadDestino);
    public void setTasas(ArrayList<Double> nuevasTasas);
    public void setTasa(Unidad unidadOrigen, Unidad unidadDestino, double nuevaTasa);
    public void agregarTasa(ArrayList<Double> nuevasTasas);
    public int getSize();
}