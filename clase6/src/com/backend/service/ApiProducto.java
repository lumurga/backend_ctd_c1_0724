package com.backend.service;

import com.backend.model.Producto;

public class ApiProducto {
    public static int calcularDescuentoProducto(Producto producto){
        return producto.getTipo().equalsIgnoreCase("latas") ? 10 : 0;
    }
}
