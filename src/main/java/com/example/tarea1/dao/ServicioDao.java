package com.example.tarea1.dao;

import com.example.tarea1.Servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServicioDao extends MySQLConnection implements Dao<Servicio> {
    Connection connection = getConnection();
    @Override
    public Optional<Servicio> findById(int id) {
        Servicio servicio = null;
        String sql = "SELECT * FROM servicio where idServicio=" + id;

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                servicio = new Servicio(resultSet.getInt("idServicio"), resultSet.getString("servicio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return Optional.ofNullable(servicio);
    }

    @Override
    public List<Servicio> findAll() {
        List<Servicio> servicios = new ArrayList<>();
        String sql = "SELECT * FROM servicio";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                servicios.add(new Servicio(resultSet.getInt("idServicio"), resultSet.getString("servicio")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return servicios;
    }

    @Override
    public boolean save(Servicio record) {
        String sql = "INSERT INTO servicio(servicio) values(?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, record.getServicio());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminar información...");
        }
        return false;
    }

    @Override
    public boolean update(Servicio record) {
        String sql = "UPDATE servicio SET servicio=? where idServicio=?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, record.getServicio());
            statement.setInt(2, record.getIdServicio());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminar información...");
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM servicio where idServicio=" + id;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminar información...");
        }
        return false;
    }
}
