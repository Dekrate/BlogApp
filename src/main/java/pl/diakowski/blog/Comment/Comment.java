package pl.diakowski.blog.Comment;

import java.sql.Timestamp;

public class Comment {
    private Integer id;
    private Integer articleId;
    private Integer userId;

    private Timestamp dateAndTime;
    private String content;

    public Comment(Integer id, Integer articleId, Integer userId, Timestamp dateAndTime, String content) {
        this.id = id;
        this.articleId = articleId;
        this.userId = userId;
        this.dateAndTime = dateAndTime;
        this.content = content;
    }

    public Comment(Integer articleId, Integer userId, Timestamp dateAndTime, String content) {
        this.articleId = articleId;
        this.userId = userId;
        this.dateAndTime = dateAndTime;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Timestamp dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
}
