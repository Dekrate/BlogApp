package pl.diakowski.blog.Article;

import jdk.jfr.Experimental;
import pl.diakowski.blog.DataSourceProvider.DataSourceProvider;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ArticleCategoryDao {
    private final DataSource dataSource;


    public ArticleCategoryDao() {
        try {
            dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ArticleCategory> getAllCategories() {
        String sql = "SELECT * FROM blog.articles_categories";

        List<ArticleCategory> articleCategories = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String categoryName = resultSet.getString("category_name");
                String categoryDescription = resultSet.getString("category_description");
                articleCategories.add(new ArticleCategory(id, categoryName, categoryDescription));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return articleCategories;
    }
}
