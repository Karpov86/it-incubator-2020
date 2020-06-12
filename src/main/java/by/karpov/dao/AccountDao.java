package by.karpov.dao;

import java.util.List;

public interface AccountDao<T> {

    List<T> findAll();
}
