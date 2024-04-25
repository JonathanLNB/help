package com.example.tarea1.dao;

import com.example.tarea1.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PropiedadDao extends MySQLConnection implements Dao<Propiedad> {
    Connection connection = getConnection();

    @Override
    public Optional<Propiedad> findById(int id) {
        Propiedad propiedad = null;
        String sql = "SELECT idPropiedad, p.idCliente, c.nombres, c.apellidoPaterno, c.apellidoMaterno," +
                "a.idAuto, m.idMarca, m.marca t.idTransmision, t.transmision, f.idTipoFreno, f.tipoFreno, a.modelo, a.color, a.motor, a.peso, a.numPuertas," +
                "a.numPersonas, a.velocidades, ac.idAccesorios, a.foto, p.numSerie FROM propiedad p join cliente c on p.idCliente = c.idCliente join auto a on p.idAuto=a.idAuto join Accesorio ac on a.idAccesorio = ac.idAccesorio join Marca m on m.idMarca = a.idMarca join Transmision t on t.idTransmision = a.idTransmision join TipoFreno f on f.idTipoFreno = a.idTipoFreno where p.idPropiedad=" + id;

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                propiedad = new Propiedad();
                propiedad.setIdPropiedad(resultSet.getInt("idPropiedad"));
                propiedad.setCliente(new Cliente(resultSet.getInt("idCliente"), resultSet.getString("nombres"), resultSet.getString("apellidoPaterno"), resultSet.getString("apellidoMaterno")));
                propiedad.setAutomovil(new Automovil(resultSet.getInt("idAuto"), new Marca(resultSet.getInt("idMarca"), resultSet.getString("marca")), resultSet.getString("modelo"), resultSet.getString("color"), resultSet.getDouble("peso"), new Transmision(resultSet.getInt("idTransmision"), resultSet.getString("transmision")), resultSet.getString("numPuertas"),
                        resultSet.getString("numPersonas"), resultSet.getString("motor"), new TipoFreno(resultSet.getInt("idTipoFreno"), resultSet.getString("tipoFreno")),
                        resultSet.getString("velocidades"), new Accesorio(resultSet.getInt("idAccesorio"), resultSet.getString("accesorio")), resultSet.getString("foto")));
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
        String sql = "SELECT idPropiedad, p.idCliente, c.nombres, c.apellidoPaterno, c.apellidoMaterno," +
                "a.idAuto, m.idMarca, m.marca t.idTransmision, t.transmision, f.idTipoFreno, f.tipoFreno, a.modelo, a.color, a.motor, a.peso, a.numPuertas," +
                "a.numPersonas, a.velocidades, ac.idAccesorios, a.foto, p.numSerie FROM propiedad p join cliente c on p.idCliente = c.idCliente join auto a on p.idAuto=a.idAuto join Accesorio ac on a.idAccesorio = ac.idAccesorio join Marca m on m.idMarca = a.idMarca join Transmision t on t.idTransmision = a.idTransmision join TipoFreno f on f.idTipoFreno = a.idTipoFreno";
        Propiedad propiedad = null;
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                propiedad = new Propiedad();
                propiedad.setIdPropiedad(resultSet.getInt("idPropiedad"));
                propiedad.setCliente(new Cliente(resultSet.getInt("idCliente"), resultSet.getString("nombres"), resultSet.getString("apellidoPaterno"), resultSet.getString("apellidoMaterno")));
                propiedad.setAutomovil(new Automovil(resultSet.getInt("idAuto"), new Marca(resultSet.getInt("idMarca"), resultSet.getString("marca")), resultSet.getString("modelo"), resultSet.getString("color"), resultSet.getDouble("peso"), new Transmision(resultSet.getInt("idTransmision"), resultSet.getString("transmision")), resultSet.getString("numPuertas"),
                        resultSet.getString("numPersonas"), resultSet.getString("motor"), new TipoFreno(resultSet.getInt("idTipoFreno"), resultSet.getString("tipoFreno")),
                        resultSet.getString("velocidades"), new Accesorio(resultSet.getInt("idAccesorio"), resultSet.getString("accesorio")), resultSet.getString("foto")));
                propiedades.add(propiedad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return propiedades;
    }

    @Override
    public boolean save(Propiedad record) {
        String sql = "INSERT INTO propiedad(idCliente, idAuto, numSerie) values(?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, record.getCliente().getIdCliente());
            statement.setInt(2, record.getAutomovil().getIdAuto());
            statement.setString(3, record.getNumSerie());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminar información...");
        }
        return false;
    }

    @Override
    public boolean update(Propiedad record) {
        String sql = "UPDATE marca SET numSerie=?, idAuto=?, idCliente=? where idPropiedad=?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, record.getNumSerie());
            statement.setInt(2, record.getAutomovil().getIdAuto());
            statement.setInt(3, record.getCliente().getIdCliente());
            statement.setInt(4, record.getIdPropiedad());
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
        String sql = "DELETE FROM propiedad where idPropiedad=" + id;

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