package com.example.tarea1.dao;

import com.example.tarea1.Marca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MarcaDao extends MySQLConnection implements Dao<Marca>{
    Connection connection=getConnection();

    @Override
    public Optional<Marca> findById(int id) {
        Marca marca=null;
        String sql = "SELECT * FROM marca where idMarca="+id;

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                marca=new Marca(resultSet.getInt("idMarca"),resultSet.getString("nombreMarca"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return Optional.ofNullable(marca);
    }

    @Override
    public List<Marca> findAll() {
        List<Marca> marcas = new ArrayList<>();
        String sql = "SELECT * FROM marca";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                marcas.add(new Marca(resultSet.getInt("idMarca"),resultSet.getString("nombreMarca")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return marcas;
    }

    @Override
    public boolean save(Marca record) {
        String sql = "INSERT INTO marca(nombreMarca) values(?)";

        try {PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,record.getNombre());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminar información...");
        }
        return false;
    }

    @Override
    public boolean update(Marca record) {
        String sql = "UPDATE marca SET nombreMarca=? where idMarca=?";

        try {PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,record.getNombre());
            statement.setInt(2,record.getId());
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
        String sql = "DELETE FROM marca where idMarca="+id;

        try {PreparedStatement statement = connection.prepareStatement(sql);
             statement.execute();
             return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminar información...");
        }
        return false;
    }
}
