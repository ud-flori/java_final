package com.epam.training.ticketservice.service.impl;

import com.epam.training.ticketservice.service.component.AdminAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminAccountTest {


    @Test
    void testSignInWithCorrectCredentials() {
        AdminAccount underTest = new AdminAccount();

        underTest.signIn("admin","admin");

        assertTrue(underTest.isSignedIn());
    }

    @Test
    void testSignInWithInCorrectCredentials() {
        AdminAccount underTest = new AdminAccount();

        underTest.signIn("admin","nimda");

        assertFalse(underTest.isSignedIn());
    }

    @Test
    void testSignOutWhenAdminLoggedIn(){
        AdminAccount underTest = new AdminAccount();
        underTest.signIn("admin","admin");

        underTest.signOut();

        assertFalse(underTest.isSignedIn());
    }


    @Test
    void getUsernameIfAdminIsSignedIn() {
        AdminAccount underTest = new AdminAccount();
        underTest.signIn("admin","admin");

        String username = underTest.getName();

        assertEquals(username, "admin");
    }

}