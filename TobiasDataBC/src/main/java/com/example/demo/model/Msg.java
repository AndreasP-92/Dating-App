package com.example.demo.model;

public class Msg {
    private int messages_id;
    private String messages_context;
    private int messages_userId;
    private String messages_date;

    public Msg(){

    }

    public Msg(String messages_context, int messages_userId, String messages_date) {
        this.messages_context = messages_context;
        this.messages_userId = messages_userId;
        this.messages_date = messages_date;
    }

    public void setMessages_id(int messages_id) {
        this.messages_id = messages_id;
    }

    public void setMessages_context(String messages_context) {
        this.messages_context = messages_context;
    }

    public void setMessages_userId(int messages_userId) {
        this.messages_userId = messages_userId;
    }

    public void setMessages_date(String messages_date) {
        this.messages_date = messages_date;
    }

    public int getMessages_id() {
        return messages_id;
    }

    public String getMessages_context() {
        return messages_context;
    }

    public int getMessages_userId() {
        return messages_userId;
    }

    public String getMessages_date() {
        return messages_date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messages_id=" + messages_id +
                ", messages_context='" + messages_context + '\'' +
                ", messages_userId=" + messages_userId +
                ", messages_date='" + messages_date + '\'' +
                '}';
    }
}
