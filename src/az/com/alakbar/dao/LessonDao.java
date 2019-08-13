package az.com.alakbar.dao;

import az.com.alakbar.model.Lesson;

import java.util.List;

public interface LessonDao {

    List<Lesson> getLessonList() throws Exception;
}
