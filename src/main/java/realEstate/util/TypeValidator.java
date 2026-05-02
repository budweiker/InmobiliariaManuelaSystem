package realEstate.util;
public class TypeValidator{
    static InputValidator a = new InputValidator();
    public TypeValidator() {

    }
    public void Mensaje(String texto){
        a.Mensaje(texto);
    }
    public int leerInt(String texto){
        return a.leerInt(texto);
    }
    public float leerFloat(String texto){
        return a.leerFloat(texto);
    }
    public String leerString(String texto){
        return a.leerString(texto);
    }
    public int leerIntEnRango(int maximo, int minimo, String texto){
        return a.leerEnEnteroEnRango(maximo, minimo, texto);
    }
    public float leerFloatEnRango(float maximo, float minimo, String texto){
        return a.leerEnFloatEnRango(maximo, minimo, texto);
    }


}