package realEstate.service;
import realEstate.domain.Property;
import realEstate.repository.PropertyRepository;
import realEstate.util.InputValidator;
import realEstate.util.TypeValidator;
public class PropertyService {
    static TypeValidator tv = new TypeValidator();
    
    public Property publicarPropiedad(Property p){


    }
    public void eliminarPropiedad(String nombre){
        for (Property p : propiedades) {
            if(p.getnombrePropiedad().equals(nombre))
                propiedades.remove(nombre);

           
            
        }
        

    }
    public void buscarPropiedad(int id, String nombre){
        for(Property p : propiedades){
            if(p.getnombrePropiedad().equals(nombre) || p.getIdPropiedad() == id)
                tv.Mensaje(p);

        }

    }
    public void mostrarTodasLasPropiedades(){

    }

    
}
