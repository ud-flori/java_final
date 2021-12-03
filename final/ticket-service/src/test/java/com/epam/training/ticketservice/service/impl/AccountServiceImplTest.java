package com.epam.training.ticketservice.service.impl;

import com.epam.training.ticketservice.service.component.AdminAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceImplTest {


    @Test
    public void testConstructor(){
        AdminAccount admin = new AdminAccount();
        AccountServiceImpl adminAccount = new AccountServiceImpl(admin);

        assertNotNull(adminAccount);
    }

    @Test
    public void testSignInFunction(){
        AdminAccount admin = new AdminAccount();
        AccountServiceImpl adminAccount = new AccountServiceImpl(admin);

        boolean response = adminAccount.signIn("admin","admin");

        assertTrue(response);
    }

    @Test
    public void testSignOutFunctionWhenSignedIn(){
        AdminAccount admin = new AdminAccount();
        AccountServiceImpl adminAccount = new AccountServiceImpl(admin);
        adminAccount.signIn("admin","admin");

        adminAccount.signOut();

        assertEquals(false, admin.isSignedIn());

    }

    @Test
    public void testGetUsernameFunctionWhenAdminLoggedIn(){
        AdminAccount admin = new AdminAccount();
        AccountServiceImpl adminAccount = new AccountServiceImpl(admin);
        adminAccount.signIn("admin","admin");

        String username = adminAccount.getUsername();

        assertEquals("admin",username);
    }

    @Test
    public void testGetUsernameFunctionWhenAdminLoggedOut(){
        AdminAccount admin = new AdminAccount();
        AccountServiceImpl adminAccount = new AccountServiceImpl(admin);
        adminAccount.signOut();

        String username = adminAccount.getUsername();

        assertEquals("",username);
    }
}