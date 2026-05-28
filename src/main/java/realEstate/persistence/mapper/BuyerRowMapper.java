package realEstate.persistence.mapper;

import realEstate.domain.Buyer;

import java.sql.ResultSet;

public class BuyerRowMapper extends UserRowMapper<Buyer> {
    @Override
    public Buyer mapRow(ResultSet rs) throws java.sql.SQLException {
        Buyer buyer = new Buyer();
        mapUserFields(rs, buyer);
        buyer.setPropiedadDeInteresActual(rs.getString("propiedadDeInteresActual"));
        buyer.setBalance(rs.getFloat("balance"));
        return buyer;
    }
}
