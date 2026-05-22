package realEstate.service;

import realEstate.domain.Buyer;
import realEstate.persistence.repository.BuyerRepository;
import realEstate.util.TypeValidator;

import java.util.Collection;
import java.util.Collections;

public class BuyerService {
    private final TypeValidator tv = new TypeValidator();
    private final BuyerRepository repository;

    public BuyerService() {
        this(new BuyerRepository());
    }

    public BuyerService(BuyerRepository repository) {
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

    public void addBuyer(Buyer b) {
        repository.agregar(b);
    }

    public Buyer findBuyer(int id) {
        return repository.buscar(id);
    }
}

