package com.tienda.formasabstractas;

// Definición de una clase abstracta llamada "Forma"
public abstract class Forma {
    // Método abstracto que obliga a las clases que hereden de "Forma" a implementar este método
    // Este método calculará el área de la forma, pero la implementación específica se delega a las subclases
    public abstract double calcularArea();

    // Sobrescribe el método "toString" para proporcionar una representación en texto de la instancia de la clase "Forma"
    // Llama al método "calcularArea" para mostrar el área calculada
    @Override
    public String toString() {
        return "Área: " + calcularArea();
    }
}