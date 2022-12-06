package com.example.demo4.servlets;

import com.example.demo4.models.Point;
import com.example.demo4.models.Service;
import com.example.demo4.models.Results;
import com.example.demo4.tools.Validation;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "AreaCheckServlet", urlPatterns = "/area")
public class AreaCheckServlet extends HttpServlet {
    Service service = new Service();
    Point point;
    private final Validation validator = new Validation();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final long start = System.nanoTime();
        double x, y;
        int r;

        try {
            x = Double.parseDouble(request.getParameter("x_coord"));
            y = Double.parseDouble(request.getParameter("y_coord"));
            r = Integer.parseInt(request.getParameter("r_coord"));
        } catch (NullPointerException | NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return;
        }

        if (!validator.validate(x, y, r)) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return;
        }

        point = service.createPoint(x, y, r, start);

        ServletContext servletContext = request.getServletContext();
        if(servletContext.getAttribute("Collection") == null) {
            servletContext.setAttribute("Collection", new Results());
        }
        Results results = ((Results) servletContext.getAttribute("Collection"));

        results.add(point);
        request.getRequestDispatcher( "/table.jsp").forward(request,response);
    }
}


