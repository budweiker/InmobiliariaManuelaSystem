package realEstate.service.portOutput;

import realEstate.domain.Property;

import java.util.Collection;

public interface PropertyPersistencePort {
    public void agregar(Property p);
    public void eliminar(String nombre);
    public Property buscar(String nombre);
    public Collection<Property> listarTodos();

}
