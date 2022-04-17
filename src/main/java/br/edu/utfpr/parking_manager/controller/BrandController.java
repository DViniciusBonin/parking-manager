package br.edu.utfpr.parking_manager.controller;

import br.edu.utfpr.parking_manager.model.domain.Brand;
import br.edu.utfpr.parking_manager.service.BrandService;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StateController", urlPatterns = "/marcas")
public class BrandController extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Brand> brands =  this.brandService.findAll();

        String json = new Gson().toJson(brands);
        json = new String(json.getBytes(), "UTF-8");

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
