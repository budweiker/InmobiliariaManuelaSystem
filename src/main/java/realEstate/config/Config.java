package realEstate.config;

import realEstate.persistence.db.DataBaseConnection;
import realEstate.persistence.mapper.PropertyRowMapper;
import realEstate.persistence.repository.*;
import realEstate.service.AdminService;
import realEstate.service.BuyerService;
import realEstate.service.PropertyServiceImpl;
import realEstate.service.SellerService;
import realEstate.service.portOutput.PropertyPersistencePort;
import realEstate.userInterface.MenuApp;
import realEstate.view.AdminView;
import realEstate.view.BuyerView;
import realEstate.view.PropertyView;
import realEstate.view.SellerView;
import realEstate.persistence.repository.PropertyRepositoryDB;

import java.sql.Connection;

public class Config {
    private final PropertyRepository propertyRepo;
    private final SellerRepository sellerRepo;
    private final BuyerRepository buyerRepo;
    private final AdminRepository adminRepo;

    private final PropertyServiceImpl propertyServiceImpl;
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

        propertyServiceImpl = new PropertyServiceImpl(propertyRepo);
        sellerService = new SellerService(sellerRepo);
        buyerService = new BuyerService(buyerRepo);
        adminService = new AdminService(adminRepo);

        propertyView = new PropertyView(propertyServiceImpl);
        sellerView = new SellerView(sellerService);
        buyerView = new BuyerView(buyerService);
        adminView = new AdminView(adminService);

        menuApp = new MenuApp(propertyView, sellerView, buyerView, adminView);

        Connection connection = DataBaseConnection.getInstance().getConnection();
        PropertyPersistencePort propertyRepositoryDB = new PropertyRepositoryDB(connection);
        PropertyRowMapper propertyRowMapper = new PropertyRowMapper();
    }

    public MenuApp getMenuApp() {
        return menuApp;
    }
}

