package com.backend.clase16.controller;


import com.backend.clase16.entity.Entrenador;
import com.backend.clase16.service.IEntrenadorService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/entrenadores")
public class EntrenadorController {


    private IEntrenadorService entrenadorService;

    public EntrenadorController(IEntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }


    @GetMapping()
    public List<Entrenador> listarEntrenadores(){

        return entrenadorService.listarEntrenadores();
    }

}
