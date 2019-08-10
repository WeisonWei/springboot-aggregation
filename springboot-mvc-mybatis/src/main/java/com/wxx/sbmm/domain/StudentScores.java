package com.wxx.sbmm.domain;

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
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private List<Score> scoreList;
}
