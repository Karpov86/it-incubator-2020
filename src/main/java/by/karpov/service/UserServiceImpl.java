package by.karpov.service;

import by.karpov.dao.UserDaoImpl;
import by.karpov.entity.User;

public class UserServiceImpl implements UserService<User> {
    @Override
    public User findUserById(int id) {
        return UserDaoImpl.getInstance().findById(id);
    }
}
