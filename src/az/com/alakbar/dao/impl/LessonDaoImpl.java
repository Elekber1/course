package az.com.alakbar.dao.impl;

import az.com.alakbar.dao.DBHelper;
import az.com.alakbar.dao.LessonDao;
import az.com.alakbar.model.Lesson;
import az.com.alakbar.util.JdbcUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LessonDaoImpl implements LessonDao {
    @Override
    public List<Lesson> getLessonList() throws Exception {
        List<Lesson> lessonList = new ArrayList<>();
        Connection c = null;  // connection db
        PreparedStatement ps = null; // sql-i run almaga hazirilayir
        ResultSet rs = null; // sql den qayidan neticeni ozunde sahliyir
        String sql = "SELECT  ID, LESSON_NAME, LESSON_TIME, LESSON_PRICE FROM LESSON " +
                "WHERE ACTIVE = 1";
        try {
            c = DBHelper.getConnection();
            if(c!=null){
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()){
                    Lesson lesson = new Lesson();
                   // lesson.setR(rs.getLong('r'));
                    lesson.setId(rs.getLong("ID"));
                    lesson.setLessonName(rs.getString("LESSON_NAME"));
                    lesson.setLessonTime(rs.getInt("LESSON_TIME"));
                    lesson.setLessonPrice(rs.getDouble("LESSON_PRICE"));
                    lessonList.add(lesson);
                }
                }else{
                System.out.println("Connection is null!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtility.close(c,ps,rs);
        }
        return lessonList;
    }
}
