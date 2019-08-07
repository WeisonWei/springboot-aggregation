package com.wxx.sbm.service;

import com.wxx.sbm.domain.Student;
import com.wxx.sbm.domain.StudentScore;
import com.wxx.sbm.domain.StudentScores;
import com.wxx.sbm.repository.CustomizedStudentRepository;
import com.wxx.sbm.repository.StudentRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CustomizedStudentRepository customizedStudentRepository;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Integer deleteStudentByName(String name) {
        return studentRepository.deleteStudentByName(name);
    }


    public Student updateStudent(Student student) {
        Student studentByName = studentRepository.findStudentByName(student.getName());
        student.setId(studentByName.getId());
        Student saveStudent = studentRepository.save(student);
        return saveStudent;
    }


    public Student findStudentById(ObjectId id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional.orElseGet(Student::new);
    }

    public Student findStudentByNameAndSex(String name, String sex) {
        Student student = studentRepository.findStudentByNameAndSex(name, sex);
        return student;
    }

    public List<Student> findStudents() {
        List<Student> students = (List) studentRepository.findAll();
        return students;
    }

    public List<Student> findStudentsById(List<ObjectId> ids) {
        List<Student> students = (List) studentRepository.findAllById(ids);
        return students;
    }

    public List<Student> findStudentListByAgeAndSexAndHobbies() {
        List<Student> studentList = customizedStudentRepository.findStudentListByAgeAndSexAndHobbies();
        return studentList;
    }

    public List<StudentScores> findStudentScoreList() {
        List<StudentScores> studentScoreList = customizedStudentRepository.findStudentScoreList();
        return studentScoreList;
    }
    public List<StudentScore> findStudentScores() {
        List<StudentScore> studentScoreList = customizedStudentRepository.findStudentScores();
        return studentScoreList;
    }



}
