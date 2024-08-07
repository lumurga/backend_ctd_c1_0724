package com.backend.repository.impl;

import com.backend.dbconnection.H2Connection;
import com.backend.entity.Medicamento;
import com.backend.repository.IDao;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicamentoDaoH2 implements IDao<Medicamento> {

    private final Logger LOGGER = Logger.getLogger(MedicamentoDaoH2.class);

    @Override
    public Medicamento registrar(Medicamento medicamento) {
        LOGGER.info("Medicamento a registrar: " + medicamento);
        Medicamento medicamentoRegistrado = null;
        Connection connection = null;

        try{
          connection = H2Connection.getConnection();
          connection.setAutoCommit(false);
            String insert = "INSERT INTO MEDICAMENTOS(CODIGO, NOMBRE, LABORATORIO, CANTIDAD, PRECIO) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, medicamento.getCodigo());
            preparedStatement.setString(2, medicamento.getNombre());
            preparedStatement.setString(3, medicamento.getLaboratorio());
            preparedStatement.setInt(4, medicamento.getCantidad());
            preparedStatement.setDouble(5, medicamento.getPrecio());
            preparedStatement.execute();



            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                medicamentoRegistrado = new Medicamento(resultSet.getLong("id"), medicamento.getCodigo(), medicamento.getNombre(), medicamento.getLaboratorio(), medicamento.getCantidad(), medicamento.getPrecio());
            }

            LOGGER.info("Medicamento guardado: " + medicamentoRegistrado);
            connection.commit();

        } catch (Exception exception){
            LOGGER.error(exception.getMessage());
            exception.printStackTrace();
            if(connection != null){
                try{
                    connection.rollback();
                    LOGGER.error("Tuvimos un problema. " + exception.getMessage());
                    exception.printStackTrace();
                } catch (SQLException sqlException){
                    LOGGER.error(exception.getMessage());
                    exception.printStackTrace();
                }
            }
        }

        finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("No se pudo cerrar la conexion: " + ex.getMessage());
            }
        }

        return medicamentoRegistrado;
    }

    @Override
    public List<Medicamento> listarTodos() {
        List<Medicamento> medicamentos = new ArrayList<>();
        Connection connection = null;

        try{

            connection = H2Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM MEDICAMENTOS");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Medicamento medicamento = new Medicamento(resultSet.getLong("id"), resultSet.getInt("codigo"), resultSet.getString("nombre"), resultSet.getString("laboratorio"), resultSet.getInt("cantidad"), resultSet.getDouble("precio"));
                medicamentos.add(medicamento);
            }


        }catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();

        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Ha ocurrido un error al intentar cerrar la bdd. " + ex.getMessage());
                ex.printStackTrace();
            }
        }

        LOGGER.info("Listado de todos los medicamentos: " + medicamentos);
        return medicamentos;
    }


}
