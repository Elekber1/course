package az.com.alakbar.dao.impl;

import az.com.alakbar.dao.DBHelper;
import az.com.alakbar.dao.StudentDao;
import az.com.alakbar.model.Student;
import az.com.alakbar.util.JdbcUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl  implements StudentDao{

    @Override
    public List<Student> getStudentList() throws Exception {
        List<Student> studentList = new ArrayList<>();
        Connection c = null; //Connection db
        PreparedStatement ps = null; //sql-i run  olunmaga hazirlayir
        ResultSet rs = null; //sql den qayidan neticeni ozunde saxliyir
        String sql = "SELECT ROWNUM r, ID,NAME,SURNAME,DOB,ADDRESS,PHONE FROM STUDENT"
                + " WHERE ACTIVE = 1 ";
        try {
            c = DBHelper.getConnection();//rs.getLong("ID")
            if(c!=null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()) {
                    Student student = new Student();
                    student.setR(rs.getLong("r"));
                    student.setId(rs.getLong("ID"));
                    student.setName(rs.getString("NAME"));
                    student.setSurname(rs.getString("SURNAME"));
                    student.setDob(rs.getDate("DOB"));
                    student.setAddress(rs.getString("ADDRESS"));
                    student.setPhone(rs.getString("PHONE"));
                    studentList.add(student);
                }
            }else {
                System.out.println("Connection is null !");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JdbcUtility.close(c, ps, rs);
        }
        return studentList;
    }

    @Override
    public boolean addStudent(Student student) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO STUDENT(ID,NAME,SURNAME,DOB,ADDRESS,PHONE,EMAIL)\r\n" +
                "VALUES(STUDENT_SEQ1.NEXTVAL,?,?,?,?,?,?)";
        try {
            c = DBHelper.getConnection();
            if(c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, student.getName());
                ps.setString(2, student.getSurname());
                ps.setDate(3, new java.sql.Date(student.getDob().getTime()));
                ps.setString(4, student.getAddress());
                ps.setString(5, student.getPhone());
                ps.setString(6,student.getEmail());
                ps.execute();
                result = true;
            }else {
                System.out.println("Connection is null !");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            c.commit();
            JdbcUtility.close(c, ps, null);
        }
        return result;
    }

    @Override
    public Student getStudentById(Long studentId) throws Exception {
        Student student = new Student();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ID,NAME,SURNAME,DOB,ADDRESS,PHONE FROM STUDENT"
                + " WHERE ACTIVE = 1 AND ID = ?";
        try {
            c = DBHelper.getConnection();
            if(c!=null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, studentId);
                rs = ps.executeQuery();
                while(rs.next()) {
                    student.setName(rs.getString("NAME"));
                    student.setSurname(rs.getString("SURNAME"));
                    student.setDob(rs.getDate("DOB"));
                    student.setAddress(rs.getString("ADDRESS"));
                    student.setPhone(rs.getString("PHONE"));
                }
            }else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtility.close(c, ps, rs);
        }
        return student;
    }

    @Override
    public boolean updateStudent(Student student, Long studentId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE  STUDENT SET NAME = ?,SURNAME = ?,DOB = ?,"
                + "ADDRESS = ?,PHONE = ? WHERE ID = ?";

        try {
            c = DBHelper.getConnection();
            if(c!=null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, student.getName());
                ps.setString(2, student.getSurname());
                ps.setDate(3, new java.sql.Date(student.getDob().getTime()));
                ps.setString(4, student.getAddress());
                ps.setString(5, student.getPhone());
                ps.setLong(6, studentId);
                ps.execute();
                result = true;
            }else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public boolean deleteStudent(Long studentId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "DELETE FROM STUDENT WHERE ID= ?";

        try {
            c = DBHelper.getConnection();
            if(c!=null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, studentId);
                ps.execute();
                result = true;
            }else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtility.close(c, ps, rs);
        }

        return result;
    }

    @Override
    public List<Student> searchStudentData(String keyword) throws Exception {

        List<Student> studentList = new ArrayList<Student>();
        Connection c = null; //Connection db
        PreparedStatement ps = null; //sql-i run  olunmaga hazirlayir
        ResultSet rs = null; //sql den qayidan neticeni ozunde saxliyir
        String sql = "SELECT ROWNUM R, ID,NAME,SURNAME,DOB,ADDRESS,PHONE FROM STUDENT\r\n" +
                "WHERE ACTIVE = 1 AND (LOWER(NAME) LIKE LOWER(?) OR LOWER(SURNAME) LIKE LOWER(?)"
                + " OR LOWER(ADDRESS) LIKE LOWER(?))";

        try {
            c = DBHelper.getConnection();//rs.getLong("ID")
            if(c!=null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, "%"+keyword+"%");
                ps.setString(2, "%"+keyword+"%");
                ps.setString(3, "%"+keyword+"%");
                rs = ps.executeQuery();
                while(rs.next()) {
                    Student student = new Student();
                    student.setR(rs.getLong("r"));
                    student.setId(rs.getLong("ID"));
                    student.setName(rs.getString("NAME"));
                    student.setSurname(rs.getString("SURNAME"));
                    student.setDob(rs.getDate("DOB"));
                    student.setAddress(rs.getString("ADDRESS"));
                    student.setPhone(rs.getString("PHONE"));
                    studentList.add(student);
                }
            }else {
                System.out.println("Connection is null !");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JdbcUtility.close(c, ps, rs);
        }
        return studentList;

    }


}
