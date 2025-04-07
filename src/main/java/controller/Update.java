package controller;

import dto.Facility;
import service.FacilityService;
import service.IFacilityService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/facility/update")
public class Update extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Update() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IFacilityService facilityService = new FacilityService();

        try {
            Facility facility = facilityService.getFacilityById(request.getParameter("id"));
            request.setAttribute("facility", facility);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        IFacilityService facilityService = new FacilityService();
        try {
            Facility prevFacility = facilityService.getFacilityById(request.getParameter("id"));
            String fac_type_name = request.getParameter("fac_type_name");
            String fac_nm = request.getParameter("fac_nm");
            Integer price = Integer.valueOf(request.getParameter("price"));
            String available_time = request.getParameter("available_time");
            String etc = request.getParameter("etc");
            facilityService.updateFacility(new Facility(
                    prevFacility.getFac_id(),
                    prevFacility.getFac_type(),
                    fac_type_name == null ? prevFacility.getFac_type_name() : fac_type_name,
                    fac_nm  == null ? prevFacility.getFac_nm() : fac_nm,
                    price,
                    available_time == null ? prevFacility.getAvailable_time() : available_time,
                    etc == null ? prevFacility.getEtc() : etc
            ));
            response.sendRedirect("/facility/list");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
