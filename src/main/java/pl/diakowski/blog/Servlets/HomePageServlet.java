package pl.diakowski.blog.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pl.diakowski.blog.Article.Article;
import pl.diakowski.blog.Article.ArticleCategory;
import pl.diakowski.blog.Article.ArticleCategoryDao;
import pl.diakowski.blog.Article.ArticleDao;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@WebServlet({"/index", ""})
public class HomePageServlet extends HttpServlet {
    ArticleDao articleDao = new ArticleDao();
    ArticleCategoryDao articleCategoryDao = new ArticleCategoryDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Principal userPrincipal = request.getUserPrincipal();
        List<ArticleCategory> allCategories = articleCategoryDao.getAllCategories();
        List<Article> allArticles = articleDao.findAllArticles();
        request.setAttribute("allArticles", allArticles);
        request.setAttribute("allCategories", allCategories);
        Principal userPrincipal = request.getUserPrincipal();

//        String username = (String) session.getAttribute("username");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
