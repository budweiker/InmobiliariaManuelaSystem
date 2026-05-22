package realEstate.service;

import realEstate.domain.Seller;
import realEstate.persistence.repository.SellerRepository;
import realEstate.util.TypeValidator;

import java.util.Collection;
import java.util.Collections;

public class SellerService {
    private final TypeValidator tv = new TypeValidator();
    private final SellerRepository repository;

    public SellerService() {
        this(new SellerRepository());
    }

    public SellerService(SellerRepository repository) {
        this.repository = repository;
    }

    public Collection<Seller> selectAllSellers() {
        if (repository == null) {
            tv.Mensaje("No hay ningun vendedor por el momento");
            return Collections.emptyList();
        }
        return repository.listarTodos();
    }

    public void deleteSeller(Seller s) {
        repository.eliminar(s.getId());
    }

    public void addSeller(Seller s) {
        repository.agregar(s);
    }

    public Seller findSeller(int id) {
        return repository.buscar(id);
    }
}

