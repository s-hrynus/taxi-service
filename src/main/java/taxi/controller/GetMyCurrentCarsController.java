package taxi.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import taxi.lib.Injector;
import taxi.model.Car;
import taxi.service.car.CarService;

public class GetMyCurrentCarsController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("org.example");

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        CarService carService = (CarService) injector.getInstance(CarService.class);
        Long currentDriverId = (Long) req.getSession().getAttribute("driverId");
        List<Car> cars = carService.getAllByDriver(currentDriverId);
        req.setAttribute("cars", cars);
        req.getRequestDispatcher("/WEB-INF/views/cars/index.jsp").forward(req, resp);
    }
}
