package controllers;

import entity.Goal;
import entity.User;
import persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        urlPatterns = {"/goals"}
)
public class Goals extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao goalDao = new GenericDao(Goal.class);
        GenericDao userDao = new GenericDao(User.class);
        String login = req.getRemoteUser();
        User user = (User)userDao.getByPropertyEqual("userName", login).get(0);
        req.setAttribute("goals", goalDao.getAllByEntityID("user", user.getId()));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/goals.jsp");
        dispatcher.forward(req, resp);
    }

}
