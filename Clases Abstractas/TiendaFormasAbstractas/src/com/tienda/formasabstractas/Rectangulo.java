package com.tienda.formasabstractas;

// La clase "Rectangulo" extiende de la clase abstracta "Forma"
// Esto significa que "Rectangulo" debe implementar todos los métodos abstractos definidos en "Forma"
public class Rectangulo extends Forma {
    // Variables de instancia privadas para almacenar el ancho y el alto del rectángulo
    private double ancho;
    private double alto;

    // Constructor que inicializa los valores del ancho y el alto
    public Rectangulo(double ancho, double alto) {
        this.ancho = ancho; // Asigna el valor proporcionado al atributo "ancho"
        this.alto = alto;   // Asigna el valor proporcionado al atributo "alto"
    }

    // Método getter para obtener el valor del ancho
    public double getAncho() {
        return ancho;
    }

    // Método setter para establecer un nuevo valor para el ancho
    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    // Método getter para obtener el valor del alto
    public double getAlto() {
        return alto;
    }

    // Método setter para establecer un nuevo valor para el alto
    public void setAlto(double alto) {
        this.alto = alto;
    }

    // Implementación del método abstracto "calcularArea" de la clase "Forma"
    // Calcula el área del rectángulo multiplicando el ancho por el alto
    @Override
    public double calcularArea() {
        return ancho * alto;
    }

    // Sobrescribe el método "toString" para proporcionar una representación en texto del rectángulo
    // Incluye el ancho, alto y el área formateada con dos decimales
    @Override
    public String toString() {
        return "Rectángulo - Ancho: " + ancho + ", Alto: " + alto + ", Área: " + String.format("%.2f", calcularArea());
    }
}
