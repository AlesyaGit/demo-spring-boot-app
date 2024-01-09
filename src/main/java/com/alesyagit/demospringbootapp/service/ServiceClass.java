package com.alesyagit.demospringbootapp.service;

import com.alesyagit.demospringbootapp.exceptions.StudentExistsException;
import com.alesyagit.demospringbootapp.exceptions.StudentNotFoundException;
import com.alesyagit.demospringbootapp.model.Student;
import com.alesyagit.demospringbootapp.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor//inject repository into this class
public class ServiceClass implements StudentService {


    //this class was created for some database CRUD methods

    private final StudentRepository studentRepository;
    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student addStudentMethod(Student student) {
        if(studentExists(student.getEmail())){
            throw new StudentExistsException("Student:" + student.getEmail() + "already exists!");
        }
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudentMethod(Student updatedStudent, Long id) {
        return studentRepository.findById(id).map(student -> {
            student.setFirst_name(updatedStudent.getFirst_name());
            student.setLast_name(updatedStudent.getLast_name());
            student.setEmail(updatedStudent.getEmail());
            student.setDepartment(updatedStudent.getDepartment());
            return studentRepository.save(student);
        }).orElseThrow(() -> new StudentNotFoundException("There is no such student in our database"));
    }


    @Override
    public void deleteStudentMethod(Long id) {
        if(!studentRepository.existsById(id)){
            throw new StudentNotFoundException("Student couldn't be found!");
        }
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("Student with this id:" + id + "wasn't found"));
    }

    private boolean studentExists(String email) {
        return studentRepository.findByEmail(email).isPresent();
    }
}
