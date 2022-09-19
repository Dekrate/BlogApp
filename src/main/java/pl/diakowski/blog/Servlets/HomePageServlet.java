package pl.diakowski.blog.Servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pl.diakowski.blog.Article.Article;
import pl.diakowski.blog.Article.ArticleDao;
import pl.diakowski.blog.Comment.CommentDao;

import java.io.IOException;
import java.util.List;

@WebServlet("/index.jsp")
public class HomePageServlet extends HttpServlet {
    ArticleDao articleDao = new ArticleDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Article> allArticles = articleDao.findAllArticles();
        request.setAttribute("allArticles", allArticles);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
