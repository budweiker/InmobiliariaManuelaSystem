package realEstate.service;
import realEstate.domain.Buyer;
import realEstate.persistence.repository.BuyerRepository;
import realEstate.util.TypeValidator;
import java.util.Collection;


public class BuyerService {
    static TypeValidator tv = new TypeValidator();
    private BuyerRepository repository;
    public BuyerService(){
        this.repository = new BuyerRepository();
    }
    public Collection<Buyer> SelectAllSellers(){
        if(repository == null){
            tv.Mensaje("No hay ningun comprador por el momento");
            return null;
        }else
            return repository.listarTodos();
    }
    public void borrarSeller(Buyer b){
        repository.eliminar(b.getId());
    }
    public void agregarSeller(Buyer b){
        repository.agregar(b);

    }
    public Buyer buscarSeller(int id){
        return repository.buscar(id);
    }

    
}
