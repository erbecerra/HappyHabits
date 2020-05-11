package controllers;

import entity.User;
import persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * A servlet that will pull up user profile
 * @author ebecerra
 */

@WebServlet(
        urlPatterns = {"/logout"}
)
public class Logout extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
            req.getSession().invalidate();

            res.sendRedirect("/HappyHabits/");
        }
    }