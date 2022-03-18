package uz.pdp.models;

import java.util.UUID;

public class Request {

    private UUID id;
    private User fromUser;
    private User toUser;
    private boolean result;
    private Group whichGroup;

    public Request(User fromUser, User toUser, Group whichGroup) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.whichGroup = whichGroup;
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Group getWhichGroup() {
        return whichGroup;
    }

    public void setWhichGroup(Group whichGroup) {
        this.whichGroup = whichGroup;
    }
}
