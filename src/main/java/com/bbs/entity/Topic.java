package com.bbs.entity;

import java.util.Date;
/*主题帖实体类*/
/**
 * 对应数据库表topic_bbs
 *
 * */
public class Topic {
    private int id;
    private int userId;
    private int digest;
    private int views;
    private int replies;

    private String title;
    private Date createTime;
    private Date lastPost;

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

    public int getDigest() {
        return digest;
    }

    public void setDigest(int digest) {
        this.digest = digest;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getReplies() {
        return replies;
    }

    public void setReplies(int replies) {
        this.replies = replies;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastPost() {
        return lastPost;
    }

    public void setLastPost(Date lastPost) {
        this.lastPost = lastPost;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", userId=" + userId +
                ", digest=" + digest +
                ", views=" + views +
                ", replies=" + replies +
                ", title='" + title + '\'' +
                ", createTime=" + createTime +
                ", lastPost=" + lastPost +
                '}';
    }
}
