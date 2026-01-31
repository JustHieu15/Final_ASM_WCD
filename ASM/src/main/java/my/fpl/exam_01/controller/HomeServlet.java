package my.fpl.exam_01.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import my.fpl.exam_01.model.User;
import my.fpl.exam_01.repository.LoginRepository;
import my.fpl.exam_01.utils.LoginStatus;


@WebServlet("/login")   // ← URL pattern: khi submit form sẽ gọi đến đây
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private LoginRepository loginRepository = new  LoginRepository();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Trang chủ mặc định khi truy cập /home hoặc /
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8"); // Hỗ trợ tiếng Việt

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String message;
        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            message = "Bạn chưa đầy đủ các trường!";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            User user = loginRepository.findById(username);
            if (user == null) {
                message = "Không tồn tại username: <b>" + username.toUpperCase() + "</b>!";
                request.setAttribute("message", message);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                if (user.getPassword().equals(password)) {
                    LoginStatus.username = username;
                    LoginStatus.password = password;
//                    request.getRequestDispatcher("/views/home.jsp")
//                            .forward(request, response);
                    response.sendRedirect("/Exam_01_war_exploded/products");
                } else {
                    message = "Mật khẩu không chính xác";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }
            }
        }
    }
}