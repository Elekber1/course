package az.com.alakbar.web;

import az.com.alakbar.dao.LessonDao;
import az.com.alakbar.dao.PaymentDao;
import az.com.alakbar.dao.StudentDao;
import az.com.alakbar.dao.TeacherDao;
import az.com.alakbar.dao.impl.LessonDaoImpl;
import az.com.alakbar.dao.impl.PaymentDaoImpl;
import az.com.alakbar.dao.impl.StudentDaoImpl;
import az.com.alakbar.dao.impl.TeacherDaoImpl;
import az.com.alakbar.model.*;
import az.com.alakbar.service.LessonService;
import az.com.alakbar.service.PaymentService;
import az.com.alakbar.service.StudentService;
import az.com.alakbar.service.TeacherService;
import az.com.alakbar.service.impl.LessonServiceImpl;
import az.com.alakbar.service.impl.PaymentServiceImpl;
import az.com.alakbar.service.impl.StudentServiceImpl;
import az.com.alakbar.service.impl.TeacherServiceImpl;
import az.com.alakbar.util.Constants;

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
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        PrintWriter pw = response.getWriter();
        String action = null;
        String address = null;

        StudentDao studentDao = new StudentDaoImpl();
        StudentService studentService = new StudentServiceImpl(studentDao);

        TeacherDao teacherDao = new TeacherDaoImpl();
        TeacherService teacherService = new TeacherServiceImpl(teacherDao);

        LessonDao lessonDao = new LessonDaoImpl();
        LessonService lessonService = new LessonServiceImpl(lessonDao);

        PaymentDao paymentDao = new PaymentDaoImpl();
        PaymentService paymentService = new PaymentServiceImpl(paymentDao);

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

                }else if (action.equalsIgnoreCase("newPay")){
                    List<Student> studentList = studentService.getStudentList();
                    List<Teacher> teacherList = teacherService.getTeacherList();
                    List<Lesson> lessonList = lessonService.getLessonList();
                    request.setAttribute("studentList",studentList);
                    request.setAttribute("teacherList",teacherList);
                    request.setAttribute("lessonList",lessonList);
                    address = "/WEB-INF/pages/newPay.jsp ";


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
                    boolean isAdded = paymentService.addPayment(payment);
                    response.setContentType("text/html");
                    if (isAdded){
                        pw.print("Success");
                    }else {
                        pw.print("Error");
                    }

                }else if (action.equalsIgnoreCase("getPaymentList")){
                    List<Payment> paymentList = paymentService.getPaymentList();
                    List<Teacher> teacherList = teacherService.getTeacherList();
                    List<Lesson> lessonList = lessonService.getLessonList();
                    request.setAttribute("teacherList",teacherList);
                    request.setAttribute("lessonList",lessonList);
                    request.setAttribute("paymentList",paymentList);
                    address = "/WEB-INF/pages/paymentList.jsp";

                }else if(action.equalsIgnoreCase("editStudent")){
                    Long studentId = Long.parseLong(request.getParameter("studentId"));
                    Student student = studentService.getStudentById(studentId);
                    request.setAttribute("student",student);
                    address = "/WEB-INF/pages/editStudent.jsp";

                }else if(action.equalsIgnoreCase("updateStudent")){
                    Long studentId = Long.parseLong(request.getParameter("studentId"));
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
                    boolean isUpdated = studentService.updateStudent(student,studentId);
                    response.setContentType("text/html");
                    if (isUpdated){
                        pw.print("success");
                    }else
                        pw.print("error");

                }else if(action.equalsIgnoreCase("deleteStudent")){
                    Long studentId = Long.parseLong(request.getParameter("studentId"));
                    boolean isDelete = studentService.deleteStudent(studentId);
                    if(isDelete){
                        pw.print("success");
                    }else {
                        pw.print("error");
                    }


                }else if (action.equalsIgnoreCase("editPayment")){
                    List<Student> studentList = studentService.getStudentList();
                    List<Teacher> teacherList = teacherService.getTeacherList();
                    List<Lesson> lessonList = lessonService.getLessonList();
                    request.setAttribute("studentList",studentList);
                    request.setAttribute("teacherList",teacherList);
                    request.setAttribute("lessonList",lessonList);
                   Long paymentId = Long.parseLong(request.getParameter("paymentId"));
                   Payment payment = paymentService.getPaymentId(paymentId);
                   request.setAttribute("payment", payment);
                   address = "/WEB-INF/pages/editPayment.jsp";


                }else if(action.equalsIgnoreCase("updatePayment")){

                    Long studentCombo = Long.parseLong(request.getParameter("studentCombo"));
                    Long teacherCombo = Long.parseLong(request.getParameter("teacherCombo"));
                    Long lessonCombo = Long.parseLong(request.getParameter("lessonCombo"));
                    Double amount = Double.parseDouble(request.getParameter("amount"));
                    Long paymentId = Long.parseLong(request.getParameter("paymentId"));
                    Payment payment = new Payment();
                    payment.setId(paymentId);
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
                    boolean isUpdated = paymentService.updatePayment(payment);
                    response.setContentType("text/html");
                    if (isUpdated){
                        pw.print("Success");
                    }else {
                        pw.print("Error");
                    }

                }else if(action.equalsIgnoreCase("deletePayment")){


                }else if(action.equalsIgnoreCase(Constants.SEARCH_STUDENT_DATA)){
                    String keyword = request.getParameter("keyword");
                    List<Student> studentList =  studentService.searchStudentData(keyword);
                    request.setAttribute("studentList",studentList);
                    address = "/WEB-INF/pages/studentListAjax.jsp";


                }else if(action.equalsIgnoreCase(Constants.SEARCH_PAYMENT_DATA)){
                    String keyword = request.getParameter("keyword");
                    List<Payment> paymentList = paymentService.searchPaymentData(keyword);
                    request.setAttribute("paymentList",paymentList);
                    address = "/WEB-INF/pages/paymentList.jsp";
                }else if(action.equalsIgnoreCase(Constants.GET_TEACHER_COMBO_BY_LESSON_ID)){
                    Long lessonId = Long.parseLong(request.getParameter("lessonId"));
                    List<Teacher> teacherList = teacherService.getTeacherComboByLessonId(lessonId);
                    request.setAttribute("teacherList",teacherList);
                    address = "/WEB-INF/pages/teacherCombo.jsp";

                    }else if(action.equalsIgnoreCase(Constants.ADVANCED_SEARCH_PAYMENT_DATA)){
                    String min1Amount = request.getParameter("minAmount");
                    String max1Amount = request.getParameter("maxAmount");
                    Double minAmount = null;
                    Double maxAmount = null;
                    Long advLessonCombo = Long.parseLong(request.getParameter("advLessonCombo"));
                    Long advTeacherCombo = Long.parseLong(request.getParameter("advTeacherCombo"));
                    if(min1Amount != null && !min1Amount.isEmpty()){
                        minAmount = Double.parseDouble(min1Amount);
                    }
                    if(max1Amount != null && !max1Amount.isEmpty()){
                      maxAmount = Double.parseDouble(max1Amount);
                    }


                    String beginDate = request.getParameter("beginDate");
                    String endDate = request.getParameter("endDate");
                    AdvancedSearch  advancedSearch = new AdvancedSearch();
                    advancedSearch.setLessonId(advLessonCombo);
                    advancedSearch.setTeacherId(advTeacherCombo);
                    advancedSearch.setMaxAmount(maxAmount);
                    advancedSearch.setMinAmount(minAmount);
                    advancedSearch.setBeginDate(beginDate);
                    advancedSearch.setEndDate(endDate);
                    List<Payment> paymentList = paymentService.advancedSearchPaymentData(advancedSearch);
                    request.setAttribute("paymentList",paymentList);
                    address = "/WEB-INF/pages/paymentData.jsp";

                    }


            }catch (Exception ex){
            ex.printStackTrace();
            }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(address);
        requestDispatcher.forward(request,response);
    }
}


;