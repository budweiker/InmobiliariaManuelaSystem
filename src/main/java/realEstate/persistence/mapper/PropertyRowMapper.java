package realEstate.persistence.mapper;

import realEstate.domain.Property;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PropertyRowMapper implements RowMapper<Property> {

    @Override
    public Property mapRow(ResultSet rs) throws SQLException {
        Property p = new Property();
        p.setIdPropiedad(rs.getInt("id_propiedad"));
        p.setBarrio(rs.getString("barrio"));
        p.setDireccion(rs.getString("direccion"));
        p.setValorPropiedad(rs.getFloat("valor"));
        p.setHabitaciones(rs.getInt("habitaciones"));
        p.setEstrato(rs.getInt("estrato"));
        return p;
    }
}
