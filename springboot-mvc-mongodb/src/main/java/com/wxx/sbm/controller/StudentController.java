package com.wxx.sbm.controller;

import com.wxx.sbm.domain.Student;
import com.wxx.sbm.domain.StudentScore;
import com.wxx.sbm.domain.StudentScores;
import com.wxx.sbm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getStudentList() {
        List<Student> students = studentService.findStudents();
        return students;
    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student) {
        Student addStudent = studentService.addStudent(student);
        return addStudent;
    }

    @DeleteMapping("/students/{name}")
    public Integer deleteStudentByName(@PathVariable String name) {
        Integer deleteNum = studentService.deleteStudentByName(name);
        return deleteNum;
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        Student updateStudent = studentService.updateStudent(student);
        return updateStudent;
    }

    @GetMapping("/students/list")
    public List<Student> getStudentListByAgeAndSexAndHobbies() {
        List<Student> studentList = studentService.findStudentListByAgeAndSexAndHobbies();
        return studentList;
    }

    @GetMapping("/students/scores")
    public List<StudentScores> getStudentScoresList() {
        List<StudentScores> studentList = studentService.findStudentScoreList();
        return studentList;
    }

    @GetMapping("/students/score")
    public List<StudentScore> getStudentScoreList() {
        List<StudentScore> studentScores = studentService.findStudentScores();
        return studentScores;
    }

}



