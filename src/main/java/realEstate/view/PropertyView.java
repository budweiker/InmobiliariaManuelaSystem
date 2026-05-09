package realEstate.view;
import real

public class PropertyView {
    static TypeValidator() tv = new TypeValidator();
    public void searchProperties () {
        int option;
        do {
            tv.Mensaje("\n=== Explorar Propiedades ===\n" +
                    "1. Ver todas las propiedades\n" +
                    "2. Buscar propiedad por nombre\n" +
                    "3. Volver al menú principal");

            option = tv.leerIntEnRango(1, 3, "Seleccione una opción: ");

            switch (option) {
                case 1:
                     
                break;
                //case 2 -> buscarPropiedad();
                case 3 -> tv.Mensaje("Volviendo... ");
            }
        } while (option != 3);
    }
    
}
