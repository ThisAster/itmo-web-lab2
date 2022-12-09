package com.example.demo4.servlets;

import com.example.demo4.models.Point;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "", loadOnStartup = 0, name = "ControllerServlet")
public class ControllerServlet extends HttpServlet {

    @Override
    public void init() {
        getServletContext().setAttribute("Collection", new ArrayList<Point>());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String x = req.getParameter("x_coord");
        String y = req.getParameter("y_coord");
        String r = req.getParameter("r_coord");
        String click = req.getParameter("is_click");
        String clear = req.getParameter("clear");
        ArrayList<Point> results = (ArrayList<Point>) getServletContext().getAttribute("Collection");
        if (x != null && y != null && r != null && click != null) {
            if (results == null) {
                getServletContext().setAttribute("Collection", new ArrayList<Point>());
            }
            getServletContext().getRequestDispatcher("/area").forward(req, resp);
        } else if (clear != null) {
            if (results != null) {
                results.clear();
            } else {
                getServletContext().setAttribute("Collection", new ArrayList<Point>());
            }
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
