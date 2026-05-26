package realEstate.domain;

public class Admin extends User {
    private String adminType;

    public Admin(){
        super();
    }

<<<<<<< Updated upstream
    public Admin(int id, String nombre, float balance, String telefono, String correo, String adminType) {
        super(id, nombre, balance, telefono, correo);
=======
    public Admin(int id, String nombre, String telefono, String correo, String adminType) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
>>>>>>> Stashed changes
        this.adminType = adminType;
    }

    public String getAdminType() {
        return adminType;
    }

    public void setAdminType(String adminType) {
        this.adminType = adminType;
    }
}
