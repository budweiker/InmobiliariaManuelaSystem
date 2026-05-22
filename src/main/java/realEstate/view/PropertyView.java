package realEstate.view;

import realEstate.domain.Property;
import realEstate.service.PropertyService;
import realEstate.util.TypeValidator;

import java.util.Collection;

public class PropertyView {
    private final PropertyService propertyService;
    private final TypeValidator tv = new TypeValidator();

    public PropertyView(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    public void menu() {
        int option;
        do {
            tv.Mensaje("Gestión de Propiedades \n" +
                    "1. Ver todas las propiedades\n" +
                    "2. Buscar propiedad por nombre\n" +
                    "3. Agregar propiedad\n" +
                    "4. Eliminar propiedad\n" +
                    "5. Volver al menú anterior");
            option = tv.leerIntEnRango(1, 5, "Seleccione una opción: ");
            switch (option) {
                case 1 -> listProperties();
                case 2 -> searchProperty();
                case 3 -> addProperty();
                case 4 -> deleteProperty();
                case 5 -> tv.Mensaje("Volviendo al menú anterior...");
            }
        } while (option != 5);
    }

    private void listProperties() {
        Collection<Property> properties = propertyService.selectAllProperties();
        if (properties == null || properties.isEmpty()) {
            tv.Mensaje("No hay propiedades registradas.");
            return;
        }
        StringBuilder sb = new StringBuilder("Propiedades registradas:\n"); //Esto es para que todo el texto quede mejor organizado y mas legible (concatenar todo)
        for (Property property : properties) {
            sb.append("ID: ").append(property.getIdPropiedad())
                    .append(" | Nombre: ").append(property.getNombrePropiedad())
                    .append(" | Valor: ").append(property.getValorPropiedad())
                    .append(" | Ubicación: ").append(property.getUbicacionPropiedad())
                    .append(" | Habitaciones: ").append(property.getHabitaciones())
                    .append(" | Estrato: ").append(property.getEstrato())
                    .append("\n");
        }
        tv.Mensaje(sb.toString());
    }

    private void searchProperty() {
        String name = tv.leerString("Ingrese el nombre de la propiedad a buscar:");
        Property property = propertyService.buscarPropiedad(name);
        if (property == null) {
            tv.Mensaje("Propiedad no encontrada.");
            return;
        }
        tv.Mensaje("Propiedad encontrada:\n" +
                "ID: " + property.getIdPropiedad() + "\n" +
                "Nombre: " + property.getNombrePropiedad() + "\n" +
                "Valor: " + property.getValorPropiedad() + "\n" +
                "Ubicación: " + property.getUbicacionPropiedad() + "\n" +
                "Habitaciones: " + property.getHabitaciones() + "\n" +
                "Estrato: " + property.getEstrato());
    }

    private void addProperty() {
        Property property = new Property();
        property.setIdPropiedad(tv.leerInt("Ingrese ID de la propiedad:"));
        property.setNombrePropiedad(tv.leerString("Ingrese nombre de la propiedad:"));
        property.setValorPropiedad(tv.leerFloat("Ingrese el valor de la propiedad:"));
        property.setUbicacionPropiedad(tv.leerString("Ingrese la ubicación de la propiedad:"));
        property.setHabitaciones(tv.leerInt("Ingrese el número de habitaciones:"));
        property.setEstrato(tv.leerInt("Ingrese el estrato de la propiedad:"));
        propertyService.agregarPropiedad(property);
        tv.Mensaje("Propiedad agregada correctamente.");
    }

    private void deleteProperty() {
        String name = tv.leerString("Ingrese el nombre de la propiedad a eliminar:");
        Property property = propertyService.buscarPropiedad(name);
        if (property == null) {
            tv.Mensaje("Propiedad no encontrada.");
            return;
        }
        propertyService.eliminarPropiedad(property);
        tv.Mensaje("Propiedad eliminada correctamente.");
    }
}

