package pl.diakowski.blog.Article;

import pl.diakowski.blog.DataSourceProvider.DataSourceProvider;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao {
    private final DataSource dataSource;

    public ArticleDao() {
        try {
            this.dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    void addArticle(Article article) {
        String sql = "INSERT INTO blog.articles (articles_category_id, title, date, content) VALUES (?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, article.getCategoryId());
            preparedStatement.setObject(2, new Timestamp(new java.util.Date().getTime())); // check if it works correctly
            preparedStatement.setString(3, article.getTitle());
            preparedStatement.setString(4, article.getContent());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                article.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // to do: removeArticle()

    public List<Article> findAllArticles() {
        String sql = "SELECT * FROM blog.articles ORDER BY date DESC";
        List<Article> arrayList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int articles_category_id = resultSet.getInt("articles_category_id");
                LocalDateTime dateAndTime = (LocalDateTime) resultSet.getObject("date");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                arrayList.add(new Article(id, articles_category_id, dateAndTime, title, content));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    public String getTitleById(int id) {
        final String sql = "SELECT title FROM blog.articles WHERE id=?";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public Article findArticle(Integer id) {
        final String sql = "SELECT * FROM blog.articles WHERE id=?";
        Article article;
        try (Connection connection = dataSource.getConnection()
        ) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int articlesCategoryId = resultSet.getInt("articles_category_id");
                LocalDateTime date = (LocalDateTime) resultSet.getObject("date");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                article = new Article(id, articlesCategoryId, date, title, content);
            } else { // to do
                throw new NullPointerException("Nie znaleziono artykułu");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return article;
    }
}
