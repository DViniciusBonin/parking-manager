package br.edu.utfpr.parking_manager.controller;

import br.edu.utfpr.parking_manager.model.domain.Car;
import br.edu.utfpr.parking_manager.service.CarService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CarController", value = "/carro")
public class CarController extends HttpServlet {
    private CarService carService = new CarService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        if(id == null || id.isEmpty() || id == "") {
            response.sendRedirect("carros");
        }else {
            Car car = this.carService.getById(Long.valueOf(id));
            if(car.getParked() == true) {
                car.setUpdated_at(null);
            }
            request.setAttribute("car", car);
            request.getRequestDispatcher("/WEB-INF/view/car.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
