DROP TABLE IF EXISTS `topic_bbs`;
SET character_set_client = utf8mb4 ;
/*主题帖表*/
CREATE TABLE `topic_bbs` (
  `topic_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `topic_title` varchar(100) DEFAULT NULL COMMENT '主题帖标题',
  `digest` int(11) DEFAULT NULL COMMENT '0-普通; 1-精华;',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '发表时间',
  `last_post` timestamp NULL DEFAULT NULL COMMENT '最后回复时间',


  `topic_views` int(11) DEFAULT NULL COMMENT '浏览数',
  `topic_replies` int(11) DEFAULT NULL COMMENT '回复数',


  PRIMARY KEY (`topic_id`),
  KEY `index_user_id` (`user_id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

