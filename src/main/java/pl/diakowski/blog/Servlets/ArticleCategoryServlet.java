package pl.diakowski.blog.Servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pl.diakowski.blog.Article.ArticleCategory;
import pl.diakowski.blog.Article.ArticleCategoryDao;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@WebServlet("/category")
public class ArticleCategoryServlet extends HttpServlet {
    private final ArticleCategoryDao articleCategoryDao = new ArticleCategoryDao();

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<ArticleCategory> categories = articleCategoryDao.getAllCategories();
//        request.setAttribute("categories", categories);
//        request.getRequestDispatcher("category.jsp").forward(request, response);
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
