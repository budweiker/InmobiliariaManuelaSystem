package realEstate.userInterface;
import realEstate.util.TypeValidator;
public class MenuApp {
    TypeValidator tv = new TypeValidator();
    int option = 0;
    public void mainMenu(){
        String a = "Bienvenido a inmobiliaria Manuela Bermudez Realtor\n" +
                            "Selecciona una opción:\n" +
                            "1. Explorar propiedades\n" +
                            "2. Iniciar sesión\n" +
                            "3. Salir";
        while (option != 3){
        option = tv.leerIntEnRango(1, 3, a);
            switch (option) {
                case 1:
                    tv.Mensaje("Ver propiedades");
                    break;
                case 2:
                   tv.Mensaje("Iniciar Sesión");
                    break;
                case 3:
                    tv.Mensaje("Has salido del sistema gracias por visitas mucha suerte =D! ");
            }
        }
    }
}
