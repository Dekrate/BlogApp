package pl.diakowski.blog.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.diakowski.blog.User.User;
import pl.diakowski.blog.User.UserDao;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    UserDao userDao = new UserDao();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String referer = request.getHeader("Referer"); // for redirect support
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (userDao.addUser(new User(username, email, password, "user"))) {
            request.login(username, password);
            response.sendRedirect(request.getContextPath() + "/index");
        } else {
            response.sendError(400, "Użytkownik o podanych danych już istnieje w bazie!");
        }
    }
}
