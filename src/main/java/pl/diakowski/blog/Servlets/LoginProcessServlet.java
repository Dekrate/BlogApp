package pl.diakowski.blog.Servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pl.diakowski.blog.User.UserDao;

import java.io.IOException;

@WebServlet("/login-verification")
public class LoginProcessServlet extends HttpServlet {
    UserDao userDao = new UserDao();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ((username == null || password == null) || request.getUserPrincipal() != null) {
            response.sendError(400, "Nie możesz odwiedzić tej strony!");
        } else {
            if (userDao.checkPassword(username, password)) {
                request.login(username, password);
                response.sendRedirect(request.getContextPath());
            } else {
                response.sendError(401, "Podano złe dane logowania.");
            }
        }
    }
}
