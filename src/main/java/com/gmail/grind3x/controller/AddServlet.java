package com.gmail.grind3x.controller;

import com.gmail.grind3x.dao.AdvertisementDAO;
import com.gmail.grind3x.dao.AuthorDAO;
import com.gmail.grind3x.dao.ImageDAO;
import com.gmail.grind3x.dao.PostgresDAOFactory;
import com.gmail.grind3x.model.Advertisement;
import com.gmail.grind3x.model.Author;
import com.gmail.grind3x.model.Image;
import com.gmail.grind3x.util.Util;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/add")
public class AddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostgresDAOFactory daoFactory = new PostgresDAOFactory();
        AuthorDAO authorDAO = daoFactory.getAuthorDAO();
        ImageDAO imageDAO = daoFactory.getImageDAO();
        AdvertisementDAO advertisementDAO = daoFactory.getAdvertisementDAO();

        String authorName = "";
        String title = "";
        String text = "";
        Image image = null;
        FileItemFactory fileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
        List<FileItem> items = null;
        try {
            items = servletFileUpload.parseRequest(req);
            authorName = Util.parseItem("author", items);
            title = Util.parseItem("title", items);
            text = Util.parseItem("text", items);
            String path = "/img/";
            image = Util.getImage(items, getServletContext().getRealPath(path), path);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        if (!"".equals(authorName) && !"".equals(authorName) && !"".equals(text) && image != null) {
            imageDAO.insertImage(image);
            Author author = null;

            if ((author = authorDAO.findAuthorByName(authorName)) == null) {
                author = new Author(authorName);
                authorDAO.insertAuthor(author);
            }
            advertisementDAO.insert(new Advertisement(title, text, author, image));
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
