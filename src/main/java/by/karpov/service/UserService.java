package by.karpov.service;

import java.util.List;

public interface UserService<T, V> {

    T findUserById(int id);

    T findRichestUser(List<V> list);
}
