-- db01
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`(
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    `username` VARCHAR(128) NOT NULL COMMENT '用户名称',
    `balance` INT NOT NULL COMMENT '余额',
    PRIMARY KEY (`id`)
)ENGINE=INNODB;

INSERT INTO `account`(`id`, `username`, `balance`) VALUES (1, 'X', 2000);
INSERT INTO `account`(`id`, `username`, `balance`) VALUES (2, 'Y', 1000);
INSERT INTO `account`(`id`, `username`, `balance`) VALUES (3, 'Z', 3000);


-- db02
DROP TABLE IF EXISTS count_helper;
CREATE TABLE `count_helper`(
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    `type` INT(1) DEFAULT 0 COMMENT '统计类型',
    `fn_account` VARCHAR(128) DEFAULT NULL COMMENT '账户',
    `count` INT(11) DEFAULT 0 COMMENT '总数',
    `year` INT(4) DEFAULT 1970 COMMENT '年',
    `month` INT(2) DEFAULT 1 COMMENT '月',
    `date` INT(6) NOT NULL COMMENT '日期：20210211',
    `create_time` timestamp NULL COMMENT '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `create_by` VARCHAR(128) DEFAULT NULL COMMENT '创建人',
    `update_by` VARCHAR(128) DEFAULT NULL COMMENT '更新人',
    PRIMARY KEY (`id`),
    UNIQUE KEY `a_d`(`fn_account`,`type`,`date`)
)ENGINE=INNODB;

SHOW INDEX FROM count_helper;

