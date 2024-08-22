package com.backend.clinica.service.impl;

import com.backend.clinica.dto.entrada.PacienteEntradaDto;
import com.backend.clinica.dto.salida.PacienteSalidaDto;
import com.backend.clinica.entity.Paciente;
import com.backend.clinica.repository.IDao;
import com.backend.clinica.service.IPacienteService;
import com.backend.clinica.utils.JsonPrinter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService implements IPacienteService {


    private final Logger LOGGER = LoggerFactory.getLogger(PacienteService.class);
    private final IDao<Paciente> pacienteIDao;
    private final ModelMapper modelMapper;

    public PacienteService(IDao<Paciente> pacienteIDao, ModelMapper modelMapper) {
        this.pacienteIDao = pacienteIDao;
        this.modelMapper = modelMapper;
        configureMapping();
    }


    @Override
    public PacienteSalidaDto registrarPaciente(PacienteEntradaDto paciente) {

        LOGGER.info("PacienteEntradaDto: {}", JsonPrinter.toString(paciente));
        Paciente entidadPaciente = modelMapper.map(paciente, Paciente.class);
        LOGGER.info("EntidadPaciente: {}", JsonPrinter.toString(entidadPaciente));
        Paciente pacienteRegistrado = pacienteIDao.registrar(entidadPaciente);
        LOGGER.info("PacienteRegistrado: {}", JsonPrinter.toString(pacienteRegistrado));
        PacienteSalidaDto pacienteSalidaDto = modelMapper.map(pacienteRegistrado, PacienteSalidaDto.class);
        LOGGER.info("PacienteSalidaDto: {}", JsonPrinter.toString(pacienteSalidaDto));
        return pacienteSalidaDto;
    }

    @Override//NO HAY QUE LANZAR LA EXCEPCION ACA
    public PacienteSalidaDto buscarPacientePorId(Long id) {
        return null;
    }

    @Override
    public List<PacienteSalidaDto> listarPacientes() {
        List<PacienteSalidaDto> pacienteSalidaDtos = pacienteIDao.listarTodos()
                .stream()
                .map(paciente -> modelMapper.map(paciente, PacienteSalidaDto.class))
                .toList();
        LOGGER.info("Listado de todos los pacientes: {}", JsonPrinter.toString(pacienteSalidaDtos));

        return pacienteSalidaDtos;
    }


    public void eliminarPaciente(Long id) {
        if(buscarPacientePorId(id) != null){
            //llamada a la capa repositorio para eliminar
            LOGGER.warn("Se ha eliminado el paciente con id {}", id);
        } else {
            //excepcion resource not found
        }

    }

    @Override
    public PacienteSalidaDto actualizarPaciente(PacienteEntradaDto pacienteEntradaDto, Long id) {
        return null;
    }


    private void configureMapping(){
        modelMapper.typeMap(PacienteEntradaDto.class, Paciente.class)
                .addMappings(mapper -> mapper.map(PacienteEntradaDto::getDomicilioEntradaDto, Paciente::setDomicilio));
        modelMapper.typeMap(Paciente.class, PacienteSalidaDto.class)
                .addMappings(mapper -> mapper.map(Paciente::getDomicilio, PacienteSalidaDto::setDomicilioSalidaDto));
    }
}



