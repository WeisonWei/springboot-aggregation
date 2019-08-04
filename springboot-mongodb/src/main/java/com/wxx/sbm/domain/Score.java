package com.wxx.sbm.domain;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "scores")
public class Score {
    @Id
    private ObjectId id;
    //学生编号
    private ObjectId studentId;
    //科目
    private String subject;
    //科目成绩
    private Integer subjectScore;
}
