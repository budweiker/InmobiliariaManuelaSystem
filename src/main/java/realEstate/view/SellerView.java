package realEstate.view;

import realEstate.domain.Seller;
import realEstate.service.SellerService;
import realEstate.util.TypeValidator;

import java.util.Collection;

public class SellerView {
    private final SellerService sellerService;
    private final TypeValidator tv = new TypeValidator();

    public SellerView(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    public void menu() {
        int option;
        do {
            tv.Mensaje("Gestión de Vendedores\n" +
                    "1. Ver todos los vendedores\n" +
                    "2. Buscar vendedor por ID\n" +
                    "3. Agregar vendedor\n" +
                    "4. Eliminar vendedor\n" +
                    "5. Volver al menú anterior");
            option = tv.leerIntEnRango(1, 5, "Seleccione una opción: ");
            switch (option) {
                case 1 -> listSellers();
                case 2 -> searchSeller();
                case 3 -> addSeller();
                case 4 -> deleteSeller();
                case 5 -> tv.Mensaje("Volviendo al menú anterior...");
            }
        } while (option != 5);
    }

    private void listSellers() {
        Collection<Seller> sellers = sellerService.selectAllSellers();
        if (sellers == null || sellers.isEmpty()) {
            tv.Mensaje("No hay vendedores registrados.");
            return;
        }
        StringBuilder sb = new StringBuilder("Vendedores registrados:\n"); //Esto es para que todo el texto quede mejor organizado y mas legible (concatenar todo)
        for (Seller seller : sellers) {
            sb.append("ID: ").append(seller.getId())
                    .append(" | Nombre: ").append(seller.getNombre())
                    .append(" | Correo: ").append(seller.getCorreo())
                    .append(" | Teléfono: ").append(seller.getTelefono())
                    .append(" | Balance: ").append(seller.getBalance())
                    .append(" | Propiedades vendidas: ").append(seller.getPropiedadesVendidas())
                    .append("\n");
        }
        tv.Mensaje(sb.toString());
    }

    private void searchSeller() {
        int id = tv.leerInt("Ingrese el ID del vendedor a buscar:");
        Seller seller = sellerService.findSeller(id);
        if (seller == null) {
            tv.Mensaje("Vendedor no encontrado.");
            return;
        }
        tv.Mensaje("Vendedor encontrado:\n" +
                "ID: " + seller.getId() + "\n" +
                "Nombre: " + seller.getNombre() + "\n" +
                "Correo: " + seller.getCorreo() + "\n" +
                "Teléfono: " + seller.getTelefono() + "\n" +
                "Balance: " + seller.getBalance() + "\n" +
                "Propiedades vendidas: " + seller.getPropiedadesVendidas());
    }

    private void addSeller() {
        Seller seller = new Seller();
        seller.setId(tv.leerInt("Ingrese ID del vendedor:"));
        seller.setNombre(tv.leerString("Ingrese nombre del vendedor:"));
        seller.setCorreo(tv.leerString("Ingrese correo del vendedor:"));
        seller.setTelefono(tv.leerString("Ingrese teléfono del vendedor:"));
        seller.setBalance(tv.leerFloat("Ingrese balance del vendedor:"));
        seller.setPropiedadesVendidas(tv.leerInt("Ingrese cantidad de propiedades vendidas:"));
        sellerService.addSeller(seller);
        tv.Mensaje("Vendedor agregado correctamente.");
    }

    private void deleteSeller() {
        int id = tv.leerInt("Ingrese el ID del vendedor a eliminar:");
        Seller seller = sellerService.findSeller(id);
        if (seller == null) {
            tv.Mensaje("Vendedor no encontrado.");
            return;
        }
        sellerService.deleteSeller(seller);
        tv.Mensaje("Vendedor eliminado correctamente.");
    }
}

