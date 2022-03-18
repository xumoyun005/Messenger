package uz.pdp.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Group {

    private final UUID id;
    private String name;
    private User owner;
    private List<User> members = new ArrayList<>();
    private boolean isDelete;

    public Group(String name, User owner) {
        this.name = name;
        this.owner = owner;
        this.id = UUID.randomUUID();
        members.add(owner);
        this.isDelete = false;
    }

    public UUID getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public void addMembers(User user) {
        members.add(user);
    }

    public String members() {
        String membersToString = "";
        for (User member : members) {
            membersToString +=member +"\n";
        }
        return membersToString;
    }

    @Override
    public String toString() {
        return "Group: " + "     id: " + id + "     name: " + name + "     owner:  " + owner.getUsername() + "\n" +
             "  MEMBERS   \n"+   members();
    }
}
