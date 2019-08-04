package com.wxx.sbm.repository;

import com.wxx.sbm.domain.Student;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, ObjectId> {

    public Student findStudentByName(String name);

    public Student findStudentByNameAndSex(String name, String sex);

    public Student findStudentByNameIn(List<String> name);


}
