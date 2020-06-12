package by.karpov.service;

import java.util.List;

public interface AccountService<T> {

    List<T> findAllAccounts();
}
