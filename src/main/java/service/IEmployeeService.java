package service;

import dto.Employee;

public interface IEmployeeService {
    Employee selectEmployeeById(String id) throws Exception;
    void insertEmployee(Employee employee) throws Exception;

}
