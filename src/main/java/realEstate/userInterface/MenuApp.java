package realEstate.userInterface;

import realEstate.domain.Admin;
import realEstate.domain.Buyer;
import realEstate.domain.Seller;
import realEstate.domain.User;
import realEstate.service.AuthService;
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
    private final AuthService authService;

    public MenuApp(PropertyView propertyView, SellerView sellerView, BuyerView buyerView, AdminView adminView, AuthService authService) {
        this.propertyView = propertyView;
        this.sellerView = sellerView;
        this.buyerView = buyerView;
        this.adminView = adminView;
        this.authService = authService;
    }

    public void mainMenu() {
        int option;
        do {
            String menuText = "Bienvenido a Inmobiliaria Manuela Bermudez Realtor\n" +
                    "Selecciona una opción:\n" +
                    "1. Iniciar sesión\n" +
                    "2. Explorar propiedades\n" +
                    "3. Gestionar usuarios\n" +
                    "4. Salir";
            option = tv.leerIntEnRango(1, 4, menuText);
            switch (option) {
                case 1 -> loginMenu();
                case 2 -> propertyView.menu();
                case 3 -> userMenu();
                case 4 -> tv.Mensaje("Has salido del sistema. ¡Gracias por su visita!");
            }
        } while (option != 4);
    }

    private void loginMenu() {
        tv.Mensaje("=== Inicio de sesión ===");
        String correo = tv.leerString("Ingrese su correo electrónico:");
        String clave = tv.leerString("Ingrese su contraseña:");

        User user = authService.authenticate(correo, clave);
        if (user == null) {
            tv.Mensaje("Correo o contraseña incorrectos. Intente de nuevo.");
            return;
        }

        if (user instanceof Admin) {
            tv.Mensaje("Inicio de sesión exitoso. Bienvenido administrador " + user.getNombre() + "!");
            adminView.menu();
        } else if (user instanceof Seller) {
            tv.Mensaje("Inicio de sesión exitoso. Bienvenido vendedor " + user.getNombre() + "!");
            sellerView.menu();
        } else if (user instanceof Buyer) {
            tv.Mensaje("Inicio de sesión exitoso. Bienvenido comprador " + user.getNombre() + "!");
            buyerView.menu();
        } else {
            tv.Mensaje("Inicio de sesión exitoso.");
        }
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

