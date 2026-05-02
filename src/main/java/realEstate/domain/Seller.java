package realEstate.domain;

public class Seller extends User {
    private int propiedadesVendidas;
    public Seller(){
        
    }


    public int getPropiedadesVendidas() {
        return propiedadesVendidas;
    }

    public void setPropiedadesVendidas(int propiedadesVendidas) {
        this.propiedadesVendidas = propiedadesVendidas;
    }
}

