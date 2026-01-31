package my.fpl.exam_02.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import my.fpl.exam_02.model.Employee;
import my.fpl.exam_02.repository.EmployeeRepository;
import my.fpl.exam_02.utils.ValidateEx;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "HomeServlet", urlPatterns = {"" , "/", "/create", "/store", "/update", "/delete", "/search"})
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private HttpSession session;

    private ValidateEx validateEx = new ValidateEx();
    private EmployeeRepository employeeRepository = new EmployeeRepository();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        System.out.println(uri);
        if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("edit")) {
            this.edit(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String uri = request.getRequestURI();
        System.out.println(uri);
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else if (uri.contains("search")) {
            this.search(request, response);
        }else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    public void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        request.setAttribute("dataList", employeeRepository.getAll());
        request.getRequestDispatcher("/index.jsp")
                .forward(request, response);
    }

    public void search(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String search = request.getParameter("search");
        request.setAttribute("dataList", employeeRepository.findByIdOrName(search));
        request.getRequestDispatcher("/index.jsp")
                .forward(request, response);
    }

    public void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        request.getRequestDispatcher("/views/create.jsp")
                .forward(request, response);
    }

    public void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        validateEx.initSession(request);
        validateEx.setSession(request, "employeeId", "employeeName", "birthday", "phoneNumber", "email");
        if (validateEx.checkNull(request, new String[]{"employeeId", "employeeName", "phoneNumber", "email"}, "employeeId", "employeeName", "phoneNumber", "email")) {
            response.sendRedirect("/Exam_02_war_exploded/create");
        } else {
            employeeRepository = new  EmployeeRepository();
            Employee employee = employeeRepository.findByEmployeeId(request.getParameter("employeeId"));
            if (employee == null) {
                clear();
                String employeeId = request.getParameter("employeeId");
                String employeeName = request.getParameter("employeeName");
                LocalDate birthday = LocalDate.parse(request.getParameter("birthday"));
                String phoneNumber = request.getParameter("phoneNumber");
                String email = request.getParameter("email");
                Employee objInput = new Employee(employeeId, employeeName, birthday, phoneNumber, email);
                validateEx.clear();
                employeeRepository.create(objInput);
                response.sendRedirect("/Exam_02_war_exploded/");
            }
            else {
                initSession(request);
                session.setAttribute("employeeIdErr", " is already exist");
                response.sendRedirect("/Exam_02_war_exploded/create");
            }
        }
    }

    public void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String id = request.getParameter("id");
        Employee item = employeeRepository.findById(id);
        if (validateEx.getSession() != null) {
            request.setAttribute("employeeName", validateEx.getSession().getAttribute("employeeName"));
            request.setAttribute("phoneNumber", validateEx.getSession().getAttribute("phoneNumber"));
            request.setAttribute("email", validateEx.getSession().getAttribute("email"));
            request.setAttribute("birthday", validateEx.getSession().getAttribute("birthday"));
        } else {
            request.setAttribute("employeeName", item.getEmployeeName());
            request.setAttribute("phoneNumber", item.getPhoneNumber());
            request.setAttribute("email", item.getEmail());
            request.setAttribute("birthday", item.getBirthday());
        }
        request.setAttribute("item", item);
        request.getRequestDispatcher("/views/edit.jsp")
                .forward(request, response);
    }

    public void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        validateEx.initSession(request);
        validateEx.setSession(request, "employeeName", "birthday", "phoneNumber", "email");
        if (validateEx.checkNull(request, new String[]{"employeeName", "phoneNumber", "email"}, "employeeName", "phoneNumber", "email")) {
            response.sendRedirect("/Exam_02_war_exploded/edit?id="+request.getParameter("id"));
        } else {
            String id = request.getParameter("id");
            String employeeName = request.getParameter("employeeName");
            LocalDate birthday = LocalDate.parse(request.getParameter("birthday"));
            String phoneNumber = request.getParameter("phoneNumber");
            String email = request.getParameter("email");
            Employee objInput = new Employee(id, employeeName, birthday, phoneNumber, email);
            validateEx.clear();
            employeeRepository.update(objInput);
            response.sendRedirect("/Exam_02_war_exploded/");
        }
    }

    public void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String id = request.getParameter("id");
        employeeRepository.delete(employeeRepository.findById(id));
        index(request, response);
    }

    public void clear() {
        session.invalidate();
        session = null;
    }

    public void initSession(HttpServletRequest request) {
        session = request.getSession();
    }
}
