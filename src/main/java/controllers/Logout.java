package controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A servlet that will end the user session and log them out
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