package pl.diakowski.blog.Servlets.AdminPanel;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pl.diakowski.blog.Admin.AdminDao;
import pl.diakowski.blog.Article.Article;
import pl.diakowski.blog.Article.ArticleDao;
import pl.diakowski.blog.Comment.Comment;
import pl.diakowski.blog.Comment.CommentDao;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin/manageComments")
public class AdminPanelManageComments extends HttpServlet {
    AdminDao adminDao = new AdminDao();

    CommentDao commentDao = new CommentDao();

    ArticleDao articleDao = new ArticleDao();

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<ArticleCategory> categories = articleCategoryDao.getAllCategories();
//        request.setAttribute("categories", categories);
//        request.getRequestDispatcher("category.jsp").forward(request, response);
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Principal userPrincipal = request.getUserPrincipal();
        if (userPrincipal == null || !adminDao.checkIfAdmin(userPrincipal.getName())) {
            try {
                response.sendError(403, "Brak uprawnień");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            List<List<Comment>> comments = new ArrayList<>();
            List<Article> allArticles = articleDao.findAllArticles();
            for (Article allArticle : allArticles) {
                comments.add(commentDao.getCommentsForArticle(allArticle.getId()));
            }
            request.setAttribute("comments", comments);
            request.getRequestDispatcher("/WEB-INF/admin/manageComments.jsp").forward(request, response);
        }
    }
}
