package az.com.alakbar.web;

import az.com.alakbar.dao.StudentDao;
import az.com.alakbar.dao.TeacherDao;
import az.com.alakbar.dao.impl.StudentDaoImpl;
import az.com.alakbar.dao.impl.TeacherDaoImpl;
import az.com.alakbar.model.Student;
import az.com.alakbar.model.Teacher;
import az.com.alakbar.service.StudentService;
import az.com.alakbar.service.TeacherService;
import az.com.alakbar.service.impl.StudentServiceImpl;
import az.com.alakbar.service.impl.TeacherServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ControllerServlet", urlPatterns = "/cs")
public class ControllerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        String action = null;
        String address = null;
        StudentDao studentDao = new StudentDaoImpl();
        StudentService studentService = new StudentServiceImpl(studentDao);

        TeacherDao teacherDao = new TeacherDaoImpl();
        TeacherService teacherService = new TeacherServiceImpl(teacherDao);


        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        }
            try {


                if (action.equalsIgnoreCase("registerStudent")) {
                    BufferedWriter bw = new BufferedWriter(new FileWriter("F://qrup36Web.txt", true));

                    String studentName = request.getParameter("studentName");
                    String studentSurname = request.getParameter("studentSurname");
                    bw.write("Name: " + studentName);
                    bw.newLine();
                    bw.write("Surname: " + studentSurname);
                    bw.newLine();
                    String[] foreignLangs = request.getParameterValues("foreignLang");
                    System.out.print("Languages: ");
                    for (String lang : foreignLangs) {
                        bw.write(lang + " ");
                    }
                    bw.newLine();
                    bw.close();
                    pw.print("<h1>Success!</h1>");

                } else if (action.equalsIgnoreCase("getStudentList")) {
                    List<Student> studentList = studentService.getStudentList();
                    request.setAttribute("studentList", studentList);
                    address = "/WEB-INF/pages/studentList.jsp";

                } else if (action.equalsIgnoreCase("getStudentListAjax"))   {
                    List<Student> studentList = studentService.getStudentList();
                    request.setAttribute("studentList",studentList);
                    address = "/WEB-INF/pages/studentListAjax.jsp";

                } else if (action.equalsIgnoreCase("getTeacherList")) {
                    List<Teacher> teacherList = teacherService.getTeacherList();
                    request.setAttribute("teacherList",teacherList);
                    address="WEB-INF/pages/teacherListAjax.jsp";
                }
            }catch (Exception ex){
            ex.printStackTrace();
            }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(address);
        requestDispatcher.forward(request,response);
    }
}


