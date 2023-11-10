package taxi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import taxi.lib.Injector;
import taxi.model.Manufacturer;
import taxi.service.manufacturer.ManufacturerService;

@WebServlet(urlPatterns = "/manufacturers/add")
public class CreateManufacturerController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("org.example");
    private final ManufacturerService manufacturerService
            = (ManufacturerService) injector.getInstance(ManufacturerService.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        String country = req.getParameter("country");
        if (name == null || country == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        Manufacturer manufacturer = new Manufacturer(country, name);
        manufacturerService.create(manufacturer);
        resp.sendRedirect(req.getContextPath() + "/cars");
    }
}
