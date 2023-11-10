package taxi.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import taxi.lib.Injector;
import taxi.model.Car;
import taxi.model.Manufacturer;
import taxi.service.car.CarService;
import taxi.service.manufacturer.ManufacturerService;

@WebServlet(urlPatterns = "/cars")
public class DisplayAllCarsController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("org.example");
    private final CarService carService
            = (CarService) injector.getInstance(CarService.class);
    private final ManufacturerService manufacturerService
            = (ManufacturerService) injector.getInstance(ManufacturerService.class);

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Car> cars = carService.getAll();
        req.setAttribute("cars", cars);
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        req.setAttribute("manufacturers", manufacturers);
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
    }
}
