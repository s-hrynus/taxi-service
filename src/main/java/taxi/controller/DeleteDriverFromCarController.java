package taxi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import taxi.lib.Injector;
import taxi.service.car.CarService;
import taxi.service.driver.DriverService;

@WebServlet(urlPatterns = "/cars/drivers/delete")
public class DeleteDriverFromCarController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("org.example");
    private final CarService carService
            = (CarService) injector.getInstance(CarService.class);
    private final DriverService driverService
            = (DriverService) injector.getInstance(DriverService.class);

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String reqCarId = req.getParameter("car_id");
        String reqDriverId = req.getParameter("driver_id");
        if (reqCarId == null || reqDriverId == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        Long carId = Long.parseLong(reqCarId);
        Long driverId = Long.parseLong(reqDriverId);
        carService.removeDriverFromCar(driverService.get(driverId), carService.get(carId));
        resp.sendRedirect(req.getContextPath() + "/cars/drivers?carId=" + carId);
    }
}
