package com.epam.training.ticketservice.presentation.cli.commandhandler;



import com.epam.training.ticketservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class AccountCommandHandler {

    private AccountService loginService;

    @Autowired
    public AccountCommandHandler(AccountService loginService) {
        this.loginService = loginService;
    }

    @ShellMethod(value = "Sign in as admin user", key = "sign in privileged")
    public String signInAsPrivileged(String username, String password){
        boolean success = loginService.signIn(username,password);
        if(success){
            return "Signed in";
        }
        return "Login failed due to incorrect credentials";

    }

    @ShellMethod(value = "Sign out", key = "sign out")
    public void signOutAsPrivileged(){
        loginService.signOut();
    }

    @ShellMethod(value = "Describe account", key = "describe account")
    public String describeAccount(){
        String user = loginService.getUsername();
        if(user.isEmpty()){
            return "You are not signed in";
        }
        return String.format("Signed in with privileged account '%s'", user);
    }





}
