package com.epam.training.ticketservice.presentation.cli.commandhandler;


import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class AccountCommandHandler {


    @ShellMethod(value = "Sign in as admin user", key = "sign in privileged")
    public String signInAsPrivileged(String username, String password){
        return "Alright";
    }

    @ShellMethod(value = "Sign out", key = "sign out")
    public String signOutAsPrivileged(){
        return "Alright";
    }

    @ShellMethod(value = "Describe account", key = "describe account")
    public String describeAccount(){
        return "Alright";
    }





}
