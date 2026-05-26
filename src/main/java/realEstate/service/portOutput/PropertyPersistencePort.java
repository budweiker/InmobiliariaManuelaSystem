package realEstate.service.portOutput;

import realEstate.domain.Property;

import java.util.Collection;

public interface PropertyPersistencePort {
    Property agregar(Property p);
    void eliminar(String nombre);
    Property buscar(String nombre);
    Collection<Property> listarTodos();

}
