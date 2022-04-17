package br.edu.utfpr.parking_manager.controller;

import br.edu.utfpr.parking_manager.util.Constants;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "home", value = "/home")
public class HomeController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.process(request, response);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) {
        //Escopo de aplicaçao
        Integer counterApplication = (Integer) getServletContext().getAttribute(Constants.COUNTER_APPLICATION);
        if(counterApplication == null){
            counterApplication = 0;
        }
        counterApplication++;
        System.out.println("Sessões na aplicação desde que foi iniciada = " + counterApplication);
        getServletContext().setAttribute(Constants.COUNTER_APPLICATION, counterApplication);
        //Escopo de sessao
        Integer counterSession = (Integer) request.getSession(true).getAttribute(Constants.COUNTER_SESSION);
        if(counterSession == null){
            counterSession = 0;
        }
        counterSession++;
        request.getSession(true).setAttribute(Constants.COUNTER_SESSION, counterSession);

        //Cookies
        Cookie cookie = new Cookie("counter", String.valueOf(counterSession));
        cookie.setMaxAge(60 * 60 * 12);// 12 horas

        response.addCookie(cookie);
    }

}