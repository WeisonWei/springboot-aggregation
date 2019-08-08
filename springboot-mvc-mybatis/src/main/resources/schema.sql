CREATE DATABASE IF NOT EXISTS `studentService`;

CREATE TABLE `t_student`
(
    `id`      int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name`    varchar(255) DEFAULT '' COMMENT '姓名',
    `age`     int(11)      DEFAULT '10' COMMENT '年龄',
    `sex`     varchar(255) DEFAULT 'Male' COMMENT '性别',
    `hobbies` varchar(255) DEFAULT '' COMMENT '爱好',
    `address` varchar(255) DEFAULT '' COMMENT '住址',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_student_name_address` (`name`, `address`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8 COMMENT ='学生表';

CREATE TABLE `t_score`
(
    `id`            int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `student_id`    int(11)      DEFAULT '0' COMMENT '学生ID',
    `student_name`  varchar(255) DEFAULT '' COMMENT '学生姓名',
    `subject`       varchar(255) DEFAULT '' COMMENT '学科',
    `subject_score` int(11)      DEFAULT NULL COMMENT '学科成绩',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_score_studentname_subject` (`student_name`, `subject`) USING BTREE,
    CONSTRAINT `t_score_ibfk_1` FOREIGN KEY (`student_name`) REFERENCES `t_student` (`name`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 10
  DEFAULT CHARSET = utf8 COMMENT ='学生成绩表';