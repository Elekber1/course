package az.com.alakbar.service.impl;

import az.com.alakbar.dao.LessonDao;
import az.com.alakbar.model.Lesson;
import az.com.alakbar.service.LessonService;

import java.util.List;

public class LessonServiceImpl implements LessonService {

    private LessonDao lessonDao;

    public LessonServiceImpl(LessonDao lessonDao) {
        this.lessonDao = lessonDao;
    }

    @Override
    public List<Lesson> getLessonList() throws Exception {
        return lessonDao.getLessonList();
    }
}
