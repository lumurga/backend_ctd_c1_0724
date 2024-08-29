package com.backend.clinica.service;

import com.backend.clinica.dto.entrada.PacienteEntradaDto;
import com.backend.clinica.dto.salida.PacienteSalidaDto;
import com.backend.clinica.entity.Paciente;

import java.util.List;

public interface IPacienteService {

    PacienteSalidaDto registrarPaciente(PacienteEntradaDto paciente);
    PacienteSalidaDto buscarPacientePorId(Long id);

    List<PacienteSalidaDto> listarPacientes();

    void eliminarPaciente(Long id);
    PacienteSalidaDto actualizarPaciente(PacienteEntradaDto pacienteEntradaDto, Long id);
    //PacienteSalidaDto buscarPacientePorDni(int dni);


}
