import Utilidades.Inicializar;
import Utilidades.ListaConversores;
import Interfaz.Interfaz;

public class Main {
    public static void main(String[] args) {
        ListaConversores conversores = new ListaConversores(Inicializar.inicializarUnidades(), Inicializar.nombres);
        Interfaz interfaz = new Interfaz(conversores);
        interfaz.setVisible(true);
    }
}