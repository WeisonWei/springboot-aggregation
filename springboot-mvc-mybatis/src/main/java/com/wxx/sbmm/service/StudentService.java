package com.wxx.sbmm.service;

import com.wxx.sbmm.domain.Student;
import com.wxx.sbmm.domain.StudentScore;
import com.wxx.sbmm.domain.StudentScores;
import com.wxx.sbmm.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    @Resource
    private StudentMapper studentMapper;


    public Integer addStudent(Student student) {
        return studentMapper.saveStudent(student);
    }

    public Integer deleteStudentByName(String name) {
        return studentMapper.deleteStudentByName(name);
    }

    public Integer deleteByStudent(Student student) {
        return studentMapper.deleteByStudent(student);
    }

    public Integer updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }


    public Student findStudentByName(String name) {
        return studentMapper.findStudentByName(name);
    }

    public List<Student> findStudents() {
        return studentMapper.findStudents();
    }

    public List<Student> findStudentByMap(Map<String, String> map) {
        return studentMapper.findStudentByMap(map);
    }

    public List<Student> findStudentByStudent(Student student) {
        return studentMapper.findStudentByStudent(student);
    }


    public List<Student> findStudentByAgeAndSex(Integer age, String sex) {
        return studentMapper.findStudentByAgeAndSex(age, sex);
    }

    public List<StudentScores> findStudentScores() {
        return studentMapper.findStudentScores();
    }

    public List<StudentScore> findStudentScore() {
        return studentMapper.findStudentScore();
    }


}