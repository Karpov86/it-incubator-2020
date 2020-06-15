package by.karpov.service;

import by.karpov.entity.Account;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AccountServiceTest {

    private final AccountServiceImpl accountService = new AccountServiceImpl();

    @Test
    public void findAllAccounts() {
        final List<Account> accounts = accountService.findAllAccounts();
        Assert.assertTrue(!accounts.isEmpty());
    }

    @Test
    public void findSumOfAccount() {
        final List<Account> accounts = accountService.findAllAccounts();
        final Integer expectedSum = accounts.stream().map(Account::getAccount).reduce(Integer::sum).get();
        final Integer sum = accountService.findSumOfAccount(accounts);
        Assert.assertEquals(expectedSum, sum);
    }
}
