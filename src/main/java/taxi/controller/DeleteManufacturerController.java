package taxi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import taxi.lib.Injector;
import taxi.service.manufacturer.ManufacturerService;

@WebServlet(urlPatterns = "/manufacturers/delete")
public class DeleteManufacturerController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("org.example");
    private final ManufacturerService manufacturerService
            = (ManufacturerService) injector.getInstance(ManufacturerService.class);

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String reqid = req.getParameter("manufacturer_id");
        if (reqid == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        Long id = Long.parseLong(reqid);
        manufacturerService.delete(id);
        resp.sendRedirect(req.getContextPath() + "/cars");
    }
}
