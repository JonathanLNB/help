package com.example.tarea1.dao;

import com.example.tarea1.TipoFreno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TipoFrenoDao extends MySQLConnection implements Dao<TipoFreno> {
    Connection connection = getConnection();

    @Override
    public Optional<TipoFreno> findById(int id) {
        TipoFreno tipoFreno = null;
        String sql = "SELECT * FROM tipoFreno where idTipoFreno=" + id;

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                tipoFreno = new TipoFreno(resultSet.getInt("idTipoFreno"), resultSet.getString("tipoFreno"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return Optional.ofNullable(tipoFreno);
    }

    @Override
    public List<TipoFreno> findAll() {
        List<TipoFreno> tipoFrenos = new ArrayList<>();
        String sql = "SELECT * FROM tipoFreno";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                tipoFrenos.add(new TipoFreno(resultSet.getInt("idTipoFreno"), resultSet.getString("tipoFreno")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return tipoFrenos;
    }

    @Override
    public boolean save(TipoFreno record) {
        String sql = "INSERT INTO tipoFreno(tipoFreno) values(?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, record.getTipoFreno());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminar información...");
        }
        return false;
    }

    @Override
    public boolean update(TipoFreno record) {
        String sql = "UPDATE tipoFreno SET tipoFreno=? where idTipoFreno=?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, record.getTipoFreno());
            statement.setInt(2, record.getIdTipoFreno());
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
        String sql = "DELETE FROM tipoFreno where idTipoFreno=" + id;

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
