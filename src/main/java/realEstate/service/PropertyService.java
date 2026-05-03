package realEstate.service;
import realEstate.domain.Property;
import realEstate.repository.PropertyRepository;
import realEstate.util.InputValidator;
import realEstate.util.TypeValidator;
public class PropertyService {
    private PropertyRepository repo;
    public PropertyService(PropertyRepository repo){
        this.repo = repo;
    }

    
}
