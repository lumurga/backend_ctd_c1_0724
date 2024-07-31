package com.backend.service;

import com.backend.model.Computadora;

import java.util.HashMap;
import java.util.Map;

public class ComputadoraFactory {

    private static Map<String, Computadora> computadorasLigeras = new HashMap<>();

    public static Computadora devolverComputadora(int ram, int disco){

        //definir la key
        String key = ram + ":" + disco;
        System.out.println(key);

        //verificar si esa key se encuentra en la coleccion
        if(!computadorasLigeras.containsKey(key)){
            //crear compu
            Computadora computadora = new Computadora(ram, disco);
            computadorasLigeras.put(key, computadora);
            System.out.println("Computadora creada: " + computadora);

        } else System.out.println("Computadora encontrada");

        return computadorasLigeras.get(key);
    }

    public static Map<String, Computadora> getComputadorasLigeras() {
        return computadorasLigeras;
    }
}
