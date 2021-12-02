package com.epam.training.ticketservice.service.component;


import org.springframework.stereotype.Component;

@Component
public class AdminAccount {

    private String name;
    private boolean isSignedIn;

    public AdminAccount(){
        this.name = "admin";
        this.isSignedIn = false;
    }

    public String getName() {
        return name;
    }

    public boolean isSignedIn() {
        return isSignedIn;
    }

    public boolean signIn(String username, String password){
        if("admin".equals(username) && "admin".equals(password)) {
            this.isSignedIn = true;
            return this.isSignedIn;
        }
        return false;
    }

    public void signOut(){
        this.isSignedIn = false;
    }

}
