package realEstate.persistence.repository;
import realEstate.domain.Property;
import realEstate.persistence.mapper.PropertyRowMapper;
import realEstate.service.portOutput.PropertyPersistencePort;
import realEstate.util.TypeValidator;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PropertyRepositoryDB implements PropertyPersistencePort {
    private final TypeValidator data = new TypeValidator();
    private final Connection connection;
    private final PropertyRowMapper rowMapper = new PropertyRowMapper();

    public PropertyRepositoryDB(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Property agregar(Property p) {
        String sql = "INSERT INTO property (propertyName, location, price, rooms, estrato) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            setCustomParams(ps, p);
            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                p.setIdPropiedad(keys.getInt(1));
        }
    }catch (Exception e) {
            throw new RuntimeException("Error al insertar datos de la propiedad", e);
        }
        return p;
    }

    public void eliminar (String nombre){
        String sql = "DELETE FROM property WHERE propertyName = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.executeUpdate();
            data.Mensaje("✓ Propiedad eliminada: " + nombre);
        }catch (Exception e) {
            throw new RuntimeException("Error al eliminar la propiedad" + e.getMessage());
        }
    }

    @Override
    public Property buscar (String nombre){
        String sql = "SELECT * FROM property WHERE propertyName = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rowMapper.mapRow(rs);
            }
        }catch (Exception e) {
            throw new RuntimeException("Error al buscar la propiedad" + e.getMessage());
        }
        return null;
    }

    @Override
    public Collection<Property> listarTodos() {
        List<Property> lista = new ArrayList<>();
        String sql = "SELECT * FROM property";
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                lista.add(rowMapper.mapRow(rs));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar propiedades: " + e.getMessage());
        }
        return lista;
    }

    //helper
    private void setCustomParams(PreparedStatement ps, Property p) throws SQLException {
        ps.setInt(1, p.getIdPropiedad());
        ps.setString(2, p.getNombrePropiedad());
        ps.setString(3, p.getUbicacionPropiedad());
        ps.setDouble(4, p.getValorPropiedad());
        ps.setInt(5, p.getHabitaciones());
        ps.setInt(6, p.getEstrato());
    }

}
