package com.example.tarea1.dao;

import com.example.tarea1.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class ClienteDao extends MySQLConnection implements Dao<Cliente>{
    Connection connection=getConnection();

    @Override
    public Optional<Cliente> findById(int id) {
        Cliente cliente=null;
        String sql = "SELECT * FROM cliente where idCliente="+id;

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                cliente=new Cliente(resultSet.getInt("idCliente"),resultSet.getString("nombres"),resultSet.getString("apellidoPaterno"),resultSet.getString("apellidoMaterno"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return Optional.ofNullable(cliente);
    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                clientes.add(new Cliente(resultSet.getInt("idCliente"),resultSet.getString("nombres"),resultSet.getString("apellidoPaterno"),resultSet.getString("apellidoMaterno")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return clientes;
    }

    @Override
    public boolean save(Cliente record) {
        String sql = "INSERT INTO cliente(nombres,apellidoPaterno,apellidoMaterno) values(?)";

        try {PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,record.getNombres());
            statement.setString(2,record.getAPaterno());
            statement.setString(3,record.getAMaterno());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminar información...");
        }
        return false;
    }

    @Override
    public boolean update(Cliente record) {
        String sql = "UPDATE cliente SET nombres=?,apellidoPaterno=?,apellidoMaterno=? where idCliente=?";

        try {PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,record.getNombres());
            statement.setString(2,record.getAPaterno());
            statement.setString(3,record.getAMaterno());
            statement.setInt(4,record.getId());
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
        String sql = "DELETE FROM cliente where idCliente="+id;

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