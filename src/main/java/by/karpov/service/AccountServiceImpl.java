package by.karpov.service;

import by.karpov.dao.AccountDaoImpl;
import by.karpov.entity.Account;

import java.util.Collections;
import java.util.List;

public class AccountServiceImpl implements AccountService<Account> {

    @Override
    public List<Account> findAllAccounts() {
        final List<Account> accounts = AccountDaoImpl.getInstance().findAll();
        if (!accounts.isEmpty()) {
            return accounts;
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public Integer findSumOfAccount(List<Account> accounts) {
        return accounts.stream().map(Account::getAccount).reduce(Integer::sum).get();
    }
}
