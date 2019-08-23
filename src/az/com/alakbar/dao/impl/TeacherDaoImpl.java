package az.com.alakbar.dao.impl;

import az.com.alakbar.dao.DBHelper;
import az.com.alakbar.dao.TeacherDao;
import az.com.alakbar.model.Teacher;
import az.com.alakbar.util.JdbcUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao {


    @Override
    public List<Teacher> getTeacherList() throws Exception {
        List<Teacher> teacherList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ID,NAME,SURNAME,DOB,ADDRESS,PHONE FROM TEACHER WHERE ACTIVE = 1";
        try {
            c = DBHelper.getConnection();
            if(c!=null){
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()){
                    Teacher teacher = new Teacher();
                    teacher.setId(rs.getLong("ID"));
                    teacher.setName(rs.getString("NAME"));
                    teacher.setSurname(rs.getString("SURNAME"));
                    teacher.setDob(rs.getDate("DOB"));
                    teacher.setAddress(rs.getString("ADDRESS"));
                    teacher.setPhone(rs.getString("PHONE"));
                    teacherList.add(teacher);
                }
            }else{
                System.out.println("Connecion is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JdbcUtility.close(c, ps, rs);
        }

        return teacherList;
    }

    @Override
    public List<Teacher> getTeacherComboByLessonId(Long lessonId) throws Exception {
        List<Teacher> teacherList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT DISTINCT T.ID,T.NAME,T.SURNAME FROM PAYMENT P \n" +
                " INNER JOIN TEACHER T ON P.T_ID = T.ID \n" +
                " INNER JOIN LESSON L ON P.L_ID = L.ID \n" +
                " WHERE T.ACTIVE = 1 AND L.ID = ? ";
        try {
            c = DBHelper.getConnection();
            if(c!=null){
                ps = c.prepareStatement(sql);
                ps.setLong(1,lessonId);
                rs = ps.executeQuery();
                while(rs.next()){
                    Teacher teacher = new Teacher();
                    teacher.setId(rs.getLong("ID"));
                    teacher.setName(rs.getString("NAME"));
                    teacher.setSurname(rs.getString("SURNAME"));
                    teacherList.add(teacher);
                }
            }else{
                System.out.println("Connecion is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JdbcUtility.close(c, ps, rs);
        }

        return teacherList;
    }
}
