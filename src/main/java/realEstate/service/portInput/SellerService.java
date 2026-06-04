package realEstate.service.portInput;

import realEstate.domain.Seller;

import java.util.Collection;

public interface SellerService {
    Collection<Seller> selectAllSellers();
    void deleteSeller(Seller s);
    Seller addSeller(Seller s);
    Seller findSeller(int id);
}
