package az.com.alakbar.service;

import az.com.alakbar.model.Student;

import java.util.List;

public interface StudentService  {

    List<Student> getStudentList() throws Exception;

    Student getStudentById(Long studentId) throws Exception;

    boolean addStudent(Student student) throws Exception;

    boolean updateStudent(Student student,Long studentId) throws Exception;

    boolean deleteStudent(Long studentId)throws Exception;

    List<Student> searchStudentData(String keyword) throws Exception;
}
