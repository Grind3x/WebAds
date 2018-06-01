package com.gmail.grind3x.controller;

import com.gmail.grind3x.dao.AdvertisementDAO;
import com.gmail.grind3x.dao.PostgresDAOFactory;
import com.gmail.grind3x.model.Advertisement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
        AdvertisementDAO advertisementDAO = new PostgresDAOFactory().getAdvertisementDAO();
        String param = "";
        List<Advertisement> advList = null;

        if ((param = req.getParameter("author")) != null) {

            advList = advertisementDAO.findByAuthor(param);
        } else {
            advList = advertisementDAO.getAll();
        }
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("advertisements", advList);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/view.jsp");
        requestDispatcher.forward(req, resp);
    }
}
