package pl.diakowski.blog.Admin;

public class Admin {
    private Integer id;
    private Integer userId;

    public Admin(Integer id, Integer userId) {
        this.id = id;
        this.userId = userId;
    }

    public Admin(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
