package pl.diakowski.blog.Article;

import java.sql.Timestamp;

public class Article {
    private Integer id;
    private Integer categoryId;
    private Timestamp dateAndTime;
    private String title;
    private String content;

    public Article(Integer id, Integer categoryId, Timestamp dateAndTime, String title, String content) {
        this.id = id;
        this.categoryId = categoryId;
        this.dateAndTime = dateAndTime;
        this.title = title;
        this.content = content;
    }

    public Article(Integer categoryId, Timestamp dateAndTime, String title, String content) {
        this.categoryId = categoryId;
        this.dateAndTime = dateAndTime;
        this.title = title;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
