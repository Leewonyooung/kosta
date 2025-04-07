package service;

import dao.FacilityDAO;
import dao.IFacilityDAO;
import dto.Facility;

import java.sql.SQLException;
import java.util.List;

public class FacilityService implements IFacilityService {

    IFacilityDAO facilityDAO = new FacilityDAO();

    @Override
    public List<Facility> getAllFacilities() throws SQLException {
        return facilityDAO.getAllFacilities();
    }

    @Override
    public Facility getFacilityById(String fac_id) throws SQLException {
        return facilityDAO.getFacilityById(fac_id);
    }

    @Override
    public void updateFacility(Facility facility) throws SQLException {
        facilityDAO.updateFacility(facility);
    }
}
