package realEstate.domain;

public class Buyer extends User {

    private String propiedadDeInteresActual;
    private float balance;
    public Buyer(){
        super();
    }

    public Buyer(int id, String nombre, float balance, String telefono, String correo, String propiedadDeInteresActual,String contraseña) {
        super(id, nombre, telefono, correo,contraseña);
        this.propiedadDeInteresActual = propiedadDeInteresActual;
        this.balance = balance;
    }

    public String getPropiedadDeInteresActual() {
        return propiedadDeInteresActual;
    }

    public void setPropiedadDeInteresActual(String propiedadDeInteresActual) {
        this.propiedadDeInteresActual = propiedadDeInteresActual;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}