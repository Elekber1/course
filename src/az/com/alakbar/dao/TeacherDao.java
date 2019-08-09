package az.com.alakbar.dao;

import az.com.alakbar.model.Teacher;

import java.util.List;

public interface TeacherDao {

    List<Teacher> getTeacherList() throws Exception;
}
