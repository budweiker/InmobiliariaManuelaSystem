package realEstate.domain;

public class Property {
    private float valorPropiedad;
    private String ubicacionPropiedad;
    private int habitaciones;
    private int estrato;
    private String nombrePropiedad;
    public Property(){
        
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
    public void setnombrePropiedad(String a){
        this.nombrePropiedad = a;
    }
    public String getnombrePropiedad(){
        return nombrePropiedad;
    }
}


