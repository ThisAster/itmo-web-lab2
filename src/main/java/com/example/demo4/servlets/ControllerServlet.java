package com.example.demo4.servlets;

import com.example.demo4.models.Point;
import com.example.demo4.models.Results;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "", loadOnStartup = 0, name = "ControllerServlet")
public class ControllerServlet extends HttpServlet {
    private final String methodGet = "GET";

    @Override
    public void init() throws ServletException {
        getServletContext().setAttribute("Collection", new Results<Point>());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String x = req.getParameter("x_coord");
        String y = req.getParameter("y_coord");
        String r = req.getParameter("r_coord");
        String clear = req.getParameter("clear");

        Results<Point> results = (Results<Point>) getServletContext().getAttribute("Collection");
        if (x != null && y != null && r != null) {
            if (results == null) {
                getServletContext().setAttribute("Collection", new Results<Point>());
            }
            getServletContext().getRequestDispatcher("/area").forward(req, resp);
        } else if (clear != null) {
            if (results != null) {
                results.clear();
            } else {
                getServletContext().setAttribute("Collection", new Results<Point>());
            }
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
