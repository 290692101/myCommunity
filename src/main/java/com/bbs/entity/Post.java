package com.bbs.entity;
//主题帖对帖子是一个一对多的关系

import java.util.Date;

public class Post {
    private int id;
    private int userId;
    //表示该帖子是否为主题帖
    private int type;
    private int topicId;
    //帖子内容
    private String content;
    //发布时间
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", UserId=" + userId +
                ", type=" + type +
                ", topicId=" + topicId +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
