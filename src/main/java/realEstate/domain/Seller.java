package realEstate.domain;

public class Seller extends User {
    private int propiedadesVendidas;
    private float balance;
    public Seller(int id, String nombre, String telefono, String correo,int propiedadesVendidas,float balance,String contraseña){
        super(id, nombre, telefono, correo,contraseña);
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

