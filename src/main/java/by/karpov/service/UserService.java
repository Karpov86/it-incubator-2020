package by.karpov.service;

public interface UserService<T> {

    T findUserById(int id);
}
