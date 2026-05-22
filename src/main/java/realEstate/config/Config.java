package realEstate.config;

import realEstate.persistence.repository.AdminRepository;
import realEstate.persistence.repository.BuyerRepository;
import realEstate.persistence.repository.PropertyRepository;
import realEstate.persistence.repository.SellerRepository;
import realEstate.service.AdminService;
import realEstate.service.BuyerService;
import realEstate.service.PropertyService;
import realEstate.service.SellerService;
import realEstate.userInterface.MenuApp;
import realEstate.view.AdminView;
import realEstate.view.BuyerView;
import realEstate.view.PropertyView;
import realEstate.view.SellerView;

public class Config {
    private final PropertyRepository propertyRepo;
    private final SellerRepository sellerRepo;
    private final BuyerRepository buyerRepo;
    private final AdminRepository adminRepo;

    private final PropertyService propertyService;
    private final SellerService sellerService;
    private final BuyerService buyerService;
    private final AdminService adminService;

    private final PropertyView propertyView;
    private final SellerView sellerView;
    private final BuyerView buyerView;
    private final AdminView adminView;
    private final MenuApp menuApp;

    public Config() {
        propertyRepo = new PropertyRepository();
        sellerRepo = new SellerRepository();
        buyerRepo = new BuyerRepository();
        adminRepo = new AdminRepository();

        propertyService = new PropertyService(propertyRepo);
        sellerService = new SellerService(sellerRepo);
        buyerService = new BuyerService(buyerRepo);
        adminService = new AdminService(adminRepo);

        propertyView = new PropertyView(propertyService);
        sellerView = new SellerView(sellerService);
        buyerView = new BuyerView(buyerService);
        adminView = new AdminView(adminService);

        menuApp = new MenuApp(propertyView, sellerView, buyerView, adminView);
    }

    public MenuApp getMenuApp() {
        return menuApp;
    }
}

