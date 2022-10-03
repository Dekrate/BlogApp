package pl.diakowski.blog.Servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pl.diakowski.blog.User.User;
import pl.diakowski.blog.User.UserDao;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    UserDao userDao = new UserDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("username") != null) {
            response.sendRedirect("/index");
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (userDao.checkPassword(username, password)) {
            session.setAttribute("username", username);
            response.sendRedirect("/index");
        } else {
            request.setAttribute("validationFailure", false);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
