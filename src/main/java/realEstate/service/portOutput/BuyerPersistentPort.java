package realEstate.service.portOutput;

import realEstate.domain.Buyer;

import java.util.Collection;

public interface BuyerPersistentPort {
        void eliminar(int id);
        Buyer buscarPorCorreo(String correo);
        Buyer buscar(int id);
        Collection<Buyer> listarTodos();
        Buyer agregar(Buyer b);
}
