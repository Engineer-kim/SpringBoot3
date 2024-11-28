package com.rest.umm.controller;

import com.rest.umm.entity.Student;
import com.rest.umm.handler.StudentErrorResponse;
import com.rest.umm.handler.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> students;
    //초기 한번만 호출하여 정보 생성
    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();
        students.add(new Student("kim", "hanjin"));
        students.add(new Student("kim2", "hanjin2"));
        students.add(new Student("kim3", "hanjin3"));
        students.add(new Student("kim5", "hanjin5"));
    }
    
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if((studentId < 0) || (studentId > students.size())) {
            throw new StudentNotFoundException("Student not found");
        }

        return students.get(studentId);

    }

    @ExceptionHandler(StudentNotFoundException.class)
        public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException studentNotFoundException){

        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setMessage("Student not found");
        studentErrorResponse.setMessage(studentNotFoundException.getMessage());
        studentErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND);
    }
}
