package com.wxx.sbm.repository;

import com.wxx.sbm.domain.StudentScore;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomizedStudentRepository {

    public StudentScore findStudentScoreByName(String name);
}
