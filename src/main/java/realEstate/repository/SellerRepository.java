package realEstate.repository;
import java.util.Collection;
import java.util.HashMap;
import realEstate.domain.Seller;
public class SellerRepository {
    HashMap<Integer, Seller> vendedores = new HashMap<>();
    public void agregar(Seller s){
        vendedores.put(s.getId(), s);
    }
    public void eliminar(int id){
        vendedores.remove(id);
    }
    public Seller buscar(int id){
        return vendedores.get(id);
    }
    public Collection<Seller> listarTodos(){
        return vendedores.values();
    }
}
