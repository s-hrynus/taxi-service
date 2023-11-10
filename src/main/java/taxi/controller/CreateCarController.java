package taxi.controller;

import java.io.IOException;
import java.util.Collections;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import taxi.lib.Injector;
import taxi.model.Car;
import taxi.service.car.CarService;
import taxi.service.manufacturer.ManufacturerService;

@WebServlet(urlPatterns = "/cars/add")
public class CreateCarController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("org.example");
    private final CarService carService
            = (CarService) injector.getInstance(CarService.class);
    private final ManufacturerService manufacturerService
            = (ManufacturerService) injector.getInstance(ManufacturerService.class);

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {
        String model = req.getParameter("model");
        String reqManufacturerId = req.getParameter("manufacturer_id");
        if (model == null || reqManufacturerId == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        Long manufacturerId = Long.valueOf(reqManufacturerId);
        Car car = new Car(model, manufacturerService.get(manufacturerId),
                Collections.emptyList());
        carService.create(car);
        resp.sendRedirect(req.getContextPath() + "/cars");
    }
}
