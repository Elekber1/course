package az.com.alakbar.web;

import az.com.alakbar.dao.LessonDao;
import az.com.alakbar.dao.StudentDao;
import az.com.alakbar.dao.TeacherDao;
import az.com.alakbar.dao.impl.LessonDaoImpl;
import az.com.alakbar.dao.impl.StudentDaoImpl;
import az.com.alakbar.dao.impl.TeacherDaoImpl;
import az.com.alakbar.model.Lesson;
import az.com.alakbar.model.Payment;
import az.com.alakbar.model.Student;
import az.com.alakbar.model.Teacher;
import az.com.alakbar.service.LessonService;
import az.com.alakbar.service.StudentService;
import az.com.alakbar.service.TeacherService;
import az.com.alakbar.service.impl.LessonServiceImpl;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        PrintWriter pw = response.getWriter();
        String action = null;
        String address = null;

        StudentDao studentDao = new StudentDaoImpl();
        StudentService studentService = new StudentServiceImpl(studentDao);

        TeacherDao teacherDao = new TeacherDaoImpl();
        TeacherService teacherService = new TeacherServiceImpl(teacherDao);

        LessonDao lessonDao = new LessonDaoImpl();
        LessonService lessonService = new LessonServiceImpl(lessonDao);

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
                    address="/WEB-INF/pages/teacherList.jsp";

                }else if (action.equalsIgnoreCase("addStudent")){
                    String name = request.getParameter("name");
                    String surname = request.getParameter("surname");
                    String addres = request.getParameter("address");
                    String phone = request.getParameter("phone");
                    String email = request.getParameter("email");
                    String dob = request.getParameter("dob");
                    Student student = new Student();
                    student.setName(name);
                    student.setSurname(surname);
                    student.setAddress(addres);
                    student.setPhone(phone);
                    student.setEmail(email);
                    if (dob != null)
                    student.setDob(df.parse(dob));
                    boolean isAdded = studentService.addStudent(student);
                    response.setContentType("text/html");
                    if (isAdded){
                        pw.print("success");
                    }else
                        pw.print("error");

                }else if (action.equalsIgnoreCase("getStudentCombo")){
                    List<Student> studentList = studentService.getStudentList();
                    request.setAttribute("studentList",studentList);
                    address = "/WEB-INF/pages/studentCombo.jsp";

                }else if (action.equalsIgnoreCase("getTeacherCombo")){
                    List<Teacher> teacherList = teacherService.getTeacherList();
                    request.setAttribute("teacherList",teacherList);
                    address = "/WEB-INF/pages/teacherCombo.jsp";

                }else if (action.equalsIgnoreCase("getLessonCombo")){
                    List<Lesson> lessonList = lessonService.getLessonList();
                    request.setAttribute("lessonList",lessonList);
                    address = "/WEB-INF/pages/lessonCombo.jsp";

                }else if (action.equalsIgnoreCase("newPayment")){
                    List<Student> studentList = studentService.getStudentList();
                    List<Teacher> teacherList = teacherService.getTeacherList();
                    List<Lesson> lessonList = lessonService.getLessonList();
                    request.setAttribute("studentList",studentList);
                    request.setAttribute("teacherList",teacherList);
                    request.setAttribute("lessonList",lessonList);
                    address = "/WEB-INF/pages/newPayment.jsp ";


                }else if (action.equalsIgnoreCase("addPayment")){
                    Long studentCombo = Long.parseLong(request.getParameter("studentCombo"));
                    Long teacherCombo = Long.parseLong(request.getParameter("teacherCombo"));
                    Long lessonCombo = Long.parseLong(request.getParameter("lessonCombo"));
                    Double amount = Double.parseDouble(request.getParameter("amount"));
                    Payment payment = new Payment();
                    Student student = new Student();
                    student.setId(studentCombo);
                    Teacher teacher = new Teacher();
                    teacher.setId(teacherCombo);
                    Lesson lesson = new Lesson();
                    lesson.setId(lessonCombo);
                    payment.setStudent(student);
                    payment.setTeacher(teacher);
                    payment.setLesson(lesson);
                    payment.setAmount(amount);
                }

            }catch (Exception ex){
            ex.printStackTrace();
            }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(address);
        requestDispatcher.forward(request,response);
    }
}


