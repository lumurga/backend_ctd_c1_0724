package com.backend;

import org.apache.log4j.Logger;

import java.sql.*;

public class Animal {

    private static final Logger LOGGER = Logger.getLogger(Animal.class);


    public static void main(String[] args) {


        Connection connection = null;

        try{
            connection = getConnection();
            String create = "DROP TABLE IF EXISTS ANIMALES; CREATE TABLE ANIMALES(ID INT AUTO_INCREMENT PRIMARY KEY, NOMBRE VARCHAR(20) NOT NULL, TIPO VARCHAR(20) NOT NULL)";
            //crear la tabla
            Statement statement = connection.createStatement();
            statement.execute(create);


            String insert = "INSERT INTO ANIMALES(NOMBRE, TIPO) VALUES ('Firulais', 'Perro'), ('Lola', 'Vaca'), ('Homero', 'Perro'), ('Pepe', 'Sapo'), ('Tuki', 'Loro')";
            //insertar los registros
            statement.execute(insert);

            //select all
            String select = "SELECT * FROM ANIMALES";
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()){
                LOGGER.info("Animal: " + resultSet.getInt(1) + " - " + resultSet.getString(2) + " - " + resultSet.getString("tipo"));
            }

            LOGGER.info("--------------------------------------------------------------------");

            //eliminar un registro
            statement.execute("DELETE FROM ANIMALES WHERE ID = 2");


            resultSet = statement.executeQuery(select);
            while (resultSet.next()){
                LOGGER.info("Animal: " + resultSet.getInt(1) + " - " + resultSet.getString(2) + " - " + resultSet.getString("tipo"));
            }




        } catch(Exception exception){
            exception.printStackTrace();
            LOGGER.error(exception.getClass() + ": " + exception.getMessage());
        }

        finally {
            try{
                connection.close();
            } catch(Exception exception){
                LOGGER.error(exception.getMessage());
            }
        }


    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        //indicar que driver vamos a usar para conectarnos
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/clase8c1-07", "us", "us");

    }


}
