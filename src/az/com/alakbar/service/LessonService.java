package az.com.alakbar.service;

import az.com.alakbar.model.Lesson;

import java.util.List;

public interface LessonService {

    List<Lesson> getLessonList() throws Exception;
}
