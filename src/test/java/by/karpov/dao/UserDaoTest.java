package by.karpov.dao;

import by.karpov.entity.User;
import org.junit.Assert;
import org.junit.Test;

public class UserDaoTest {

    private final UserDaoImpl userDao = UserDaoImpl.getInstance();

    @Test
    public void findByIdTest() {
        final int id = 1;
        final User user = userDao.findById(id);
        final String fullName = user.getName() + " " + user.getSurname();
        Assert.assertNotNull(user);
        Assert.assertEquals("Josephine Huffman", fullName);
    }
}
