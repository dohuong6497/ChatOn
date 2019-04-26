package rmiinterface;

import java.io.Serializable;
import java.sql.Timestamp;

public class Message implements Serializable{
    private int id;
    private User user;
    private Group group;
    private String message;

    public Message() {
    }

    public Message(int id, User user, Group group, String message) {
        this.id = id;
        this.user = user;
        this.group = group;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
