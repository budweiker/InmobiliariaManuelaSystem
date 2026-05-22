package realEstate.view;

import realEstate.domain.Admin;
import realEstate.service.AdminService;
import realEstate.util.TypeValidator;

import java.util.Collection;

public class AdminView {
    private final AdminService adminService;
    private final TypeValidator tv = new TypeValidator();

    public AdminView(AdminService adminService) {
        this.adminService = adminService;
    }

    public void menu() {
        int option;
        do {
            tv.Mensaje("Gestión de Administradores\n" +
                    "1. Ver todos los administradores\n" +
                    "2. Buscar administrador por ID\n" +
                    "3. Agregar administrador\n" +
                    "4. Eliminar administrador\n" +
                    "5. Volver al menú anterior");
            option = tv.leerIntEnRango(1, 5, "Seleccione una opción: ");
            switch (option) {
                case 1 -> listAdmins();
                case 2 -> searchAdmin();
                case 3 -> addAdmin();
                case 4 -> deleteAdmin();
                case 5 -> tv.Mensaje("Volviendo al menú anterior...");
            }
        } while (option != 5);
    }

    private void listAdmins() {
        Collection<Admin> admins = adminService.selectAllAdmins();
        if (admins == null || admins.isEmpty()) {
            tv.Mensaje("No hay administradores registrados.");
            return;
        }
        StringBuilder sb = new StringBuilder("Administradores registrados:\n"); //Esto es para que todo el texto quede mejor organizado y mas legible (concatenar todo)
        for (Admin admin : admins) {
            sb.append("ID: ").append(admin.getId())
                    .append(" | Nombre: ").append(admin.getNombre())
                    .append(" | Correo: ").append(admin.getCorreo())
                    .append(" | Teléfono: ").append(admin.getTelefono())
                    .append(" | Balance: ").append(admin.getBalance())
                    .append("\n");
        }
        tv.Mensaje(sb.toString());
    }

    private void searchAdmin() {
        int id = tv.leerInt("Ingrese el ID del administrador a buscar:");
        Admin admin = adminService.findAdmin(id);
        if (admin == null) {
            tv.Mensaje("Administrador no encontrado.");
            return;
        }
        tv.Mensaje("Administrador encontrado:\n" +
                "ID: " + admin.getId() + "\n" +
                "Nombre: " + admin.getNombre() + "\n" +
                "Correo: " + admin.getCorreo() + "\n" +
                "Teléfono: " + admin.getTelefono() + "\n" +
                "Balance: " + admin.getBalance());
    }

    private void addAdmin() {
        Admin admin = new Admin();
        admin.setId(tv.leerInt("Ingrese ID del administrador:"));
        admin.setNombre(tv.leerString("Ingrese nombre del administrador:"));
        admin.setCorreo(tv.leerString("Ingrese correo del administrador:"));
        admin.setTelefono(tv.leerString("Ingrese teléfono del administrador:"));
        admin.setBalance(tv.leerFloat("Ingrese balance del administrador:"));
        adminService.addAdmin(admin);
        tv.Mensaje("Administrador agregado correctamente.");
    }

    private void deleteAdmin() {
        int id = tv.leerInt("Ingrese el ID del administrador a eliminar:");
        Admin admin = adminService.findAdmin(id);
        if (admin == null) {
            tv.Mensaje("Administrador no encontrado.");
            return;
        }
        adminService.deleteAdmin(admin);
        tv.Mensaje("Administrador eliminado correctamente.");
    }
}

