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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        response.addHeader("Cache-Control", "no-store,no-cache,must-revalidate");
        response.addHeader("Pragma", "no-cache");
        response.addHeader("Expires", "-1");
    }
}
