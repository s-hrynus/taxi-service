package taxi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import taxi.lib.Injector;
import taxi.model.Driver;
import taxi.service.driver.DriverService;

@WebServlet(urlPatterns = "/drivers/add")
public class CreateDriverController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("org.example");
    private final DriverService driverService
            = (DriverService) injector.getInstance(DriverService.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        String licenseNumber = req.getParameter("licenseNumber");
        if (name == null || licenseNumber == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        driverService.create(new Driver(name, licenseNumber));
        resp.sendRedirect(req.getContextPath() + "/drivers");
    }
}
