package Interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import Utilidades.ListaConversores;
import Base.Unidades;

public class Interfaz extends JFrame implements ActionListener {

    private JComboBox<String> unidadesComboOrigen, unidadesComboDestino;
    private JLabel unidadesLabel, valorLabel;
    private JTextField valorTextField;
    private JButton convertirButton, unidadButton, intercambiarButton;
    private ListaConversores conversores;
    private ArrayList<JButton> listaConversores = new ArrayList<JButton>();

    public Interfaz(ListaConversores conversores) {
        setLayout(new FlowLayout());

        this.conversores = conversores;

        JPanel principal = new JPanel();
        JPanel conversorPrinipalPanel = new JPanel();
        JPanel conversorPanel = new JPanel();
        JPanel tituloPanel = new JPanel();
        JPanel unidadesPanel = new JPanel();
        JPanel valorPanel = new JPanel();
        JPanel convertirPanel = new JPanel();
        JPanel listaConversoresPanel = new JPanel();

        principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));
        conversorPrinipalPanel.setLayout(new BoxLayout(conversorPrinipalPanel, BoxLayout.X_AXIS));
        conversorPanel.setLayout(new BoxLayout(conversorPanel, BoxLayout.Y_AXIS));
        listaConversoresPanel.setLayout(new BoxLayout(listaConversoresPanel, BoxLayout.Y_AXIS));

        setTitle("Conversor de unidades");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        unidadesComboOrigen = new JComboBox<>(conversores.getConversor().getUnidades());
        unidadesComboDestino = new JComboBox<>(conversores.getConversor().getUnidades());
        unidadesLabel = new JLabel("Monedas");
        valorLabel = new JLabel("Valor");
        valorTextField = new JTextField(10);
        convertirButton = new JButton("Convertir");
        unidadButton = new JButton("Cambiar Conversor");
        intercambiarButton = new JButton("\uf362");
        for (int i = 0; i < conversores.getNombres().size(); i++) {
            this.listaConversores.add(new JButton(conversores.getNombres().get(i)));
        }

        convertirButton.addActionListener(this);
        unidadButton.addActionListener(this);
        valorTextField.addActionListener(this);
        intercambiarButton.addActionListener(this);
        for (int i = 0; i < listaConversores.size(); i++) {
            this.listaConversores.get(i).addActionListener(this);
        }

        unidadesComboDestino.setSelectedIndex(1);

        tituloPanel.add(unidadesLabel);
        unidadesPanel.add(unidadesComboOrigen); 
        unidadesPanel.add(intercambiarButton);
        unidadesPanel.add(unidadesComboDestino);
        valorPanel.add(valorLabel);
        valorPanel.add(valorTextField);
        convertirPanel.add(convertirButton);

        for (int i = 0; i < listaConversores.size(); i++) {
            listaConversoresPanel.add(listaConversores.get(i));
        }
        listaConversoresPanel.add(unidadButton);

        conversorPanel.add(unidadesPanel);
        conversorPanel.add(valorPanel);
        conversorPanel.add(convertirPanel);

        conversorPrinipalPanel.add(conversorPanel);
        conversorPrinipalPanel.add(listaConversoresPanel);

        principal.add(tituloPanel);
        principal.add(conversorPrinipalPanel);

        add(principal);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == unidadButton || this.listaConversores.indexOf(e.getSource()) != -1) {
            Unidades unidades;
            if (this.listaConversores.indexOf(e.getSource()) != -1) {
                unidades = this.conversores.getConversor(e.getActionCommand());
                unidadesLabel.setText(e.getActionCommand());
            } else {
                conversores.siguiente();
                unidades = conversores.getConversor();
                unidadesLabel.setText(conversores.getNombreActual());
            }
            unidadesComboOrigen.setModel(new DefaultComboBoxModel<>(unidades.getUnidades()));
            unidadesComboDestino.setModel(new DefaultComboBoxModel<>(unidades.getUnidades()));
            unidadesComboOrigen.setSelectedIndex(1);
            repaint();
        } else if (e.getSource() == convertirButton || e.getSource() == valorTextField) {
            Unidades unidades = conversores.getConversor();
            try {
                double cambio = unidades.cambiar(unidadesComboOrigen.getSelectedItem().toString(),
                        unidadesComboDestino.getSelectedItem().toString(),
                        (double) Double.parseDouble(valorTextField.getText()));
                String mensaje = String.format("%.2f %s son %.2f %s", Double.parseDouble(valorTextField.getText()),
                        unidadesComboOrigen.getSelectedItem().toString(), cambio,
                        unidadesComboDestino.getSelectedItem().toString());
                JOptionPane.showMessageDialog(null, mensaje);
            } catch (java.lang.NumberFormatException num) {
                valorTextField.setText("");
                JOptionPane.showMessageDialog(null, "Solo ingrese Numeros");
            }
        } else if (e.getSource() == intercambiarButton) {
            int origen = unidadesComboOrigen.getSelectedIndex();
            int destino = unidadesComboDestino.getSelectedIndex();
            unidadesComboOrigen.setSelectedIndex(destino);
            unidadesComboDestino.setSelectedIndex(origen);
        }
    }
}
