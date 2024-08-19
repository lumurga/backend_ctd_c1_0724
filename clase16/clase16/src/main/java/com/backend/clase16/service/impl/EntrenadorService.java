package com.backend.clase16.service.impl;

import com.backend.clase16.entity.Entrenador;
import com.backend.clase16.service.IEntrenadorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EntrenadorService implements IEntrenadorService {

    private final Logger LOGGER = LoggerFactory.getLogger(EntrenadorService.class);


    //private IDao<Entrenador> entrenadorIDao;

    //public EntrenadorService(IDao<Entrenador> entrenadorIDao) {
    //  this.entrenadorIDao = entrenadorIDao;
    //}


    @Override
    public List<Entrenador> listarEntrenadores() {
        List<Entrenador> entrenadores = Arrays.asList(new Entrenador("Simon"), new Entrenador("Pablo"), new Entrenador("Lionel")); //entrenadorIDao.listar();
        LOGGER.info("Listado de todos los entrenadores: " + entrenadores);
        return entrenadores;
    }
}
