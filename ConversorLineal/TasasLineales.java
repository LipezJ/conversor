package ConversorLineal;

import java.util.ArrayList;
import Abstract.Tasas;
import Abstract.Unidad;

public class TasasLineales implements Tasas {
    private ArrayList<ArrayList<Double>> tasas = new ArrayList<ArrayList<Double>>();

    public double getTasa(Unidad unidadOrigen, Unidad unidadDestino) {
        if (unidadOrigen.getIdentificador() >= 0 && unidadOrigen.getIdentificador() < this.tasas.size()
            && unidadDestino.getIdentificador() >= 0 && unidadDestino.getIdentificador() < this.tasas.size()) {
            return this.tasas.get(unidadOrigen.getIdentificador()).get(unidadDestino.getIdentificador());
        } else {
            throw new IllegalArgumentException("Identificador de unidad no válido");
        }
    }

    public void setTasas(ArrayList<Double> nuevasTasas){
        if (nuevasTasas.size() == tasas.size()) {
            for (int i = 0; i < this.tasas.size(); i++) {
                this.tasas.get(i).add(nuevasTasas.get(i) != 0 ? 1.0 / nuevasTasas.get(i) : 0.0);
            }
            nuevasTasas.add(1.0);
            this.tasas.add(nuevasTasas);
        } else {
            throw new IllegalArgumentException("Lista de tasas no valida");
        }
    }

    public void setTasa(Unidad unidadOrigen, Unidad unidadDestino, double nuevaTasa) {
        if (unidadOrigen.getIdentificador() >= 0 && unidadOrigen.getIdentificador() < this.tasas.size()
            && unidadDestino.getIdentificador() >= 0 && unidadDestino.getIdentificador() < this.tasas.size()) {
            this.tasas.get(unidadOrigen.getIdentificador()).set(unidadDestino.getIdentificador(), nuevaTasa);
        } else {
            throw new IllegalArgumentException("Identificador de unidad no válido");
        }
    }

    public void agregarTasa(ArrayList<Double> nuevasTasas) {
        if (nuevasTasas.size() == this.tasas.size()) {
            this.tasas.add(nuevasTasas);
        } else {
            throw new IllegalArgumentException("El tamaño de la lista de this.tasas no coincide con el número de unidades");
        }
    }

    public int getSize(){
        return this.tasas.size();
    }
}