package by.karpov.service;

import by.karpov.dao.UserDaoImpl;
import by.karpov.entity.Account;
import by.karpov.entity.User;

import java.util.Comparator;
import java.util.List;

public class UserServiceImpl implements UserService<User, Account> {

    @Override
    public User findUserById(int id) {
        return UserDaoImpl.getInstance().findById(id);
    }

    @Override
    public User findRichestUser(List<Account> accounts) {
        return accounts.stream().max(Comparator.comparing(Account::getAccount)).map(Account::getUser).get();
    }
}
