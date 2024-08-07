package com.backend.service.impl;

import com.backend.entity.Medicamento;
import com.backend.repository.IDao;
import com.backend.service.IMedicamentoService;

import java.util.List;

public class MedicamentoService implements IMedicamentoService {

    //capa de logica de negocio que interactua con la capa de persistencia, pero desconoce los detalles de la implementacion de esa persistencia
    private IDao<Medicamento> medicamentoIDao;

    public MedicamentoService(IDao<Medicamento> medicamentoIDao) {
        this.medicamentoIDao = medicamentoIDao;
    }

    @Override
    public Medicamento registrarMedicamento(Medicamento medicamento) {
        //alguna logica de negocio
        return medicamentoIDao.registrar(medicamento);
    }

    @Override
    public List<Medicamento> listarMedicamentos() {
        return medicamentoIDao.listarTodos();
    }
}
