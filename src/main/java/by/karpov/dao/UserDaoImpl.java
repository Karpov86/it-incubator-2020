package by.karpov.dao;

import by.karpov.entity.User;

import java.sql.*;

public class UserDaoImpl implements UserDao<User> {

    private static final String FIND_USER_QUERY = "SELECT * FROM users WHERE id = ?;";
    private static final String FIND_BY_MAX_ACCOUNT_QUERY =
            "SELECT u.name, u.surname, a.account\n" +
                    "FROM users u \n" +
                    "join accounts a on u.id=a.user_id\n" +
                    "group by name\n" +
                    "having account = (select max(account) from accounts);";
    private static UserDaoImpl INSTANCE;

    private UserDaoImpl() {

    }

    public static UserDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (UserDaoImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UserDaoImpl();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public User findById(int id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_USER_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            User user = null;
            while (resultSet.next()) {
                user = new User.Builder()
                        .setName(resultSet.getString("name"))
                        .setSurname(resultSet.getString("surname"))
                        .build();
            }

            resultSet.close();
            statement.close();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findByMaxAccount() {
        try (final Connection connection = ConnectionManager.getConnection()) {
            final PreparedStatement statement = connection.prepareStatement(FIND_BY_MAX_ACCOUNT_QUERY);
            final ResultSet resultSet = statement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User.Builder()
                        .setName(resultSet.getString("name"))
                        .setSurname(resultSet.getString("surname"))
                        .build();
                resultSet.close();
                statement.close();
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(User user) {
        try (Connection connection = ConnectionManager.getConnection()) {
            String sql = "INSERT INTO users (name, surname) VALUES (?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE id = ?;");
            statement.setLong(1, id);
            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
