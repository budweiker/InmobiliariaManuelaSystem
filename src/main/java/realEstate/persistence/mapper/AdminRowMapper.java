package realEstate.persistence.mapper;

import realEstate.domain.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRowMapper extends UserRowMapper<Admin>{
    @Override
    public Admin mapRow(ResultSet rs) throws SQLException {
        Admin admin = new Admin();
        mapUserFields(rs, admin);
        admin.setAdminType(rs.getString("admin_type"));
        return admin;
    }
}
