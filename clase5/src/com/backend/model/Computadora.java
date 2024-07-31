package com.backend.model;

public class Computadora {

    private int ram;
    private int disco;
    private static int contador;

    public Computadora(int ram, int disco) {
        this.ram = ram;
        this.disco = disco;
        contador++;
        System.out.println("Existencias: " + contador);
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getDisco() {
        return disco;
    }

    public void setDisco(int disco) {
        this.disco = disco;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Computadora.contador = contador;
    }

    @Override
    public String toString() {
        return "Computadora: " +
                " - ram: " + ram +
                " - disco: " + disco;
    }
}
