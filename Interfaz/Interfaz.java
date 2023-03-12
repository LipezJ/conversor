package Interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Utilidades.ListaConversores;
import Utilidades.Unidades;

public class Interfaz extends JFrame implements ActionListener {

    private JComboBox<String> unidadesComboOrigen, unidadesComboDestino;
    private JLabel unidadesLabel, valorLabel;
    private JTextField valorTextField;
    private JButton convertirButton, unidadButton;
    private ListaConversores conversores;

    public Interfaz(ListaConversores conversores) {
        setLayout(new FlowLayout());

        this.conversores = conversores;

        JPanel principal = new JPanel();

        setTitle("Conversor de unidades");
        setSize(800, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        unidadesComboOrigen = new JComboBox<>(conversores.getUnidades().getUnidades());
        unidadesComboDestino = new JComboBox<>(conversores.getUnidades().getUnidades());
        unidadesLabel = new JLabel("Monedas");
        valorLabel = new JLabel("Valor");
        valorTextField = new JTextField(10);
        convertirButton = new JButton("Convertir");
        unidadButton = new JButton("Cambiar Conversor");

        convertirButton.addActionListener(this);
        unidadButton.addActionListener(this);
        valorTextField.addActionListener(this);

        unidadesComboDestino.setSelectedIndex(1);

        principal.add(unidadesComboOrigen);
        principal.add(unidadesComboDestino);
        principal.add(unidadesLabel);
        principal.add(valorLabel);
        principal.add(valorTextField);
        principal.add(convertirButton);
        principal.add(unidadButton);

        add(principal);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == unidadButton) {
            conversores.siguiente();
            Unidades unidades = conversores.getUnidades();
            unidadesLabel.setText(conversores.getNombreActual());
            unidadesComboOrigen.setModel(new DefaultComboBoxModel<>(unidades.getUnidades()));
            unidadesComboDestino.setModel(new DefaultComboBoxModel<>(unidades.getUnidades()));
            repaint();
        } else if (e.getSource() == convertirButton || e.getSource() == valorTextField) {
            Unidades unidades = conversores.getUnidades();
            try {
                double cambio = unidades.cambiar(unidadesComboOrigen.getSelectedItem().toString(), unidadesComboDestino.getSelectedItem().toString(), (double) Double.parseDouble(valorTextField.getText()));
                JOptionPane.showMessageDialog(null, cambio);
            } catch (java.lang.NumberFormatException num) {
                valorTextField.setText("");
                JOptionPane.showMessageDialog(null, "Solo ingrese Numeros");
            }
        }
    }
}
