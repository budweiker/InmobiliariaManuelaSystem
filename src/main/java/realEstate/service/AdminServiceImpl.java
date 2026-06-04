package realEstate.service;

import realEstate.domain.Admin;
import realEstate.service.portInput.AdminService;
import realEstate.service.portOutput.AdminPersistencePort;
import realEstate.util.TypeValidator;

import java.util.Collection;
import java.util.Collections;

public class AdminServiceImpl implements AdminService {
    private final TypeValidator tv = new TypeValidator();
    private final AdminPersistencePort repository;

    public AdminServiceImpl(AdminPersistencePort repository) {
        this.repository = repository;
    }

    public Collection<Admin> selectAllAdmins() {
        Collection<Admin> lista = repository.listarTodos();
        if (lista.isEmpty()) {
            tv.Mensaje("No hay ningun administrador por el momento");
            return Collections.emptyList();
        }
        return lista;
    }

    public void deleteAdmin(int id) {
        repository.eliminar(id);
    }

    public Admin addAdmin(Admin a) {
        return repository.agregar(a);
    }

    public Admin findAdmin(int id) {
        return repository.buscar(id);
    }

    public Admin findByCorreo(String correo) {return repository.buscarPorCorreo(correo);}
}

