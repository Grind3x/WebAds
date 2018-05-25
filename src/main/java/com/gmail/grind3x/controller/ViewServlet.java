package com.gmail.grind3x.controller;

import com.gmail.grind3x.model.Advertisement;
import com.gmail.grind3x.model.Advertisements;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/view")
public class ViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Advertisements advertisements = Advertisements.getInstance();
        List<Advertisement> advertisementList = advertisements.getAdvList();

        req.setAttribute("advertisements", advertisementList);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/view.jsp");
        requestDispatcher.forward(req, resp);
    }

}
