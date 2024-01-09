package com.alesyagit.demospringbootapp.service;

import com.alesyagit.demospringbootapp.model.Student;

import java.util.List;

public interface StudentService {

    Student addStudentMethod(Student student);
    List<Student> getStudents();
    Student updateStudentMethod(Student student,Long Id);
    void deleteStudentMethod(Long id);
    Student getStudentById(Long id);


}
