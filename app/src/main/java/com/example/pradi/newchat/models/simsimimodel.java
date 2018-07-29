package com.example.pradi.newchat.models;

/**
 * Created by pradi on 28/7/18.
 */

public class simsimimodel {

    public String response;
    public String id;
    public int result;
    public String message;

    public simsimimodel(String response, String id, int result, String message) {
        this.response = response;
        this.id = id;
        this.result = result;
        this.message = message;
    }

    public simsimimodel() {
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
