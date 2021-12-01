package com.epam.training.ticketservice.service.impl;

public final class Flag  {

    private boolean isSuccesful;

    Flag(){
        this.isSuccesful = true;
    }

    public void setFlag(boolean flag){
        this.isSuccesful = flag;
    }

    public boolean getFlag(){
        return isSuccesful;
    }


}
