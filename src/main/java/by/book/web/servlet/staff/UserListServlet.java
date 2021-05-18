package by.book.web.servlet.staff;

import by.book.entity.User;
import by.book.service.StaffUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/staff/user/all", name = "UserListServlet")
public class UserListServlet extends HttpServlet {
    private StaffUserService staffUserService = new StaffUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = staffUserService.getAll();
        req.setAttribute("userList", userList);
        getServletContext().getRequestDispatcher("/pages/staff/userList.jsp").forward(req, resp);
    }
}
