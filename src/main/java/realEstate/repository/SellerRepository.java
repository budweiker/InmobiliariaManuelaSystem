package realEstate.repository;
import java.util.Collection;
import java.util.HashMap;
import realEstate.domain.Seller;
public class SellerRepository {
    HashMap<String, Seller> vendedores = new HashMap<>();
    public void agregar(Seller s){
        vendedores.put(s.getNombre(), s);
    }
    public void eliminar(String nombre){
        vendedores.remove(nombre);
    }
    public Seller buscar(String nombre){
        return vendedores.get(nombre);
    }
    public Collection<Seller> listarTodos(){
        return vendedores.values();
    }
}
