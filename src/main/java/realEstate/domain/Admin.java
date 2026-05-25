package realEstate.domain;

public class Admin extends User {
    private String adminType;

    public Admin(){
        super();
    }

    public Admin(int id, String nombre, float balance, String telefono, String correo, String adminType) {
        super(id, nombre, balance, telefono, correo);
        this.adminType = adminType;
    }

    public String getAdminType() {
        return adminType;
    }

    public void setAdminType(String adminType) {
        this.adminType = adminType;
    }
}
