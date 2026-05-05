package realEstate.config;

import realEstate.persistence.repository.BuyerRepository;
import realEstate.persistence.repository.PropertyRepository;
import realEstate.persistence.repository.SellerRepository;
import realEstate.service.PropertyService;

public class Config {
    
    // Repositories
    private PropertyRepository propertyRepo = new PropertyRepository();
    private SellerRepository sellerRepo = new SellerRepository();
    private BuyerRepository buyerRepo = new BuyerRepository();

    // Services 
    private PropertyService propertyService = new PropertyService(propertyRepo);
    //private SellerService sellerService = new SellerService(sellerRepo, propertyService);
    //private BuyerService buyerService = new BuyerService(buyerRepo, propertyService);

}
