package com.wxx.sbm.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentScores {
    private String name;
    private Integer age;
    private String sex;
    private List<Score> scoreList;
}
