package com.backend.clinica.repository;

import com.backend.clinica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    //@Query("SELECT p FROM Paciente p WHERE p.dni = ?1") //HQL
    //@Query(value = "SELECT * FROM PACIENTES WHERE DNI = ?1", nativeQuery = true) //SQL
    //Paciente buscarPacientePorDni(int dni);

    //Paciente findByDni(int dni);
    //Paciente findByDniAndNombre(int dni, String nombre);



}
