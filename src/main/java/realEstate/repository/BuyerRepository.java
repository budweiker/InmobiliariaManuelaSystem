package realEstate.repository;
import java.util.Collection;
import java.util.HashMap;
import realEstate.domain.Buyer;
public class BuyerRepository {
    HashMap<Integer, Buyer> compradores = new HashMap<>();
    public void agregar(Buyer b){
        compradores.put(b.getId(), b);
    }
    public void eliminar(int id){
        compradores.remove(id);
    }
    public Buyer buscar(int id){
        return compradores.get(id);
    }
    public Collection<Buyer> listarTodos(){
        return compradores.values();
    }
}
