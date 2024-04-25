package com.example.tarea1.dao;

import com.example.tarea1.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ServicioAutoDao extends MySQLConnection implements Dao<ServicioAuto> {
    Connection connection = getConnection();

    @Override
    public Optional<ServicioAuto> findById(int id) {
        ServicioAuto servicioAuto = null;
        Propiedad propiedad = null;
        String sql = "SELECT sa.idServicioAuto, sa.fechaServicio s.idServicio, s.servicio, p.idPropiedad, p.idCliente, c.nombres, c.apellidoPaterno, c.apellidoMaterno," +
                "a.idAuto, m.idMarca, m.marca t.idTransmision, t.transmision, f.idTipoFreno, f.tipoFreno, a.modelo, a.color, a.motor, a.peso, a.numPuertas," +
                "a.numPersonas, a.velocidades, ac.idAccesorios, a.foto, p.numSerie FROM servicioAuto sa join propiedad p on sa.idPropiedad = p.idPropiedad join servicio s on sa.idServicio = s.idServicio join cliente c on p.idCliente = c.idCliente join auto a on p.idAuto=a.idAuto join Accesorio ac on a.idAccesorio = ac.idAccesorio join Marca m on m.idMarca = a.idMarca join Transmision t on t.idTransmision = a.idTransmision join TipoFreno f on f.idTipoFreno = a.idTipoFreno where idServicioAuto=" + id;

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                propiedad = new Propiedad();
                propiedad.setIdPropiedad(resultSet.getInt("idPropiedad"));
                propiedad.setCliente(new Cliente(resultSet.getInt("idCliente"), resultSet.getString("nombres"), resultSet.getString("apellidoPaterno"), resultSet.getString("apellidoMaterno")));
                propiedad.setAutomovil(new Automovil(resultSet.getInt("idAuto"), new Marca(resultSet.getInt("idMarca"), resultSet.getString("marca")), resultSet.getString("modelo"), resultSet.getString("color"), resultSet.getDouble("peso"), new Transmision(resultSet.getInt("idTransmision"), resultSet.getString("transmision")), resultSet.getString("numPuertas"),
                        resultSet.getString("numPersonas"), resultSet.getString("motor"), new TipoFreno(resultSet.getInt("idTipoFreno"), resultSet.getString("tipoFreno")),
                        resultSet.getString("velocidades"), new Accesorio(resultSet.getInt("idAccesorio"), resultSet.getString("accesorio")), resultSet.getString("foto")));
                servicioAuto = new ServicioAuto(resultSet.getInt("idServicioAuto"), new Servicio(resultSet.getInt("idServicio"), resultSet.getString("servicio")), propiedad, resultSet.getDate("fechaServicio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return Optional.ofNullable(servicioAuto);
    }

    @Override
    public List<ServicioAuto> findAll() {
        List<ServicioAuto> servicioAutos = new ArrayList<>();
        Propiedad propiedad = null;
        String sql = "SELECT sa.idServicioAuto, sa.fechaServicio s.idServicio, s.servicio, p.idPropiedad, p.idCliente, c.nombres, c.apellidoPaterno, c.apellidoMaterno," +
                "a.idAuto, m.idMarca, m.marca t.idTransmision, t.transmision, f.idTipoFreno, f.tipoFreno, a.modelo, a.color, a.motor, a.peso, a.numPuertas," +
                "a.numPersonas, a.velocidades, ac.idAccesorios, a.foto, p.numSerie FROM servicioAuto sa join propiedad p on sa.idPropiedad = p.idPropiedad join servicio s on sa.idServicio = s.idServicio join cliente c on p.idCliente = c.idCliente join auto a on p.idAuto=a.idAuto join Accesorio ac on a.idAccesorio = ac.idAccesorio join Marca m on m.idMarca = a.idMarca join Transmision t on t.idTransmision = a.idTransmision join TipoFreno f on f.idTipoFreno = a.idTipoFreno";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                propiedad = new Propiedad();
                propiedad.setIdPropiedad(resultSet.getInt("idPropiedad"));
                propiedad.setCliente(new Cliente(resultSet.getInt("idCliente"), resultSet.getString("nombres"), resultSet.getString("apellidoPaterno"), resultSet.getString("apellidoMaterno")));
                propiedad.setAutomovil(new Automovil(resultSet.getInt("idAuto"), new Marca(resultSet.getInt("idMarca"), resultSet.getString("marca")), resultSet.getString("modelo"), resultSet.getString("color"), resultSet.getDouble("peso"), new Transmision(resultSet.getInt("idTransmision"), resultSet.getString("transmision")), resultSet.getString("numPuertas"),
                        resultSet.getString("numPersonas"), resultSet.getString("motor"), new TipoFreno(resultSet.getInt("idTipoFreno"), resultSet.getString("tipoFreno")),
                        resultSet.getString("velocidades"), new Accesorio(resultSet.getInt("idAccesorio"), resultSet.getString("accesorio")), resultSet.getString("foto")));

                servicioAutos.add(new ServicioAuto(resultSet.getInt("idServicioAuto"), new Servicio(resultSet.getInt("idServicio"), resultSet.getString("servicio")), propiedad, resultSet.getDate("fechaServicio")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return servicioAutos;
    }

    @Override
    public boolean save(ServicioAuto record) {
        String sql = "INSERT INTO servicioAuto(idPropiedad, idServicio, fechaServicio) values(?, ?, NOW())";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, record.getServicio().getIdServicio());
            statement.setInt(2, record.getPropiedad().getIdPropiedad());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminar información...");
        }
        return false;
    }

    @Override
    public boolean update(ServicioAuto record) {
        String sql = "UPDATE servicioAuto SET idServicio=?, idPropiedad=?, fechaServicio=NOW(), where idServicioAuto=?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, record.getServicio().getIdServicio());
            statement.setInt(2, record.getPropiedad().getIdPropiedad());
            statement.setInt(3, record.getIdServicioAuto());
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
        String sql = "DELETE FROM servicioAuto where idServicioAuto=" + id;

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