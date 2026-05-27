package realEstate.domain;

public abstract class User {
    private int id;
    private String contraseña;
    private String nombre;
    private String telefono;
    private String correo;
    
    
    public User(){
    }

    public User(int id, String nombre, String telefono, String correo,String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getPassword() {
        return id;
    }

    public void setPassword(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}