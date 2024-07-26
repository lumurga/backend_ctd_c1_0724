package com.backend.service;

import com.backend.model.Empleado;
import com.backend.model.EmpleadoContratado;

public class LiquidadorContratado extends LiquidadorSueldo{
    @Override
    protected double calcularSueldo(Empleado empleado) {
        double sueldo = 0;
        if (empleado instanceof EmpleadoContratado empleadoContratado)
            sueldo = empleadoContratado.getCantidadHoras() * empleadoContratado.getValorHora();

        return sueldo;
    }

    @Override
    protected String generarRecibo(Empleado empleado) {
        return "La liquidacion es un archivo impreso";
    }
}
