package realEstate.service;
import realEstate.domain.Seller;
import realEstate.persistence.repository.SellerRepository;
import realEstate.domain.Property;
import realEstate.util.TypeValidator;
import java.util.Collection;

public class SellerService {
    static TypeValidator tv = new TypeValidator();
    private SellerRepository repository;
    public SellerService(){
        this.repository = new SellerRepository();
    }
    public Collection<Seller> SelectAllSellers(){
        if(repository == null){
            tv.Mensaje("No hay ningun vendedor por el momento");
            return null;
        }else
            return repository.listarTodos();
    }
    public void borrarSeller(Seller s){
        repository.eliminar(s.getId());
    }
    public void agregarSeller(Seller s){
        repository.agregar(s);

    }
    public Seller buscarSeller(int id){
        return repository.buscar(id);
    }

    
}
