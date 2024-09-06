package com.backend.clinica.service.impl;

import com.backend.clinica.dto.entrada.DomicilioEntradaDto;
import com.backend.clinica.dto.entrada.PacienteEntradaDto;
import com.backend.clinica.dto.salida.PacienteSalidaDto;
import com.backend.clinica.entity.Domicilio;
import com.backend.clinica.entity.Paciente;
import com.backend.clinica.exceptions.ResourceNotFoundException;
import com.backend.clinica.repository.PacienteRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class PacienteServiceTest {

    //@Mock
    //private PacienteRepository pacienteRepository;
    //@InjectMocks
    //private PacienteService pacienteService;

    private final PacienteRepository pacienteRepositoryMock = mock(PacienteRepository.class);
    private final ModelMapper modelMapper = new ModelMapper();

    private final PacienteService pacienteService = new PacienteService(pacienteRepositoryMock, modelMapper);

    private static PacienteEntradaDto pacienteEntradaDto;
    private static Paciente paciente;

    @BeforeAll
    static void setUp(){

        // Inicializa el objeto común antes de cada prueba
        paciente = new Paciente(1L, "Juan", "Perez", 123456, LocalDate.of(2024, 6, 22),
                new Domicilio(1L, "Calle", 123, "Localidad", "Provincia"));

        pacienteEntradaDto = new PacienteEntradaDto("Juan", "Perez", 123456, LocalDate.of(2024, 6, 22), new DomicilioEntradaDto("Calle", 123, "Localidad", "Provincia"));
    }

    @Test
    void deberiaMandarAlRepositorioUnPacienteDeNombreJuan_yRetornarUnSalidaDtoConSuId(){
        when(pacienteRepositoryMock.save(any(Paciente.class))).thenReturn(paciente);

        PacienteSalidaDto pacienteSalidaDto = pacienteService.registrarPaciente(pacienteEntradaDto);

        assertNotNull(pacienteSalidaDto);
        assertNotNull(pacienteSalidaDto.getId());
        assertEquals("Juan", pacienteSalidaDto.getNombre());
        verify(pacienteRepositoryMock, times(1)).save(any(Paciente.class));
    }

    @Test
    void deberiaDevolverUnListadoNoVacioDePacientes(){
        List<Paciente> pacientes = new java.util.ArrayList<>(List.of(paciente));
        when(pacienteRepositoryMock.findAll()).thenReturn(pacientes);

        List<PacienteSalidaDto> listadoDePacientes = pacienteService.listarPacientes();
        assertFalse(listadoDePacientes.isEmpty());

    }

    @Test
    void deberiaEliminarElPacienteConId1(){
        when(pacienteRepositoryMock.findById(1L)).thenReturn(Optional.of(paciente));
        doNothing().when(pacienteRepositoryMock).deleteById(1L);

        assertDoesNotThrow(() -> pacienteService.eliminarPaciente(1L));

        verify(pacienteRepositoryMock, times(1)).deleteById(1L);

    }

    @Test
    void deberiaEliminarElPacienteConId2(){
        paciente.setId(2L);
        when(pacienteRepositoryMock.findById(2L)).thenReturn(Optional.of(paciente));
        doNothing().when(pacienteRepositoryMock).deleteById(2L);

        try{
            pacienteService.eliminarPaciente(2L);
        } catch (ResourceNotFoundException resourceNotFoundException){
            fail("No debería lanzarse la excepción");
        }
        verify(pacienteRepositoryMock, times(1)).deleteById(2L);
    }


    @Test
    void deberiaDevolverUnaListaVaciaDePacientes(){
        when(pacienteRepositoryMock.findAll()).thenReturn(new ArrayList<>());

        List<PacienteSalidaDto> pacientes = pacienteService.listarPacientes();
        assertTrue(pacientes.isEmpty());
        verify(pacienteRepositoryMock, times(1)).findAll();
    }


    @Test
    void deberiaLanzarExcepcionCuandoElPacienteAActualizarNoSeaEncontrado(){
        when(pacienteRepositoryMock.findById(2L)).thenReturn(Optional.empty());

        pacienteEntradaDto.setDni(66666666);

        assertThrows(ResourceNotFoundException.class, () -> pacienteService.actualizarPaciente(pacienteEntradaDto, 2L));

    }



}