package pl.diakowski.blog.Comment;

import pl.diakowski.blog.DataSourceProvider.DataSourceProvider;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {
    private final DataSource dataSource;

    public CommentDao() {
        try {
            this.dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public void addComment(Comment comment) {
        String sql = "INSERT INTO blog.comments (articles_id, users_id, date, content) VALUES (?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, comment.getArticleId());
            preparedStatement.setInt(2, comment.getUserId());
            preparedStatement.setObject(3, comment.getDateAndTime());
            preparedStatement.setString(4, comment.getContent());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                comment.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Comment> getCommentsForArticle(Integer articleId) {
        List<Comment> comments = new ArrayList<>();
        String sql = String.format("SELECT * FROM blog.comments WHERE articles_id='%s' ORDER BY date DESC", articleId);
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int articlesId = resultSet.getInt("articles_id");
                int usersId = resultSet.getInt("users_id");
                Timestamp dateAndTime = (Timestamp) resultSet.getObject("date");
                String content = resultSet.getString("content");
                comments.add(new Comment(id, articlesId, usersId, dateAndTime, content));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return comments;
    }
}
