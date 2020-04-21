package controllers;

import entity.Goal;
import persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/goals"}
)
public class Goals extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // GenericDao dao = new GenericDao(Goal.class);

        //get all goals

        RequestDispatcher dispatcher = req.getRequestDispatcher("/goals.jsp");
        dispatcher.forward(req, resp);
    }

}
