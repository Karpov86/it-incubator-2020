package by.karpov.dao;

public interface UserDao<T> {

    T findById(int id);

    /**
     * find the richest user by query
     */
    T findByMaxAccount();

    void save(T entity);

    void delete(int id);
}
