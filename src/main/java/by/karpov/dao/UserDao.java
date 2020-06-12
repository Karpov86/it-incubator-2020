package by.karpov.dao;

public interface UserDao<T> {

    T findById(int id);
}
