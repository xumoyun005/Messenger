package uz.pdp.service;

import uz.pdp.Application;
import uz.pdp.database.Database;
import uz.pdp.models.Group;
import uz.pdp.models.Request;
import uz.pdp.models.User;
import uz.pdp.utills.Constants;

import java.util.UUID;

public class GroupService {

    public static void read() {
        if (Application.currentUser.getGroups().isEmpty()) {
            System.out.println("Your group list is empty.");
            return;
        }

        for (int i = 0; i < Application.currentUser.getGroups().size() &&
                !Application.currentUser.getGroups().get(i).isDelete(); i++) {
            System.out.println(Application.currentUser.getGroups().get(i));
        }

    }

    public static void create(User user) {

        System.out.print(" Enter Group name : ");
        String groupName = Constants.SCANNER_STR.nextLine();
        for (int i = 0; i < Database.groups.size(); i++) {
            if (Database.groups.get(i).getName().equalsIgnoreCase(groupName)) {
                System.out.println(" This Group name already taken ..");
                return;
            }
        }
        Group group = new Group(groupName, user);

        if(Application.currentUser.getRoles().equals(Database.allRoles)){
            Database.groups.add(group);
            System.out.println("Created group successfully. ");
            return;
        }

        for (User user1 : Database.users) {
            if (user1.getRoles().equals(Database.allRoles)) {
                Request request1 = new Request(Application.currentUser, user1, group);
                Database.requests.add(request1);
                return;
            }
        }
    }

    public static void shows() {
        if (Database.groups.isEmpty()) {
            System.out.println("No groups");
        } else {
            for (Group group : Database.groups) {
                System.out.println(group);
            }
        }

    }

    public static void update() {
        if (Application.currentUser.getGroups().isEmpty()) {
            System.out.println("Your group list is empty.");
            return;
        }
        read();
        Group group = null;
        String newName;
        String idGroup;
        do {
            System.out.print("Enter ID the Group need to be update : ");
            idGroup = Constants.SCANNER_STR.nextLine().trim();
            for (int i = 0; i < Application.currentUser.getGroups().size(); i++) {
                if (!Application.currentUser.getGroups().get(i).isDelete() &&
                        UUID.fromString(idGroup).equals(Application.currentUser.getGroups().get(i).getId())) {
                    group = Application.currentUser.getGroups().get(i);
                }
            }
        } while (group == null);

        System.out.print("Enter new name :  ");
        newName = Constants.SCANNER_STR.nextLine();

        for (int i = 0; i < Database.groups.size(); i++) {
            if (newName.equals(Database.groups.get(i).getName())) {
                System.out.println("The group with this name has already been created");
                return;
            }
        }

        for (int i = 0; i < Application.currentUser.getGroups().size(); i++) {
            if (Application.currentUser.getGroups().get(i).getId().equals(UUID.fromString(idGroup))) {
                Application.currentUser.getGroups().get(i).setName(newName);
                System.out.println("New name was set successfully.");
                return;
            }
        }
    }

    public static void delete() {
    }

    public static void addGroup() {

        for (Group group : Database.groups) {
            if(!group.getMembers().contains(Application.currentUser)){
                System.out.println(group);
            }
        }

        Group group = null;
        do {
            System.out.print("Enter group id:  ");
            String groupId = Constants.SCANNER_STR.nextLine().trim();

            for (Group group1 : Database.groups) {
                if (group1.getId().equals(UUID.fromString(groupId))) {
                    group = group1;
                    break;
                }
            }

        } while (group == null);

        Request request = new Request(Application.currentUser, group.getOwner(), group);
        Database.requests.add(request);
    }
}
