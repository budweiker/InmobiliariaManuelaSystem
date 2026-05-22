package realEstate.userInterface;

import realEstate.util.TypeValidator;
import realEstate.view.AdminView;
import realEstate.view.BuyerView;
import realEstate.view.PropertyView;
import realEstate.view.SellerView;

public class MenuApp {
    private final TypeValidator tv = new TypeValidator();
    private final PropertyView propertyView;
    private final SellerView sellerView;
    private final BuyerView buyerView;
    private final AdminView adminView;

    public MenuApp(PropertyView propertyView, SellerView sellerView, BuyerView buyerView, AdminView adminView) {
        this.propertyView = propertyView;
        this.sellerView = sellerView;
        this.buyerView = buyerView;
        this.adminView = adminView;
    }

    public void mainMenu() {
        int option;
        do {
            String menuText = "Bienvenido a Inmobiliaria Manuela Bermudez Realtor\n" +
                    "Selecciona una opción:\n" +
                    "1. Explorar propiedades\n" +
                    "2. Gestionar usuarios\n" +
                    "3. Salir";
            option = tv.leerIntEnRango(1, 3, menuText);
            switch (option) {
                case 1 -> propertyView.menu();
                case 2 -> userMenu();
                case 3 -> tv.Mensaje("Has salido del sistema. ¡Gracias por su visita!");
            }
        } while (option != 3);
    }

    private void userMenu() {
        int option;
        do {
            String userMenuText = "\n=== Gestión de usuarios ===\n" +
                    "1. Administradores\n" +
                    "2. Vendedores\n" +
                    "3. Compradores\n" +
                    "4. Volver al menú principal";
            option = tv.leerIntEnRango(1, 4, userMenuText);
            switch (option) {
                case 1 -> adminView.menu();
                case 2 -> sellerView.menu();
                case 3 -> buyerView.menu();
                case 4 -> tv.Mensaje("Volviendo al menú principal...");
            }
        } while (option != 4);
    }
}

