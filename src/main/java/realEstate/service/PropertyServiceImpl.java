package realEstate.service;

import realEstate.domain.Property;
import realEstate.service.portInput.PropertyService;
import realEstate.service.portOutput.PropertyPersistencePort;
import realEstate.util.TypeValidator;

import java.util.Collection;
import java.util.Collections;

public class PropertyServiceImpl implements PropertyService {
    private final TypeValidator tv = new TypeValidator();
    private final PropertyPersistencePort repository;

    public PropertyServiceImpl(PropertyPersistencePort repository) {
        this.repository = repository;
    }

    public Collection<Property> selectAllProperties() {
        if (repository == null) {
            tv.Mensaje("No hay propiedades registradas aun");
            return Collections.emptyList();
        }
        return repository.listarTodos();
    }

    public Property buscarPropiedad(String nombre) {
        return repository.buscar(nombre);
    }

    public void eliminarPropiedad(Property p) {
        repository.eliminar(p.getBarrio());
    }

    public void agregarPropiedad(Property p) {
        repository.agregar(p);
    }
}
