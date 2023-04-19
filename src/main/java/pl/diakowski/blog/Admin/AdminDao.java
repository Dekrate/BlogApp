package pl.diakowski.blog.Admin;

import pl.diakowski.blog.DataSourceProvider.DataSourceProvider;
import pl.diakowski.blog.User.User;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {
    private final DataSource dataSource;

    public AdminDao() {
        try {
            this.dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkIfAdmin(String user) {
        String sql = "SELECT user_roles FROM user_roles WHERE username=?";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString(1).equals("admin");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public Admin addAdmin(User user) {
        Admin admin = new Admin();
        String sql = "UPDATE blog.user_roles SET user_roles=? WHERE username=?";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, admin.getUsername());
            preparedStatement.setString(2, "admin");
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) { // adding parameter id in object User
                admin.setId(generatedKeys.getInt(1));
            }
            return admin;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
