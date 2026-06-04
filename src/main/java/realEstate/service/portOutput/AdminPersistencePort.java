package realEstate.service.portOutput;

import realEstate.domain.Admin;

import java.util.Collection;

public interface AdminPersistencePort {
    Admin agregar(Admin a);
    void eliminar(int id);
    Admin buscarPorCorreo(String correo);
    Admin buscar(int id);
    Collection<Admin> listarTodos();
}
