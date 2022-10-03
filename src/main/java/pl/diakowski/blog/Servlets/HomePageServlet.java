package pl.diakowski.blog.Servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pl.diakowski.blog.Article.Article;
import pl.diakowski.blog.Article.ArticleCategory;
import pl.diakowski.blog.Article.ArticleCategoryDao;
import pl.diakowski.blog.Article.ArticleDao;
import pl.diakowski.blog.Comment.CommentDao;

import java.io.IOException;
import java.util.List;

@WebServlet("/index")
public class HomePageServlet extends HttpServlet {
    ArticleDao articleDao = new ArticleDao();
    ArticleCategoryDao articleCategoryDao = new ArticleCategoryDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ArticleCategory> allCategories = articleCategoryDao.getAllCategories();
        List<Article> allArticles = articleDao.findAllArticles();
        request.setAttribute("allArticles", allArticles);
        request.setAttribute("allCategories", allCategories);
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
