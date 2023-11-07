package Controller;

import Model.Clasez;
import Model.Student;
import Service.ClassService;
import Service.IClasezService;
import Service.IService;
import Service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

import static java.nio.file.Files.delete;

@WebServlet(name = "StudentController", value = "/student")
public class StudentController extends HttpServlet {
    private IService<Student> studentIService = new StudentService();
    private IClasezService<Clasez> clasezIClasezService = new ClassService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "home":
                showHome(request, response);
                break;
            case "create":
                showFormCreate(request, response);
                break;
            case "delete":
                deleteStudent(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        Student student = studentIService.findStudentById(id);
        request.setAttribute("editStudent", student);
        List<Clasez> clasezList = clasezIClasezService.findAll();
        request.setAttribute("clasezList", clasezList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentIService.delete(id);
        response.sendRedirect("/student?action=home");
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/create.jsp");
        List<Clasez> clasezList = clasezIClasezService.findAll();
        request.setAttribute("clasezList", clasezList);
        dispatcher.forward(request, response);
    }

    private void showHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = null;
        String search = request.getParameter("search");
        if (search != null) {
            studentList = studentIService.findProductByName(search);
        } else {
            studentList = studentIService.findAll();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
        request.setAttribute("listStudent", studentList);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "create":
                createStudent(request, response);
                break;
            case "edit":
                editStudent(request, response);
                break;
        }
    }

    private void editStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        int classRoomId = Integer.parseInt(request.getParameter("classRoomId"));
        Clasez clasez = new Clasez(classRoomId);
        Student student = new Student(name, email, dateOfBirth, address, phoneNumber, clasez);
        studentIService.edit(student, id);
        response.sendRedirect("/student?action=home");
    }

    private void createStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        int classRoomId = Integer.parseInt(request.getParameter("classRoomId"));
        Clasez clasez = new Clasez(classRoomId);
        Student student = new Student(name, email, dateOfBirth, address, phoneNumber, clasez);
        studentIService.add(student);
        response.sendRedirect("/student?action=home");
    }
}