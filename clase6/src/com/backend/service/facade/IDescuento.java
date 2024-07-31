package com.backend.service.facade;

import com.backend.model.Producto;
import com.backend.model.Tarjeta;

public interface IDescuento {
    int calcularDescuento(Producto producto, Tarjeta tarjeta, int cantidad);
}
