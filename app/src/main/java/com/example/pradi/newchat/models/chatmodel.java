package com.example.pradi.newchat.models;

/**
 * Created by pradi on 28/7/18.
 */

public class chatmodel {

    public String message;
    public boolean isSend;

    public chatmodel(String message, boolean isSend) {
        this.message = message;
        this.isSend = isSend;
    }

    public chatmodel() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSend() {
        return isSend;
    }

    public void setSend(boolean send) {
        isSend = send;
    }
}
