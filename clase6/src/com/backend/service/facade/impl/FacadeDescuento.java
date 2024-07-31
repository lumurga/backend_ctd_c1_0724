package com.backend.service.facade.impl;

import com.backend.model.Producto;
import com.backend.model.Tarjeta;
import com.backend.service.ApiCantidad;
import com.backend.service.ApiProducto;
import com.backend.service.ApiTarjeta;
import com.backend.service.facade.IDescuento;

public class FacadeDescuento implements IDescuento {


    @Override
    public int calcularDescuento(Producto producto, Tarjeta tarjeta, int cantidad) {
        int descuento = 0;
        descuento += ApiTarjeta.calcularDescuentoTarjeta(tarjeta);
        descuento += ApiCantidad.calcularDescuentoCantidad(cantidad);
        descuento += ApiProducto.calcularDescuentoProducto(producto);
        System.out.println(descuento);
        return descuento;
    }
}
