package realEstate.persistence.repository;

import realEstate.domain.Buyer;
import realEstate.persistence.mapper.BuyerRowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BuyerRepositoryDB {
    private final Connection connection;
    private final BuyerRowMapper rowMapper = new BuyerRowMapper();

    public BuyerRepositoryDB(Connection connection) {
        this.connection = connection;
    }

    public Buyer agregar(Buyer b) {
        String sqlUser = "INSERT INTO superUser (nombre, apellido, telefono, correo, contraseña, status, rol) VALUES (?, ?, ?, ?, ?, ?, 'BUYER')";
        try (PreparedStatement ps = connection.prepareStatement(sqlUser, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, b.getNombre());
            ps.setString(2, b.getApellido());
            ps.setString(2, b.getTelefono());
            ps.setString(3, b.getCorreo());
            ps.setString(4, b.getPassword());
            ps.setBoolean(5, b.isStatus());
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) b.setId(keys.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException("Error al insertar usuario buyer: " + e.getMessage());
        }

        String sqlBuyer = "INSERT INTO buyer (id, propiedadDeInteresActual, balance) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sqlBuyer)) {
            ps.setInt(1, b.getId());
            ps.setString(2, b.getPropiedadDeInteresActual());
            ps.setFloat(3, b.getBalance());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al insertar buyer: " + e.getMessage());
        }
        return b;
    }

    public Buyer buscarPorCorreo(String correo) {
        String sql = "SELECT u.*, b.propiedadDeInteresActual, b.balance FROM superUser u JOIN buyer b ON u.id = b.id WHERE u.correo = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rowMapper.mapRow(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar buyer: " + e.getMessage());
        }
        return null;
    }

    public Collection<Buyer> listarTodos() {
        List<Buyer> lista = new ArrayList<>();
        String sql = "SELECT u.*, b.propiedadDeInteresActual, b.balance FROM user u JOIN buyer b ON u.id = b.id";
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) lista.add(rowMapper.mapRow(rs));
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar buyers: " + e.getMessage());
        }
        return lista;
    }
}
