package com.example.budgettracker.web;

import com.example.budgettracker.model.dto.AccountDTO;
import com.example.budgettracker.model.dto.OperationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.example.budgettracker.Main.*;

public class OperationServlet extends HttpServlet {
    public static Logger log = LoggerFactory.getLogger(OperationServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user", USERDTO);
        req.setAttribute("testing", "test attribute");
        log.debug("Hello OperationServlet");
        for (AccountDTO acc : USERDTO.getAccounts()) {
            for (OperationDTO op : acc.getOperations()) {
                log.debug(op.toString());
            }
        }
        log.debug("after");
        req.getRequestDispatcher("operations.jsp").forward(req, resp);
    }
}
