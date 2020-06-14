package by.karpov.service;

import by.karpov.entity.Account;
import by.karpov.entity.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UserServiceTest {

    private final UserServiceImpl userService = new UserServiceImpl();

    private final AccountServiceImpl accountService = new AccountServiceImpl();

    @Test
    public void findUserByIdTest(){
        final int userId = 1;
        final User user = userService.findUserById(userId);
        Assert.assertNotNull(user);
    }

    @Test
    public void findRichestUserTest(){
        final List<Account> accounts = accountService.findAllAccounts();
        final User richestUser = userService.findRichestUser(accounts);
        final String fullName = richestUser.getName() + " " + richestUser.getSurname();
        Assert.assertEquals("Alena Klar", fullName);
    }
}
