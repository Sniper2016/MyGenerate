create database test_db;

DROP TABLE IF EXISTS `test_userInfo`;
CREATE TABLE `test_userInfo` (
  `id` int(11) NOT NULL COMMENT '玩家ID',
  `name` varchar(100) DEFAULT NULL COMMENT '玩家名字',
  `age` int(1) DEFAULT NULL COMMENT '玩家年纪',
  `schoolName` varchar(100) DEFAULT NULL COMMENT '玩家学校名称',
  `birthDay` date DEFAULT NULL COMMENT '玩家生日',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='玩家信息';