package realEstate.service;

import realEstate.domain.Property;
import realEstate.persistence.repository.PropertyRepository;
import realEstate.util.TypeValidator;

import java.util.Collection;
import java.util.Collections;

public class PropertyServiceImpl {
    private final TypeValidator tv = new TypeValidator();
    private final PropertyRepository repository;

    public PropertyServiceImpl() {
        this(new PropertyRepository());
    }

    public PropertyServiceImpl(PropertyRepository repository) {
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
        repository.eliminar(p.getNombrePropiedad());
    }

    public void agregarPropiedad(Property p) {
        repository.agregar(p);
    }
}
