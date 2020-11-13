package com.example.demo.model;

public class Message {
    private int messages_id;
    private String messages_context;
    private int messages_userId;
    private int messages_date;

    public Message(){

    }

    public Message(String messages_context, int messages_userId, int messages_date) {
        this.messages_context = messages_context;
        this.messages_userId = messages_userId;
        this.messages_date = messages_date;
    }

    public int getMessages_id() {
        return messages_id;
    }

    public void setMessages_id(int messages_id) {
        this.messages_id = messages_id;
    }

    public String getMessages_context() {
        return messages_context;
    }

    public void setMessages_context(String messages_context) {
        this.messages_context = messages_context;
    }

    public int getMessages_userId() {
        return messages_userId;
    }

    public void setMessages_userId(int messages_userId) {
        this.messages_userId = messages_userId;
    }

    public int getMessages_date() {
        return messages_date;
    }

    public void setMessages_date(int messages_date) {
        this.messages_date = messages_date;
    }
}
