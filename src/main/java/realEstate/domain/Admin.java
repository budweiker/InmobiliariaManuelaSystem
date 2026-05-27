package realEstate.domain;

public class Admin extends User {
    private String adminType;
    public Admin(){
        super();
    }

    public Admin(int id, String nombre, String telefono, String correo, String contraseña,String adminType){
        super(id,nombre,telefono,correo,contraseña);
        this.adminType = adminType;
    }
   
    public String getAdminType() {
        return adminType;
    }

    public void setAdminType(String adminType) {
        this.adminType = adminType;
    }
 }
     