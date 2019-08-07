package com.wxx.sbm.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wxx.sbm.common.ObjectIdSerializer;
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
    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId id;
    //学生编号
    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId studentId;

    private String studentName;
    //科目
    private String subject;
    //科目成绩
    private Integer subjectScore;
}

