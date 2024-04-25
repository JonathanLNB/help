package com.example.tarea1.dao;


import com.example.tarea1.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AutomovilDao extends MySQLConnection implements Dao<Automovil> {
    Connection connection = getConnection();

    @Override
    public Optional<Automovil> findById(int id) {
        Automovil automovil = null;
        String sql = "SELECT idAuto, a.idMarca, m.nombreMarca, modelo," + " color, peso, tipoTrans, numPuertas, numPersonas, motor," + " tipoFreno, velocidades, accesorio, foto FROM marca m join autos a on m.idMarca = a.idMarca where idAuto=" + id;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                automovil = new Automovil(resultSet.getInt("idAuto"), new Marca(resultSet.getInt("idMarca"), resultSet.getString("nombreMarca")), resultSet.getString("modelo"), resultSet.getString("color"), resultSet.getDouble("peso"), new Transmision(resultSet.getInt("idTransmision"), resultSet.getString("transmision")), resultSet.getString("numPuertas"), resultSet.getString("numPersonas"), resultSet.getString("motor"), new TipoFreno(resultSet.getInt("idTipoFreno"), resultSet.getString("tipoFreno")), resultSet.getString("velocidades"), new Accesorio(resultSet.getInt("idAccesorio"), resultSet.getString("accesorio")), resultSet.getString("foto"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return Optional.ofNullable(automovil);
    }

    public List<Automovil> findAll() {
        List<Automovil> automoviles = new ArrayList<>();
        String sql = "SELECT idAuto, a.idMarca, m.nombreMarca, modelo," + " color, peso, t.idTransmision, numPuertas, numPersonas, motor," + " f.idTipoFreno, velocidades, c.idAccesorio, foto FROM marca m, join autos a on m.idMarca = a.idMarca;";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Automovil automovil;
            while (resultSet.next()) {
                automovil = new Automovil(resultSet.getInt("idAuto"), new Marca(resultSet.getInt("idMarca"), resultSet.getString("nombreMarca")), resultSet.getString("modelo"), resultSet.getString("color"), resultSet.getDouble("peso"), new Transmision(resultSet.getInt("idTransmision"), resultSet.getString("transmision")), resultSet.getString("numPuertas"), resultSet.getString("numPersonas"), resultSet.getString("motor"), new TipoFreno(resultSet.getInt("idTipoFreno"), resultSet.getString("tipoFreno")), resultSet.getString("velocidades"), new Accesorio(resultSet.getInt("idAccesorio"), resultSet.getString("accesorio")), resultSet.getString("foto"));
                automoviles.add(automovil);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return automoviles;
    }

    @Override
    public boolean save(Automovil record) {
        String sql = "INSERT INTO autos(idMarca, modelo," + "color, peso, tipoTrans, numPuertas, numPasajeros, motor," + "tipoFrenos, velocidades, accesorios, fotografia) values(?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, record.getMarca().getId());
            statement.setString(2, record.getModelo());
            statement.setString(3, record.getColor());
            statement.setDouble(4, record.getPeso());
            statement.setInt(5, record.getTipoTrans().getId());
            statement.setString(6, record.getNumPuertas());
            statement.setString(7, record.getNumPersonas());
            statement.setString(8, record.getMotor());
            statement.setInt(9, record.getTipoFrenos().getIdFreno());
            statement.setString(10, record.getVelocidades());
            statement.setInt(11, record.getAccesorios().getId());
            statement.setString(12, record.getFotografia());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al salvar información...");
        }
        return false;
    }

    @Override
    public boolean update(Automovil record) {
        String sql = "UPDATE autos SET idMarca=?, modelo=?," + "color=?, peso=?, tipoTrans=?, numPuertas=?, numPasajeros=?, motor=?," + "tipoFrenos=?, velocidades=?, accesorios=?, fotografia=? where idAuto=?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, record.getMarca().getId());
            statement.setString(2, record.getModelo());
            statement.setString(3, record.getColor());
            statement.setDouble(4, record.getPeso());
            statement.setInt(5, record.getTransmision().getId());
            statement.setString(6, record.getNumPuertas());
            statement.setString(7, record.getNumPersonas());
            statement.setString(8, record.getMotor());
            statement.setInt(9, record.getTipoFrenos().getIdFreno());
            statement.setString(10, record.getVelocidades());
            statement.setInt(11, record.getAccesorios().getId());
            statement.setString(12, record.getFotografia());
            statement.setInt(13, record.getIdAuto());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al actualizar información...");
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM autos where idAuto=" + id;

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

    public List<Automovil> findByBrand(Marca marca) {
        List<Automovil> automoviles = new ArrayList<>();
        String sql = "SELECT idAuto, a.idMarca, m.nombreMarca, modelo," + " color, peso, tipoTrans, numPuertas, numPasajeros, motor," + " tipoFrenos, velocidades, accesorios, fotografia FROM marca m join autos a on m.idMarca = a.idMarca where m.idMarca=" + marca.getId();
        Automovil automovil;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                automovil = new Automovil(resultSet.getInt("idAuto"), new Marca(resultSet.getInt("idMarca"), resultSet.getString("nombreMarca")), resultSet.getString("modelo"), resultSet.getString("color"), resultSet.getDouble("peso"), new Transmision(resultSet.getInt("idTransmision"), resultSet.getString("transmision")), resultSet.getString("numPuertas"), resultSet.getString("numPersonas"), resultSet.getString("motor"), new TipoFreno(resultSet.getInt("idTipoFreno"), resultSet.getString("tipoFreno")), resultSet.getString("velocidades"), new Accesorio(resultSet.getInt("idAccesorio"), resultSet.getString("accesorio")), resultSet.getString("foto"));
                automoviles.add(automovil);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return automoviles;
    }
}
