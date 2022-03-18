package uz.pdp.database;

import uz.pdp.models.*;
import uz.pdp.utills.Constants;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class Database {

    public static final List<User> users = new LinkedList();
    public static final List<Group> groups = new LinkedList();
    public static final List<MessageGroup> messagesGroups = new LinkedList();
    public static final List<MessageUser> MESSAGES_USER = new LinkedList();
    public static final List<Request> requests = new LinkedList();

    //for roles
    public static final List<String> allRoles = new ArrayList<>();

    static  {

        allRoles.add(Constants.ROLE_USER);
        allRoles.add(Constants.ROLE_ADMIN);

        User admin = new User("admin01", "admin01", "Hasan", "Fayzullayev");
        admin.setRoles(allRoles);
        users.add(admin);

        User user01 = new User("user01", "user01", "Ruslan", "Quvvatboyev");
        users.add(user01);

        User user02 = new User("user02", "user02", "user02", "user02");
        users.add(user02);

        Group group01 = new Group("Java g4",user01);
        groups.add(group01);
        //user01.addGroup(group01);
        user02.addGroup(group01);
        group01.addMembers(user02);
        admin.addGroup(group01);
        group01.addMembers(admin);

        Group group02 = new Group("Leader Developer",user02);
        groups.add(group02);
        //user02.addGroup(group02);
        user01.addGroup(group02);
        admin.addGroup(group02);
        group02.addMembers(admin);
        group02.addMembers(user01);

        Group group03 = new Group("Java OOP",user02);
        user01.addGroup(group03);
        group03.addMembers(user01);

        MessageUser messageUser1 = new MessageUser(user01,user02,"Salom user02");
        MESSAGES_USER.add(messageUser1);


        MessageUser messageUser2 = new MessageUser(admin,user02,"Admindan Salom user02");
        MESSAGES_USER.add(messageUser2);

        MessageUser messageUser3 = new MessageUser(user01,admin,"Salom Admin");
        MESSAGES_USER.add(messageUser3);

        //MessageUser message = new MessageUser();

        MessageGroup messageGroup1 = new MessageGroup(user01,group01,"salom group01");
        messagesGroups.add(messageGroup1);


        MessageGroup messageGroup2 = new MessageGroup(user02,group01,"salom group01 (user02)");
        messagesGroups.add(messageGroup2);

        MessageGroup messageGroup3 = new MessageGroup(admin,group01,"Admindan ham salom");
        messagesGroups.add(messageGroup3);
    }
}
