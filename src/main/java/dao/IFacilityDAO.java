package dao;

import dto.Facility;

import java.sql.SQLException;
import java.util.List;

public interface IFacilityDAO {
    List<Facility> getAllFacilities() throws SQLException;
    Facility getFacilityById(String fac_id) throws SQLException;
    void updateFacility(Facility facility) throws SQLException;
}
