package com.backend.repository.impl;

import com.backend.entity.Medicamento;
import com.backend.repository.IDao;

import java.util.List;

public class MedicamentoDaoEnMemoria implements IDao<Medicamento> {

    @Override
    public Medicamento registrar(Medicamento medicamento) {
        return null;
    }

    @Override
    public List<Medicamento> listarTodos() {
        return null;
    }
}
