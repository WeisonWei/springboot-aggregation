package com.wxx.sbmm.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Score {

    private Integer id;
    //学生编号
    private Integer studentId;

    private String studentName;
    //科目
    private String subject;
    //科目成绩
    private Integer subjectScore;
}

