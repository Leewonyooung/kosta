package dao;

import dto.Facility;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisSqlSessionFactory;

import java.sql.SQLException;
import java.util.List;

public class FacilityDAO implements IFacilityDAO{

    SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();


    @Override
    public List<Facility> getAllFacilities() throws SQLException {
        List<Facility> facilityList = sqlSession.selectList("mapper.facility.getAllFacilities");
        if(facilityList.isEmpty()){
            throw new SQLException();
        }
        return facilityList;
    }

    @Override
    public Facility getFacilityById(String fac_id) throws SQLException {
        Facility facility = sqlSession.selectOne("mapper.facility.getFacilityById", fac_id);
        if(facility == null){
            throw new SQLException();
        }
        return facility;
    }

    @Override
    public void updateFacility(Facility facility) throws SQLException {
        if(facility.getFac_id() == null){
            throw new SQLException();
        }
        sqlSession.update("mapper.facility.updateFacility", facility);
        sqlSession.commit();
    }

}
