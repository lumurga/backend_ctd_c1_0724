package com.backend.repository.impl;

import com.backend.dbconnection.H2Connection;
import com.backend.entity.Domicilio;
import com.backend.entity.Paciente;
import com.backend.repository.IDao;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;

public class PacienteDaoH2 implements IDao<Paciente> {

    private final Logger LOGGER = Logger.getLogger(PacienteDaoH2.class);

    private DomicilioDaoH2 domicilioDaoH2;


    @Override
    public Paciente registrar(Paciente paciente) {
        Paciente pacienteRegistrado = null;
        Connection connection = null;
        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            domicilioDaoH2 = new DomicilioDaoH2();
            Domicilio domicilioRegistrado = domicilioDaoH2.registrar(paciente.getDomicilio());

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PACIENTES (NOMBRE, APELLIDO, DNI, FECHA, DOMICILIO_ID) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, paciente.getNombre());
            preparedStatement.setString(2, paciente.getApellido());
            preparedStatement.setInt(3, paciente.getDni());
            preparedStatement.setDate(4, Date.valueOf(paciente.getFechaIngreso()));
            preparedStatement.setLong(5, domicilioRegistrado.getId());
            preparedStatement.execute();

            pacienteRegistrado = new Paciente(paciente.getNombre(), paciente.getApellido(), paciente.getDni(), paciente.getFechaIngreso(), domicilioRegistrado);

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while(resultSet.next()) {
                pacienteRegistrado.setId(resultSet.getLong("id"));
            }

            connection.commit();
            LOGGER.info("Se ha registrado el paciente: " + pacienteRegistrado);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                    LOGGER.info("Tuvimos un problema");
                    LOGGER.error(e.getMessage());
                    e.printStackTrace();
                } catch (SQLException exception) {
                    LOGGER.error(exception.getMessage());
                    exception.printStackTrace();
                }
            }
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("No se pudo cerrar la conexion: " + ex.getMessage());
            }
        }



        return pacienteRegistrado;
    }

    @Override
    public Paciente buscarPorId(Long id) {
        Paciente pacienteBuscado = null;
        Connection connection = null;
        try {
            connection = H2Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PACIENTES WHERE ID = ?");
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                pacienteBuscado = crearObjetoPaciente(resultSet);
            }


        }  catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Ha ocurrido un error al intentar cerrar la bdd. " + ex.getMessage());
                ex.printStackTrace();
            }
        }


        if(pacienteBuscado == null) LOGGER.error("No se ha encontrado el paciente con id: " + id);
        else LOGGER.info("Se ha encontrado el paciente: " + pacienteBuscado);

        return pacienteBuscado;
    }

    @Override
    public List<Paciente> listarTodos() {
        return null;
    }

    private Paciente crearObjetoPaciente(ResultSet resultSet) throws SQLException {

        Domicilio domicilio = new DomicilioDaoH2().buscarPorId(resultSet.getLong("domicilio_id"));

        return new Paciente(resultSet.getLong("id"), resultSet.getString("nombre"), resultSet.getString("apellido"), resultSet.getInt("dni"), resultSet.getDate("fecha").toLocalDate(), domicilio);

    }

}
