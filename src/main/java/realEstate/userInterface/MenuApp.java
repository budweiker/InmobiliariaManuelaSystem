package realEstate.userInterface;

import java.util.Scanner;

public class MenuApp {

    Scanner sc = new Scanner(System.in);
    public void mainMenu(){
        boolean running = true;
        while (running){
        System.out.println("Bienvenido a inmobiliaria Manuela Bermudez Realtor\n" +
                            "Selecciona una opción:\n" +
                            "1. Explorar propiedades\n" +
                            "2. Iniciar sesión\n" +
                            "3. Salir");
        int option = sc.nextInt();
        sc.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Ver propiedades");
                    break;
                case 2:
                    System.out.println("Iniciar Sesión");
                    break;
                case 3:
                    System.out.println("salir del sistema");
                    running = false;
                default:
                    System.out.println("Ingrese una opción valida");
            }
        }
    }
}
