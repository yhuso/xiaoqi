CREATE TABLE `diary` (
  `id` INTEGER unsigned NOT NULL AUTO_INCREMENT,
  `toUserName` varchar(40) DEFAULT NULL COMMENT '开发者微信号',
  `fromUserName` varchar(40) DEFAULT NULL COMMENT '发送方帐号',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '消息创建时间',
	`msgType` varchar(10) COMMENT '消息类型',
  `content` varchar(300) DEFAULT NULL COMMENT '文本消息内容',
	`msgId` bigint DEFAULT NULL COMMENT '消息id',
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8;


ALTER TABLE diary  ADD `mediaId` VARCHAR(128) DEFAULT NULL COMMENT '媒体id';
ALTER TABLE diary  ADD `picUrl` VARCHAR(200) DEFAULT NULL COMMENT '图片链接';
ALTER TABLE diary  ADD `msgGroupId` INTEGER unsigned DEFAULT NULL COMMENT '媒体id';

CREATE TABLE `msgGroup` (
  `id` INTEGER unsigned NOT NULL AUTO_INCREMENT,
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '消息创建时间',
	`updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8;