package br.edu.utfpr.parking_manager.controller;

import br.edu.utfpr.parking_manager.model.domain.Car;
import br.edu.utfpr.parking_manager.service.CarService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListCarsController", value = "/carros")
public class ListCarsController extends HttpServlet {
    private CarService carService = new CarService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Car> cars = this.carService.findAll();
        List<Car> carsParked = new ArrayList();
        for (Car car: cars) {
            if(car.getParked() == true) {
                carsParked.add(car);
            }
        }
        request.setAttribute("cars", carsParked);
        request.getRequestDispatcher("/WEB-INF/view/list-cars.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
