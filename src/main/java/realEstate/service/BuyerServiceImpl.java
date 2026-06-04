package realEstate.service;

import realEstate.domain.Buyer;
import realEstate.persistence.repository.BuyerRepository;
import realEstate.service.portInput.BuyerService;
import realEstate.service.portOutput.BuyerPersistentPort;
import realEstate.util.TypeValidator;

import java.util.Collection;
import java.util.Collections;

public class BuyerServiceImpl implements BuyerService {
    private final TypeValidator tv = new TypeValidator();
    private final BuyerPersistentPort repository;

    public BuyerServiceImpl() {
        this(new BuyerRepository());
    }

    public BuyerServiceImpl(BuyerPersistentPort repository) {
        this.repository = repository;
    }

    public Collection<Buyer> selectAllBuyers() {
        if (repository == null) {
            tv.Mensaje("No hay ningun comprador por el momento");
            return Collections.emptyList();
        }
        return repository.listarTodos();
    }

    public void deleteBuyer(Buyer b) {
        repository.eliminar(b.getId());
    }

    public Buyer addBuyer(Buyer b) {
        repository.agregar(b);
        return b;
    }

    public Buyer findBuyer(int id) {
        return repository.buscar(id);
    }
}

