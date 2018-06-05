package com.gmail.grind3x.controller;

import com.gmail.grind3x.dao.AdvertisementDAO;
import com.gmail.grind3x.dao.CategoryDAO;
import com.gmail.grind3x.dao.PostgresDAOFactory;
import com.gmail.grind3x.model.Advertisement;
import com.gmail.grind3x.model.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostgresDAOFactory daoFactory = new PostgresDAOFactory();
        CategoryDAO categoryDAO = daoFactory.getCategoryDAO();
        AdvertisementDAO advertisementDAO = daoFactory.getAdvertisementDAO();
        Category category = categoryDAO.findById(Long.valueOf(req.getParameter("id")));
        List<Advertisement> advertisements = advertisementDAO.findByCategory(category);
        req.setAttribute("advertisements", advertisements);
        req.setAttribute("category", category);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/category.jsp");
        requestDispatcher.forward(req, resp);
    }
}
