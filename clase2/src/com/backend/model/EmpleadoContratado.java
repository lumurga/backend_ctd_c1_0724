package com.backend.model;

public class EmpleadoContratado extends Empleado {

    private int cantidadHoras;
    private double valorHora;

    public EmpleadoContratado(String nombre, String apellido, String numeroCuenta, int cantidadHoras, double valorHora) {
        super(nombre, apellido, numeroCuenta);
        this.cantidadHoras = cantidadHoras;
        this.valorHora = valorHora;
    }

    public int getCantidadHoras() {
        return cantidadHoras;
    }

    public void setCantidadHoras(int cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }
}
