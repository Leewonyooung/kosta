package dao;

import dto.Employee;

public interface IEmployeeDAO {
    Employee selectEmployeeById(String id) throws Exception;
    void insertEmployee(Employee employee) throws Exception;
}
