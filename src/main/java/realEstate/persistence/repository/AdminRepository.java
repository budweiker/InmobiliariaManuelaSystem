package realEstate.persistence.repository;
import java.util.Collection;
import java.util.HashMap;
import realEstate.domain.Admin;
import realEstate.service.portOutput.AdminPersistencePort;

public class AdminRepository implements AdminPersistencePort {
    HashMap<Integer, Admin> administradores = new HashMap<>();
    public Admin agregar(Admin a){
        administradores.put(a.getId(), a);
        return a;
    }
    public void eliminar(int id){
        administradores.remove(id);
    }
    public Admin buscar(int id){
        return administradores.get(id);
    }

    @Override
    public Admin buscarPorCorreo(String correo) {
        for (Admin a : administradores.values()) {
            if (a.getCorreo().equals(correo)) {
                return a;
            }
        }
        return null;
    }

    public Collection<Admin> listarTodos(){
        return administradores.values();
    }
}
