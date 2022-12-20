package pl.diakowski.blog.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.diakowski.blog.Comment.Comment;
import pl.diakowski.blog.Comment.CommentDao;
import pl.diakowski.blog.User.UserDao;

import java.io.IOException;
import java.security.Principal;
import java.time.LocalDateTime;

@WebServlet("/addComment")
public class CommentServlet extends HttpServlet {
    private final CommentDao commentDao = new CommentDao();
    UserDao userDao = new UserDao();
/*
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Comment> commentsInArticle = commentDao.getCommentsForArticle(Integer.valueOf(request.getParameter("articleId")));
        request.setAttribute("commentsInArticle", commentsInArticle);
//        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
*/

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Principal userPrincipal = request.getUserPrincipal();
        Integer articleId = Integer.valueOf(request.getParameter("id"));
        int userId = userDao.findUserId(userPrincipal.getName());
        String newComment = (String) request.getParameter("comment");
        commentDao.addComment(new Comment(articleId, userId, userPrincipal.getName(), LocalDateTime.now(), newComment));
        response.sendRedirect(request.getContextPath());
    }
}
