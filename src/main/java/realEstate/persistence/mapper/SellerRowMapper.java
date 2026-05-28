package realEstate.persistence.mapper;

import realEstate.domain.Seller;

import java.sql.ResultSet;

public class SellerRowMapper extends UserRowMapper<Seller>{
    @Override
    public Seller mapRow(ResultSet rs) throws java.sql.SQLException {
        Seller seller = new Seller();
        mapUserFields(rs, seller);
        seller.setPropiedadesVendidas(rs.getInt("propiedadesVendidas"));
        seller.setBalance(rs.getFloat("balance"));
        return seller;
    }

}
