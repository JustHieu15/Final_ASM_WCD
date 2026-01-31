package my.fpl.exam_01.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import my.fpl.exam_01.model.User;
import my.fpl.exam_01.repository.ProductRepository;
import my.fpl.exam_01.utils.LoginStatus;

import java.io.IOException;

@WebServlet({"/products", "/products/logout"})
public class ProductServerlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProductRepository productRepository = new  ProductRepository();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        System.out.println(uri);
        if (uri.contains("logout")) {
            LoginStatus.username = "";
            LoginStatus.password = "";
//            request.getRequestDispatcher("/index.jsp").forward(request, response);
            response.sendRedirect("/Exam_01_war_exploded/");
        } else {
            if (LoginStatus.username == null || LoginStatus.username.isBlank()) {
//            request.setAttribute("message", ": <b>" + username.toUpperCase() + "</b>!");
//            request.getRequestDispatcher("/views/san-pham/edit.jsp")
//                    .forward(request, response);
                request.getRequestDispatcher("index.jsp")
                        .forward(request, response);
            } else {
                request.setAttribute("products", productRepository.getAll());
                request.getRequestDispatcher("/views/products.jsp").forward(request, response);
            }
        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
