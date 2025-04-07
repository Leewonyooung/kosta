package service;

import dao.EmployeeDAO;
import dao.IEmployeeDAO;
import dto.Employee;

public class EmployeeService implements IEmployeeService{

    IEmployeeDAO employeeDAO = new EmployeeDAO();

    @Override
    public Employee selectEmployeeById(String emp_no) throws Exception {
        Employee employee = employeeDAO.selectEmployeeById(emp_no);
        if(employee == null){
            throw new Exception("Employee not found");
        }
        return employee;
    }

    @Override
    public void insertEmployee(Employee employee) throws Exception {
        if(employeeDAO.selectEmployeeById(employee.getEmp_no()) != null){
            throw new Exception("Employee already exist");
        }
        employeeDAO.insertEmployee(employee);
    }
}
