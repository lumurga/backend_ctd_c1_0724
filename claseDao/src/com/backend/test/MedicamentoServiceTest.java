package com.backend.test;

import com.backend.entity.Medicamento;
import com.backend.repository.impl.MedicamentoDaoH2;
import com.backend.service.impl.MedicamentoService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedicamentoServiceTest {
    private MedicamentoService medicamentoService;

    @Test
    void deberiaRegistrarUnMedicamentoEnH2YRetornarSuId(){
        medicamentoService = new MedicamentoService(new MedicamentoDaoH2());
        Medicamento medicamentoARegistrar = new Medicamento(1236, "Aspirina", "Bayer", 50, 5000.);

        Medicamento medicamentoPersistido = medicamentoService.registrarMedicamento(medicamentoARegistrar);

        assertNotNull(medicamentoPersistido.getId());

    }



}