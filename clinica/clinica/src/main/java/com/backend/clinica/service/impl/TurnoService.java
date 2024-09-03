package com.backend.clinica.service.impl;

import com.backend.clinica.dto.salida.PacienteSalidaDto;
import com.backend.clinica.repository.TurnoRepository;
import org.modelmapper.ModelMapper;

public class TurnoService {
    private final ModelMapper modelMapper;
    private final TurnoRepository turnoRepository;
    private final PacienteService pacienteService;
    private final OdontologoService odontologoService;

    public TurnoService(ModelMapper modelMapper, TurnoRepository turnoRepository, PacienteService pacienteService, OdontologoService odontologoService) {
        this.modelMapper = modelMapper;
        this.turnoRepository = turnoRepository;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }


}
