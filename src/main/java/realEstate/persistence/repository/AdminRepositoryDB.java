package realEstate.persistence.repository;

import realEstate.domain.Admin;
import realEstate.persistence.mapper.AdminRowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AdminRepositoryDB {
    private final Connection connection;
    private final AdminRowMapper rowMapper = new AdminRowMapper();

    public AdminRepositoryDB(Connection connection) {
        this.connection = connection;
    }

    public Admin agregar(Admin a) {
        // 1. Insertar en user
        String sqlUser = "INSERT INTO superUser (nombre, apellido, telefono, correo, contraseña, status, rol) VALUES (?, ?, ?, ?, ?, ?, 'ADMIN')";
        try (PreparedStatement ps = connection.prepareStatement(sqlUser, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getApellido());
            ps.setString(3, a.getTelefono());
            ps.setString(4, a.getCorreo());
            ps.setString(5, a.getPassword());
            ps.setBoolean(6, a.isStatus());
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                a.setId(keys.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al insertar usuario admin: " + e.getMessage());
        }

        // 2. Insertar en admin
        String sqlAdmin = "INSERT INTO admin (id, adminType) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sqlAdmin)) {
            ps.setInt(1, a.getId());
            ps.setString(2, a.getAdminType());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al insertar admin: " + e.getMessage());
        }
        return a;
    }

    public Admin buscarPorCorreo(String correo) {
        String sql = "SELECT u.*, a.adminType FROM superUser u JOIN admin a ON u.id = a.id WHERE u.correo = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rowMapper.mapRow(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar admin: " + e.getMessage());
        }
        return null;
    }

    public Collection<Admin> listarTodos() {
        List<Admin> lista = new ArrayList<>();
        String sql = "SELECT u.*, a.adminType FROM superUser u JOIN admin a ON u.id = a.id";
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) lista.add(rowMapper.mapRow(rs));
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar admins: " + e.getMessage());
        }
        return lista;
    }
}

