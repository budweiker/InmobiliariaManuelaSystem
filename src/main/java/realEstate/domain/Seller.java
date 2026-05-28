package realEstate.domain;

public class Seller extends User {
    private int propiedadesVendidas;
    private float balance;

    public Seller(){
        super();
    }

    public Seller(int id, String password, String nombre, String apellido, String telefono, String correo, boolean status, int propiedadesVendidas, float balance) {
        super(id, password, nombre, apellido, telefono, correo, status);
        this.propiedadesVendidas = propiedadesVendidas;
        this.balance = balance;
    }

    public int getPropiedadesVendidas() {
        return propiedadesVendidas;
    }

    public void setPropiedadesVendidas(int propiedadesVendidas) {
        this.propiedadesVendidas = propiedadesVendidas;
    }
    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}

