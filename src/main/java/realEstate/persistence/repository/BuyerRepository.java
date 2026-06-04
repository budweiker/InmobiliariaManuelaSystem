package realEstate.persistence.repository;
import java.util.Collection;
import java.util.HashMap;
import realEstate.domain.Buyer;
import realEstate.service.portOutput.BuyerPersistentPort;

public class BuyerRepository implements BuyerPersistentPort {
    HashMap<Integer, Buyer> compradores = new HashMap<>();
    public Buyer agregar(Buyer b){
        compradores.put(b.getId(), b);
        return b;
    }
    public void eliminar(int id){
        compradores.remove(id);
    }
    @Override
    public Buyer buscarPorCorreo(String correo){
        for (Buyer b : compradores.values()){
            if (b.getCorreo().equals(correo)) {
                return b;
            }
        }
        return null;
    }
    public Buyer buscar(int id){
        return compradores.get(id);
    }
    public Collection<Buyer> listarTodos(){
        return compradores.values();
    }

}
