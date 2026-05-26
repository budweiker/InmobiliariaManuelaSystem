package realEstate.domain;

public abstract class User {
    private int id;
    private String nombre;
    private String telefono;
    private String correo;
    private float balance;
    
    public User(){
    }

    public User(int id, String nombre, String telefono, String correo) {
        this.id = id;
        this.nombre = nombre;
        //this.balance = balance;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
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