package realEstate.view;

import realEstate.domain.Buyer;
import realEstate.service.BuyerService;
import realEstate.util.TypeValidator;

import java.util.Collection;

public class BuyerView {
    private final BuyerService buyerService;
    private final TypeValidator tv = new TypeValidator();

    public BuyerView(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    public void menu() {
        int option;
        do {
            tv.Mensaje("Gestión de Compradores \n" +
                    "1. Ver todos los compradores\n" +
                    "2. Buscar comprador por ID\n" +
                    "3. Agregar comprador\n" +
                    "4. Eliminar comprador\n" +
                    "5. Volver al menú anterior");
            option = tv.leerIntEnRango(1, 5, "Seleccione una opción: ");
            switch (option) {
                case 1 -> listBuyers();
                case 2 -> searchBuyer();
                case 3 -> addBuyer();
                case 4 -> deleteBuyer();
                case 5 -> tv.Mensaje("Volviendo al menú anterior...");
            }
        } while (option != 5);
    }

    private void listBuyers() {
        Collection<Buyer> buyers = buyerService.selectAllBuyers();
        if (buyers == null || buyers.isEmpty()) {
            tv.Mensaje("No hay compradores registrados.");
            return;
        }
        StringBuilder sb = new StringBuilder("Compradores registrados:\n"); //Esto es para que todo el texto quede mejor organizado y mas legible (concatenar todo)
        for (Buyer buyer : buyers) {
            sb.append("ID: ").append(buyer.getId())
                    .append(" | Nombre: ").append(buyer.getNombre())
                    .append(" | Correo: ").append(buyer.getCorreo())
                    .append(" | Teléfono: ").append(buyer.getTelefono())
                    .append(" | Balance: ").append(buyer.getBalance())
                    .append(" | Propiedad de interés: ").append(buyer.getPropiedadDeInteresActual())
                    .append("\n");
        }
        tv.Mensaje(sb.toString());
    }

    private void searchBuyer() {
        int id = tv.leerInt("Ingrese el ID del comprador a buscar:");
        Buyer buyer = buyerService.findBuyer(id);
        if (buyer == null) {
            tv.Mensaje("Comprador no encontrado.");
            return;
        }
        tv.Mensaje("Comprador encontrado:\n" +
                "ID: " + buyer.getId() + "\n" +
                "Nombre: " + buyer.getNombre() + "\n" +
                "Correo: " + buyer.getCorreo() + "\n" +
                "Teléfono: " + buyer.getTelefono() + "\n" +
                "Balance: " + buyer.getBalance() + "\n" +
                "Propiedad de interés: " + buyer.getPropiedadDeInteresActual());
    }

    private void addBuyer() {
        Buyer buyer = new Buyer();
        buyer.setId(tv.leerInt("Ingrese ID del comprador:"));
        buyer.setNombre(tv.leerString("Ingrese nombre del comprador:"));
        buyer.setCorreo(tv.leerString("Ingrese correo del comprador:"));
        buyer.setTelefono(tv.leerString("Ingrese teléfono del comprador:"));
        buyer.setBalance(tv.leerFloat("Ingrese balance del comprador:"));
        buyer.setPropiedadDeInteresActual(tv.leerString("Ingrese propiedad de interés actual:"));
        buyerService.addBuyer(buyer);
        tv.Mensaje("Comprador agregado correctamente.");
    }

    private void deleteBuyer() {
        int id = tv.leerInt("Ingrese el ID del comprador a eliminar:");
        Buyer buyer = buyerService.findBuyer(id);
        if (buyer == null) {
            tv.Mensaje("Comprador no encontrado.");
            return;
        }
        buyerService.deleteBuyer(buyer);
        tv.Mensaje("Comprador eliminado correctamente.");
    }
}

