/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : department_sys

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2017-11-28 20:12:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bedroom_inf
-- ----------------------------
DROP TABLE IF EXISTS `bedroom_inf`;
CREATE TABLE `bedroom_inf` (
  `bedroom_id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `star` int(11) DEFAULT NULL,
  `updateTime` date DEFAULT NULL,
  `used` bit(1) NOT NULL,
  `building_id` int(11) NOT NULL,
  `meter_id` int(11) NOT NULL,
  PRIMARY KEY (`bedroom_id`),
  KEY `FK_cicq5e315jmvp23io98i6db0u` (`building_id`),
  KEY `FK_9lu9we8hlc63uxb6qy0arubvd` (`meter_id`),
  CONSTRAINT `FK_9lu9we8hlc63uxb6qy0arubvd` FOREIGN KEY (`meter_id`) REFERENCES `meter_inf` (`meter_id`),
  CONSTRAINT `FK_cicq5e315jmvp23io98i6db0u` FOREIGN KEY (`building_id`) REFERENCES `building_inf` (`building_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bedroom_inf
-- ----------------------------
INSERT INTO `bedroom_inf` VALUES ('1', '102', '60', '5', '2017-09-07', '', '1', '1');
INSERT INTO `bedroom_inf` VALUES ('2', '102', '99', '3', '2017-09-06', '', '1', '2');
INSERT INTO `bedroom_inf` VALUES ('3', '103', '0', '4', '2017-09-06', '', '1', '3');
INSERT INTO `bedroom_inf` VALUES ('4', '201', '0', '2', '2017-05-16', '', '1', '4');
INSERT INTO `bedroom_inf` VALUES ('5', '202', '0', '2', '2017-05-16', '', '1', '5');
INSERT INTO `bedroom_inf` VALUES ('6', '203', '0', '5', '2017-05-16', '', '1', '6');
INSERT INTO `bedroom_inf` VALUES ('7', '301', '76', '3', '2017-05-16', '', '1', '7');
INSERT INTO `bedroom_inf` VALUES ('8', '302', '79', '3', '2017-05-16', '', '1', '8');
INSERT INTO `bedroom_inf` VALUES ('9', '303', '88', '4', '2017-09-06', '', '1', '9');
INSERT INTO `bedroom_inf` VALUES ('10', '101', '91', '5', '2017-05-06', '', '2', '10');
INSERT INTO `bedroom_inf` VALUES ('11', '102', '69', '1', '2017-05-06', '', '2', '11');
INSERT INTO `bedroom_inf` VALUES ('12', '101', '88', '3', '2017-05-06', '', '3', '12');
INSERT INTO `bedroom_inf` VALUES ('13', '101', '74', '2', '2017-05-06', '', '4', '13');
INSERT INTO `bedroom_inf` VALUES ('14', '101', '87', '3', '2017-05-06', '', '5', '14');
INSERT INTO `bedroom_inf` VALUES ('15', '101', '76', '2', '2017-05-06', '', '6', '15');
INSERT INTO `bedroom_inf` VALUES ('16', '101', '74', '2', '2017-05-06', '', '7', '16');
INSERT INTO `bedroom_inf` VALUES ('17', '101', '83', '3', '2017-05-06', '', '8', '17');
INSERT INTO `bedroom_inf` VALUES ('18', '101', '66', '1', '2017-05-06', '', '9', '18');

-- ----------------------------
-- Table structure for building_inf
-- ----------------------------
DROP TABLE IF EXISTS `building_inf`;
CREATE TABLE `building_inf` (
  `building_id` int(11) NOT NULL AUTO_INCREMENT,
  `buildingName` varchar(30) DEFAULT NULL,
  `campus_id` int(11) NOT NULL,
  PRIMARY KEY (`building_id`),
  KEY `FK_2sbdosfyp4334xo8laxn1ogiw` (`campus_id`),
  CONSTRAINT `FK_2sbdosfyp4334xo8laxn1ogiw` FOREIGN KEY (`campus_id`) REFERENCES `campus_inf` (`campus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of building_inf
-- ----------------------------
INSERT INTO `building_inf` VALUES ('1', '海虹一栋', '1');
INSERT INTO `building_inf` VALUES ('2', '海虹二栋', '1');
INSERT INTO `building_inf` VALUES ('3', '余区1舍', '1');
INSERT INTO `building_inf` VALUES ('4', '余区2舍', '1');
INSERT INTO `building_inf` VALUES ('5', '升升A栋', '2');
INSERT INTO `building_inf` VALUES ('6', '升升B栋', '2');
INSERT INTO `building_inf` VALUES ('7', '南湖一栋', '3');
INSERT INTO `building_inf` VALUES ('8', '东院一栋', '4');
INSERT INTO `building_inf` VALUES ('9', '西院一栋', '5');

-- ----------------------------
-- Table structure for campus_inf
-- ----------------------------
DROP TABLE IF EXISTS `campus_inf`;
CREATE TABLE `campus_inf` (
  `campus_id` int(11) NOT NULL AUTO_INCREMENT,
  `campusName` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`campus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of campus_inf
-- ----------------------------
INSERT INTO `campus_inf` VALUES ('1', '余家头');
INSERT INTO `campus_inf` VALUES ('2', '升升公寓');
INSERT INTO `campus_inf` VALUES ('3', '南湖');
INSERT INTO `campus_inf` VALUES ('4', '东院');
INSERT INTO `campus_inf` VALUES ('5', '西院');

-- ----------------------------
-- Table structure for cost_daily
-- ----------------------------
DROP TABLE IF EXISTS `cost_daily`;
CREATE TABLE `cost_daily` (
  `meter_id` int(11) NOT NULL,
  `cost` double DEFAULT NULL,
  `_date` datetime NOT NULL,
  PRIMARY KEY (`meter_id`,`_date`),
  CONSTRAINT `FK_a6wi63mvfpl83vj4h33ulfive` FOREIGN KEY (`meter_id`) REFERENCES `meter_inf` (`meter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cost_daily
-- ----------------------------
INSERT INTO `cost_daily` VALUES ('1', '1', '2017-05-03 15:56:05');

-- ----------------------------
-- Table structure for file_inf
-- ----------------------------
DROP TABLE IF EXISTS `file_inf`;
CREATE TABLE `file_inf` (
  `file_id` int(11) NOT NULL AUTO_INCREMENT,
  `save_path` varchar(200) DEFAULT NULL,
  `time` date DEFAULT NULL,
  `title` varchar(30) DEFAULT NULL,
  `manager_id` int(11) NOT NULL,
  PRIMARY KEY (`file_id`),
  KEY `FK_118ydwq3x2f328i4q5ba3jdbd` (`manager_id`),
  CONSTRAINT `FK_118ydwq3x2f328i4q5ba3jdbd` FOREIGN KEY (`manager_id`) REFERENCES `manager_inf` (`manager_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of file_inf
-- ----------------------------
INSERT INTO `file_inf` VALUES ('12', 'E:\\savePath\\test4.imi', null, 'test4', '1');
INSERT INTO `file_inf` VALUES ('14', 'E:\\项目文件\\IdeaProjects\\DMS\\classes\\artifacts\\DMS_war_exploded\\uploadFiles\\null\\\\tomcat.gif', null, '', '1');

-- ----------------------------
-- Table structure for mainst_building
-- ----------------------------
DROP TABLE IF EXISTS `mainst_building`;
CREATE TABLE `mainst_building` (
  `mainst_id` int(11) NOT NULL,
  `building_id` int(11) NOT NULL,
  KEY `FK_eiq5shcei6et26chfi7xq0oa6` (`building_id`),
  KEY `FK_q4owdaaidewsuil940736uh5p` (`mainst_id`),
  CONSTRAINT `FK_eiq5shcei6et26chfi7xq0oa6` FOREIGN KEY (`building_id`) REFERENCES `building_inf` (`building_id`),
  CONSTRAINT `FK_q4owdaaidewsuil940736uh5p` FOREIGN KEY (`mainst_id`) REFERENCES `mainst_inf` (`mainst_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mainst_building
-- ----------------------------
INSERT INTO `mainst_building` VALUES ('1', '1');
INSERT INTO `mainst_building` VALUES ('2', '2');
INSERT INTO `mainst_building` VALUES ('3', '3');
INSERT INTO `mainst_building` VALUES ('4', '4');
INSERT INTO `mainst_building` VALUES ('5', '5');
INSERT INTO `mainst_building` VALUES ('6', '6');
INSERT INTO `mainst_building` VALUES ('7', '7');
INSERT INTO `mainst_building` VALUES ('8', '8');
INSERT INTO `mainst_building` VALUES ('9', '9');
INSERT INTO `mainst_building` VALUES ('10', '9');

-- ----------------------------
-- Table structure for mainst_inf
-- ----------------------------
DROP TABLE IF EXISTS `mainst_inf`;
CREATE TABLE `mainst_inf` (
  `mainst_id` int(11) NOT NULL AUTO_INCREMENT,
  `birth` date DEFAULT NULL,
  `idCard` int(11) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `tel` int(11) DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`mainst_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mainst_inf
-- ----------------------------
INSERT INTO `mainst_inf` VALUES ('1', '1984-07-21', '111111', '刘备', '111111', '男', '1222', 'ss');
INSERT INTO `mainst_inf` VALUES ('2', '1979-03-07', '222222', '关羽', '222222', '男', '333333', 'sss');
INSERT INTO `mainst_inf` VALUES ('3', '1980-07-16', '333333', '张飞', '333333', '男', '333333', 'ss1');
INSERT INTO `mainst_inf` VALUES ('4', '1978-03-10', '444444', '大乔', '444444', '女', '444444', 'ss11');
INSERT INTO `mainst_inf` VALUES ('5', '1984-10-15', '555555', '小乔', '555555', '女', '555555', '小乔asd');
INSERT INTO `mainst_inf` VALUES ('6', '1985-10-26', '666666', '孙权', '666666', '男', '666666', '孙权');
INSERT INTO `mainst_inf` VALUES ('7', '2017-04-26', '777777', '曹操', '777777', '男', '777777', '曹操');
INSERT INTO `mainst_inf` VALUES ('8', '2016-11-09', '888888', '周瑜', '888888', '男', '888888', '周瑜');
INSERT INTO `mainst_inf` VALUES ('9', '2015-03-12', '999999', '司马懿', '999999', '男', '999999', '司马懿');
INSERT INTO `mainst_inf` VALUES ('10', '2016-05-11', '123456', '张春华', '123456', '女', '123456', '张春华');

-- ----------------------------
-- Table structure for manager_inf
-- ----------------------------
DROP TABLE IF EXISTS `manager_inf`;
CREATE TABLE `manager_inf` (
  `manager_id` int(11) NOT NULL AUTO_INCREMENT,
  `birth` date DEFAULT NULL,
  `idCard` int(11) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `tel` int(11) DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`manager_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager_inf
-- ----------------------------
INSERT INTO `manager_inf` VALUES ('1', '1980-02-07', '111111', '张三', '111111', '男', '111111', 'qwe');
INSERT INTO `manager_inf` VALUES ('2', '1984-03-01', '222222', '李四', '222222', '女', '222222', '李四');
INSERT INTO `manager_inf` VALUES ('3', '1975-06-12', '333333', '王五', '333333', '男', '333333', '王五');
INSERT INTO `manager_inf` VALUES ('4', '1978-04-01', '444444', '赵六', '444444', '女', '444444', '赵六');

-- ----------------------------
-- Table structure for master_inf
-- ----------------------------
DROP TABLE IF EXISTS `master_inf`;
CREATE TABLE `master_inf` (
  `master_id` int(11) NOT NULL AUTO_INCREMENT,
  `birth` date DEFAULT NULL,
  `idCard` int(11) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `tel` int(11) DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  `building_id` int(11) NOT NULL,
  PRIMARY KEY (`master_id`),
  KEY `FK_1l05nvt7nj3h1p0fi64ga20c0` (`building_id`),
  CONSTRAINT `FK_1l05nvt7nj3h1p0fi64ga20c0` FOREIGN KEY (`building_id`) REFERENCES `building_inf` (`building_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of master_inf
-- ----------------------------
INSERT INTO `master_inf` VALUES ('1', '1971-03-27', '111111', '李伟', '111111', '男', '333', 's', '1');
INSERT INTO `master_inf` VALUES ('2', '1980-03-06', '222222', '张伟', '222222', '男', '222222', '张伟', '2');
INSERT INTO `master_inf` VALUES ('3', '2017-03-03', '333333', '王伟', '333333', '男', '333333', '王伟', '3');
INSERT INTO `master_inf` VALUES ('4', '1990-10-24', '444444', '赵伟', '444444', '男', '444444', '赵伟', '4');
INSERT INTO `master_inf` VALUES ('5', '1974-10-30', '555555', '孙伟', '555555', '男', '555555', '孙伟', '5');
INSERT INTO `master_inf` VALUES ('6', '1975-10-15', '666666', '刘伟', '666666', '男', '666666', '刘伟', '6');
INSERT INTO `master_inf` VALUES ('7', '2017-02-16', '777777', '钱伟', '777777', '男', '777777', '钱伟', '7');
INSERT INTO `master_inf` VALUES ('8', '1984-07-26', '888888', '庞伟', '888888', '男', '888888', '庞伟', '8');
INSERT INTO `master_inf` VALUES ('9', '1985-11-08', '999999', '陈伟', '999999', '男', '999999', '陈伟', '9');

-- ----------------------------
-- Table structure for meter_inf
-- ----------------------------
DROP TABLE IF EXISTS `meter_inf`;
CREATE TABLE `meter_inf` (
  `meter_id` int(11) NOT NULL,
  `costAll` double NOT NULL,
  `costMonth` double NOT NULL,
  `meterNum` int(11) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`meter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of meter_inf
-- ----------------------------
INSERT INTO `meter_inf` VALUES ('1', '2', '23', '324', '在线，合闸');
INSERT INTO `meter_inf` VALUES ('2', '1655', '23', '342', '在线，合闸');
INSERT INTO `meter_inf` VALUES ('3', '1223', '43', '234', '在线，合闸');
INSERT INTO `meter_inf` VALUES ('4', '2341', '42', '122', '在线，合闸');
INSERT INTO `meter_inf` VALUES ('5', '3432', '45', '245', '在线，合闸');
INSERT INTO `meter_inf` VALUES ('6', '2341', '34', '451', '在线，合闸');
INSERT INTO `meter_inf` VALUES ('7', '3214', '76', '121', '在线，合闸');
INSERT INTO `meter_inf` VALUES ('8', '2356', '46', '321', '在线，合闸');
INSERT INTO `meter_inf` VALUES ('9', '2785', '43', '371', '在线，合闸');
INSERT INTO `meter_inf` VALUES ('10', '1253', '24', '652', '在线，合闸');
INSERT INTO `meter_inf` VALUES ('11', '1567', '24', '612', '在线，合闸');
INSERT INTO `meter_inf` VALUES ('12', '2354', '41', '317', '在线，合闸');
INSERT INTO `meter_inf` VALUES ('13', '3216', '56', '203', '在线，合闸');
INSERT INTO `meter_inf` VALUES ('14', '2311', '45', '341', '在线，合闸');
INSERT INTO `meter_inf` VALUES ('15', '2841', '35', '315', '在线，合闸');
INSERT INTO `meter_inf` VALUES ('16', '3122', '41', '311', '在线，合闸');
INSERT INTO `meter_inf` VALUES ('17', '1766', '26', '675', '在线，合闸');
INSERT INTO `meter_inf` VALUES ('18', '3231', '40', '305', '在线，合闸');

-- ----------------------------
-- Table structure for notice_inf
-- ----------------------------
DROP TABLE IF EXISTS `notice_inf`;
CREATE TABLE `notice_inf` (
  `notice_id` int(11) NOT NULL AUTO_INCREMENT,
  `text` longtext,
  `time` date DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `manager_id` int(11) NOT NULL,
  PRIMARY KEY (`notice_id`),
  KEY `FK_4ox38elugiwtuorsvodvloo6w` (`manager_id`),
  CONSTRAINT `FK_4ox38elugiwtuorsvodvloo6w` FOREIGN KEY (`manager_id`) REFERENCES `manager_inf` (`manager_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice_inf
-- ----------------------------
INSERT INTO `notice_inf` VALUES ('4', '4', '2017-05-01', '关于学生宿舍夏季用电的通知', '4');
INSERT INTO `notice_inf` VALUES ('5', '', '2017-05-17', '123123123', '1');
INSERT INTO `notice_inf` VALUES ('12', 'asdasdasd', '2017-05-18', 'asdasdasd阿斯', '1');
INSERT INTO `notice_inf` VALUES ('14', '111', '2017-09-07', 'ash', '1');

-- ----------------------------
-- Table structure for repair_inf
-- ----------------------------
DROP TABLE IF EXISTS `repair_inf`;
CREATE TABLE `repair_inf` (
  `repair_id` int(11) NOT NULL AUTO_INCREMENT,
  `finishTime` date DEFAULT NULL,
  `finished` bit(1) NOT NULL,
  `note` varchar(50) DEFAULT NULL,
  `receiveTime` date DEFAULT NULL,
  `received` bit(1) NOT NULL,
  `repairTime` date DEFAULT NULL,
  `bedroom_id` int(11) NOT NULL,
  `mainst_id` int(11) DEFAULT NULL,
  `stu_id` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  PRIMARY KEY (`repair_id`),
  KEY `FK_rkjh2hgb17xispdul8gbo0wfb` (`bedroom_id`),
  KEY `FK_7fmbrbn7nityqelw23f33wrn6` (`mainst_id`),
  KEY `FK_jm09t7pq3g2owbhmdlumv6a25` (`stu_id`),
  KEY `FK_1nq3uag8qox92gi8o1rqf5gks` (`type_id`),
  CONSTRAINT `FK_1nq3uag8qox92gi8o1rqf5gks` FOREIGN KEY (`type_id`) REFERENCES `type_inf` (`type_id`),
  CONSTRAINT `FK_7fmbrbn7nityqelw23f33wrn6` FOREIGN KEY (`mainst_id`) REFERENCES `mainst_inf` (`mainst_id`),
  CONSTRAINT `FK_jm09t7pq3g2owbhmdlumv6a25` FOREIGN KEY (`stu_id`) REFERENCES `stu_info` (`stu_id`),
  CONSTRAINT `FK_rkjh2hgb17xispdul8gbo0wfb` FOREIGN KEY (`bedroom_id`) REFERENCES `bedroom_inf` (`bedroom_id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of repair_inf
-- ----------------------------
INSERT INTO `repair_inf` VALUES ('1', '2017-05-16', '\0', '灯不亮', null, '', '2017-04-27', '1', '1', '1', '3');
INSERT INTO `repair_inf` VALUES ('2', '2017-06-22', '', '椅子坏了', null, '', '2017-05-07', '2', '1', '5', '2');
INSERT INTO `repair_inf` VALUES ('3', '2017-09-06', '', '玻璃破了', null, '', '2017-05-10', '3', '1', '7', '2');
INSERT INTO `repair_inf` VALUES ('4', '2017-09-06', '', '水管漏了', null, '', '2017-05-17', '10', '1', '14', '1');
INSERT INTO `repair_inf` VALUES ('5', '2017-09-06', '', '水管漏了', null, '', '2017-05-15', '3', '1', '7', '1');
INSERT INTO `repair_inf` VALUES ('6', null, '\0', 'asd ', null, '\0', null, '1', '1', '1', '1');
INSERT INTO `repair_inf` VALUES ('7', '2017-09-06', '', '???', null, '', null, '1', '1', '1', '1');
INSERT INTO `repair_inf` VALUES ('8', '2017-09-06', '', '???', null, '', null, '1', '1', '1', '1');
INSERT INTO `repair_inf` VALUES ('9', '2017-09-06', '', 'asd', null, '', null, '1', '1', '1', '1');
INSERT INTO `repair_inf` VALUES ('10', '2017-09-06', '', 'asdasd', null, '', null, '1', '1', '1', '1');
INSERT INTO `repair_inf` VALUES ('11', '2017-09-07', '', 'asdd', null, '', null, '1', '2', '1', '1');
INSERT INTO `repair_inf` VALUES ('12', null, '\0', '', null, '', null, '1', '2', '1', '1');
INSERT INTO `repair_inf` VALUES ('13', null, '\0', '', null, '', null, '1', '1', '1', '1');
INSERT INTO `repair_inf` VALUES ('14', '2017-09-06', '', '123123123123', null, '', null, '1', '1', '1', '1');
INSERT INTO `repair_inf` VALUES ('15', null, '\0', '???', null, '', null, '1', '1', '1', '1');
INSERT INTO `repair_inf` VALUES ('16', null, '\0', '???', null, '', null, '1', '1', '1', '1');
INSERT INTO `repair_inf` VALUES ('17', null, '\0', '??', null, '', null, '1', '1', '1', '1');
INSERT INTO `repair_inf` VALUES ('18', null, '\0', '??', null, '', null, '1', '1', '1', '1');
INSERT INTO `repair_inf` VALUES ('25', null, '\0', '??', null, '', null, '1', '1', '1', '1');
INSERT INTO `repair_inf` VALUES ('26', null, '\0', '??', null, '', null, '1', '1', '1', '1');
INSERT INTO `repair_inf` VALUES ('27', null, '\0', '????', null, '', null, '1', '1', '1', '1');
INSERT INTO `repair_inf` VALUES ('28', null, '\0', '阿萨德阿斯', null, '', null, '1', '1', '1', '1');
INSERT INTO `repair_inf` VALUES ('29', null, '\0', '阿萨德', null, '', null, '1', '1', '1', '1');
INSERT INTO `repair_inf` VALUES ('42', '2017-09-07', '', '222', null, '', '2017-09-07', '5', '2', '2', '1');
INSERT INTO `repair_inf` VALUES ('43', null, '\0', 'zdzf', null, '\0', '2017-09-07', '5', null, '2', '1');

-- ----------------------------
-- Table structure for stu_info
-- ----------------------------
DROP TABLE IF EXISTS `stu_info`;
CREATE TABLE `stu_info` (
  `stu_id` int(11) NOT NULL AUTO_INCREMENT,
  `_class` varchar(30) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `college` varchar(30) DEFAULT NULL,
  `major` varchar(30) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `studentNum` varchar(30) DEFAULT NULL,
  `tel` int(11) DEFAULT NULL,
  `bedroom_id` int(11) NOT NULL,
  PRIMARY KEY (`stu_id`),
  KEY `FK_2y2jpenloapatl4mahit1e9vl` (`bedroom_id`),
  CONSTRAINT `FK_2y2jpenloapatl4mahit1e9vl` FOREIGN KEY (`bedroom_id`) REFERENCES `bedroom_inf` (`bedroom_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_info
-- ----------------------------
INSERT INTO `stu_info` VALUES ('1', 'zy1401', '2017-05-24', '计算机科学与技术学院', '计算机', '汪洋', '111111', '男', '111', '111111', '6');
INSERT INTO `stu_info` VALUES ('2', 'zy1401', '2017-05-02', '计算机科学与技术学院', '计算机', '周豪义', '222222', '男', '222', '222222', '5');
INSERT INTO `stu_info` VALUES ('3', 'zy1401', '2017-05-10', '计算机科学与技术学院', '计算机', '傅晓杰', '333333', '男', '333', '333333', '9');
INSERT INTO `stu_info` VALUES ('4', 'zy1401', '2017-05-10', '计算机科学与技术学院', '计算机', '陈海伦', '444444', '男', '444', '444444', '6');
INSERT INTO `stu_info` VALUES ('5', 'zy1401', '2017-02-03', '计算机科学与技术学院', '计算机', '周杰伦', '555555', '男', '555', '555555', '6');
INSERT INTO `stu_info` VALUES ('6', 'zy1401', '2017-01-04', '计算机科学与技术学院', '计算机', '周星驰', '666666', '男', '666', '666666', '5');
INSERT INTO `stu_info` VALUES ('7', 'zy1402', '2016-06-15', '计算机科学与技术学院', '计算机', '周润发', '777777', '男', '777', '777777', '4');
INSERT INTO `stu_info` VALUES ('8', '1401', '2017-05-04', '计算机科学与技术学院', '物联网', '周华健', '888888', '男', '888', '888888', '3');
INSERT INTO `stu_info` VALUES ('9', '1402', '2016-05-22', '计算机科学与技术学院', '物联网', '周传雄', '999999', '男', '999', '9999999', '5');
INSERT INTO `stu_info` VALUES ('10', 'zy1501', '2016-08-18', '计算机科学与技术学院', '计算机', '宋江', '111110', '男', '110', '111110', '6');
INSERT INTO `stu_info` VALUES ('11', '1302', '2017-05-09', '航运学院', '航海技术', '卢俊义', '222220', '男', '220', '222220', '7');
INSERT INTO `stu_info` VALUES ('12', '1303', '2016-04-13', '航运学院', '海事管理', '吴用', '333330', '男', '330', '333330', '8');
INSERT INTO `stu_info` VALUES ('13', '1401', '2017-01-27', '航运学院', '航海技术', '公孙胜', '444440', '男', '440', '444440', '9');
INSERT INTO `stu_info` VALUES ('14', '1401', '2016-12-14', '计算机科学与技术学院', '计算机', '周迅', '555550', '女', '550', '555550', '10');
INSERT INTO `stu_info` VALUES ('15', '1401', '2016-11-15', '物流学院', '机械设计', '关胜', '666660', '男', '660', '666660', '11');
INSERT INTO `stu_info` VALUES ('16', '1601', '2017-02-22', '文法学院', '法律', '林冲', '777770', '男', '770', '777770', '12');
INSERT INTO `stu_info` VALUES ('17', '1602', '2017-05-09', '外国语学院', '英语', '扈三娘', '888880', '女', '880', '888880', '13');
INSERT INTO `stu_info` VALUES ('18', '1501', '2017-05-15', '外国学院', '法语', '柴进', '999990', '男', '990', '999990', '14');
INSERT INTO `stu_info` VALUES ('19', '1502', '2017-03-28', '理学院', '数学', '花荣', '111100', '男', '100', '111100', '15');
INSERT INTO `stu_info` VALUES ('20', 'zy1302', '2017-01-11', '理学院', '物理', '武松', '222200', '男', '200', '222200', '16');
INSERT INTO `stu_info` VALUES ('21', '1602', '2017-02-20', '机电学院', '包装工程', '鲁智深', '333300', '男', '300', '333300', '17');
INSERT INTO `stu_info` VALUES ('22', '1401', '2016-12-14', '计算机科学与技术学院', '软件工程', '李逵', '444400', '男', '400', '444400', '18');

-- ----------------------------
-- Table structure for type_inf
-- ----------------------------
DROP TABLE IF EXISTS `type_inf`;
CREATE TABLE `type_inf` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type_inf
-- ----------------------------
INSERT INTO `type_inf` VALUES ('1', '管道类');
INSERT INTO `type_inf` VALUES ('2', '家具类');
INSERT INTO `type_inf` VALUES ('3', '电器类');
INSERT INTO `type_inf` VALUES ('4', '其它');
