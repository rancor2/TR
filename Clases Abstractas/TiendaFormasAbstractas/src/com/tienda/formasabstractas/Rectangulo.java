package com.tienda.formasabstractas;

public class Rectangulo extends Forma {
    private double ancho;
    private double alto;

    public Rectangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    @Override
    public double calcularArea() {
        return ancho * alto;
    }

    @Override
    public String toString() {
        return "Rectángulo - Ancho: " + ancho + ", Alto: " + alto + ", Área: " + String.format("%.2f", calcularArea());
    }
}
