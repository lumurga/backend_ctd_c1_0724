package com.backend.service;

import com.backend.model.Empleado;

public abstract class LiquidadorSueldo {

    //Metodo template
    public String liquidarSueldo(Empleado empleado){
        String respuesta = "La liquidacion no pudo ser calculada";

        //1- calcular sueldo
        double sueldo = calcularSueldo(empleado);
        if (sueldo > 0){
            //2- generar recibo
            String recibo = generarRecibo(empleado);
            respuesta = recibo + ". Sueldo a depositar: $" + sueldo;
            //3- depositar
            System.out.println(depositar(empleado.getNumeroCuenta()));
        }
        System.out.println(respuesta);
        return respuesta;
    }

    protected abstract double calcularSueldo(Empleado empleado);

    protected abstract String generarRecibo(Empleado empleado);

    private String depositar(String numeroCuenta){
        return "Orden de deposito en la cuenta: " + numeroCuenta;
    }


}
