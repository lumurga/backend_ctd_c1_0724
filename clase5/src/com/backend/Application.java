package com.backend;

import com.backend.model.Computadora;
import com.backend.service.ComputadoraFactory;

public class Application {

    public static void main(String[] args) {

        Computadora win1 = ComputadoraFactory.devolverComputadora(2, 128);
        System.out.println(win1);
        Computadora win2 = ComputadoraFactory.devolverComputadora(2, 128);
        System.out.println(win2);
        Computadora win3 = ComputadoraFactory.devolverComputadora(2, 128);
        System.out.println(win3);
        //ctrl+D
        Computadora mac1 = ComputadoraFactory.devolverComputadora(16, 500);
        Computadora mac2 = ComputadoraFactory.devolverComputadora(16, 500);
        Computadora mac3 = ComputadoraFactory.devolverComputadora(16, 500);

        System.out.println("-----------------------------------------------------");

        System.out.println(ComputadoraFactory.getComputadorasLigeras());

    }

}
