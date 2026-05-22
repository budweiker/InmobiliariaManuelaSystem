package realEstate.service;

import realEstate.domain.Admin;
import realEstate.persistence.repository.AdminRepository;
import realEstate.util.TypeValidator;

import java.util.Collection;
import java.util.Collections;

public class AdminService {
    private final TypeValidator tv = new TypeValidator();
    private final AdminRepository repository;

    public AdminService() {
        this(new AdminRepository());
    }

    public AdminService(AdminRepository repository) {
        this.repository = repository;
    }

    public Collection<Admin> selectAllAdmins() {
        if (repository == null) {
            tv.Mensaje("No hay ningun administrador por el momento");
            return Collections.emptyList();
        }
        return repository.listarTodos();
    }

    public void deleteAdmin(Admin a) {
        repository.eliminar(a.getId());
    }

    public void addAdmin(Admin a) {
        repository.agregar(a);
    }

    public Admin findAdmin(int id) {
        return repository.buscar(id);
    }
}

