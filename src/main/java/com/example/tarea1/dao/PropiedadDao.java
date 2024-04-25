package com.example.tarea1.dao;
import com.example.tarea1.Propiedad;
import com.example.tarea1.Cliente;
import com.example.tarea1.Automovil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class PropiedadDao extends MySQLConnection implements Dao<Propiedad>{
    Connection connection=getConnection();

    @Override
    public Optional<Propiedad> findById(int id) {
        Propiedad propiedad=null;
        String sql = "SELECT idPropiedad,a.idCliente,b.nombres,c.apellidoPaterno,d.apellidoMaterno,"+
                "e.idAuto,f.idMarca,g.idTransmision,h.idTipoFreno,i.modelo,j.color,k.motor,l.peso,m.numPuertas," +
                "n.numPersonas,o.velocidades,p.idAccesorios,q.foto,numSerie FROM cliente a,b,c,d join autos where idPropiedad="+id;

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                propiedad=new Propiedad();
                propiedad.setIdPropiedad(resultSet.getInt("idPropiedad"));
                propiedad.setIdPropiedad(new Cliente(resultSet.getInt("idCliente"),resultSet.getString("nombres"),resultSet.getString("apellidoPaterno"),resultSet.getString("apellidoMaterno")).getId());
                propiedad.setIdPropiedad(new Automovil(resultSet.getInt("idAuto"),resultSet.getInt("idMarca"),resultSet.getInt("idTransmision"),resultSet.getInt("idTipoFreno"),
                        resultSet.getString("modelo"),resultSet.getString("color"),resultSet.getString("motor"),resultSet.getDouble("modelo"),resultSet.getInt("numPuertas"),
                        resultSet.getInt("numPersonas"),resultSet.getInt("velocidades"),resultSet.getInt("idAccesorios"),resultSet.getString("foto")));
                propiedad.setIdPropiedad(resultSet.getInt("idPropiedad"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return Optional.ofNullable(propiedad);
    }

    @Override
    public List<Propiedad> findAll() {
        List<Propiedad> propiedades = new ArrayList<>();
        String sql = "SELECT * FROM propiedad";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                propiedades.add(new Propiedad(resultSet.getInt("idCliente"),resultSet.getString("nombres"),resultSet.getString("apellidoPaterno"),resultSet.getString("apellidoMaterno")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return propiedades;
    }

    @Override
    public boolean save(Propiedad record) {
        String sql = "INSERT INTO propiedad(nombres,apellidoPaterno,apellidoMaterno) values(?)";

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
        String sql = "UPDATE marca SET nombres=?,apellidoPaterno=?,apellidoMaterno=? where idCliente=?";

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