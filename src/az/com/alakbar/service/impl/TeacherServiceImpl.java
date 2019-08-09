package az.com.alakbar.service.impl;

import az.com.alakbar.dao.TeacherDao;
import az.com.alakbar.model.Teacher;
import az.com.alakbar.service.TeacherService;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    private TeacherDao teacherDao;

    public TeacherServiceImpl(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public List<Teacher> getTeacherList() throws Exception {
        return teacherDao.getTeacherList();
    }
}
