package com.gmail.grind3x.controller;

import com.gmail.grind3x.model.Advertisement;
import com.gmail.grind3x.model.Author;

import javax.persistence.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;

    @Override
    public void init() throws ServletException {
        entityManagerFactory = Persistence.createEntityManagerFactory("JPATest");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        entityManager = entityManagerFactory.createEntityManager();
        try {
            req.setCharacterEncoding("UTF-8");
            String authorName = req.getParameter("author");
            String title = req.getParameter("title");
            String text = req.getParameter("text");
            if (!"".equals(authorName) && !"".equals(authorName) && !"".equals(text)) {
                entityManager.getTransaction().begin();
                Author author = null;
                try {
                    Query query = entityManager.createQuery("SELECT a FROM Author a WHERE a.name = :name", Author.class);
                    query.setParameter("name", authorName);
                    author = (Author) query.getSingleResult();

                } catch (NoResultException | NonUniqueResultException e) {
                    e.printStackTrace();
                }
                if (author != null) {
                    entityManager.persist(author);
                    entityManager.flush();
                    entityManager.persist(new Advertisement(title, text, author));
                } else {
                    author = new Author(authorName);
                    entityManager.persist(author);
                    entityManager.flush();
                    entityManager.persist(new Advertisement(title, text, author));
                }
                entityManager.getTransaction().commit();
                req.setAttribute("success_message", "Advertisement success added!");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/add.jsp");
                requestDispatcher.forward(req, resp);
            } else {
                req.setAttribute("error_message", "You entered incorrect data!");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/add.jsp");
                requestDispatcher.forward(req, resp);
            }
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void destroy() {
        entityManagerFactory.close();
    }
}
