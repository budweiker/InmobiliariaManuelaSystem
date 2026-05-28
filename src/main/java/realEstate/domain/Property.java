package realEstate.domain;

public class Property {
    private int id;
    private float valorPropiedad;
    private String ubicacionPropiedad;
    private String direccion;
    private int habitaciones;
    private int estrato;
    private String barrio;

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public void setBarrio(String barrio) {
        this.barrio= barrio;
    }

    public String getBarrio() {
        return barrio;
    }

    public int getIdPropiedad() {
        return id;
    }

    public void setIdPropiedad(int nuevaId) {
        this.id = nuevaId;
    }
}


