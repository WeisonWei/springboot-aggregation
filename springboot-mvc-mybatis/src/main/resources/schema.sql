CREATE DATABASE IF NOT EXISTS `studentService`;

CREATE TABLE IF NOT EXISTS `t_student`
(
    `id`      INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name`    VARCHAR(255) DEFAULT NULL COMMENT '姓名',
    `age`     INT          DEFAULT 10 COMMENT '年龄',
    `sex`     VARCHAR(255) DEFAULT NULL COMMENT '性别',
    `hobbies` VARCHAR(255) DEFAULT NULL COMMENT '爱好',
    `address` VARCHAR(255) DEFAULT NULL COMMENT '住址',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `idx_student_name_address` (`name`, `address`) USING BTREE
) ENGINE = INNODB
  DEFAULT CHARSET = utf8
  AUTO_INCREMENT = 1 COMMENT '学生表';

CREATE TABLE IF NOT EXISTS `t_score`
(
    `id`            INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `student_id`    INT          DEFAULT NULL COMMENT '学生ID',
    `student_name`  VARCHAR(255) DEFAULT NULL COMMENT '学生姓名',
    `subject`       VARCHAR(255) DEFAULT NULL COMMENT '学科',
    `subject_score` INT COMMENT '学科成绩',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `idx_score_studentname_subject` (`student_name`, `subject`) USING BTREE,
    FOREIGN KEY (student_id) REFERENCES t_student (id)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8
  AUTO_INCREMENT = 1 COMMENT '学生成绩表';