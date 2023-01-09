package com.example.budgettracker.web;

import com.example.budgettracker.model.Account;
import com.example.budgettracker.model.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.example.budgettracker.Main.USER;

public class AccountServlet extends HttpServlet {
    public static Logger log = LoggerFactory.getLogger(AccountServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user", USER);
        req.setAttribute("testing", "test attribute");
        log.debug("Hello AccountServlet");
        for (Account acc : USER.getAccounts()) {
            for (Operation op : acc.getOperations()) {
                log.debug(op.toString());
            }
        }
        log.debug("after");
        req.getRequestDispatcher("account.jsp").forward(req, resp);
    }
}
