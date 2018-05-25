package com.gmail.grind3x.controller;

import com.gmail.grind3x.model.Advertisement;
import com.gmail.grind3x.model.Advertisements;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Advertisements advertisements = Advertisements.getInstance();

        String author = req.getParameter("author");
        String title = req.getParameter("title");
        String text = req.getParameter("text");
        if (!"".equals(author) && !"".equals(author) && !"".equals(text)) {
            advertisements.add(new Advertisement(author, title, text));
            req.setAttribute("success_message", "Advertisement success added!");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/add.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            req.setAttribute("error_message", "You entered incorrect data!");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/add.jsp");
            requestDispatcher.forward(req, resp);
        }

    }
}
