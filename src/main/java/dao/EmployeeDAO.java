package dao;

import dto.Employee;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisSqlSessionFactory;

public class EmployeeDAO implements IEmployeeDAO {

    SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
    @Override
    public Employee selectEmployeeById(String emp_no) throws Exception {
        return sqlSession.selectOne("mapper.employee.selectEmployeeById", emp_no);
    }

    @Override
    public void insertEmployee(Employee employee) throws Exception {
        sqlSession.insert("mapper.employee.insertEmployee", employee);
        sqlSession.commit(); // mybatis를 사용하면 autocommit이 설정이 안되어 있다.
    }
}
