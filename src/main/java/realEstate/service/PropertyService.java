package realEstate.service;
import realEstate.domain.Property;
import realEstate.persistence.repository.PropertyRepository;
import realEstate.util.TypeValidator;

import java.util.Collection;


public class PropertyService {
    static private TypeValidator tv = new TypeValidator();
    private PropertyRepository repository;
    public PropertyService(){
        this.repository = new PropertyRepository();
    } 
    public Collection<Property> selectAllProperties(){
        if(repository == null){
            tv.Mensaje("No hay propiedades registradas aun");
            return null;
        }else{
            return repository.listarTodos();
        }  
    }
    public Property buscarPropiedad(String nombre){
        return repository.buscar(nombre);

    }
    public void eliminarPropiedad(Property p){
        repository.eliminar(p.getNombrePropiedad());
    }
    public void agregarPropiedad(Property p){
        repository.agregar(p);    
}
}