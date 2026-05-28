package realEstate.domain;

public class Buyer extends User {

    private String propiedadDeInteresActual;
    private float balance;
    public Buyer(){
        super();
    }

    public Buyer(int id, String password, String nombre, String apellido, String telefono, String correo, boolean status, String propiedadDeInteresActual, float balance) {
        super(id, password, nombre, apellido, telefono, correo, status);
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