package realEstate.config;

import realEstate.repository.BuyerRepository;
import realEstate.repository.PropertyRepository;
import realEstate.repository.SellerRepository;
import realEstate.service.BuyerService;
import realEstate.service.PropertyService;
import realEstate.service.SellerService;

public class Config {
    
    // Repositories
    private PropertyRepository propertyRepo = new PropertyRepository();
    private SellerRepository sellerRepo = new SellerRepository();
    private BuyerRepository buyerRepo = new BuyerRepository();

    // Services 
    private PropertyService propertyService = new PropertyService(propertyRepo);
    private SellerService sellerService = new SellerService(sellerRepo, propertyService);
    private BuyerService buyerService = new BuyerService(buyerRepo, propertyService);

}
