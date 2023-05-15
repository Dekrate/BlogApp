package pl.diakowski.blog.Servlets.AdminPanel;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pl.diakowski.blog.Admin.AdminDao;

import java.io.IOException;
import java.security.Principal;

@WebServlet({"/admin/index", "/admin"})
public class AdminPanelHomePageServlet extends HttpServlet {
    AdminDao adminDao = new AdminDao();

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
            request.getRequestDispatcher("/WEB-INF/admin/index.jsp").forward(request, response);
        }
    }
}
