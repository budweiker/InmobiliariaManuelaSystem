package realEstate.domain;

public class User {
    protected int id; //Como es una clase padre, ps si ponemos private las otras clases no lo van a poder ver y si es public no estamos usando encapsulacion, entonces la mejor opcion es protected
    protected String nombre;
    protected float balance;
    protected String telefono;
    protected String correo;
    
    public User(){
        
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