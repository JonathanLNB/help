package com.example.tarea1.dao;

import com.example.tarea1.Transmision;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TransmisionDao extends MySQLConnection implements Dao<Transmision> {
    Connection connection = getConnection();

    @Override
    public Optional<Transmision> findById(int id) {
        Transmision transmision = null;
        String sql = "SELECT * FROM transmision where idTransmision=" + id;

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                transmision = new Transmision(resultSet.getInt("idTransmision"), resultSet.getString("transmision"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return Optional.ofNullable(transmision);
    }

    @Override
    public List<Transmision> findAll() {
        List<Transmision> transmisions = new ArrayList<>();
        String sql = "SELECT * FROM transmision";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                transmisions.add(new Transmision(resultSet.getInt("idTransmision"), resultSet.getString("transmision")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return transmisions;
    }

    @Override
    public boolean save(Transmision record) {
        String sql = "INSERT INTO transmision(transmision) values(?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, record.getTransmision());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminar información...");
        }
        return false;
    }

    @Override
    public boolean update(Transmision record) {
        String sql = "UPDATE transmision SET transmision=? where idTransmision=?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, record.getTransmision());
            statement.setInt(2, record.getIdTransmision());
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
        String sql = "DELETE FROM transmision where idTransmision=" + id;

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
