package com.example.tarea1.dao;

import com.example.tarea1.Accesorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class AccesorioDao extends MySQLConnection implements Dao<Accesorio>{
    Connection connection=getConnection();

        @Override
        public Optional<Accesorio> findById(int id) {
            Accesorio accesorio=null;
            String sql = "SELECT * FROM accesorio where idAccesorio="+id;

            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    accesorio=new Accesorio(resultSet.getInt("idAccesorio"),resultSet.getString("accesorio"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error al recuperar información...");
            }
            return Optional.ofNullable(accesorio);
        }

        @Override
        public List<Accesorio> findAll() {
            List<Accesorio> accesorios = new ArrayList<>();
            String sql = "SELECT * FROM accesorio";

            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    accesorios.add(new Accesorio(resultSet.getInt("idAccesorio"),resultSet.getString("accesorio")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error al recuperar información...");
            }
            return accesorios;
        }

        @Override
        public boolean save(Accesorio record) {
            String sql = "INSERT INTO accesorio(accesorio) values(?)";

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
        public boolean update(Accesorio record) {
            String sql = "UPDATE accesorio SET accesorio=? where idAccesorio=?";

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
            String sql = "DELETE FROM accesorio where idAccesorio="+id;

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