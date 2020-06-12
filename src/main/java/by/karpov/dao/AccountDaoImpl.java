package by.karpov.dao;

import by.karpov.entity.Account;
import by.karpov.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class AccountDaoImpl implements AccountDao<Account> {

    private static final String FIND_ALL_QUERY = "SELECT * FROM accounts a JOIN users u ON a.user_id=u.id;";
    private static AccountDaoImpl INSTANCE;
    private Map<Integer, User> userMap = new HashMap<>();

    private AccountDaoImpl() {
    }

    public static AccountDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (AccountDaoImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AccountDaoImpl();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public List<Account> findAll() {
        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();
            List<Account> accounts = new ArrayList<>();

            while (resultSet.next()) {
                accounts.add(new Account.Builder()
                        .setAccount(resultSet.getInt("account"))
                        .setUser(new User.Builder().setId(resultSet.getInt("user_id"))
                                .setName(resultSet.getString("name"))
                                .setSurname(resultSet.getString("surname"))
                                .build())
                        .build());
            }
            resultSet.close();
            statement.close();
            return accounts;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}


