package realEstate.service.portInput;

import realEstate.domain.Property;

import java.util.Collection;

public interface PropertyService {
    public Collection<Property> selectAllProperties();
    public Property buscarPropiedad(String nombre);
    public void eliminarPropiedad(Property p);
    public void agregarPropiedad(Property p);
}
