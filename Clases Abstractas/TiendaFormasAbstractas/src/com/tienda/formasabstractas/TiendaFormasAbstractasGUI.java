package com.tienda.formasabstractas;

import javax.swing.*;  // Librerías de Swing para crear la GUI
import java.awt.*;  // Clases para manejar layouts y componentes gráficos
import java.awt.event.*;  // Manejo de eventos (acciones de usuario)

public class TiendaFormasAbstractasGUI extends JFrame {  // La clase hereda de JFrame, que representa una ventana de aplicación
    // Componentes de la GUI
    private JComboBox<String> tipoFormaCombo;  // ComboBox para seleccionar el tipo de forma (Círculo o Rectángulo)
    private JTextField radioField, anchoField, altoField;  // Campos de texto para ingresar datos del radio, ancho y alto
    private JButton agregarButton;  // Botón para agregar una nueva forma
    private DefaultListModel<Forma> listaModel;  // Modelo de datos para la lista de formas
    private JList<Forma> formasList;  // Lista visual que muestra las formas agregadas

    // Constructor de la ventana principal
    public TiendaFormasAbstractasGUI() {
        setTitle("Tienda de Formas Geométricas (Abstracta)"); // Establece el título de la ventana
        setSize(500, 400); // Define el tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configura la acción de cerrar la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        initComponents(); // Llama al método para inicializar los componentes
    }

    // Método para inicializar los componentes de la GUI
    private void initComponents() {
        // Panel principal con diseño de borde (BorderLayout)
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Panel de entrada con diseño de cuadrícula (5 filas, 2 columnas)
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));

        // ComboBox para seleccionar el tipo de forma (Círculo o Rectángulo)
        inputPanel.add(new JLabel("Tipo de Forma:"));
        tipoFormaCombo = new JComboBox<>(new String[]{"Círculo", "Rectángulo"});
        inputPanel.add(tipoFormaCombo);

        // Campo de texto para el radio del círculo
        inputPanel.add(new JLabel("Radio:"));
        radioField = new JTextField();
        inputPanel.add(radioField);

        // Campo de texto para el ancho del rectángulo
        inputPanel.add(new JLabel("Ancho:"));
        anchoField = new JTextField();
        inputPanel.add(anchoField);

        // Campo de texto para el alto del rectángulo
        inputPanel.add(new JLabel("Alto:"));
        altoField = new JTextField();
        inputPanel.add(altoField);

        // Botón para agregar una nueva forma
        agregarButton = new JButton("Agregar Forma");
        inputPanel.add(agregarButton);

        // Agrega el panel de entrada al panel principal en la parte superior
        panel.add(inputPanel, BorderLayout.NORTH);

        // Lista para mostrar las formas agregadas, con modelo para almacenar los datos
        listaModel = new DefaultListModel<>();
        formasList = new JList<>(listaModel);
        JScrollPane scrollPane = new JScrollPane(formasList); // Permite desplazar la lista si es necesario
        panel.add(scrollPane, BorderLayout.CENTER); // Añade la lista al panel principal

        // Agrega el panel principal a la ventana
        add(panel);

        // Configura la acción del botón agregar
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarForma(); // Llama al método que añade una nueva forma
            }
        });

        // Configura la acción cuando se selecciona un tipo de forma en el ComboBox
        tipoFormaCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarCampos(); // Llama al método que actualiza la visibilidad de los campos
            }
        });

        // Establece la visibilidad inicial de los campos
        actualizarCampos();
    }

    // Método para actualizar la visibilidad de los campos de entrada según el tipo de forma
    private void actualizarCampos() {
        String tipo = (String) tipoFormaCombo.getSelectedItem();
        if (tipo.equals("Círculo")) {
            // Activa el campo de radio y desactiva los de ancho y alto
            radioField.setEnabled(true);
            anchoField.setEnabled(false);
            altoField.setEnabled(false);
            // Limpia los campos de texto para evitar valores no válidos
            radioField.setText("");
            anchoField.setText("");
            altoField.setText("");
        } else if (tipo.equals("Rectángulo")) {
            // Activa los campos de ancho y alto y desactiva el de radio
            radioField.setEnabled(false);
            anchoField.setEnabled(true);
            altoField.setEnabled(true);
            // Limpia los campos de texto para evitar valores no válidos
            radioField.setText("");
            anchoField.setText("");
            altoField.setText("");
        }
    }

    // Método para agregar una nueva forma a la lista
    private void agregarForma() {
        String tipo = (String) tipoFormaCombo.getSelectedItem(); // Obtiene el tipo de forma seleccionada
        Forma forma = null; // Variable para almacenar la nueva forma
        try {
            if (tipo.equals("Círculo")) {
                // Crea un nuevo círculo con el radio ingresado
                double radio = Double.parseDouble(radioField.getText());
                forma = new Circulo(radio);
            } else if (tipo.equals("Rectángulo")) {
                // Crea un nuevo rectángulo con el ancho y alto ingresados
                double ancho = Double.parseDouble(anchoField.getText());
                double alto = Double.parseDouble(altoField.getText());
                forma = new Rectangulo(ancho, alto);
            }
        } catch (NumberFormatException ex) {
            // Muestra un mensaje de error si los datos ingresados no son válidos
            JOptionPane.showMessageDialog(this, "Datos inválidos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (forma != null) {
            // Añade la forma a la lista y limpia los campos de entrada
            listaModel.addElement(forma);
            limpiarCampos();
        }
    }

    // Método para limpiar los campos de entrada
    private void limpiarCampos() {
        radioField.setText("");
        anchoField.setText("");
        altoField.setText("");
    }

    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() { // Ejecuta la GUI en el hilo de despacho de eventos de Swing
            @Override
            public void run() {
                new TiendaFormasAbstractasGUI().setVisible(true); // Muestra la ventana
            }
        });
    }
}
