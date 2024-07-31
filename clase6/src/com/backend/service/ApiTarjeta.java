package com.backend.service;

import com.backend.model.Tarjeta;

public class ApiTarjeta {

    public static int calcularDescuentoTarjeta(Tarjeta tarjeta){
        //int descuento = 0;
        //if (tarjeta.getBanco().equalsIgnoreCase("Star Bank")) descuento = 20;
        //return descuento;

        return tarjeta.getBanco().equalsIgnoreCase("Star Bank") ? 20 : 0;

    }


}
