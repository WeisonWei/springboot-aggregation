package com.wxx.sbm.repository;

import com.wxx.sbm.domain.Student;
import com.wxx.sbm.domain.StudentScore;
import com.wxx.sbm.domain.StudentScores;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomizedStudentRepository {

    public StudentScore findStudentScoreByName(String name);

    public List<Student> findStudentListByAgeAndSexAndHobbies();

    public List<StudentScores> findStudentScoreList();

    public List<StudentScore> findStudentScores();
}
