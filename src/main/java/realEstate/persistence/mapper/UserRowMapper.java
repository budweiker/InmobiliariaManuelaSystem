package realEstate.persistence.mapper;

import realEstate.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class UserRowMapper <T extends User> implements RowMapper<T> {
    protected void mapUserFields(ResultSet rs, User u) throws SQLException {
        u.setId(rs.getInt("id"));
        u.setNombre(rs.getString("nombre"));
        u.setApellido(rs.getString("apellido"));
        u.setTelefono(rs.getString("telefono"));
        u.setCorreo(rs.getString("correo"));
        u.setPassword(rs.getString("password"));
        u.setStatus(rs.getBoolean("status"));
    }
}
