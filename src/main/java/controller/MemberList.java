package controller;

import dto.Facility;
import service.FacilityService;
import service.IFacilityService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/facility/list")
public class MemberList extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MemberList() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        IFacilityService facilityService = new FacilityService();
        try{
            List<Facility> facilityList = facilityService.getAllFacilities();
            request.setAttribute("facilityList", facilityList);
            request.getRequestDispatcher("/list.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
