package com.backend.service;

import com.backend.entity.Medicamento;

import java.util.List;

public interface IMedicamentoService {

    Medicamento registrarMedicamento(Medicamento medicamento);
    List<Medicamento> listarMedicamentos();
}
