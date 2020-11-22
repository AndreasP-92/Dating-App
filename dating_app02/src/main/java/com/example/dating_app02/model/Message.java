package com.example.dating_app02.model;

public class Message {
    private int messages_id;
    private String messages_context;
    private String messages_usermail;
    private String messages_date;
    private String messages_title;

    public Message() {
    }

    public Message(String messages_context, String messages_usermail, String messages_date, String messages_title) {
        this.messages_context = messages_context;
        this.messages_usermail = messages_usermail;
        this.messages_date = messages_date;
        this.messages_title = messages_title;
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

    public String getMessages_usermail() {
        return messages_usermail;
    }

    public void setMessages_userMail(String messages_userMail) {
        this.messages_usermail = messages_userMail;
    }

    public String getMessages_date() {
        return messages_date;
    }

    public void setMessages_date(String messages_date) {
        this.messages_date = messages_date;
    }

    public String getMessages_title() {
        return messages_title;
    }

    public void setMessages_title(String messages_title) {
        this.messages_title = messages_title;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messages_id=" + messages_id +
                ", messages_context='" + messages_context + '\'' +
                ", messages_userMail='" + messages_usermail + '\'' +
                ", messages_date='" + messages_date + '\'' +
                ", messages_title='" + messages_title + '\'' +
                '}';
    }
}
