package realEstate.persistence.repository;

import realEstate.domain.Seller;
import realEstate.persistence.mapper.SellerRowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SellerRepositoryDB {
    private final Connection connection;
    private final SellerRowMapper rowMapper = new SellerRowMapper();

    public SellerRepositoryDB(Connection connection) {
        this.connection = connection;
    }

    public Seller agregar(Seller s) {
        String sqlUser = "INSERT INTO superUser (nombre, apellido, telefono, correo, contraseña, status, rol) VALUES (?, ?, ?, ?, ?, ?, 'SELLER')";
        try (PreparedStatement ps = connection.prepareStatement(sqlUser, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, s.getNombre());
            ps.setString(2, s.getApellido());
            ps.setString(3, s.getTelefono());
            ps.setString(4, s.getCorreo());
            ps.setString(5, s.getPassword());
            ps.setBoolean(6, s.isStatus());
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) s.setId(keys.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException("Error al insertar usuario seller: " + e.getMessage());
        }

        String sqlSeller = "INSERT INTO seller (id, propiedadesVendidas, balance) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sqlSeller)) {
            ps.setInt(1, s.getId());
            ps.setInt(2, s.getPropiedadesVendidas());
            ps.setFloat(3, s.getBalance());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al insertar seller: " + e.getMessage());
        }
        return s;
    }

    public Seller buscarPorCorreo(String correo) {
        String sql = "SELECT u.*, s.propiedadesVendidas, s.balance FROM superUser u JOIN seller s ON u.id = s.id WHERE u.correo = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rowMapper.mapRow(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar seller: " + e.getMessage());
        }
        return null;
    }

    public Collection<Seller> listarTodos() {
        List<Seller> lista = new ArrayList<>();
        String sql = "SELECT u.*, s.propiedadesVendidas, s.balance FROM user u JOIN seller s ON u.id = s.id";
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) lista.add(rowMapper.mapRow(rs));
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar sellers: " + e.getMessage());
        }
        return lista;
    }
}
