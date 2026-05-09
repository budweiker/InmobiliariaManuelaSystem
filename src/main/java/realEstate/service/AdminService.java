package realEstate.service;
import realEstate.domain.Admin;
import realEstate.persistence.repository.AdminRepository;
import realEstate.domain.Property;
import realEstate.util.TypeValidator;
import java.util.Collection;


public class AdminService {
    static TypeValidator tv = new TypeValidator();
    private AdminRepository repository;
    public AdminService(){
        this.repository = new AdminRepository();
    }
    public Collection<Admin> SelectAllSellers(){
        if(repository == null){
            tv.Mensaje("No hay ningun comprador por el momento");
            return null;
        }else
            return repository.listarTodos();
    }
    public void borrarSeller(Admin a){
        repository.eliminar(a.getId());
    }
    public void agregarSeller(Admin a){
        repository.agregar(a);

    }
    public Admin buscarSeller(int id){
        return repository.buscar(id);
    }

    
}
