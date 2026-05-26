package realEstate.persistence.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import realEstate.domain.Property;

public class PropertyRepository {

    List <Property> propiedades = new ArrayList<>();

    public Property agregar(Property p) {
        propiedades.add(p);
        for(Property p1:propiedades){
            System.out.println(p1.getIdPropiedad() + " " + p1.getNombrePropiedad() + " " + p1.getPropertyAddress() + " " + p1.getValorPropiedad() + " " + p1.getHabitaciones() + " " + p1.getEstrato());
        }
        return p;
    }

    public void eliminar(String nombre) {
        propiedades.removeIf(p -> p.getNombrePropiedad().equals(nombre));
    }

    public Property buscar(String nombre) {
        for(Property p:propiedades) {
            if(p.getNombrePropiedad().equals(nombre)) {
                return p;
            }
        }
        return null;
    }

    public Collection<Property> listarTodos() {
        return propiedades;
    }
}

    



