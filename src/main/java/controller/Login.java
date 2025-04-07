package controller;

import dto.Employee;
import service.EmployeeService;
import service.IEmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/member/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Login() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String emp_no = request.getParameter("empNo");
        String pw = request.getParameter("empPw");
        HttpSession session = request.getSession();
        IEmployeeService employeeService = new EmployeeService();
        try {
            Employee employee = employeeService.selectEmployeeById(emp_no);
            session.setAttribute("empNo", employee.getEmp_no());
            session.setAttribute("empNm", employee.getEmp_nm());
            response.sendRedirect("/facility/list");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
