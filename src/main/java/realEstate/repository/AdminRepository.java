package realEstate.repository;
import java.util.Collection;
import java.util.HashMap;
import realEstate.domain.Admin;
public class AdminRepository {
    HashMap<Integer, Admin> administradores = new HashMap<>();
    public void agregar(Admin a){
        administradores.put(a.getId(), a);
    }
    public void eliminar(int id){
        administradores.remove(id);
    }
    public Admin buscar(int id){
        return administradores.get(id);
    }
    public Collection<Admin> listarTodos(){
        return administradores.values();
    }
}
