package realEstate.service;
import realEstate.domain.Property;
import realEstate.persistence.repository.PropertyRepository;
import realEstate.util.TypeValidator;

import java.util.Collection;
import java.util.Properties;

public class PropertyService {
    private PropertyRepository repo;
    public PropertyService(PropertyRepository repo){
        this.repo = repo;
    } //constructor

    private TypeValidator tv = new TypeValidator();

    public void searchProperties () {
        int option;
        do {
            tv.Mensaje("\n=== Explorar Propiedades ===\n" +
                    "1. Ver todas las propiedades\n" +
                    "2. Buscar propiedad por nombre\n" +
                    "3. Volver al menú principal");

            option = tv.leerIntEnRango(3, 1, "Seleccione una opción: ");

            switch (option) {
                case 1 -> selectAllProperties();
                //case 2 -> buscarPropiedad();
                case 3 -> tv.Mensaje("Volviendo... ");
            }
        } while (option != 3);
    }
            private void selectAllProperties(){
                Collection<Property> lista = repo.listarTodos();
                if (lista.isEmpty()){
                tv.Mensaje("No hay propiedades registradas.");
                return;
                }
            }





}
