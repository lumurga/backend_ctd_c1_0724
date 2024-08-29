package com.backend.clinica.service.impl;

import com.backend.clinica.dto.entrada.PacienteEntradaDto;
import com.backend.clinica.dto.salida.PacienteSalidaDto;
import com.backend.clinica.entity.Paciente;
import com.backend.clinica.repository.PacienteRepository;
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
    private final PacienteRepository pacienteRepository;
    private final ModelMapper modelMapper;


    public PacienteService(PacienteRepository pacienteRepository, ModelMapper modelMapper) {
        this.pacienteRepository = pacienteRepository;
        this.modelMapper = modelMapper;
        configureMapping();
    }


    @Override
    public PacienteSalidaDto registrarPaciente(PacienteEntradaDto paciente) {

        LOGGER.info("PacienteEntradaDto: {}", JsonPrinter.toString(paciente));
        Paciente entidadPaciente = modelMapper.map(paciente, Paciente.class);
        LOGGER.info("EntidadPaciente: {}", JsonPrinter.toString(entidadPaciente));
        Paciente pacienteRegistrado = pacienteRepository.save(entidadPaciente);
        LOGGER.info("PacienteRegistrado: {}", JsonPrinter.toString(pacienteRegistrado));
        PacienteSalidaDto pacienteSalidaDto = modelMapper.map(pacienteRegistrado, PacienteSalidaDto.class);
        LOGGER.info("PacienteSalidaDto: {}", JsonPrinter.toString(pacienteSalidaDto));
        return pacienteSalidaDto;
    }

    @Override//NO HAY QUE LANZAR LA EXCEPCION ACA NI EN NINGUN SERVICIO EN EL METODO buscarPorId
    public PacienteSalidaDto buscarPacientePorId(Long id) {
        Paciente pacienteBuscado = pacienteRepository.findById(id).orElse(null);
        LOGGER.info("Paciente buscado: {}", JsonPrinter.toString(pacienteBuscado));
        PacienteSalidaDto pacienteEncontrado = null;
        if(pacienteBuscado != null){
            pacienteEncontrado = modelMapper.map(pacienteBuscado, PacienteSalidaDto.class);
            LOGGER.info("Paciente encontrado: {}", JsonPrinter.toString(pacienteEncontrado));
        } else LOGGER.error("No se ha encontrado el paciente con id {}", id);

        return pacienteEncontrado;
    }

    @Override
    public List<PacienteSalidaDto> listarPacientes() {
        List<PacienteSalidaDto> pacienteSalidaDtos = pacienteRepository.findAll()
                .stream()
                .map(paciente -> modelMapper.map(paciente, PacienteSalidaDto.class))
                .toList();
        LOGGER.info("Listado de todos los pacientes: {}", JsonPrinter.toString(pacienteSalidaDtos));

        return pacienteSalidaDtos;
    }


    public void eliminarPaciente(Long id) {
        if(buscarPacientePorId(id) != null){
            //llamada a la capa repositorio para eliminar
            pacienteRepository.deleteById(id);
            LOGGER.warn("Se ha eliminado el paciente con id {}", id);
        } else {
            //excepcion resource not found
        }

    }

    @Override
    public PacienteSalidaDto actualizarPaciente(PacienteEntradaDto pacienteEntradaDto, Long id) {
        Paciente pacienteAActualizar = pacienteRepository.findById(id).orElse(null);
        Paciente pacienteRecibido = modelMapper.map(pacienteEntradaDto, Paciente.class);
        PacienteSalidaDto pacienteSalidaDto = null;

        if (pacienteAActualizar != null){

            pacienteRecibido.setId(pacienteAActualizar.getId());
            pacienteRecibido.getDomicilio().setId(pacienteAActualizar.getDomicilio().getId());
            pacienteAActualizar = pacienteRecibido;

            //pacienteAActualizar.setNombre(pacienteRecibido.getNombre());
            //pacienteAActualizar.setApellido(pacienteRecibido.getApellido());
            //pacienteAActualizar.setDni(pacienteRecibido.getDni());
            //pacienteAActualizar.setFechaIngreso(pacienteRecibido.getFechaIngreso());
            //pacienteAActualizar.getDomicilio().setNumero(pacienteRecibido.getDomicilio().getNumero());
            //pacienteAActualizar.getDomicilio().setLocalidad(pacienteRecibido.getDomicilio().getLocalidad());
            //pacienteAActualizar.getDomicilio().setProvincia(pacienteRecibido.getDomicilio().getProvincia());

            pacienteRepository.save(pacienteAActualizar);
            pacienteSalidaDto = modelMapper.map(pacienteAActualizar, PacienteSalidaDto.class);
            LOGGER.warn("Paciente actualizado: {}", JsonPrinter.toString(pacienteSalidaDto));

        } else LOGGER.error("No fue posible actualizar el paciente porque no se encuentra en nuestra base de datos");
            //lanzar exception

        return pacienteSalidaDto;
    }



    private void configureMapping(){
        modelMapper.typeMap(PacienteEntradaDto.class, Paciente.class)
                .addMappings(mapper -> mapper.map(PacienteEntradaDto::getDomicilioEntradaDto, Paciente::setDomicilio));
        modelMapper.typeMap(Paciente.class, PacienteSalidaDto.class)
                .addMappings(mapper -> mapper.map(Paciente::getDomicilio, PacienteSalidaDto::setDomicilioSalidaDto));
    }
}



