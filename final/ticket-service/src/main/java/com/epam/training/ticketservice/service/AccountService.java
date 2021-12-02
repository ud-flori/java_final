package com.epam.training.ticketservice.service;

public interface AccountService {

    boolean signIn(String username, String password);

    void signOut();

    String getUsername();
}
