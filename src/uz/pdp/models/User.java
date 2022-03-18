package uz.pdp.models;

import uz.pdp.utills.Constants;

import java.util.*;

public class User {

    private UUID id;
    private String username;
    private String password;
    private List<String> roles;

    private List<Group> groups = new ArrayList<>();
    private String firstName;
    private String lastName;
    private boolean isBlocked;

    public User(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = UUID.randomUUID();
        this.isBlocked = false;
        roles = new ArrayList<>();
        this.roles.add(Constants.ROLE_USER);
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public void addGroup(Group group){
        this.groups.add(group);
    }


    @Override
    public String toString() {
        return  " username: " + username + " id: " + id + "  " + firstName+" roles: " + roles;
    }
}
