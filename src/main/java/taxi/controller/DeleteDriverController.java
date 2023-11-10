package taxi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import taxi.lib.Injector;
import taxi.service.driver.DriverService;

@WebServlet(urlPatterns = "/drivers/delete")
public class DeleteDriverController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("org.example");
    private final DriverService driverService
            = (DriverService) injector.getInstance(DriverService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String reqId = req.getParameter("id");
        if (reqId == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        Long id = Long.parseLong(reqId);
        driverService.delete(id);
        resp.sendRedirect(req.getContextPath() + "/drivers");
    }
}
