package com.wxx.sbmm.controller;

import com.wxx.sbmm.domain.Student;
import com.wxx.sbmm.domain.StudentScore;
import com.wxx.sbmm.domain.StudentScores;
import com.wxx.sbmm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public Integer saveStudent(@RequestBody Student student) {
        Integer addNum = studentService.addStudent(student);
        return addNum;
    }

    @DeleteMapping("/students/{name}")
    public Integer deleteStudentByName(@PathVariable String name) {
        Integer deleteNum = studentService.deleteStudentByName(name);
        return deleteNum;
    }

    @DeleteMapping("/students")
    public Integer deleteStudentByStudent(@RequestBody Student student) {
        Integer deleteNum = studentService.deleteByStudent(student);
        return deleteNum;
    }

    @PutMapping("/students")
    public Integer updateStudent(@RequestBody Student student) {
        Integer updateNum = studentService.updateStudent(student);
        return updateNum;
    }

    @GetMapping("/students/{name}")
    public Student findStudentByName(@PathVariable String name) {
        Student student = studentService.findStudentByName(name);
        return student;
    }

    @GetMapping("/students")
    public List<Student> getStudentListByAgeAndSexAndHobbies() {
        List<Student> studentList = studentService.findStudents();
        return studentList;
    }

    @GetMapping("/students/map")
    public List<Student> findStudentByMap() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Even");
        List<Student> studentList = studentService.findStudentByMap(map);
        return studentList;
    }

    @GetMapping("/students/st")
    public List<Student> findStudentByStudent() {
        List<Student> studentList = studentService.findStudentByStudent(Student.builder().name("Even").build());
        return studentList;
    }

    @GetMapping("/students/{age}/{sex}")
    public List<Student> findStudentByAgeAndSex(@PathVariable Integer age, @PathVariable String sex) {
        List<Student> studentList = studentService.findStudentByAgeAndSex(age, sex);
        return studentList;
    }

    @GetMapping("/students/scores")
    public List<StudentScores> findStudentScores() {
        List<StudentScores> studentList = studentService.findStudentScores();
        return studentList;
    }

    @GetMapping("/students/score")
    public List<StudentScore> findStudentScore() {
        List<StudentScore> studentScores = studentService.findStudentScore();
        return studentScores;
    }

}