package com.application.mentalhealth.botchat;

public class ChatsModel {

    private String Message;
    private String Sender;

    public ChatsModel(String message, String sender) {
        Message = message;
        Sender = sender;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getSender() {
        return Sender;
    }

    public void setSender(String sender) {
        Sender = sender;
    }
}
