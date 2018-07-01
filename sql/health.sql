/*
Navicat MySQL Data Transfer

Source Server         : nishuai
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : health

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2018-07-01 11:11:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for adjustsalary
-- ----------------------------
DROP TABLE IF EXISTS `adjustsalary`;
CREATE TABLE `adjustsalary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) DEFAULT NULL,
  `asDate` date DEFAULT NULL COMMENT '调薪日期',
  `beforeSalary` int(11) DEFAULT NULL COMMENT '调前薪资',
  `afterSalary` int(11) DEFAULT NULL COMMENT '调后薪资',
  `reason` varchar(255) DEFAULT NULL COMMENT '调薪原因',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `pid` (`eid`),
  CONSTRAINT `adjustsalary_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adjustsalary
-- ----------------------------

-- ----------------------------
-- Table structure for appraise
-- ----------------------------
DROP TABLE IF EXISTS `appraise`;
CREATE TABLE `appraise` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) DEFAULT NULL,
  `appDate` date DEFAULT NULL COMMENT '考评日期',
  `appResult` varchar(32) DEFAULT NULL COMMENT '考评结果',
  `appContent` varchar(255) DEFAULT NULL COMMENT '考评内容',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `pid` (`eid`),
  CONSTRAINT `appraise_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of appraise
-- ----------------------------

-- ----------------------------
-- Table structure for departments
-- ----------------------------
DROP TABLE IF EXISTS `departments`;
CREATE TABLE `departments` (
  `did` varchar(255) NOT NULL,
  `dname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of departments
-- ----------------------------
INSERT INTO `departments` VALUES ('1', '儿科');
INSERT INTO `departments` VALUES ('2', '口腔科');
INSERT INTO `departments` VALUES ('3', '皮肤科');
INSERT INTO `departments` VALUES ('4', '外科');
INSERT INTO `departments` VALUES ('5', '骨科');
INSERT INTO `departments` VALUES ('6', '外科');
INSERT INTO `departments` VALUES ('7', '男科');
INSERT INTO `departments` VALUES ('8', '泌尿科');

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `id_number` varchar(255) DEFAULT NULL,
  `practice_number` varchar(255) DEFAULT NULL COMMENT '执业编号',
  `professional_title` varchar(255) DEFAULT NULL COMMENT '职称',
  `gender` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `speciality` varchar(255) DEFAULT NULL,
  `introduce` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `did` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1012 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES ('1001', '张医生', '342622778377383736', '110320700002528', '主治医师', '男', '188953567591', '儿科诊断1', '多年经验', '35', '1002');
INSERT INTO `doctor` VALUES ('1002', '李医生', '342622778377383785', '110320700002524', '主治医师', '女', '18895356758', '口腔诊断', '多年临床经验', '40', '1002');
INSERT INTO `doctor` VALUES ('1003', '王医生', '342622778377383728', '110320700002753', '副主任医师', '男', '18895352733', '皮肤诊断', '多年皮肤诊断经验', '28', '1003');
INSERT INTO `doctor` VALUES ('1004', '杨医生', '342622778377383738', '110320700002742', '主任医师', '男', '18895367367', '外科', '多年外科诊断经验', '44', '1001');
INSERT INTO `doctor` VALUES ('1005', '兰医生', '342622778357383738', '110220700002742', '主治医师', '男', '18267532646', '男科诊断', '多年男科诊断经验', '32', '1001');
INSERT INTO `doctor` VALUES ('1006', '倪医生', '342622738377383738', '110220500002742', '主治医师', '男', '18895356752', '骨科诊断', '多年男科诊断经验', '35', '1003');
INSERT INTO `doctor` VALUES ('1007', '杨医生', '2344', '110', '主治医师', '男', '188', '儿科', '多年', '25', '1002');
INSERT INTO `doctor` VALUES ('1010', '刘主任', '3424', '1134', '副主任医师', '男', '188', '擅长', '介绍', '56', null);
INSERT INTO `doctor` VALUES ('1011', '张山峰', '3424', '112', '主治医师', '男', '188', '医生擅长', '医生介绍', '34', null);

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `name` varchar(10) DEFAULT NULL COMMENT '员工姓名',
  `gender` char(4) DEFAULT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `idCard` char(18) DEFAULT NULL COMMENT '身份证号',
  `wedlock` char(4) DEFAULT NULL COMMENT '婚姻状况',
  `race` varchar(8) DEFAULT NULL COMMENT '民族',
  `nativePlace` varchar(20) DEFAULT NULL COMMENT '籍贯',
  `politic` varchar(8) DEFAULT NULL COMMENT '政治面貌',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(11) DEFAULT NULL COMMENT '电话号码',
  `address` varchar(64) DEFAULT NULL COMMENT '联系地址',
  `departmentId` int(11) DEFAULT NULL COMMENT '所属部门',
  `jobId` int(11) DEFAULT NULL COMMENT '职称ID',
  `posId` int(11) DEFAULT NULL COMMENT '职位ID',
  `engageForm` varchar(8) DEFAULT NULL COMMENT '聘用形式',
  `tiptopDegree` varchar(8) DEFAULT NULL COMMENT '最高学历',
  `specialty` varchar(32) DEFAULT NULL COMMENT '所属专业',
  `school` varchar(32) DEFAULT NULL COMMENT '毕业院校',
  `beginDate` date DEFAULT NULL COMMENT '入职日期',
  `workState` varchar(32) DEFAULT NULL COMMENT '在职状态',
  `workID` int(11) DEFAULT NULL COMMENT '工号',
  `contractTerm` int(11) DEFAULT NULL COMMENT '合同期限',
  `befromDate` date DEFAULT NULL COMMENT '转正日期',
  `notWorkDate` date DEFAULT NULL COMMENT '离职日期',
  `beginContract` date DEFAULT NULL COMMENT '合同起始日期',
  `endContract` date DEFAULT NULL COMMENT '合同终止日期',
  `workAge` int(11) DEFAULT NULL COMMENT '工龄',
  PRIMARY KEY (`id`),
  KEY `departmentId` (`departmentId`),
  KEY `jobId` (`jobId`),
  KEY `dutyId` (`posId`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`departmentId`) REFERENCES `department` (`id`),
  CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`jobId`) REFERENCES `joblevel` (`id`),
  CONSTRAINT `employee_ibfk_3` FOREIGN KEY (`posId`) REFERENCES `position` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', null, null, null, null, null, null, null, null, null, null, null, '8', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for employeeec
-- ----------------------------
DROP TABLE IF EXISTS `employeeec`;
CREATE TABLE `employeeec` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) DEFAULT NULL COMMENT '员工编号',
  `ecDate` date DEFAULT NULL COMMENT '奖罚日期',
  `ecReason` varchar(255) DEFAULT NULL COMMENT '奖罚原因',
  `ecPoint` int(11) DEFAULT NULL COMMENT '奖罚分',
  `ecType` int(11) DEFAULT NULL COMMENT '奖罚类别，0：奖，1：罚',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `pid` (`eid`),
  CONSTRAINT `employeeec_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employeeec
-- ----------------------------

-- ----------------------------
-- Table structure for employeeremove
-- ----------------------------
DROP TABLE IF EXISTS `employeeremove`;
CREATE TABLE `employeeremove` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) DEFAULT NULL,
  `afterDepId` int(11) DEFAULT NULL COMMENT '调动后部门',
  `afterJobId` int(11) DEFAULT NULL COMMENT '调动后职位',
  `removeDate` date DEFAULT NULL COMMENT '调动日期',
  `reason` varchar(255) DEFAULT NULL COMMENT '调动原因',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pid` (`eid`),
  CONSTRAINT `employeeremove_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employeeremove
-- ----------------------------

-- ----------------------------
-- Table structure for employeetrain
-- ----------------------------
DROP TABLE IF EXISTS `employeetrain`;
CREATE TABLE `employeetrain` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) DEFAULT NULL COMMENT '员工编号',
  `trainDate` date DEFAULT NULL COMMENT '培训日期',
  `trainContent` varchar(255) DEFAULT NULL COMMENT '培训内容',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `pid` (`eid`),
  CONSTRAINT `employeetrain_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employeetrain
-- ----------------------------

-- ----------------------------
-- Table structure for hospital
-- ----------------------------
DROP TABLE IF EXISTS `hospital`;
CREATE TABLE `hospital` (
  `hid` int(11) NOT NULL AUTO_INCREMENT,
  `hname` varchar(255) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `longitude` varchar(255) DEFAULT NULL,
  `latitude` varchar(255) DEFAULT NULL,
  `introduce` varchar(10000) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`hid`)
) ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hospital
-- ----------------------------
INSERT INTO `hospital` VALUES ('101', '安徽医科大学第一附属医院', '三级乙等', '合肥市', '12.0', '13.0', '北京协和医院是集医疗、教学、科研于一体的大型三级甲等综合医院，是国家卫生计生委指定的全国疑难重症诊治指导中心\r\n                也是最早承担高干保健和外宾医疗任务的医院之一，以学科齐全、技术力量雄厚、特色专科突出、多学科综合优势强大享誉海内外。\r\n                在2009-2016年度复旦大学医院管理研究所公布的“中国最佳医院排行榜”中连续八年名列榜首。', 'http://101.132.171.196/images/hospital2.jpg');
INSERT INTO `hospital` VALUES ('102', '复旦大学附属中山医院', '三级甲等', '上海市', '12', '12', '不错', null);
INSERT INTO `hospital` VALUES ('103', '北京协和医院', '二级甲等', '北京市', '23', '23', '很好', null);
INSERT INTO `hospital` VALUES ('104', '江苏省立医院', '二级甲等', '1', '4.0', '4.0', '很好', null);
INSERT INTO `hospital` VALUES ('110', '上海市肺科医院', '二级丙等', '上海市肺科', '121.508477', '31.307327', '不错很好', './static/uploadimg/img.jpg');
INSERT INTO `hospital` VALUES ('114', '上海市第六人民医院', '三级丙等', '上海市第六人民医院', '121.430069', '31.185164', '很好', '');
INSERT INTO `hospital` VALUES ('116', '上海东方医院', '三级甲等', '上海浦东新区', '121.518766', '31.24346', '很不错', './static/uploadimg/hospital2.jpg');
INSERT INTO `hospital` VALUES ('119', '8', '二级乙等', '88', '0.0', '0.0', '88', './static/uploadimg/hospital2.jpg');
INSERT INTO `hospital` VALUES ('120', '芜湖第一人名医院1', '三级甲等', '芜湖市弋江区', '0.0', '0.0', '芜湖第一人民医院是个好医院1', './static/uploadimg/hospital4.jpg');
INSERT INTO `hospital` VALUES ('122', '芜湖第二人民医院', '二级甲等', '芜湖第二人民', '0.0', '0.0', '芜湖第二人民医院', './static/uploadimg/hospital4.jpg');
INSERT INTO `hospital` VALUES ('123', '', '三级丙等', '芜湖第二人民yiyuan', '0.0', '0.0', '', '');
INSERT INTO `hospital` VALUES ('124', '淮南第一人民医院', '一级甲等', '淮南第一人民医院', '0.0', '0.0', '淮南第一人民医院', './static/uploadimg/hospital3.jpg');
INSERT INTO `hospital` VALUES ('125', '', '二级乙等', 'hef', '0.0', '0.0', '', '');
INSERT INTO `hospital` VALUES ('126', '126', '一级乙等', '安汇宝', '0.0', '0.0', '', '');
INSERT INTO `hospital` VALUES ('128', '4', '二级乙等', '444', '0.0', '0.0', '4', './static/uploadimg/31.png');
INSERT INTO `hospital` VALUES ('131', '芜湖第二人民医院', '三级甲等', '芜湖第二人民', '0.0', '0.0', 'の2熭前端的无', 'http://101.132.171.196/images/hospital2.jpg');

-- ----------------------------
-- Table structure for hospitaldepartment
-- ----------------------------
DROP TABLE IF EXISTS `hospitaldepartment`;
CREATE TABLE `hospitaldepartment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hid` int(11) DEFAULT NULL,
  `did` varchar(255) DEFAULT NULL,
  `introduce` varchar(20000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1007 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hospitaldepartment
-- ----------------------------
INSERT INTO `hospitaldepartment` VALUES ('1001', '101', '1', '儿科是首批安徽省临床医学重点学科，首批国务院硕士学位授予点，安徽省教育厅精品课程，安徽医科大学重点教研室。科室共有固定床位177张，设有四个病区，包括：儿科一病区（分设消化、肾脏、风湿免疫、心血管学亚专业）、儿科二病区（分设呼吸、血液、遗传内分泌学亚专业）、新生儿病区和安徽省小儿神经康复中心。');
INSERT INTO `hospitaldepartment` VALUES ('1002', '101', '2', '口腔科是首批安徽省临床医学重点学科，首批国务院硕士学位授予点，安徽省教育厅精品课程，安徽医科大学重点教研室。科室共有固定床位177张，设有四个病区，包括：儿科一病区（分设消化、肾脏、风湿免疫、心血管学亚专业）、儿科二病区（分设呼吸、血液、遗传内分泌学亚专业）、新生儿病区和安徽省小儿神经康复中心。');
INSERT INTO `hospitaldepartment` VALUES ('1003', '102', '1', '儿科介绍');
INSERT INTO `hospitaldepartment` VALUES ('1004', '101', '3', '介绍');
INSERT INTO `hospitaldepartment` VALUES ('1006', '101', '6', '外科');

-- ----------------------------
-- Table structure for hr
-- ----------------------------
DROP TABLE IF EXISTS `hr`;
CREATE TABLE `hr` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'hrID',
  `name` varchar(32) DEFAULT NULL COMMENT '姓名',
  `gender` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号码',
  `telephone` varchar(255) DEFAULT NULL COMMENT '住宅电话',
  `address` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `enabled` tinyint(1) DEFAULT '1',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `userface` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `hid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hr
-- ----------------------------
INSERT INTO `hr` VALUES ('3', '系统管理员', null, '18568887789', '029-82881234', '深圳南山', '1', 'admin', '$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm', 'http://101.132.171.196/images/img.jpg', null, '0');
INSERT INTO `hr` VALUES ('5', '李白', null, '18568123489', '029-82123434', '海口美兰', '1', 'libai', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'http://101.132.171.196/images/img.jpg', null, '0');
INSERT INTO `hr` VALUES ('10', '韩愈', null, '18568123666', '029-82111555', '广州番禺', '1', 'hanyu', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'http://101.132.171.196/images/img.jpg', null, '0');
INSERT INTO `hr` VALUES ('11', '柳宗元', null, '18568123377', '029-82111333', '广州天河', '1', 'liuzongyuan', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'http://101.132.171.196/images/img.jpg', null, '0');
INSERT INTO `hr` VALUES ('12', '曾巩', '男', '18568128888', '029-82111222', '广州越秀', '1', 'zenggong', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'http://101.132.171.196/images/img.jpg', null, '0');
INSERT INTO `hr` VALUES ('13', '总系统管理员', '', '18895356759', null, '安徽芜湖', '1', 'nishuai', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'http://101.132.171.196/images/img.jpg', null, null);
INSERT INTO `hr` VALUES ('14', '张三', '男', '18895356759', '029-82111222', '广州越秀', '1', 'hospitaladmin', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'http://101.132.171.196/images/img.jpg', null, '101');
INSERT INTO `hr` VALUES ('15', '李四', '男', '18895356759', '029-82111222', '广州天河', '1', 'doctor', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'http://101.132.171.196/images/img.jpg', null, '103');
INSERT INTO `hr` VALUES ('16', '王五', '女', '188953567591', '029-821112221', '安徽合肥1', '1', 'wangwu1', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'http://101.132.171.196/images/img.jpg', null, '101');
INSERT INTO `hr` VALUES ('33', '李丽', '女', '19995354675', '4792645', '江苏南京', '1', 'lili', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE', 'http://101.132.171.196/images/img.jpg', null, '101');
INSERT INTO `hr` VALUES ('35', '王平安', '男', '1888', '4792745', '江苏镇江', '0', 'wangpingan', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'http://101.132.171.196/images/img.jpg', null, '101');
INSERT INTO `hr` VALUES ('36', 'w', '女', '1333', '1233', '3211313', '1', 'w', null, null, null, '101');

-- ----------------------------
-- Table structure for hr_role
-- ----------------------------
DROP TABLE IF EXISTS `hr_role`;
CREATE TABLE `hr_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hrid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rid` (`rid`),
  KEY `hr_role_ibfk_1` (`hrid`),
  CONSTRAINT `hr_role_ibfk_1` FOREIGN KEY (`hrid`) REFERENCES `hr` (`id`) ON DELETE CASCADE,
  CONSTRAINT `hr_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hr_role
-- ----------------------------
INSERT INTO `hr_role` VALUES ('1', '3', '6');
INSERT INTO `hr_role` VALUES ('9', '5', '1');
INSERT INTO `hr_role` VALUES ('10', '5', '4');
INSERT INTO `hr_role` VALUES ('35', '12', '4');
INSERT INTO `hr_role` VALUES ('36', '12', '3');
INSERT INTO `hr_role` VALUES ('37', '12', '2');
INSERT INTO `hr_role` VALUES ('43', '11', '3');
INSERT INTO `hr_role` VALUES ('44', '11', '2');
INSERT INTO `hr_role` VALUES ('45', '11', '4');
INSERT INTO `hr_role` VALUES ('46', '11', '5');
INSERT INTO `hr_role` VALUES ('47', '10', '3');
INSERT INTO `hr_role` VALUES ('48', '13', '15');
INSERT INTO `hr_role` VALUES ('49', '14', '16');
INSERT INTO `hr_role` VALUES ('50', '15', '17');
INSERT INTO `hr_role` VALUES ('51', '16', '15');
INSERT INTO `hr_role` VALUES ('60', '33', '16');
INSERT INTO `hr_role` VALUES ('62', '35', '16');
INSERT INTO `hr_role` VALUES ('63', '36', '16');

-- ----------------------------
-- Table structure for joblevel
-- ----------------------------
DROP TABLE IF EXISTS `joblevel`;
CREATE TABLE `joblevel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '职称名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of joblevel
-- ----------------------------

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(64) DEFAULT NULL,
  `path` varchar(64) DEFAULT NULL,
  `component` varchar(64) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `iconCls` varchar(64) DEFAULT NULL,
  `keepAlive` tinyint(1) DEFAULT NULL,
  `requireAuth` tinyint(1) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `parentId` (`parentId`),
  CONSTRAINT `menu_ibfk_1` FOREIGN KEY (`parentId`) REFERENCES `menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '/', null, null, '所有', null, null, null, null, '1');
INSERT INTO `menu` VALUES ('2', '/', '/home', 'Home', '员工资料', 'fa fa-user-circle-o', null, '1', '1', '1');
INSERT INTO `menu` VALUES ('3', '/', '/home', 'Home', '人事管理', 'fa fa-address-card-o', null, '1', '1', '1');
INSERT INTO `menu` VALUES ('4', '/', '/home', 'Home', '薪资管理', 'fa fa-money', null, '1', '1', '1');
INSERT INTO `menu` VALUES ('5', '/', '/home', 'Home', '统计管理', 'fa fa-bar-chart', null, '1', '1', '1');
INSERT INTO `menu` VALUES ('6', '/', '/home', 'Home', '系统管理', 'fa fa-windows', null, '1', '1', '1');
INSERT INTO `menu` VALUES ('7', '/employee/basic/**', '/emp/basic', 'EmpBasic', '基本资料', null, null, '1', '2', '1');
INSERT INTO `menu` VALUES ('8', '/employee/advanced/**', '/emp/adv', 'EmpAdv', '高级资料', null, null, '1', '2', '0');
INSERT INTO `menu` VALUES ('9', '/personnel/emp/**', '/per/emp', 'PerEmp', '员工资料', null, null, '1', '3', '1');
INSERT INTO `menu` VALUES ('10', '/personnel/ec/**', '/per/ec', 'PerEc', '员工奖惩', null, null, '1', '3', '1');
INSERT INTO `menu` VALUES ('11', '/personnel/train/**', '/per/train', 'PerTrain', '员工培训', null, null, '1', '3', '1');
INSERT INTO `menu` VALUES ('12', '/personnel/salary/**', '/per/salary', 'PerSalary', '员工调薪', null, null, '1', '3', '1');
INSERT INTO `menu` VALUES ('13', '/personnel/remove/**', '/per/mv', 'PerMv', '员工调动', null, null, '1', '3', '1');
INSERT INTO `menu` VALUES ('14', '/salary/sob/**', '/sal/sob', 'SalSob', '工资账套管理', null, null, '1', '4', '1');
INSERT INTO `menu` VALUES ('15', '/salary/sobcfg/**', '/sal/sobcfg', 'SalSobCfg', '员工账套设置', null, null, '1', '4', '1');
INSERT INTO `menu` VALUES ('16', '/salary/table/**', '/sal/table', 'SalTable', '工资表管理', null, null, '1', '4', '1');
INSERT INTO `menu` VALUES ('17', '/salary/month/**', '/sal/month', 'SalMonth', '月末处理', null, null, '1', '4', '1');
INSERT INTO `menu` VALUES ('18', '/salary/search/**', '/sal/search', 'SalSearch', '工资表查询', null, null, '1', '4', '1');
INSERT INTO `menu` VALUES ('19', '/statistics/all/**', '/sta/all', 'StaAll', '综合信息统计', null, null, '1', '5', '1');
INSERT INTO `menu` VALUES ('20', '/statistics/score/**', '/sta/score', 'StaScore', '员工积分统计', null, null, '1', '5', '1');
INSERT INTO `menu` VALUES ('21', '/statistics/personnel/**', '/sta/pers', 'StaPers', '人事信息统计', null, null, '1', '5', '1');
INSERT INTO `menu` VALUES ('22', '/statistics/recored/**', '/sta/record', 'StaRecord', '人事记录统计', null, null, '1', '5', '1');
INSERT INTO `menu` VALUES ('23', '/system/basic/**', '/sys/basic', 'SysBasic', '基础信息设置', null, null, '1', '6', '1');
INSERT INTO `menu` VALUES ('24', '/system/cfg/**', '/sys/cfg', 'SysCfg', '系统管理', null, null, '1', '6', '1');
INSERT INTO `menu` VALUES ('25', '/system/log/**', '/sys/log', 'SysLog', '操作日志管理', null, null, '1', '6', '1');
INSERT INTO `menu` VALUES ('26', '/system/hr/**', '/sys/hr', 'SysHr', '操作员管理', null, null, '1', '6', '1');
INSERT INTO `menu` VALUES ('27', '/system/data/**', '/sys/data', 'SysData', '备份恢复数据库', null, null, '1', '6', '1');
INSERT INTO `menu` VALUES ('28', '/system/init/**', '/sys/init', 'SysInit', '初始化数据库', null, null, '1', '6', '1');
INSERT INTO `menu` VALUES ('29', '/hospital/hospitaltable/**', '/hospital/hospitaltable', 'HospitalTable', '医院信息表格', null, null, '1', '32', '1');
INSERT INTO `menu` VALUES ('30', '/chart/chartSystemadmindatastatistics/**', '/chart/chartSystemadmindatastatistics', 'ChartSystemadmindatastatistics', '医院信息统计图', null, null, '1', '33', '1');
INSERT INTO `menu` VALUES ('31', '/user/usertable/**', '/user/usertable', 'UserTable', '医院系统管理员', null, null, '1', '34', '1');
INSERT INTO `menu` VALUES ('32', '/', '/home', 'Home', '医院信息管理', 'fa fa-home', null, '1', '1', '1');
INSERT INTO `menu` VALUES ('33', '/', '/home', 'Home', '数据统计', 'fa fa-bar-chart', null, '1', '1', '1');
INSERT INTO `menu` VALUES ('34', '/', '/home', 'Home', '管理员信息管理', 'fa fa-user-md', null, '1', '1', '1');
INSERT INTO `menu` VALUES ('35', '/hospital/hospitaeditl/**', '/hospital/hospitaledit', 'HospitalEdit', '医院信息', null, null, '1', '39', '1');
INSERT INTO `menu` VALUES ('36', '/department/departmenttable/**', '/department/departmenttable', 'DepartmentTable', '科室信息', null, null, '1', '40', '1');
INSERT INTO `menu` VALUES ('37', '/doctor/doctortable/**', '/doctor/doctortable', 'DoctorTable', '医生信息', null, null, '1', '41', '1');
INSERT INTO `menu` VALUES ('38', '/chart/hospitaldatastatistics/**', '/chart/hospitaldatastatistics', 'ChartHospitaldatastatistics', '患者相关数据统计', null, null, '1', '42', '1');
INSERT INTO `menu` VALUES ('39', '/', '/home', 'Home', '医院信息管理', 'fa fa-institution', null, '1', '1', '1');
INSERT INTO `menu` VALUES ('40', '/', '/home', 'Home', '科室信息管理', 'fa fa-medkit', null, '1', '1', '1');
INSERT INTO `menu` VALUES ('41', '/', '/home', 'Home', '医生信息管理', 'fa fa-user-md', null, '1', '1', '1');
INSERT INTO `menu` VALUES ('42', '/', '/home', 'Home', '数据统计图', 'fa fa-bar-chart', null, '1', '1', '1');
INSERT INTO `menu` VALUES ('43', '/doctor/doctortest1/**', '/doctor/doctortest1', 'Doctortest1', '居民资料', null, null, '1', '45', '1');
INSERT INTO `menu` VALUES ('44', '/doctor/doctortest2/**', '/doctor/doctortest2', 'Doctortest2', '就诊记录', null, null, '1', '46', '1');
INSERT INTO `menu` VALUES ('45', '/', '/home', 'Home', '居民资料管理', null, null, '1', '1', '1');
INSERT INTO `menu` VALUES ('46', '/', '/home', 'Home', '就诊资料管理', null, null, '1', '1', '1');

-- ----------------------------
-- Table structure for menu_role
-- ----------------------------
DROP TABLE IF EXISTS `menu_role`;
CREATE TABLE `menu_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mid` (`mid`),
  KEY `rid` (`rid`),
  CONSTRAINT `menu_role_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `menu` (`id`),
  CONSTRAINT `menu_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=291 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu_role
-- ----------------------------
INSERT INTO `menu_role` VALUES ('161', '7', '3');
INSERT INTO `menu_role` VALUES ('162', '7', '6');
INSERT INTO `menu_role` VALUES ('163', '9', '6');
INSERT INTO `menu_role` VALUES ('164', '10', '6');
INSERT INTO `menu_role` VALUES ('165', '11', '6');
INSERT INTO `menu_role` VALUES ('166', '12', '6');
INSERT INTO `menu_role` VALUES ('167', '13', '6');
INSERT INTO `menu_role` VALUES ('168', '14', '6');
INSERT INTO `menu_role` VALUES ('169', '15', '6');
INSERT INTO `menu_role` VALUES ('170', '16', '6');
INSERT INTO `menu_role` VALUES ('171', '17', '6');
INSERT INTO `menu_role` VALUES ('172', '18', '6');
INSERT INTO `menu_role` VALUES ('173', '19', '6');
INSERT INTO `menu_role` VALUES ('174', '20', '6');
INSERT INTO `menu_role` VALUES ('175', '21', '6');
INSERT INTO `menu_role` VALUES ('176', '22', '6');
INSERT INTO `menu_role` VALUES ('177', '23', '6');
INSERT INTO `menu_role` VALUES ('178', '25', '6');
INSERT INTO `menu_role` VALUES ('179', '26', '6');
INSERT INTO `menu_role` VALUES ('180', '27', '6');
INSERT INTO `menu_role` VALUES ('181', '28', '6');
INSERT INTO `menu_role` VALUES ('182', '24', '6');
INSERT INTO `menu_role` VALUES ('247', '7', '4');
INSERT INTO `menu_role` VALUES ('248', '8', '4');
INSERT INTO `menu_role` VALUES ('249', '11', '4');
INSERT INTO `menu_role` VALUES ('250', '7', '2');
INSERT INTO `menu_role` VALUES ('251', '8', '2');
INSERT INTO `menu_role` VALUES ('252', '9', '2');
INSERT INTO `menu_role` VALUES ('253', '10', '2');
INSERT INTO `menu_role` VALUES ('254', '12', '2');
INSERT INTO `menu_role` VALUES ('255', '13', '2');
INSERT INTO `menu_role` VALUES ('256', '7', '1');
INSERT INTO `menu_role` VALUES ('257', '8', '1');
INSERT INTO `menu_role` VALUES ('258', '9', '1');
INSERT INTO `menu_role` VALUES ('259', '10', '1');
INSERT INTO `menu_role` VALUES ('260', '11', '1');
INSERT INTO `menu_role` VALUES ('261', '12', '1');
INSERT INTO `menu_role` VALUES ('262', '13', '1');
INSERT INTO `menu_role` VALUES ('263', '14', '1');
INSERT INTO `menu_role` VALUES ('264', '15', '1');
INSERT INTO `menu_role` VALUES ('265', '16', '1');
INSERT INTO `menu_role` VALUES ('266', '17', '1');
INSERT INTO `menu_role` VALUES ('267', '18', '1');
INSERT INTO `menu_role` VALUES ('268', '19', '1');
INSERT INTO `menu_role` VALUES ('269', '20', '1');
INSERT INTO `menu_role` VALUES ('270', '21', '1');
INSERT INTO `menu_role` VALUES ('271', '22', '1');
INSERT INTO `menu_role` VALUES ('272', '23', '1');
INSERT INTO `menu_role` VALUES ('273', '24', '1');
INSERT INTO `menu_role` VALUES ('274', '25', '1');
INSERT INTO `menu_role` VALUES ('275', '26', '1');
INSERT INTO `menu_role` VALUES ('276', '27', '1');
INSERT INTO `menu_role` VALUES ('277', '28', '1');
INSERT INTO `menu_role` VALUES ('278', '26', '15');
INSERT INTO `menu_role` VALUES ('279', '30', '15');
INSERT INTO `menu_role` VALUES ('282', '29', '15');
INSERT INTO `menu_role` VALUES ('284', '31', '15');
INSERT INTO `menu_role` VALUES ('285', '35', '16');
INSERT INTO `menu_role` VALUES ('286', '36', '16');
INSERT INTO `menu_role` VALUES ('287', '37', '16');
INSERT INTO `menu_role` VALUES ('288', '38', '16');
INSERT INTO `menu_role` VALUES ('289', '43', '17');
INSERT INTO `menu_role` VALUES ('290', '44', '17');

-- ----------------------------
-- Table structure for oplog
-- ----------------------------
DROP TABLE IF EXISTS `oplog`;
CREATE TABLE `oplog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` date DEFAULT NULL COMMENT '添加日期',
  `operate` varchar(255) DEFAULT NULL COMMENT '操作内容',
  `hrid` int(11) DEFAULT NULL COMMENT '操作员ID',
  PRIMARY KEY (`id`),
  KEY `hrid` (`hrid`),
  CONSTRAINT `oplog_ibfk_1` FOREIGN KEY (`hrid`) REFERENCES `hr` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oplog
-- ----------------------------

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '职位',
  `createDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `enabled` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES ('1', '市场总监', '2018-01-11 11:35:26', '1');

-- ----------------------------
-- Table structure for resident
-- ----------------------------
DROP TABLE IF EXISTS `resident`;
CREATE TABLE `resident` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `certificate_type` varchar(255) DEFAULT NULL,
  `certificate_number` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `nationality` varchar(255) DEFAULT NULL,
  `profession` varchar(255) DEFAULT NULL,
  `education` varchar(255) DEFAULT NULL,
  `marriage` varchar(255) DEFAULT NULL,
  `habits` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resident
-- ----------------------------
INSERT INTO `resident` VALUES ('1', '黎明', '28', '0', null, '身份证', '1243254315346534643', '18895356749', '汉族', '教师', '本科', '已婚', '抽烟');
INSERT INTO `resident` VALUES ('2', '张飞', '26', '0', null, '身份证', '1243254315346534648', '18895356749', '汉族', '医生', '本科', '未婚', '喝酒');
INSERT INTO `resident` VALUES ('3', '杨虎', '45', '0', null, '身份证', '1243254315346534642', '18895356749', '满族', '农民', '小学', '已婚', null);
INSERT INTO `resident` VALUES ('4', '王刚', '53', '0', null, '身份证', '1243254315346534698', '18895356749', '汉族', '农民', '初中', '已婚', null);
INSERT INTO `resident` VALUES ('5', '李丽', '68', '1', null, '身份证', '1243254315346534682', '18895356749', '汉族', '农民', '初中', '已婚', null);
INSERT INTO `resident` VALUES ('6', '高圆圆', '36', '1', null, '身份证', '1243254315346434366', '18895356749', '汉族', '银行职工', '本科', '已婚', null);
INSERT INTO `resident` VALUES ('7', '李欢', '18', '0', null, '身份证', '1243254315346434366', '18895356749', '彝族', '学生', '初中', '未婚', null);
INSERT INTO `resident` VALUES ('8', '杨丽萍', '21', '1', null, '身份证', '1243254315346433535', '18895356749', '汉族', '学生', '专科', '未婚', null);
INSERT INTO `resident` VALUES ('9', '刘阿曼', '63', '0', null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `nameZh` varchar(64) DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'ROLE_manager', '部门经理');
INSERT INTO `role` VALUES ('2', 'ROLE_personnel', '人事专员');
INSERT INTO `role` VALUES ('3', 'ROLE_recruiter', '招聘主管');
INSERT INTO `role` VALUES ('4', 'ROLE_train', '培训主管');
INSERT INTO `role` VALUES ('5', 'ROLE_performance', '薪酬绩效主管');
INSERT INTO `role` VALUES ('6', 'ROLE_admin', '系统管理员');
INSERT INTO `role` VALUES ('13', 'ROLE_test2', '测试角色2');
INSERT INTO `role` VALUES ('14', 'ROLE_test1', '测试角色1');
INSERT INTO `role` VALUES ('15', 'ROLE_alladmin', '总系统管理员');
INSERT INTO `role` VALUES ('16', 'ROLE_hospitaladmin', '医院管理员');
INSERT INTO `role` VALUES ('17', 'ROLE_doctor', '医生');

-- ----------------------------
-- Table structure for salary
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) DEFAULT NULL,
  `depId` int(11) DEFAULT NULL,
  `bonus` int(11) DEFAULT NULL COMMENT '奖金',
  `lunchSalary` int(11) DEFAULT NULL COMMENT '午餐补助',
  `trafficSalary` int(11) DEFAULT NULL COMMENT '交通补助',
  `basisSalary` int(11) DEFAULT NULL COMMENT '基本工资',
  `allSalary` int(11) DEFAULT NULL COMMENT '应发工资',
  PRIMARY KEY (`id`),
  KEY `depId` (`depId`),
  KEY `pid` (`eid`),
  CONSTRAINT `salary_ibfk_2` FOREIGN KEY (`depId`) REFERENCES `department` (`id`),
  CONSTRAINT `salary_ibfk_3` FOREIGN KEY (`eid`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of salary
-- ----------------------------

-- ----------------------------
-- Table structure for treatmenthistory
-- ----------------------------
DROP TABLE IF EXISTS `treatmenthistory`;
CREATE TABLE `treatmenthistory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resident_id` int(11) NOT NULL,
  `doctor_id` int(11) NOT NULL,
  `check_information` varchar(45) DEFAULT NULL,
  `diagnose` varchar(45) DEFAULT NULL,
  `recipe` varchar(45) DEFAULT NULL,
  `advise` varchar(45) DEFAULT NULL,
  `time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of treatmenthistory
-- ----------------------------
INSERT INTO `treatmenthistory` VALUES ('101', '1', '1001', '图片上有', '肺癌', '吃一些药物', '少吸烟', '2014-10-16');
INSERT INTO `treatmenthistory` VALUES ('102', '2', '1001', '图片上有', '肝癌', '吃一些药物', '少吸烟', '2014-03-15');
INSERT INTO `treatmenthistory` VALUES ('103', '3', '1003', '图片上有', '肝癌', '吃一些药物', '少吸烟', '2015-03-07');
INSERT INTO `treatmenthistory` VALUES ('104', '1', '1004', '图片上有', '头疼', '头疼药', '多睡觉', '2016-03-08');
INSERT INTO `treatmenthistory` VALUES ('105', '4', '1005', '图片上有', '头疼', '头疼药', '多睡觉', '2017-02-28');
INSERT INTO `treatmenthistory` VALUES ('106', '5', '1005', '图片上有', '腿疼', '吃药', '多休息', '2016-03-15');
INSERT INTO `treatmenthistory` VALUES ('107', '6', '1007', '图片上有', '腿疼', '吃药', '多休息', '2015-03-15');
INSERT INTO `treatmenthistory` VALUES ('108', '7', '1007', '图片上有', '腿疼', '吃药', '多休息', '2017-03-15');
INSERT INTO `treatmenthistory` VALUES ('109', '8', '1007', '图片上有', '腿疼', '吃药', '多休息', '2018-03-06');
INSERT INTO `treatmenthistory` VALUES ('110', '9', '1007', '图片上有', null, null, null, '2018-03-08');

-- ----------------------------
-- Procedure structure for addDep
-- ----------------------------
DROP PROCEDURE IF EXISTS `addDep`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addDep`(in depName varchar(32),in parentId int,in enabled boolean,out result int,out result2 int)
begin
  declare did int;
  declare pDepPath varchar(64);
  insert into department set name=depName,parentId=parentId,enabled=enabled;
  select row_count() into result;
  select last_insert_id() into did;
  set result2=did;
  select depPath into pDepPath from department where id=parentId;
  update department set depPath=concat(pDepPath,'.',did) where id=did;
  update department set isParent=true where id=parentId;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for deleteDep
-- ----------------------------
DROP PROCEDURE IF EXISTS `deleteDep`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteDep`(in did int,out result int)
begin
  declare ecount int;
  declare pid int;
  declare pcount int;
  select count(*) into ecount from employee where departmentId=did;
  if ecount>0 then set result=-1;
  else 
  select parentId into pid from department where id=did;
  delete from department where id=did and isParent=false;
  select row_count() into result;
  select count(*) into pcount from department where parentId=pid;
  if pcount=0 then update department set isParent=false where id=pid;
  end if;
  end if;
end
;;
DELIMITER ;
