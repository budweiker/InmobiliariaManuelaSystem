package realEstate.util;

import javax.swing.JOptionPane;

public class InputValidator{

    public InputValidator(){

   
    }
    //region System.out.println 
    public void Mensaje(String texto){
        JOptionPane.showMessageDialog(null, texto);
    }
     //endregion
    //region validarTipos
    public int leerInt(String texto){
        try{
            return Integer.parseInt(JOptionPane.showInputDialog(null, texto));
        }
        catch(Exception ex){
             Mensaje("Error, tipo de dato entero no valido");
             return leerInt(texto);
        }

    }
   

    public float leerFloat (String texto){
        try{
            return Float.parseFloat(JOptionPane.showInputDialog(null, texto));
        }
        catch(Exception ex){
            Mensaje("Error, tipo de dato no valido, porfavor intente nuevamente");
        return leerFloat(texto);
        }
    }
public String leerString(String Texto)
{
    String Dato = JOptionPane.showInputDialog(null, Texto).trim();

    if (Dato.isEmpty())
    {
        Mensaje("Valor no válido, debe ser un texto diferente de vacío, reintente por favor");
        return leerString(Texto);
    }
    else
        return Dato;
}
    //endregion
    //region metodos para leer en rango para int y float
    public int LeerEnEnteroEnRango(int numero, int maximo, int minimo,String texto){
        numero = leerInt(texto);
        if(numero > minimo  && numero < maximo)
            return numero;
        else{
            Mensaje("Ingrese un numero dentro del rango dado: " + minimo + " - " + maximo);
            return LeerEnEnteroEnRango(numero, maximo, minimo, texto);

        }

    }
    public int LeerEnFloatEnRango(int numero, int maximo, int minimo,String texto){
        numero = leerInt(texto);
        if(numero > minimo  && numero < maximo)
            return numero;
        else{
            Mensaje("Ingrese un numero dentro del rango dado: " + minimo + " - " + maximo);
            return LeerEnEnteroEnRango(numero, maximo, minimo, texto);

        }

    }
    //endregion



   
}