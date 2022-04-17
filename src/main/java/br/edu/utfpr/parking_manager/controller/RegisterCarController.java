package br.edu.utfpr.parking_manager.controller;

import br.edu.utfpr.parking_manager.model.domain.Brand;
import br.edu.utfpr.parking_manager.model.domain.Car;
import br.edu.utfpr.parking_manager.service.BrandService;
import br.edu.utfpr.parking_manager.service.CarService;
import br.edu.utfpr.parking_manager.util.Constants;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RegisterCarController", value = "/registrar-carros")
public class RegisterCarController extends HttpServlet {
    private CarService carService = new CarService();
    private BrandService brandServie = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/register-car.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer brandId = Integer.valueOf(request.getParameter("brand"));
        String model = request.getParameter("model");
        String placa = request.getParameter("placa");
        String color = request.getParameter("color");

        Brand brand = this.brandServie.getById(Long.valueOf(brandId));
        Car car = new Car(model, placa, color, brand);
        this.carService.save(car);
        List<Car> cars = this.carService.findAll();
        request.setAttribute("flash.cars", cars);
        response.sendRedirect("carros");
    }
}
