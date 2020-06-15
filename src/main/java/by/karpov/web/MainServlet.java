package by.karpov.web;

import by.karpov.entity.Account;
import by.karpov.entity.User;
import by.karpov.service.AccountServiceImpl;
import by.karpov.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.karpov.web.util.ServletUtil.createViewPath;

@WebServlet(urlPatterns = "/main", name = "MainServlet")
public class MainServlet extends HttpServlet {

    AccountServiceImpl accountService = new AccountServiceImpl();

    UserServiceImpl userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final List<Account> accounts = accountService.findAllAccounts();
        final Integer sum = accountService.findSumOfAccount(accounts);
        final User user = userService.findRichestUser(accounts);

        request.setAttribute("sum", sum);
        request.setAttribute("user", user);

        request.getRequestDispatcher(createViewPath("main")).forward(request, response);
    }
}
