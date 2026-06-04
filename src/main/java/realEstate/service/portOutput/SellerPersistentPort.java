package realEstate.service.portOutput;

import realEstate.domain.Seller;

import java.util.Collection;

public interface SellerPersistentPort {
    Seller agregar(Seller s);
    void eliminar(int id);
    Seller buscarPorCorreo(String correo);
    Seller buscar(int id);
    Collection<Seller> listarTodos();
}
