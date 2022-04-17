package br.edu.utfpr.parking_manager.controller;

import br.edu.utfpr.parking_manager.model.domain.Car;
import br.edu.utfpr.parking_manager.service.CarService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.ZonedDateTime;

@WebServlet(name = "RegisterDepartureController", value = "/registrar-saida")
public class RegisterDepartureController extends HttpServlet {
    private CarService carService = new CarService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Car car = this.carService.getById(Long.valueOf(id));
        car.setUpdated_at(ZonedDateTime.now());
        car.setParked(false);
        this.carService.update(car);
        request.setAttribute("flash.car", car);
        response.sendRedirect("carro?id=" + car.getId());
    }
}
