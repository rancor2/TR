package com.tienda.formasabstractas;

// La clase "Circulo" extiende de la clase abstracta "Forma"
// Esto significa que "Circulo" debe proporcionar una implementación del método abstracto "calcularArea"
public class Circulo extends Forma {
    // Variable de instancia privada para almacenar el radio del círculo
    private double radio;

    // Constructor que inicializa el radio del círculo
    public Circulo(double radio) {
        this.radio = radio; // Asigna el valor proporcionado al atributo "radio"
    }

    // Método getter para obtener el valor del radio
    public double getRadio() {
        return radio;
    }

    // Método setter para establecer un nuevo valor para el radio
    public void setRadio(double radio) {
        this.radio = radio;
    }

    // Implementación del método abstracto "calcularArea" de la clase "Forma"
    // Calcula el área del círculo usando la fórmula π * radio^2
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    // Sobrescribe el método "toString" para proporcionar una representación en texto del círculo
    // Incluye el valor del radio y el área formateada con dos decimales
    @Override
    public String toString() {
        return "Círculo - Radio: " + radio + ", Área: " + String.format("%.2f", calcularArea());
    }
}
