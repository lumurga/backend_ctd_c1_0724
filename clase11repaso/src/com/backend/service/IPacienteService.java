package com.backend.service;

import com.backend.entity.Paciente;

public interface IPacienteService {

    Paciente registrarPaciente(Paciente paciente);
    Paciente buscarPacientePorId(Long id);


}
