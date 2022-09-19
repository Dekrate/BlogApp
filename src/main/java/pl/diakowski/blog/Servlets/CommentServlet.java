package pl.diakowski.blog.Servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pl.diakowski.blog.Comment.Comment;
import pl.diakowski.blog.Comment.CommentDao;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CommentServlet", value = "/")
public class CommentServlet extends HttpServlet {
    private final CommentDao commentDao = new CommentDao();
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Comment> commentsInArticle = commentDao.getCommentsForArticle(Integer.valueOf(request.getParameter("articleId")));
//        request.setAttribute("commentsInArticle", commentsInArticle);
////        request.getRequestDispatcher("index.jsp").forward(request, response);
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer articleId = Integer.valueOf(request.getParameter("article_id"));
        Integer userId = Integer.valueOf(request.getParameter("user_id"));
        String newComment = (String) request.getAttribute("newComment");
        commentDao.addComment(new Comment(articleId, userId, new Timestamp(new Date().getTime()), newComment));
    }
}
