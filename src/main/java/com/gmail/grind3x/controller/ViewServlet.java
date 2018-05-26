package com.gmail.grind3x.controller;

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
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;

    @Override
    public void init() throws ServletException {
        entityManagerFactory = Persistence.createEntityManagerFactory("JPATest");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        entityManager = entityManagerFactory.createEntityManager();
        String param = "";
        List<Advertisement> advList = null;
        try {
            if ((param = req.getParameter("author")) != null) {
                Query query = entityManager.createQuery("SELECT a FROM Advertisement a WHERE a.author.name = :name", Advertisement.class);
                query.setParameter("name", param);
                advList = (List<Advertisement>) query.getResultList();
            } else {
                Query query = entityManager.createQuery("SELECT a FROM Advertisement a", Advertisement.class);
                advList = (List<Advertisement>) query.getResultList();
            }
            req.setCharacterEncoding("UTF-8");
            req.setAttribute("advertisements", advList);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/view.jsp");
            requestDispatcher.forward(req, resp);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void destroy() {
        entityManagerFactory.close();
    }
}
