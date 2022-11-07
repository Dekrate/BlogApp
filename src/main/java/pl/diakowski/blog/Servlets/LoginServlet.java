package pl.diakowski.blog.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.diakowski.blog.User.UserDao;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    UserDao userDao = new UserDao();
    // zamiast robić j_security_check, można użyć metody request.login!!!!! i to rozwiąże problemy tego świata

    // przerobić servlet tak, aby formularz kierował tutaj i sprawdzał passy a potem na stronę główną
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
}
