package realEstate.persistence.repository;
import java.util.Collection;
import java.util.HashMap;

import realEstate.domain.Admin;
import realEstate.domain.Seller;
import realEstate.service.portOutput.SellerPersistentPort;

public class SellerRepository implements SellerPersistentPort {
    HashMap<Integer, Seller> vendedores = new HashMap<>();
    public Seller agregar(Seller s){
        vendedores.put(s.getId(), s);
        return s;
    }
    public void eliminar(int id){
        vendedores.remove(id);
    }
    public Seller buscar(int id){
        return vendedores.get(id);
    }

    @Override
    public Seller buscarPorCorreo(String correo) {
        for (Seller s : vendedores.values()) {
            if (s.getCorreo().equals(correo)) {
                return s;
            }
        }
        return null;
    }

    public Collection<Seller> listarTodos(){
        return vendedores.values();
    }
}
