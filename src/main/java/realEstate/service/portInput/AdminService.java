package realEstate.service.portInput;

import realEstate.domain.Admin;

import java.util.Collection;

public interface AdminService {
    Collection<Admin> selectAllAdmins();
    void deleteAdmin(int id);
    Admin addAdmin(Admin a);
    Admin findAdmin(int id);
}
