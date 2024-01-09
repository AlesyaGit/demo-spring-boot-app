package com.alesyagit.demospringbootapp.controller;

import com.alesyagit.demospringbootapp.exceptions.StudentNotFoundException;
import com.alesyagit.demospringbootapp.model.Student;
import com.alesyagit.demospringbootapp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/all/students")
@RequiredArgsConstructor
public class StudentController {

 //into this class we created our end-points

    private final StudentService studentService;


    @GetMapping
    public ResponseEntity<List<Student>>getStudents(){
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.FOUND);
    }


    //to catch exception with message,not with 500 error
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> handleStudentNotFoundException(StudentNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student){
       return studentService.addStudentMethod(student);
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@RequestBody Student student,@PathVariable Long id){
        return studentService.updateStudentMethod(student,id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudentMethod(id);
    }

    @GetMapping("/find/student/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

}
