package com.backend.test;

import com.backend.service.facade.impl.FacadeDescuento;
import com.backend.model.Producto;
import com.backend.model.Tarjeta;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class FacadeDescuentoTest {
    private FacadeDescuento facadeDescuento = new FacadeDescuento();


    @Test
    void alComprarMasDe12Latas_deberiaCalcular25DeDescuento(){
        Tarjeta tarjeta = new Tarjeta("Link Bank", "3658965895");
        Producto producto = new Producto("Choclo", "latas");
        int descuentoObtenido = facadeDescuento.calcularDescuento(producto, tarjeta, 14);
        assertEquals(25, descuentoObtenido);
    }



}