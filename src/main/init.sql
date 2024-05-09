create schema atd collate utf8_unicode_ci;

DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`
(
    `uid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `rid` int not null,
    `nickName`varchar(256) null,
    `account` varchar(256) not null,
    `password` varchar(100) not null comment '登录密码',
    `entryDate` datetime  not null comment '注册时间',
    `notifyEnabled` tinyint(1) DEFAULT '0',
    `email`varchar(255) not null,

    PRIMARY KEY (`uid`)
)
  DEFAULT CHARSET = utf8;
INSERT INTO `user_info` (`uid`, `rid`, `nickName`, `account`, `password`, `entryDate`, `notifyEnabled`, `email`)
VALUES ('1000', '1', '', 'kkklong', '123456', '20221101', '0', 'kkkdark@hotmail.com');

DROP TABLE IF EXISTS `soyal`;
CREATE TABLE `soyal`
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT,
    `uid`         bigint(20)   not null comment '人員id',
    `account`     varchar(256) not null,
    `clockatd`  datetime    not null comment '打卡時間',

    PRIMARY KEY (`id`)
) DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `attendance_record`;
CREATE TABLE `attendance_record`
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT,
    `uid`         bigint(20)   not null comment '人員id',
    `account`     varchar(256) not null,
    `morningAtd`  datetime    not null comment '打卡時間',
    `eveningAtd`  datetime    not null comment '打卡時間',

    PRIMARY KEY (`id`)
) DEFAULT CHARSET = utf8;
