package edu.udacity.java.nano.chat;

public class SimpleMessage {

    public SimpleMessage() {

    }

    public SimpleMessage(String username, String msg) {
        this.username = username;
        this.msg = msg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String username;
    private String msg;
}
