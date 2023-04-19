package pl.diakowski.blog.Servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pl.diakowski.blog.Admin.AdminDao;
import pl.diakowski.blog.Article.Article;
import pl.diakowski.blog.Article.ArticleCategory;
import pl.diakowski.blog.Article.ArticleCategoryDao;
import pl.diakowski.blog.Article.ArticleDao;
import pl.diakowski.blog.Comment.Comment;
import pl.diakowski.blog.Comment.CommentDao;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@WebServlet("/article")
public class ArticleServlet extends HttpServlet {
    ArticleDao articleDao = new ArticleDao();
    ArticleCategoryDao articleCategoryDao = new ArticleCategoryDao();

    AdminDao adminDao = new AdminDao();
    CommentDao commentDao = new CommentDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        List<ArticleCategory> allCategories = articleCategoryDao.getAllCategories();
        Article article = articleDao.findArticle(id);
        Principal userPrincipal = request.getUserPrincipal();
        boolean checkIfAdmin = false;
        if (userPrincipal != null) {
            if (adminDao.checkIfAdmin(userPrincipal.getName())) {
                checkIfAdmin = true;
            }
        }
        List<Comment> commentsForArticle = commentDao.getCommentsForArticle(id);
        request.setAttribute("allCategories", allCategories);
        request.setAttribute("article", article);
        request.setAttribute("commentsForArticle", commentsForArticle);
        request.setAttribute("id", id);
        request.setAttribute("checkIfAdmin", checkIfAdmin);
        request.getRequestDispatcher("/article.jsp").forward(request, response);
    }
}
