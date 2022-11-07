package pl.diakowski.blog.Comment;

import java.time.LocalDateTime;

public class Comment {
    private Integer id;
    private Integer articleId;
    private Integer userId;

    private String username;

    private LocalDateTime dateAndTime;
    private String content;

    public Comment(Integer id, Integer articleId, Integer userId, String username, LocalDateTime dateAndTime, String content) {
        this.id = id;
        this.articleId = articleId;
        this.userId = userId;
        this.username = username;
        this.dateAndTime = dateAndTime;
        this.content = content;
    }

    public Comment(Integer articleId, Integer userId, String username, LocalDateTime dateAndTime, String content) {
        this.articleId = articleId;
        this.userId = userId;
        this.username = username;
        this.dateAndTime = dateAndTime;
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
}
