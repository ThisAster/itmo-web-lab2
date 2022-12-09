package com.example.demo4.servlets;

import com.example.demo4.models.Point;
import com.example.demo4.models.Service;
import com.example.demo4.tools.Validation;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AreaCheckServlet", urlPatterns = "/area")
public class AreaCheckServlet extends HttpServlet {
    Service service = new Service();
    Point point;
    private final Validation validator = new Validation();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final long start = System.nanoTime();
        double x, y;
        int r;
        boolean isClick;

        try {
            x = Double.parseDouble(request.getParameter("x_coord"));
            y = Double.parseDouble(request.getParameter("y_coord"));
            r = Integer.parseInt(request.getParameter("r_coord"));
        } catch (NullPointerException | NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return;
        }

        try {
            isClick = Boolean.parseBoolean(request.getParameter("is_click"));
        } catch (NullPointerException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return;
        }

        point = service.createPoint(x, y, r, start, isClick);
        if (!point.isClicked()) {
            if (!validator.validate(x, y, r)) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                request.getRequestDispatcher("/error.jsp").forward(request, response);
                return;
            }
        }



        ServletContext servletContext = request.getServletContext();
        if(servletContext.getAttribute("Collection") == null) {
            servletContext.setAttribute("Collection", new ArrayList<Point>());
        }
        ArrayList<Point> results = (ArrayList<Point>) servletContext.getAttribute("Collection");

        results.add(point);
        request.getRequestDispatcher( "/table.jsp").forward(request,response);
    }
}


