package realEstate.domain;

public class Admin extends User {
    private String adminType;
    public Admin(){
        super();
    }

    public Admin(int id, String password, String nombre, String apellido, String telefono, String correo, boolean status, String adminType) {
        super(id, password, nombre, apellido, telefono, correo, status);
        this.adminType = adminType;
    }

    public String getAdminType() {
        return adminType;
    }

    public void setAdminType(String adminType) {
        this.adminType = adminType;
    }
 }
     