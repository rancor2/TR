package com.tienda.formasabstractas;

public abstract class Forma {
    public abstract double calcularArea();

    @Override
    public String toString() {
        return "Área: " + calcularArea();
    }
}
