package realEstate.service.portInput;

import realEstate.domain.Buyer;

import java.util.Collection;

public interface BuyerService {
    Collection<Buyer> selectAllBuyers();
    void deleteBuyer(Buyer b);
    Buyer addBuyer(Buyer b);
    Buyer findBuyer(int id);
}
