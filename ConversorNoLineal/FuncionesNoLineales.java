package ConversorNoLineal;

import Utilidades.Unidad;
import java.util.ArrayList;
import java.util.function.Function;

public class FuncionesNoLineales {
    private ArrayList<ArrayList<Function<Double, Double>>> tasas = new ArrayList<ArrayList<Function<Double, Double>>>();

    public Function<Double, Double> getTasa(Unidad unidadOrigen, Unidad unidadDestino) {
        if (unidadOrigen.getIdentificador() >= 0 && unidadOrigen.getIdentificador() < this.tasas.size()
            && unidadDestino.getIdentificador() >= 0 && unidadDestino.getIdentificador() < this.tasas.size()) {
            return this.tasas.get(unidadOrigen.getIdentificador()).get(unidadDestino.getIdentificador());
        } else {
            throw new IllegalArgumentException("Identificador de unidad no válido");
        }
    }

    public void setTasas(ArrayList<Function<Double, Double>> nuevasTasas, ArrayList<Function<Double, Double>> nuevasInversas){
        if (nuevasTasas.size() == tasas.size()) {
            for (int i = 0; i < this.tasas.size(); i++) {
                this.tasas.get(i).add(nuevasInversas.get(i));
            }
            nuevasTasas.add(valor -> valor);
            this.tasas.add(nuevasTasas);
        } else {
            throw new IllegalArgumentException("Lista de tasas no valida");
        }
    }

    public void setTasa(Unidad unidadOrigen, Unidad unidadDestino, Function<Double, Double> nuevaTasa) {
        if (unidadOrigen.getIdentificador() >= 0 && unidadOrigen.getIdentificador() < this.tasas.size()
            && unidadDestino.getIdentificador() >= 0 && unidadDestino.getIdentificador() < this.tasas.size()) {
            this.tasas.get(unidadOrigen.getIdentificador()).set(unidadDestino.getIdentificador(), nuevaTasa);
        } else {
            throw new IllegalArgumentException("Identificador de unidad no válido");
        }
    }

    public void agregarTasa(ArrayList<Function<Double, Double>> nuevasTasas) {
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
