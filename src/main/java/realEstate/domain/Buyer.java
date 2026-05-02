package realEstate.domain;

public class Buyer extends User {

    private String propiedadDeInteresActual;
    public Buyer(){
        
    }

    public String getPropiedadDeInteresActual() {
        return propiedadDeInteresActual;
    }

    public void setPropiedadDeInteresActual(String propiedadDeInteresActual) {
        this.propiedadDeInteresActual = propiedadDeInteresActual;
    }
    
}