package by.karpov.dao;

import by.karpov.entity.Account;
import by.karpov.entity.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.contains;

public class AccountDaoTest {

    private final AccountDaoImpl accountDao = AccountDaoImpl.getInstance();

    @Test
    public void findAllTest() {
        final List<Account> all = accountDao.findAll();
        final List<String> names = all.stream().map(Account::getUser).map(User::getName).limit(3).collect(toList());
        Assert.assertEquals(10, all.size());
        Assert.assertThat(names, contains("Josephine", "Maurice", "Royal"));
    }
}
