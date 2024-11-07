package com.tienda.formas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TiendaFormasGUI extends JFrame {
    private JComboBox<String> tipoFormaCombo;
    private JTextField radioField, anchoField, altoField;
    private JButton agregarButton;
    private DefaultListModel<Forma> listaModel;
    private JList<Forma> formasList;

    public TiendaFormasGUI() {
        setTitle("Tienda de Formas Geométricas");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Panel de entrada
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));

        inputPanel.add(new JLabel("Tipo de Forma:"));
        tipoFormaCombo = new JComboBox<>(new String[]{"Círculo", "Rectángulo"});
        inputPanel.add(tipoFormaCombo);

        inputPanel.add(new JLabel("Radio:"));
        radioField = new JTextField();
        inputPanel.add(radioField);

        inputPanel.add(new JLabel("Ancho:"));
        anchoField = new JTextField();
        inputPanel.add(anchoField);

        inputPanel.add(new JLabel("Alto:"));
        altoField = new JTextField();
        inputPanel.add(altoField);

        agregarButton = new JButton("Agregar Forma");
        inputPanel.add(agregarButton);
        inputPanel.add(new JLabel("")); // Espacio vacío

        panel.add(inputPanel, BorderLayout.NORTH);

        // Lista de formas
        listaModel = new DefaultListModel<>();
        formasList = new JList<>(listaModel);
        JScrollPane scrollPane = new JScrollPane(formasList);
        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);

        // Acción del botón agregar
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarForma();
            }
        });

        // Cambio de visibilidad de campos según el tipo de forma seleccionado
        tipoFormaCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarCampos();
            }
        });

        actualizarCampos();
    }

    private void actualizarCampos() {
        String tipo = (String) tipoFormaCombo.getSelectedItem();
        if (tipo.equals("Círculo")) {
            radioField.setEnabled(true);
            anchoField.setEnabled(false);
            altoField.setEnabled(false);
            radioField.setText("");
            anchoField.setText("");
            altoField.setText("");
        } else if (tipo.equals("Rectángulo")) {
            radioField.setEnabled(false);
            anchoField.setEnabled(true);
            altoField.setEnabled(true);
            radioField.setText("");
            anchoField.setText("");
            altoField.setText("");
        }
    }

    private void agregarForma() {
        String tipo = (String) tipoFormaCombo.getSelectedItem();
        Forma forma = null;
        try {
            if (tipo.equals("Círculo")) {
                double radio = Double.parseDouble(radioField.getText());
                forma = new Circulo(radio);
            } else if (tipo.equals("Rectángulo")) {
                double ancho = Double.parseDouble(anchoField.getText());
                double alto = Double.parseDouble(altoField.getText());
                forma = new Rectangulo(ancho, alto);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Datos inválidos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (forma != null) {
            listaModel.addElement(forma);
            limpiarCampos();
        }
    }

    private void limpiarCampos() {
        radioField.setText("");
        anchoField.setText("");
        altoField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TiendaFormasGUI().setVisible(true);
            }
        });
    }
}
