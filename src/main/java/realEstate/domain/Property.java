package realEstate.domain;

public class Property {
    private int id;
    private float valorPropiedad;
    private String ubicacionPropiedad;
    private String propertyAddress;
    private int habitaciones;
    private int estrato;
    private String nombrePropiedad;

    public Property() {
    }

    public float getValorPropiedad() {
        return valorPropiedad;
    }

    public void setValorPropiedad(float valorPropiedad) {
        this.valorPropiedad = valorPropiedad;
    }

    public String getUbicacionPropiedad() {
        return ubicacionPropiedad;
    }

    public void setUbicacionPropiedad(String ubicacionPropiedad) {
        this.ubicacionPropiedad = ubicacionPropiedad;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public int getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    public int getEstrato() {
        return estrato;
    }

    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }

    public void setNombrePropiedad(String nombrePropiedad) {
        this.nombrePropiedad = nombrePropiedad;
    }

    public String getNombrePropiedad() {
        return nombrePropiedad;
    }

    public int getIdPropiedad() {
        return id;
    }

    public void setIdPropiedad(int nuevaId) {
        this.id = nuevaId;
    }
}


