package com.wxx.sbmm.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentScore {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private Score score;
}
