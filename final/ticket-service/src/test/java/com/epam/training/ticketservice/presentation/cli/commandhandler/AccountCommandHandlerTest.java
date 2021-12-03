package com.epam.training.ticketservice.presentation.cli.commandhandler;

import com.epam.training.ticketservice.service.AccountService;
import com.epam.training.ticketservice.service.component.AdminAccount;
import com.epam.training.ticketservice.service.impl.AccountServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountCommandHandlerTest {

    @Test
    void testSignInAsPrivilegedMethodUsingValidCredentials(){
        AccountService loginService = new AccountServiceImpl(new AdminAccount());
        AccountCommandHandler accountCommandHandler = new AccountCommandHandler(loginService);

        String response = accountCommandHandler.signInAsPrivileged("admin","admin");

        assertEquals("Signed in",response);
    }

    @Test
    void testSignInAsPrivilegedMethodUsingInvalidCredentials(){
        AccountService loginService = new AccountServiceImpl(new AdminAccount());
        AccountCommandHandler accountCommandHandler = new AccountCommandHandler(loginService);

        String response = accountCommandHandler.signInAsPrivileged("admin","nimda");

        assertEquals("Login failed due to incorrect credentials",response);
    }

    @Test
    void testDescribeAccountFunctionAsPrivileged(){
        AccountService loginService = new AccountServiceImpl(new AdminAccount());
        AccountCommandHandler accountCommandHandler = new AccountCommandHandler(loginService);
        loginService.signIn("admin","admin");

        String response = accountCommandHandler.describeAccount();

        assertEquals("Signed in with privileged account 'admin'",response);
    }

    @Test
    void testDescribeAccountFunctionAsNonPrivileged(){
        AccountService loginService = new AccountServiceImpl(new AdminAccount());
        AccountCommandHandler accountCommandHandler = new AccountCommandHandler(loginService);
        loginService.signIn("admin","nimda");

        String response = accountCommandHandler.describeAccount();

        assertEquals("You are not signed in",response);
    }



}