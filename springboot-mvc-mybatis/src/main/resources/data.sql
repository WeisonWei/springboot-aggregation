INSERT INTO t_student (name,age, sex, hobbies,  address)
  SELECT "Even",9,"Male","ShuXue,English","XiAn" FROM DUAL WHERE NOT EXISTS(SELECT 1 FROM t_student WHERE name = "Even");
INSERT INTO t_student (name,age, sex, hobbies,  address)
  SELECT "Weison",11,"Male","YuWen,WuLi","HeNan" FROM DUAL WHERE NOT EXISTS(SELECT 1 FROM t_student WHERE name = "Weison");
INSERT INTO t_student (name,age, sex, hobbies,  address)
  SELECT "Angule",13,"Female","YuWen,English","Chengdu" FROM DUAL WHERE NOT EXISTS(SELECT 1 FROM t_student WHERE name = "Angule");



INSERT INTO t_score (student_id,student_name, subject,  subject_score)
  SELECT 1,"Even","YuWen",90 FROM DUAL WHERE NOT EXISTS(SELECT 1 FROM t_score WHERE student_name = "Even" and subject ="YuWen");

INSERT INTO t_score (student_id,student_name, subject,  subject_score)
  SELECT 1,"Even","ShuXue",89 FROM DUAL WHERE NOT EXISTS(SELECT 1 FROM t_score WHERE student_name = "Even" and subject ="ShuXue");

INSERT INTO t_score (student_id,student_name, subject,  subject_score)
  SELECT 1,"Even","English",67 FROM DUAL WHERE NOT EXISTS(SELECT 1 FROM t_score WHERE student_name = "Even" and subject ="English");

INSERT INTO t_score (student_id,student_name, subject,  subject_score)
  SELECT 2,"Weison","YuWen",69 FROM DUAL WHERE NOT EXISTS(SELECT 1 FROM t_score WHERE student_name = "Weison" and subject ="YuWen");
INSERT INTO t_score (student_id,student_name, subject,  subject_score)
  SELECT 2,"Weison","ShuXue",94 FROM DUAL WHERE NOT EXISTS(SELECT 1 FROM t_score WHERE student_name = "Weison" and subject ="ShuXue");
INSERT INTO t_score (student_id,student_name, subject,  subject_score)
  SELECT 2,"Weison","English",82 FROM DUAL WHERE NOT EXISTS(SELECT 1 FROM t_score WHERE student_name = "Weison" and subject ="English");


INSERT INTO t_score (student_id,student_name, subject,  subject_score)
  SELECT 3,"Angule","YuWen",58 FROM DUAL WHERE NOT EXISTS(SELECT 1 FROM t_score WHERE student_name = "Angule" and subject ="YuWen");
INSERT INTO t_score (student_id,student_name, subject,  subject_score)
  SELECT 3,"Angule","ShuXue",73 FROM DUAL WHERE NOT EXISTS(SELECT 1 FROM t_score WHERE student_name = "Angule" and subject ="ShuXue");
INSERT INTO t_score (student_id,student_name, subject,  subject_score)
  SELECT 3,"Angule","English",91 FROM DUAL WHERE NOT EXISTS(SELECT 1 FROM t_score WHERE student_name = "Angule" and subject ="English");

commit;