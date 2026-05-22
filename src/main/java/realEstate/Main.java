package realEstate;

import realEstate.config.Config;
import realEstate.userInterface.MenuApp;

public class Main {
    public static void main(String[] args) {
        Config config = new Config();
        MenuApp menu = config.getMenuApp();
        menu.mainMenu();
    }
}

