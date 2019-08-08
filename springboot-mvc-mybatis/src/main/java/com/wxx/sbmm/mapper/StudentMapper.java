package com.wxx.sbmm.mapper;


import com.wxx.sbmm.domain.Student;
import com.wxx.sbmm.domain.StudentScore;
import com.wxx.sbmm.domain.StudentScores;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    // 增删改查
    Student saveStudent(Student student);

    Integer deleteStudentByName(@Param("name") String name);

    Integer deleteByStudent(Student student);

    Student updateStudent(Student student);

    // 5种查询
    Student findStudentByName(@Param("name") String name);

    List<Student> findStudents();

    List<Student> findStudentByMap(Map<String, String> map);

    List<Student> findStudentByStudent(Student student);

    List<Student> findStudentByAgeAndSex(Integer age, String sex);

    // 关联查询
    List<StudentScores> findStudentScores();

    List<StudentScore> findStudentScore();


}