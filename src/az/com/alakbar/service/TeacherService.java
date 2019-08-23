package az.com.alakbar.service;

import az.com.alakbar.model.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getTeacherList() throws Exception;
    List<Teacher> getTeacherComboByLessonId(Long lessonId) throws Exception;
}
