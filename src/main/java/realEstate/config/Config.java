package realEstate.config;

import realEstate.persistence.db.DataBaseConnection;
import realEstate.persistence.repository.*;
import realEstate.service.AdminServiceImpl;
import realEstate.service.BuyerServiceImpl;
import realEstate.service.PropertyServiceImpl;
import realEstate.service.SellerServiceImpl;
import realEstate.service.portOutput.AdminPersistencePort;
import realEstate.service.portOutput.BuyerPersistentPort;
import realEstate.service.portOutput.PropertyPersistencePort;
import realEstate.service.portOutput.SellerPersistentPort;
import realEstate.userInterface.MenuApp;
import realEstate.view.AdminView;
import realEstate.view.BuyerView;
import realEstate.view.PropertyView;
import realEstate.view.SellerView;
import realEstate.persistence.repository.PropertyRepositoryDB;
import realEstate.persistence.repository.AdminRepositoryDB;

import java.sql.Connection;

public class Config {
/*    private final SellerRepository sellerRepo;
    private final BuyerRepository buyerRepo;
    private final AdminRepository adminRepo;*/

    private final PropertyServiceImpl propertyServiceImpl;
    private final SellerServiceImpl sellerServiceImpl;
    private final BuyerServiceImpl buyerServiceImpl;
    private final AdminServiceImpl adminServiceImpl;

    private final PropertyView propertyView;
    private final SellerView sellerView;
    private final BuyerView buyerView;
    private final AdminView adminView;
    private final MenuApp menuApp;

    public Config() {
/*      sellerRepo = new SellerRepository();
        buyerRepo = new BuyerRepository();
        adminRepo = new AdminRepository();*/

        Connection connection = DataBaseConnection.getInstance().getConnection();
        //repositories DB
        PropertyPersistencePort propertyRepositoryDB = new PropertyRepositoryDB(connection);
        AdminPersistencePort adminRepositoryDB  = new AdminRepositoryDB(connection);
        SellerPersistentPort sellerRepositoryDB = new SellerRepositoryDB(connection);
        BuyerPersistentPort buyerRepositoryDB  = new BuyerRepositoryDB(connection);

        //Services
        propertyServiceImpl = new PropertyServiceImpl(propertyRepositoryDB);
        adminServiceImpl = new AdminServiceImpl(adminRepositoryDB);
        sellerServiceImpl = new SellerServiceImpl(sellerRepositoryDB);
        buyerServiceImpl = new BuyerServiceImpl(buyerRepositoryDB);
/*        sellerServiceImpl = new SellerServiceImpl(sellerRepo);
        buyerServiceImpl = new BuyerServiceImpl(buyerRepo);
        adminServiceImpl = new AdminServiceImpl(adminRepo);*/

        propertyView = new PropertyView(propertyServiceImpl);
        sellerView = new SellerView(sellerServiceImpl);
        buyerView = new BuyerView(buyerServiceImpl);
        adminView = new AdminView(adminServiceImpl);

        menuApp = new MenuApp(propertyView, sellerView, buyerView, adminView);
    }

    public MenuApp getMenuApp() {
        return menuApp;
    }
}

