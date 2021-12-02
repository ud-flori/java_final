package com.epam.training.ticketservice.service.impl;

import com.epam.training.ticketservice.service.component.AdminAccount;
import com.epam.training.ticketservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AdminAccount admin;

    @Autowired
    public AccountServiceImpl(AdminAccount admin) {
        this.admin = admin;
    }

    @Override
    public boolean signIn(String username, String password) {
        return admin.signIn(username,password);
    }

    @Override
    public void signOut() {
        admin.signOut();
    }

    @Override
    public String getUsername() {
        return admin.isSignedIn() ? admin.getName() : "";
    }

}