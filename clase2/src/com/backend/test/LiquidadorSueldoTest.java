package com.backend.test;

import com.backend.model.Empleado;
import com.backend.model.EmpleadoContratado;
import com.backend.model.EmpleadoEfectivo;
import com.backend.service.LiquidadorContratado;
import com.backend.service.LiquidadorEfectivo;
import com.backend.service.LiquidadorSueldo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LiquidadorSueldoTest {

    private LiquidadorSueldo liquidadorSueldo;

    @Test
    public void dadoUnEmpleadoEfectivo_deberiaLiquidarseSuSueldoYGenerarseReciboDigital(){
        //arrange
        liquidadorSueldo = new LiquidadorEfectivo();
        Empleado empleado = new EmpleadoEfectivo("Pedro", "Ponce", "CA-5655654656", 2000, 100, 50);

        String respuestaEsperada = "La liquidacion es un archivo digital. Sueldo a depositar: $2050.0";

        //act
        String respuestaObtenida = liquidadorSueldo.liquidarSueldo(empleado);

        //assert
        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    public void cuandoUnEmpleadoTrabajoCeroHoras_deberiaInformarQueNoSePuedeLiquidar(){
        //arrange
        liquidadorSueldo = new LiquidadorContratado();
        Empleado empleadoContratado = new EmpleadoContratado("Martin", "Martini", "CA-65176878777", 0, 2000);
        String respuestaEsperada = "La liquidacion no pudo ser calculada";
        String respuestaObtenida = liquidadorSueldo.liquidarSueldo(empleadoContratado);

        //assert
        assertEquals(respuestaEsperada, respuestaObtenida);

    }

}