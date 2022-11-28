package com.example.demo4.servlets;

import com.example.demo4.models.Rectangle;
import com.example.demo4.models.Sector;
import com.example.demo4.models.Triangle;
import com.example.demo4.tools.CheckHitManager;
import com.example.demo4.models.Point;
import com.example.demo4.models.Results;
import com.example.demo4.tools.Validator;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "AreaCheckServlet", urlPatterns = "/area")
public class AreaCheckServlet extends HttpServlet {
    private final Validator validator = new Validator();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final long start = System.nanoTime();

        double x, y;
        int r;

        try {
            x = Double.parseDouble(request.getParameter("x_coord"));
            y = Double.parseDouble(request.getParameter("y_coord"));
            r = Integer.parseInt(request.getParameter("r_coord"));
        } catch (NullPointerException | NumberFormatException e) {
            response.sendError(400, "Invalid coordinates\n" + e);
            return;
        }

        if (!validator.validate(x, y, (int) r)) {
            response.sendError(400, "Invalid value");
            return;
        }

        Triangle triangle = new Triangle();
        Rectangle rectangle = new Rectangle();
        Sector sector = new Sector();
        Point point = new Point(x, y, r, LocalDateTime.now(), System.nanoTime()-start, new CheckHitManager(x, y, r).hasHit(sector, rectangle, triangle));

        ServletContext servletContext = request.getServletContext();
        if(servletContext.getAttribute("Collection") == null){
            servletContext.setAttribute("Collection",new Results());

        }
        Results results = ((Results) servletContext.getAttribute("Collection"));

        results.add(point);
        request.getRequestDispatcher( "/table.jsp").forward(request,response);

    }
}


