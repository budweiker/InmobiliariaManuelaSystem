package realEstate.service;

import realEstate.domain.Seller;
import realEstate.persistence.repository.SellerRepository;
import realEstate.service.portInput.SellerService;
import realEstate.service.portOutput.SellerPersistentPort;
import realEstate.util.TypeValidator;

import java.util.Collection;
import java.util.Collections;

public class SellerServiceImpl implements SellerService {
    private final TypeValidator tv = new TypeValidator();
    private final SellerPersistentPort repository;

    public SellerServiceImpl() {
        this(new SellerRepository());
    }

    public SellerServiceImpl(SellerPersistentPort repository) {
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

    public Seller addSeller(Seller s) {
        repository.agregar(s);
        return s;
    }

    public Seller findSeller(int id) {
        return repository.buscar(id);
    }
}

