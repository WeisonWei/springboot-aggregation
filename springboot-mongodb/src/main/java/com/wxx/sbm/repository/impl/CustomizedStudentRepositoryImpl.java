package com.wxx.sbm.repository.impl;

import com.wxx.sbm.domain.Student;
import com.wxx.sbm.domain.StudentScore;
import com.wxx.sbm.domain.StudentScores;
import com.wxx.sbm.repository.CustomizedStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.aggregation.LookupOperation.newLookup;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

public class CustomizedStudentRepositoryImpl implements CustomizedStudentRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public StudentScore findStudentScoreByName(String name) {
        return null;
    }

    /**
     * 查找大于"10"岁 性别是"男" 并且 爱好"语文"和"英语"的 童鞋们
     *
     * @return
     */
    public List<Student> findStudentListByAgeAndSexAndHobbies() {
        Query query = query(where("age").gte(10)
                .and("sex").is("Male")
                .orOperator(where("hobbies").is("YuWen"),
                        where("hobbies").is("English")));
        List<Student> students = mongoTemplate.find(query, Student.class, "students");
        return students;

    }

    /**
     * 查询所有童鞋和他们的各科成绩
     * @return
     */
    public List<StudentScores> findStudentScoreList() {
        Aggregation aggregation = Aggregation.newAggregation(
                newLookup()
                        .from("scores")
                        .localField("id")
                        .foreignField("studentId")
                        .as("scores"),
                project()
                        .andExpression("name").as("name")
                        .andExpression("age").as("age")
                        .andExpression("sex").as("sex")
                        .andExpression("scores").as("scoreList"));

        AggregationResults<StudentScores> aggregationResults = mongoTemplate.aggregate(aggregation, "students", StudentScores.class);
        List<StudentScores> studentScores = aggregationResults.getMappedResults();
        return studentScores;
    }

    /**
     * 查询大于"10岁"喜欢"语文"或"英语"的"男孩" 以及他们"英语"成绩
     * @return
     */
    public List<StudentScore> findStudentScores() {
        Aggregation aggregation = Aggregation.newAggregation(
                newLookup()
                        .from("scores")
                        .localField("id")
                        .foreignField("studentId")
                        .as("scores"),
                match(where("age").gte(10)
                        .and("sex").is("Male")
                        .orOperator(where("hobbies").is("YuWen"), where("hobbies").is("English"))
                        .and("scores.subject").is("English")
                ),
                project()
                        .andExpression("name").as("name")
                        .andExpression("age").as("age")
                        .andExpression("sex").as("sex")
                        .andExpression("scores").as("score"),
                unwind("scoreList"));

        AggregationResults<StudentScore> aggregationResults = mongoTemplate.aggregate(aggregation, "students", StudentScore.class);
        List<StudentScore> studentScores = aggregationResults.getMappedResults();
        return studentScores;
    }
}
