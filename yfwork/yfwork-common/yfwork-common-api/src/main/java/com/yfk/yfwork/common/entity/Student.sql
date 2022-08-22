-- auto Generated on 2022-08-08
-- DROP TABLE IF EXISTS student;
CREATE TABLE student
(
    id         INT(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
    `name`     VARCHAR(50) COMMENT '姓名',
    age        INT(11) COMMENT '年龄',
    email      VARCHAR(50) COMMENT '邮箱',
    `password` VARCHAR(50) COMMENT '密码',
    phone      VARCHAR(50) COMMENT '电话',
    address    VARCHAR(50) COMMENT '地址',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT 'student';
