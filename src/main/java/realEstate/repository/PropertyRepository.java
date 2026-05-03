package realEstate.repository;
import java.util.Collection;
import java.util.HashMap;
import realEstate.domain.Property;
import realEstate.util.TypeValidator;

public class PropertyRepository {
    HashMap<String, Property> propiedades = new HashMap<>();




    static TypeValidator tv = new TypeValidator();
    
    public void agregar(Property p){
        propiedades.put(p.getnombrePropiedad(), p);


    }
    public void eliminar(String nombre){
        propiedades.remove(nombre);
        

    }
    public Property buscar(String nombre){
        return propiedades.get(nombre);

    }
    public Collection<Property> listarTodos(){
        return propiedades.values();

    }

    
}

    



