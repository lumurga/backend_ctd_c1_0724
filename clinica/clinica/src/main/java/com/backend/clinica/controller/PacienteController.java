package com.backend.clinica.controller;

import com.backend.clinica.dto.entrada.PacienteEntradaDto;
import com.backend.clinica.dto.salida.PacienteSalidaDto;
import com.backend.clinica.entity.Paciente;
import com.backend.service.IPacienteService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    private IPacienteService pacienteService;

    public PacienteController(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }


    //JSON -> @RequestBody -> DTO Entrada -> controller --> service -> mapper = entidad --> repository --> BDD
    //--> entidad --> repository --> service -> mapper -> DTO Salida --> controller -> @ResponseBody -> JSON --> cliente

    //POST
    @PostMapping("/registrar")
    public PacienteSalidaDto registrarPaciente(@RequestBody @Valid PacienteEntradaDto pacienteEntradaDto){
        return null;//pacienteService.registrarPaciente(paciente);
    }

    //GET
    @GetMapping("/listar")
    public List<PacienteSalidaDto> listarPacientes(){
        return null;
    }

    @GetMapping("/{id}")//localhost:8080/pacientes/x
    public PacienteSalidaDto buscarPacientePorId(@PathVariable Long id){
        return null;//pacienteService.buscarPacientePorId(id);
    }

    //PUT
    @PutMapping("/actualizar/{id}")
    public com.backend.entity.Paciente actualizarPaciente(@RequestBody com.backend.entity.Paciente paciente, @PathVariable Long id){
        return null;
    }

    //DELETE
    @DeleteMapping("/eliminar")//localhost:8080/pacientes/eliminar?id=x
    public void eliminarPaciente(@RequestParam Long id){

    }



}
