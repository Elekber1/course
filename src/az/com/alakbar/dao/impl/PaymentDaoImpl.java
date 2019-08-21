package az.com.alakbar.dao.impl;

import az.com.alakbar.dao.DBHelper;
import az.com.alakbar.dao.PaymentDao;
import az.com.alakbar.model.Lesson;
import az.com.alakbar.model.Payment;
import az.com.alakbar.model.Student;
import az.com.alakbar.model.Teacher;
import az.com.alakbar.util.JdbcUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaymentDaoImpl implements PaymentDao {


    @Override
    public List<Payment> getPaymentList() throws Exception {
        List<Payment> paymentList = new ArrayList<Payment>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r, p.id ID ,\n" +
                "      s.id STUDENT_ID,  s.name STUDENT_NAME, S.SURNAME STUDENT_SURNAME,\n" +
                "       t.id TEACHER_ID ,t.name TEACHER_NAME, T.SURNAME TEACHER_SURNAME,\n" +
                "       l.id LESSON_ID, l.lesson_name,\n" +
                "       p.amount,\n" +
                "       p.pay_date\n" +
                "       FROM PAYMENT P\n" +
                "       INNER JOIN  STUDENT S\n" +
                "       ON p.s_id = s.id\n" +
                "       INNER JOIN TEACHER T\n" +
                "       ON p.t_id = t.id\n" +
                "       INNER JOIN LESSON L\n" +
                "       ON p.l_id = l.id\n" +
                "       WHERE p.active = 1 AND s.active = 1 AND t.active = 1 AND l.active = 1";

        try {
            c = DBHelper.getConnection();
            if(c!=null){
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()){
                    Payment payment = new Payment();
                    payment.setId(rs.getLong("ID"));

                    Student student = new Student();
                    student.setId(rs.getLong("STUDENT_ID"));
                    student.setName(rs.getString("STUDENT_NAME"));
                    student.setSurname(rs.getString("STUDENT_SURNAME"));

                    Teacher teacher = new Teacher();
                    teacher.setId(rs.getLong("TEACHER_ID"));
                    teacher.setName(rs.getString("TEACHER_NAME"));
                    teacher.setSurname(rs.getString("TEACHER_SURNAME"));

                    Lesson lesson = new Lesson();
                    lesson.setId(rs.getLong("LESSON_ID"));
                    lesson.setLessonName(rs.getString("lesson_name"));

                    payment.setStudent(student);
                    payment.setTeacher(teacher);
                    payment.setLesson(lesson);
                    payment.setAmount(rs.getDouble("amount"));
                    payment.setPayDate(rs.getDate("pay_date"));
                    paymentList.add(payment);
                }

            }else{
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JdbcUtility.close(c, ps, rs);
        }
        return paymentList;
    }

    @Override
    public boolean addPayment(Payment payment) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO PAYMENT(ID,S_ID,T_ID,L_ID,AMOUNT)\n" +
                "VALUES (PAYMENT_SEQ.NEXTVAL,?,?,?,?)";
        try {
            c = DBHelper.getConnection();
            if(c!=null){
                ps = c.prepareStatement(sql);
                ps.setLong(1, payment.getStudent().getId());
                ps.setLong(2, payment.getTeacher().getId());
                ps.setLong(3, payment.getLesson().getId());
                ps.setDouble(4, payment.getAmount());
                ps.execute();
                result = true;
            }else{
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            c.commit();
            JdbcUtility.close(c, ps, null);
        }

        return result;
    }

    @Override
    public Payment getPaymentId(Long paymentId) throws Exception {
        Payment payment = new Payment();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ID, S_ID, T_ID, L_ID, AMOUNT FROM PAYMENT WHERE ACTIVE = 1 AND ID = ?";

        try {
            c = DBHelper.getConnection();
            if(c!=null){
                ps = c.prepareStatement(sql);
                ps.setLong(1, paymentId);
                rs = ps.executeQuery();
                while(rs.next()){
                   //ID,
                  //  payment.setId(rs.getLong("ID"));
                    Student student = new Student();
                    student.setId(rs.getLong("S_ID"));
                    Teacher teacher = new Teacher();
                    teacher.setId(rs.getLong("T_ID"));
                    Lesson lesson = new Lesson();
                    lesson.setId(rs.getLong("L_ID"));


                    payment.setStudent(student);
                    payment.setTeacher(teacher);
                    payment.setLesson(lesson);
                    payment.setAmount(rs.getDouble("AMOUNT"));

                }

            }else{
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JdbcUtility.close(c, ps, rs);
        }


        return payment;
    }

    @Override
    public boolean updatePayment(Payment payment) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE PAYMENT SET S_ID=?, T_ID=?, L_ID=?, AMOUNT=?\n" +
                " WHERE ID = ?";

        try{
          c = DBHelper.getConnection();
          if(c!=null){
            ps = c.prepareStatement(sql);
            ps.setLong(1,payment.getStudent().getId());
            ps.setLong(2,payment.getTeacher().getId());
            ps.setLong(3,payment.getLesson().getId());
            ps.setDouble(4,payment.getAmount());
            ps.setLong(5,payment.getId());
            ps.executeQuery();
          }else{
              System.out.println("Connection is null!");
          }
        }catch (Exception ex){
        ex.printStackTrace();
        }finally {
            c.commit();
            JdbcUtility.close(c, ps, null);
        }
        return result;
    }

    @Override
    public List<Payment> searchPaymentData(String keyword) throws Exception {
        List<Payment> paymentList = new ArrayList<Payment>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT p.id   ,s.id STUDENT_ID, s.name STUDENT_NAME, S.SURNAME STUDENT_SURNAME,\n " +
                " t.id TEACHER_ID ,t.name TEACHER_NAME, T.SURNAME TEACHER_SURNAME,l.id LESSON_ID, l.lesson_name, p.amount,\n " +
                "    p.pay_date  FROM PAYMENT P INNER JOIN  STUDENT S  ON p.s_id = s.id  INNER JOIN TEACHER T  ON p.t_id = t.id\n " +
                "            INNER JOIN LESSON L\n " +
                "                       ON p.l_id = l.id\n " +
                " WHERE  p.active = 1 AND s.active = 1 AND t.active = 1 AND l.active = 1 AND \n " +
                " (LOWER(s.name) LIKE LOWER(?) OR LOWER(t.name) LIKE LOWER(?) OR LOWER(l.lesson_name) LIKE LOWER (?))";
        try {
            c = DBHelper.getConnection();
            if(c!=null){
             ps = c.prepareStatement(sql);
             ps.setString(1,"%"+keyword+"%");
             ps.setString(2,"%"+keyword+"%");
             ps.setString(3,"%"+keyword+"%");
             rs = ps.executeQuery();

             while (rs.next()){
                 Payment payment  = new Payment();
                 payment.setId(rs.getLong("ID"));

                 Student student = new Student();
                 student.setId(rs.getLong("STUDENT_ID"));
                 student.setName(rs.getString("STUDENT_NAME"));
                 student.setSurname(rs.getString("STUDENT_SURNAME"));

                 Teacher teacher = new Teacher();
                 teacher.setId(rs.getLong("TEACHER_ID"));
                 teacher.setName(rs.getString("TEACHER_NAME"));
                 teacher.setSurname(rs.getString("TEACHER_SURNAME"));

                 Lesson lesson = new Lesson();
                 lesson.setId(rs.getLong("LESSON_ID"));
                 lesson.setLessonName(rs.getString("lesson_name"));

                 payment.setStudent(student);
                 payment.setTeacher(teacher);
                 payment.setLesson(lesson);
                 payment.setAmount(rs.getDouble("amount"));
                 payment.setPayDate(rs.getDate("pay_date"));
                 paymentList.add(payment);
             }
            }else {
                System.out.println("Connection is null !");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtility.close(c, ps, rs);
        }
        return paymentList;
    }
}


















