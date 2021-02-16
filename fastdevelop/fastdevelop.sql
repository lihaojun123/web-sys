/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80021
Source Host           : localhost:3306
Source Database       : fastdevelop

Target Server Type    : MYSQL
Target Server Version : 80021
File Encoding         : 65001

Date: 2021-01-10 23:04:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` varchar(32) NOT NULL COMMENT '博客id',
  `title` varchar(100) DEFAULT NULL COMMENT '博客标题',
  `sub_title` varchar(100) DEFAULT NULL COMMENT '博客副标题',
  `img` varchar(500) NOT NULL DEFAULT 'https://img11.360buyimg.com/n5/s50x64_jfs/t1/107641/24/16240/175339/5eb0cb99E4058b9b0/cf5d2f0a14c0518f.jpg!cc_50x64.jpg' COMMENT '博客封面图片',
  `category_id` varchar(32) DEFAULT NULL COMMENT '博客分类',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('04b41f1a85204278803ff01ef0718724', 'Java资深开发工程师-课程大纲', 'Java资深开发工程师-课程大纲', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-11-14 18:41:52', '2020-11-21 21:56:20');
INSERT INTO `blog` VALUES ('0b2e7c2336dc418287d7875642db81fe', 'spring学习记录', 'spring学习记录', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-10-01 01:02:22', '2020-11-21 21:56:20');
INSERT INTO `blog` VALUES ('0ccd473bf9df4ea9af9e092e9c8ff972', '个人博客开发记录', '个人博客开发记录', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '29', '2020-11-26 21:16:03', '2020-12-07 21:27:28');
INSERT INTO `blog` VALUES ('0dedb3b272284b4088734f51546467a1', '什么样的社交算是有用社交', '', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-11-20 00:21:50', '2020-11-23 21:10:50');
INSERT INTO `blog` VALUES ('0f2009bb183943d4a52ffae3580f0dfb', 'spring源码深度解析', 'spring源码深度解析spring源码深度解析', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-11-03 10:14:18', '2020-11-21 21:56:20');
INSERT INTO `blog` VALUES ('15b48b3cfc02496b877edad3f936c7bc', 'java代理', '', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-10-21 09:51:09', '2020-11-21 21:56:20');
INSERT INTO `blog` VALUES ('1d0c27ab4b0f4575b9771e585d346db1', '如何正确删库', '如何正确删库', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-11-01 17:42:14', '2020-11-21 21:56:20');
INSERT INTO `blog` VALUES ('242d520bc48c423c9fcbd4a705b6ea4d', 'spring aop切入点表达式', 'spring aop切入点表达式', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '20', '2020-11-30 22:06:55', '2020-12-07 21:27:28');
INSERT INTO `blog` VALUES ('2d6491fb644d4798a8b0444be3b1d4ac', 'spring容器的启动过程', '', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-11-05 10:12:03', '2020-11-21 21:56:20');
INSERT INTO `blog` VALUES ('368e6d2e0498439886c9db4cb28f0183', '杂记', '杂记', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-10-21 23:36:08', '2020-11-21 21:56:20');
INSERT INTO `blog` VALUES ('4b8ab38fc533444ab60f0c04bf3447e0', 'gradle下载安装', 'gradle下载安装', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '27', '2020-11-25 10:42:40', '2020-11-25 10:43:09');
INSERT INTO `blog` VALUES ('4fb6b526846b4365a05689725202f4fc', 'html回到顶部', 'html回到顶部', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-11-19 22:34:08', '2020-11-23 21:10:50');
INSERT INTO `blog` VALUES ('556f4f23e3d64d8f85887ae884005f7a', 'springboot源码', 'springboot源码', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-11-07 13:53:13', '2020-11-21 21:56:20');
INSERT INTO `blog` VALUES ('6054ec44239c4f33ae3fbaae5c3772f5', 'MySQL常见命令记录', 'MySQL常见命令记录', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-10-13 23:13:27', '2020-11-21 21:56:20');
INSERT INTO `blog` VALUES ('64be1dd9488a44d1a0c4aea98240ea89', '待做事项', '待做事项', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-10-13 20:39:48', '2020-11-21 21:56:20');
INSERT INTO `blog` VALUES ('6afd29a875a94e6790098c81ab70b16f', 'springboot中如何优雅的校验参数', 'springboot中如何优雅的校验参数', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '33', '2020-12-13 12:24:47', '2020-12-13 12:24:47');
INSERT INTO `blog` VALUES ('6f4f0dc97d5e42f6b3c22840396849e7', '搞懂 MySQL Explain 命令之前不要说自己会SQL优化', '搞懂 MySQL Explain 命令之前不要说自己会SQL优化', '', '24', '2020-12-12 14:46:43', '2020-12-12 14:46:43');
INSERT INTO `blog` VALUES ('72c0622248a5476e82824367409a8dd7', 'guava学习总结', 'guava学习总结', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-11-16 16:43:04', '2020-11-21 21:56:20');
INSERT INTO `blog` VALUES ('7698a6d5de58458981167ab61cb61c51', '自研项目', '自研项目', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-10-17 21:59:38', '2020-11-21 21:56:20');
INSERT INTO `blog` VALUES ('77aa798602174edbb0fd490d54564509', '秒杀项目', '秒杀项目', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-11-15 19:59:13', '2020-11-21 21:56:20');
INSERT INTO `blog` VALUES ('84f4de8ed3134734ba945e0f49e2fd02', 'jetcache的使用', '阿里巴巴缓存框架——jetcache的使用', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-11-20 19:44:55', '2020-11-23 21:10:50');
INSERT INTO `blog` VALUES ('87b67514603b456caa9ce4848bc1c9a5', 'mysql数据库 Java代码自动生成工具', 'mysql数据库 Java代码自动生成工具', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-10-20 17:18:40', '2020-11-21 21:56:20');
INSERT INTO `blog` VALUES ('8bcd0f980b2c4a0a98099c1fee2cd847', 'MySQL 老有贼慢 SQL ，怎么优化？', 'MySQL 老有贼慢 SQL ，怎么优化？', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '25', '2020-11-23 22:54:33', '2020-12-07 21:27:28');
INSERT INTO `blog` VALUES ('909c2ca019934fa899f61c9cd79e5d44', 'Springbean的生命周期', 'Springbean的生命周期', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-11-04 09:31:00', '2020-11-21 21:56:20');
INSERT INTO `blog` VALUES ('99999', 'console测试标题', '子标题', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-09-29 10:48:21', '2020-11-21 21:56:20');
INSERT INTO `blog` VALUES ('9a17b3d96a7b45c49c01b03bf73b149a', '测试博客', '测试博客子标题', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-09-30 19:53:08', '2020-11-21 21:56:20');
INSERT INTO `blog` VALUES ('ae4452e4fc4546e0a5efe0cc20f77d7c', 'spring注解驱动开发', 'spring注解驱动开发', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '20', '2020-11-21 18:24:15', '2020-11-23 22:47:24');
INSERT INTO `blog` VALUES ('b5200519395c4b23bc9cb3c0c11db474', 'virtual box安装centos7并配置网络', 'virtual box安装centos7并配置网络', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-10-19 21:40:12', '2020-11-21 21:56:20');
INSERT INTO `blog` VALUES ('b6110f752c6e47a7a4e2e8e398b30238', 'spring加载单实例', 'spring加载单实例', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-11-19 21:47:55', '2020-11-23 21:10:50');
INSERT INTO `blog` VALUES ('c14ee7f33759478b9ca4b70176db3114', 'centos 7 命令记录', 'centos 7 命令记录', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-10-19 23:18:09', '2020-11-21 21:56:20');
INSERT INTO `blog` VALUES ('cf969d459d4f45b6a7996d5ac2ba7a74', '223', '223', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-09-30 19:54:07', '2020-11-21 21:56:20');
INSERT INTO `blog` VALUES ('d6ee9f77fcd444c98a94eed458676b8f', '后端优化性能经验分享', '后端优化性能经验分享', '', '32', '2020-12-09 17:29:41', '2020-12-09 17:29:41');
INSERT INTO `blog` VALUES ('d864b4b920864f218e094ac9e1768673', '测试博客', '测试博客子标题', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-09-27 22:00:39', '2020-11-21 21:56:20');
INSERT INTO `blog` VALUES ('d9f99262011c471e851641983d2e8af3', 'MySQL高性能', '', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-11-15 22:53:41', '2020-11-21 21:56:20');
INSERT INTO `blog` VALUES ('dde7f3fa8eda4a78926b924939fe1da6', 'linux 安装jdk8', '', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-10-20 10:44:47', '2020-11-21 21:56:20');
INSERT INTO `blog` VALUES ('de868e2baccb4ea7b97534539cc683ce', 'spring相关知识点总结', 'spring相关知识点总结', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-11-03 11:08:04', '2020-11-21 21:56:20');
INSERT INTO `blog` VALUES ('ee111ea804644de0ab142fd1cf9eefcf', '青椒炒鸡蛋', '青椒炒鸡蛋', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-11-16 20:05:09', '2020-11-21 21:56:20');
INSERT INTO `blog` VALUES ('f1f0c376262f428eaf20d5fbc6b6723e', 'Java秒杀项目b站', '', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-11-16 11:14:09', '2020-11-21 21:56:20');
INSERT INTO `blog` VALUES ('f2d4574a17ff4433b85d82d540dce64b', 'docker', 'docker', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-10-19 22:32:56', '2020-11-21 21:56:20');
INSERT INTO `blog` VALUES ('f41bde9b011f47e0b020280db4d29b8f', '333', '333', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-09-30 19:59:49', '2020-11-21 21:56:20');
INSERT INTO `blog` VALUES ('f909c5174a774a91862bef4091ea4883', 'redisson使用总结', '', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-11-17 14:23:14', '2020-11-21 21:56:20');
INSERT INTO `blog` VALUES ('fa239f1b25bd4378802fc0c6c7f19b06', 'Java高并发', '', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-11-16 10:26:07', '2020-11-21 21:56:20');
INSERT INTO `blog` VALUES ('fc2b1c8735664348a1027e9fd2489935', 'springboot整合rabbitmq', '', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '1', '2020-11-18 10:55:04', '2020-11-21 21:56:20');
INSERT INTO `blog` VALUES ('ffd986fde9e74a1ea5902513e8fc0a2b', '2020/11/30', '2020/11/30', 'https://w.wallhaven.cc/full/57/wallhaven-57ld93.png', '31', '2020-11-30 23:01:53', '2020-12-07 21:27:28');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` varchar(100) NOT NULL COMMENT '分类id',
  `name` varchar(100) DEFAULT NULL COMMENT '分类名称',
  `p_id` varchar(100) DEFAULT NULL COMMENT '父分类id',
  `description` varchar(200) DEFAULT NULL COMMENT '分类描述',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('0472452a5a754ed68c4f5bdd5b9ffb1e', 'Spring Cloud Alibaba', '16d2915de15046d98fee9d5b207ed1ee', 'Spring Cloud Alibaba', '2021-01-03 13:04:49', '2021-01-03 13:04:49');
INSERT INTO `category` VALUES ('0c5e06824b034d1790d6b75b1edca943', 'leetcode 题库', '0', 'leetcode 题库', '2021-01-07 18:39:18', '2021-01-07 18:39:18');
INSERT INTO `category` VALUES ('1107e728938545c08648a9c5bf542cef', 'Mysql', '4d4b06f6014949e683e12b7215ba815a', 'MySQL技术总结', '2021-01-02 15:51:02', '2021-01-02 15:51:02');
INSERT INTO `category` VALUES ('16d2915de15046d98fee9d5b207ed1ee', '后端', '0', '后端', '2020-12-29 17:45:45', '2020-12-29 17:45:45');
INSERT INTO `category` VALUES ('1efd7736273e450baa5c81672a95f01a', 'SpringBoot', '16d2915de15046d98fee9d5b207ed1ee', 'SpringBoot', '2021-01-06 18:29:06', '2021-01-06 18:29:06');
INSERT INTO `category` VALUES ('3c7595180f454ed5a10d98845b7352a5', 'spring', '16d2915de15046d98fee9d5b207ed1ee', 'spring', '2021-01-01 13:31:23', '2021-01-01 13:31:23');
INSERT INTO `category` VALUES ('4003fcf94fae469a97be465342e88cfd', '情感生活', '0', '情感生活', '2021-01-01 13:04:52', '2021-01-01 13:04:52');
INSERT INTO `category` VALUES ('435fab233c5d4a6da771ed7c799ee21f', '数据库', '0c5e06824b034d1790d6b75b1edca943', '数据库', '2021-01-07 18:39:32', '2021-01-07 18:39:32');
INSERT INTO `category` VALUES ('4d4b06f6014949e683e12b7215ba815a', '数据库', '0', '数据库', '2021-01-01 10:13:50', '2021-01-01 10:14:09');
INSERT INTO `category` VALUES ('4fdd585cecf44d1f89a2d4b700219e9d', '前端', '0', '前端', '2020-12-29 17:48:34', '2020-12-29 17:48:34');
INSERT INTO `category` VALUES ('7f882536f88b437e84dff1f13564d296', 'VUE', '4fdd585cecf44d1f89a2d4b700219e9d', 'VUE', '2020-12-29 21:02:33', '2020-12-29 21:02:33');
INSERT INTO `category` VALUES ('886c3ae42ded4cffbc9c2ffbc4a16e5f', '测试分类', '0', '测试分类', '2021-01-01 12:51:40', '2021-01-01 12:51:40');
INSERT INTO `category` VALUES ('a39337aaf14f4f87a36a0fc408953149', '数据分析', '0', '数据分析', '2021-01-01 10:16:37', '2021-01-01 10:16:37');
INSERT INTO `category` VALUES ('bef31cb1c65d42918007a6bfedbad6dd', '数据挖掘', 'a39337aaf14f4f87a36a0fc408953149', '数据挖掘', '2021-01-01 10:16:58', '2021-01-01 10:16:58');
INSERT INTO `category` VALUES ('fc3412aa32684e72b85f377fdf6448f2', 'Java面试', '16d2915de15046d98fee9d5b207ed1ee', 'Java面试', '2021-01-06 18:20:06', '2021-01-06 18:20:06');

-- ----------------------------
-- Table structure for chapter
-- ----------------------------
DROP TABLE IF EXISTS `chapter`;
CREATE TABLE `chapter` (
  `id` varchar(100) NOT NULL COMMENT '章节id',
  `p_id` varchar(100) NOT NULL COMMENT '章节父id',
  `title` varchar(100) NOT NULL COMMENT '章节内容',
  `chapter_type` varchar(100) NOT NULL COMMENT '章节类型，1代表章，2代表节',
  `num` bigint DEFAULT NULL COMMENT '顺序'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of chapter
-- ----------------------------
INSERT INTO `chapter` VALUES ('0099f876968c4453b2a65847d5274b65', '0', 'MySQL优化总结', '1', null);
INSERT INTO `chapter` VALUES ('c700eadbd76a477a8db66138945fc664', '0099f876968c4453b2a65847d5274b65', '章1', '1', '1');
INSERT INTO `chapter` VALUES ('3738b0d957974477a34c27362c394942', 'c700eadbd76a477a8db66138945fc664', '节1.1', '2', '1');
INSERT INTO `chapter` VALUES ('de1fec68d7b74e09bd38396d37a1aa5a', 'c700eadbd76a477a8db66138945fc664', '节1.2', '2', '2');
INSERT INTO `chapter` VALUES ('4330473bd1ad481d88f50669171e604f', 'c700eadbd76a477a8db66138945fc664', '节13', '2', '3');
INSERT INTO `chapter` VALUES ('44cd15defb7242baa4da1ee25b9fcef1', '0099f876968c4453b2a65847d5274b65', '章2', '1', '2');
INSERT INTO `chapter` VALUES ('a8d84c02c84a4bcf959f417532b503dd', '44cd15defb7242baa4da1ee25b9fcef1', '节2.1', '2', '1');
INSERT INTO `chapter` VALUES ('6a252ce9509c4ddfa54554be2529eed6', '0', 'spring cloud alibaba限流sentinel', '1', null);
INSERT INTO `chapter` VALUES ('b3f298310098495ab2c69bb51d92a1c1', '6a252ce9509c4ddfa54554be2529eed6', '限流sentinel', '1', '1');
INSERT INTO `chapter` VALUES ('e0970cf1ca044fb0b5871a8570b14ae2', 'b3f298310098495ab2c69bb51d92a1c1', '限流sentinel 结合spring cloud gateway', '2', '1');
INSERT INTO `chapter` VALUES ('ec00658252f1404496dbcc86e7f39d48', '0', 'Java面试大全', '1', null);
INSERT INTO `chapter` VALUES ('a014184cb55d4d93bb803121e005573b', 'ec00658252f1404496dbcc86e7f39d48', '1 Java 基础', '1', '1');
INSERT INTO `chapter` VALUES ('c72dbac67228440e83f82662753ab8a4', 'a014184cb55d4d93bb803121e005573b', '1.1 java基础知识', '2', '1');
INSERT INTO `chapter` VALUES ('0fbbfa63538d4b6eaa920272d1275963', 'a014184cb55d4d93bb803121e005573b', '1.2 java基础知识进阶', '2', '2');
INSERT INTO `chapter` VALUES ('5869c0994bf2408695d57f535cc85f87', '0', 'MySQL基础', '1', null);
INSERT INTO `chapter` VALUES ('2c71182a95814683a55c781a12af349d', '5869c0994bf2408695d57f535cc85f87', '1 MySQL列操作', '1', '1');
INSERT INTO `chapter` VALUES ('9d0820ed40f744c4b6a7a37ebbf03771', '2c71182a95814683a55c781a12af349d', '1.1  增加一列', '2', '1');
INSERT INTO `chapter` VALUES ('ee78a7d4e21a4fc1a71c01e4c2565b25', '2c71182a95814683a55c781a12af349d', '1.2 删除一列', '2', '2');
INSERT INTO `chapter` VALUES ('8e5ad9e8d09f4af38297e623189f8b07', '2c71182a95814683a55c781a12af349d', '1.3 修改列', '2', '3');

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(255) NOT NULL,
  `resource_ids` varchar(255) DEFAULT NULL,
  `client_secret` varchar(255) DEFAULT NULL,
  `scope` varchar(255) DEFAULT NULL,
  `authorized_grant_types` varchar(255) DEFAULT NULL,
  `web_server_redirect_uri` varchar(255) DEFAULT NULL,
  `authorities` varchar(255) DEFAULT NULL,
  `access_token_validity` int DEFAULT NULL,
  `refresh_token_validity` int DEFAULT NULL,
  `additional_information` varchar(255) DEFAULT NULL,
  `autoapprove` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('fastdevelop', '', '$2a$10$gR42Aws1nHNoPdmCAwXVj.HRQrYnXsoyzaUnF22pZHTqLi08QqBii', 'app', 'authorization_code,password,refresh_token,client_credentials', 'http://localhost', '', '36000', '36000', '{\"key\":\"value\"}', '');
INSERT INTO `oauth_client_details` VALUES ('testapp', '', '$2a$10$dslJFXYzpPT6PIU/GPU9Nu9vep.oG2Qg76KsnzMpfWtBEA6lhRFCS', 'app', '', '', 'user', '36000', '36000', '{\"key\":\"value\"}', '');
INSERT INTO `oauth_client_details` VALUES ('tesapp2', '', '$2a$10$GlTk1leg4gWdN4GteyaqLueRVQq2/LknctQsnholaA.5ZypUmPMWG', 'app', '', '', '', '36000', '36000', '{\"key\":\"value\"}', '');

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` varchar(100) NOT NULL COMMENT 'id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `title` varchar(500) DEFAULT NULL,
  `sub_title` varchar(500) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `project_type` varchar(100) DEFAULT NULL,
  `category_id` varchar(100) DEFAULT NULL,
  `img` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT 'https://gitee.com/leefuyong/blogimg/raw/master/null/user_avatar.jpg' COMMENT '封面',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('0099f876968c4453b2a65847d5274b65', '2021-01-02 15:51:18', '2021-01-06 18:17:55', 'MySQL优化总结', 'MySQL优化总结', '1', '2', '1107e728938545c08648a9c5bf542cef', 'https://gitee.com/leefuyong/blogimg/raw/master/null/user_avatar.jpg');
INSERT INTO `project` VALUES ('04b144d9a8164d889faf42a9f4f80247', '2020-12-26 00:58:17', '2021-01-01 12:47:50', 'JAVA8的java.util.function包', 'JAVA8的java.util.function包介绍', '1', '1', '16d2915de15046d98fee9d5b207ed1ee', 'https://gitee.com/leefuyong/blogimg/raw/master/null/user_avatar.jpg');
INSERT INTO `project` VALUES ('0717a7c6ec7f449fae891350c4b5b41b', '2021-01-10 16:04:34', '2021-01-10 17:23:46', '编写一个 SQL 查询来实现分数排名。', '如果两个分数相同，则两个分数排名（Rank）相同。请注意，平分后的下一个名次应该是下一个连续的整数值。换句话说，名次之间不应该有“间隔”。', '1', '1', '435fab233c5d4a6da771ed7c799ee21f', 'https://gitee.com/leefuyong/blogimg/raw/master/null/user_avatar.jpg');
INSERT INTO `project` VALUES ('26f8ff0aa0c84ef4a9f4c61438118a24', '2021-01-07 18:40:07', '2021-01-09 16:18:39', '1 、组合表', '1 、组合表', '1', '1', '435fab233c5d4a6da771ed7c799ee21f', 'https://gitee.com/leefuyong/blogimg/raw/master/null/user_avatar.jpg');
INSERT INTO `project` VALUES ('4d3d4c4401654c279e3af3178bd54927', '2021-01-07 19:11:52', '2021-01-09 16:18:40', '编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。', '编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。', '1', '1', '435fab233c5d4a6da771ed7c799ee21f', 'https://gitee.com/leefuyong/blogimg/raw/master/null/user_avatar.jpg');
INSERT INTO `project` VALUES ('5869c0994bf2408695d57f535cc85f87', '2021-01-10 17:12:09', '2021-01-10 17:23:46', 'MySQL基础', 'MySQL基础', '1', '2', '1107e728938545c08648a9c5bf542cef', 'https://gitee.com/leefuyong/blogimg/raw/master/null/user_avatar.jpg');
INSERT INTO `project` VALUES ('6a252ce9509c4ddfa54554be2529eed6', '2021-01-03 13:05:38', '2021-01-06 18:17:55', 'Spring Cloud Alibaba', 'Spring Cloud Alibaba', '1', '2', '0472452a5a754ed68c4f5bdd5b9ffb1e', 'https://gitee.com/leefuyong/blogimg/raw/master/null/user_avatar.jpg');
INSERT INTO `project` VALUES ('6d232a6cb39f4d3dae319bd58ba68c71', '2021-01-09 15:41:12', '2021-01-09 16:18:42', '编写一个 SQL 查询，获取 Employee 表中第 n 高的薪水（Salary）', '编写一个 SQL 查询，获取 Employee 表中第 n 高的薪水（Salary）', '1', '1', '435fab233c5d4a6da771ed7c799ee21f', 'https://gitee.com/leefuyong/blogimg/raw/master/null/user_avatar.jpg');
INSERT INTO `project` VALUES ('87b597ef6b3b470286a1ed0aab0740d3', '2021-01-06 18:29:18', '2021-01-06 21:32:52', '基于 SpringBoot，来实现MySQL读写分离技术', '基于 SpringBoot，来实现MySQL读写分离技术', '1', '1', '1efd7736273e450baa5c81672a95f01a', 'https://gitee.com/leefuyong/blogimg/raw/master/null/user_avatar.jpg');
INSERT INTO `project` VALUES ('8e8baa010d0b4b919608c0005001778e', '2020-12-25 20:31:50', '2021-01-01 12:51:49', '测试博客标题', '测试博客子标题', '1', '1', '886c3ae42ded4cffbc9c2ffbc4a16e5f', 'https://gitee.com/leefuyong/blogimg/raw/master/null/user_avatar.jpg');
INSERT INTO `project` VALUES ('9587e6b496c142a391542dacb3e72c98', '2020-12-24 23:12:51', '2021-01-01 12:51:58', 'ff', 'fff', '1', '1', '886c3ae42ded4cffbc9c2ffbc4a16e5f', 'https://gitee.com/leefuyong/blogimg/raw/master/null/user_avatar.jpg');
INSERT INTO `project` VALUES ('9ba7b32d97ff48a68a9fdc62b0815ed3', '2021-01-01 09:53:44', '2021-01-01 10:24:41', '再来测试', '再来测试', '1', '1', null, 'https://gitee.com/leefuyong/blogimg/raw/master/null/user_avatar.jpg');
INSERT INTO `project` VALUES ('a230335472234e528fddc8d2472cd082', '2020-12-26 15:55:03', '2021-01-01 10:24:41', 'Spring Cloud Alibaba Nacos配置中心与服务发现', 'nacos注册中心介绍', '1', '1', null, 'https://gitee.com/leefuyong/blogimg/raw/master/null/user_avatar.jpg');
INSERT INTO `project` VALUES ('a5a3b57096e84ee080a92246a631e93a', '2020-12-24 23:15:14', '2021-01-01 10:24:41', 'ddd', 'ddddd', '1', '1', null, 'https://gitee.com/leefuyong/blogimg/raw/master/null/user_avatar.jpg');
INSERT INTO `project` VALUES ('b0c0970052fe4a8d90106b0116619742', '2021-01-03 14:28:42', '2021-01-03 14:28:42', 'spring源码研究', 'spring源码研究', '1', '1', '3c7595180f454ed5a10d98845b7352a5', 'https://gitee.com/leefuyong/blogimg/raw/master/null/user_avatar.jpg');
INSERT INTO `project` VALUES ('b231df2a347c460282d434d5c69fa4e0', '2021-01-01 13:05:14', '2021-01-06 18:17:55', '情绪管理的七点建议', '情绪管理的七点建议', '1', '1', '4003fcf94fae469a97be465342e88cfd', 'https://gitee.com/leefuyong/blogimg/raw/master/null/user_avatar.jpg');
INSERT INTO `project` VALUES ('bcf48d50ed5248788663c349654e827a', '2021-01-01 09:56:24', '2021-01-01 10:24:41', '再来测试', '再来测试', '1', '1', '7f882536f88b437e84dff1f13564d296', 'https://gitee.com/leefuyong/blogimg/raw/master/null/user_avatar.jpg');
INSERT INTO `project` VALUES ('e7d671ea4c244586a84702594b09c344', '2021-01-01 10:41:25', '2021-01-06 18:17:55', '测试', '测试', '1', '1', '16d2915de15046d98fee9d5b207ed1ee', 'https://gitee.com/leefuyong/blogimg/raw/master/null/user_avatar.jpg');
INSERT INTO `project` VALUES ('ec00658252f1404496dbcc86e7f39d48', '2021-01-06 18:20:32', '2021-01-06 18:21:10', 'Java面试大全', 'Java面试大全', '1', '2', 'fc3412aa32684e72b85f377fdf6448f2', 'https://gitee.com/leefuyong/blogimg/raw/master/null/user_avatar.jpg');
INSERT INTO `project` VALUES ('f9e338bd85614895a425a01d90ca1fce', '2020-12-25 22:40:37', '2021-01-01 10:24:41', 'Java optional', 'Java optional介绍', '1', '1', null, 'https://gitee.com/leefuyong/blogimg/raw/master/null/user_avatar.jpg');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(10) DEFAULT NULL COMMENT '用户名称',
  `nickname` varchar(10) DEFAULT NULL COMMENT '用户昵称',
  `password` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户密码',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `userpic` varchar(500) DEFAULT NULL COMMENT '用户头像',
  `email` varchar(20) DEFAULT NULL COMMENT '用户邮箱',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `nickname` (`nickname`),
  UNIQUE KEY `mobile` (`mobile`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'lifuyong', '李付勇', '$2a$10$MIQ65WhfoOJoQD7P3Ty5h.NsT6jMfjAAWxEiH1GMG.tiZX4RI6wju', '13761809951', 'https://gitee.com/leefuyong/blogimg/raw/master/null/user_avatar.jpg', '13761809951@163.com', '2020-09-30 17:16:14', '2020-12-14 12:51:43');
INSERT INTO `user` VALUES ('2', 'lichangjun', '李长军', '$2a$10$4EyZRCIEwUwFe3RgYYjxXOiU4Tb7kahgiqDNvxZKp.Zwm26yHswEi', '15765453465', 'https://gitee.com/leefuyong/blogimg/raw/master/null/user_avatar.jpg', '157654534625@qq.com', '2020-09-30 17:51:43', '2020-12-18 21:13:14');
INSERT INTO `user` VALUES ('13', '8', 'yyyy', '7', '7', 'https://gitee.com/leefuyong/blogimg/raw/master/null/user_avatar.jpg', '7', '2020-09-30 22:04:21', '2020-12-14 12:51:43');
INSERT INTO `user` VALUES ('16', '81', 'yyyy1', '71', '71', 'https://gitee.com/leefuyong/blogimg/raw/master/null/user_avatar.jpg', '71', '2020-10-12 23:45:39', '2020-12-14 12:51:43');
INSERT INTO `user` VALUES ('18', 'liyulan', '鲤鱼烂', '$2a$10$bL.BHxWVwUju0DDiJE5zneR.LSvuqdQQTzeHX3e8gQIMxGuzQ5//G', null, 'https://gitee.com/leefuyong/blogimg/raw/master/null/user_avatar.jpg', null, '2020-10-24 00:00:21', '2020-12-19 01:55:10');
INSERT INTO `user` VALUES ('19', 'tingting', null, '$2a$10$vUxf.U/5u838ybxfz7iv9.TgWel84QGF5lD1xDTvwOCv2pMXi/zVa', null, 'https://gitee.com/leefuyong/blogimg/raw/master/null/user_avatar.jpg', null, '2020-12-08 15:00:26', '2020-12-14 12:51:43');
INSERT INTO `user` VALUES ('20', 'kikihi', 'KIKIhi', '$2a$10$voHpaIaKHMw5uecRLg4qzOOgWiI4ayeUHMXdlckDyRo8Iogc3BvM6', null, 'https://gitee.com/leefuyong/blogimg/raw/master/null/user_avatar.jpg', null, '2020-12-18 22:13:11', '2020-12-18 22:38:42');
