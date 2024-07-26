package com.backend.service;

import com.backend.model.Empleado;
import com.backend.model.EmpleadoEfectivo;

public class LiquidadorEfectivo extends LiquidadorSueldo{

    @Override
    protected double calcularSueldo(Empleado empleado) {
        double sueldo = 0;

        if(empleado instanceof EmpleadoEfectivo empleadoEfectivo)
        sueldo = empleadoEfectivo.getSueldoBase() - empleadoEfectivo.getDescuento() + empleadoEfectivo.getPremio();

        return sueldo;
    }

    @Override
    protected String generarRecibo(Empleado empleado) {
        return "La liquidacion es un archivo digital";
    }
}
