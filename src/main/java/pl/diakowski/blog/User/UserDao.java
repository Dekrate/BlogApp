package pl.diakowski.blog.User;

import pl.diakowski.blog.DataSourceProvider.DataSourceProvider;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class UserDao {
    private final DataSource dataSource;

    public UserDao() {
        try {
            this.dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addUser(User user) {
        String sql = "INSERT INTO blog.users (email, username, password) VALUES (?, ?, ?)";
        String sql2 = "SELECT (email) FROM blog.users WHERE email=?";
        String sql3 = "SELECT (username) FROM blog.users WHERE username=?";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statementCheckUniqueUser = connection.prepareStatement(sql2);
            statementCheckUniqueUser.setString(1, user.getEmail());
            ResultSet possibleSameData = statementCheckUniqueUser.executeQuery();
            if (possibleSameData.isBeforeFirst()) {
                return false;
            }
            PreparedStatement checkUsername = connection.prepareStatement(sql3);
            checkUsername.setString(1, user.getLogin());
            ResultSet resultSet = checkUsername.executeQuery();
            if (resultSet.isBeforeFirst()) {
                return false;
            }

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());

            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) { // adding parameter id in object User
                user.setId(generatedKeys.getInt(1));
            }

            String sql4 = "INSERT INTO blog.user_roles (username, user_roles) VALUES (?, ?)";
            PreparedStatement addRoles = connection.prepareStatement(sql4);
            addRoles.setString(1, user.getLogin());
            addRoles.setString(2, "user");
            addRoles.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }


    public boolean checkPassword(String username, String password) {
        final String sql = String.format("SELECT password FROM blog.users WHERE username='%s'", username);
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                return false;
            }
            if (resultSet.next()) {
                if (!resultSet.getString(1).equals(password))
                    return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
