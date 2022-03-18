package uz.pdp.service;

import uz.pdp.Application;
import uz.pdp.database.Database;
import uz.pdp.models.Group;
import uz.pdp.models.MessageUser;
import uz.pdp.models.MessageGroup;
import uz.pdp.models.User;
import uz.pdp.utills.Constants;

import java.util.UUID;

public class MessageService {


    public static void sendMassageToGroup() {
        GroupService.read();
        if (Application.currentUser.getGroups().isEmpty()){
            return;
        }
        String groupId;
        Group group = null;
        do {
            System.out.print("Enter group id :  ");
            groupId = Constants.SCANNER_STR.nextLine().trim();

            for (Group group1 : Application.currentUser.getGroups()) {
                if (group1.getId().equals(UUID.fromString(groupId))) {
                    group = group1;
                    break;
                }
            }

        } while (group == null);

        System.out.print("Enter message :  ");
        String massage = Constants.SCANNER_STR.nextLine();

        MessageGroup messageGroup = new MessageGroup(Application.currentUser, group, massage);
        Database.messagesGroups.add(messageGroup);


    }

    public static void sendMassageToUser() {
        for (User user : Database.users) {
            System.out.println(user);
        }
        String userId;
        User user = null;
        do {
            System.out.print("Enter group id :  ");
            userId = Constants.SCANNER_STR.nextLine().trim();

            for (User user1 : Database.users) {
                if (user1.getId().equals(UUID.fromString(userId))) {
                    user = user1;
                    break;
                }
            }

        } while (user == null);

        System.out.print("Enter messageUser :  ");
        String massage = Constants.SCANNER_STR.nextLine();

        MessageUser messageUser = new MessageUser(Application.currentUser, user, massage);
        Database.MESSAGES_USER.add(messageUser);

    }

    public static void showMassGroup() {
        for (int i = 0; i < Application.currentUser.getGroups().size(); i++) {
            System.out.print("********* " + Application.currentUser.getGroups().get(i).getName() + " *********\n\n");
            for (MessageGroup messagesGroup : Database.messagesGroups) {

                if(!messagesGroup.isRead() &&
                        messagesGroup.getToGroup().equals(Application.currentUser.getGroups().get(i))){
                    System.out.print("new message: ");
                }
                if ( messagesGroup.getToGroup().equals(Application.currentUser.getGroups().get(i))) {
                    System.out.println(messagesGroup);
                    messagesGroup.setRead(true);
                }
                System.out.println();
            }
        }
    }

    public static void showMassUser() {
        for (MessageUser messageUser : Database.MESSAGES_USER) {

            if (!messageUser.isRead() && messageUser.getToWhom().equals(Application.currentUser)) {
                System.out.print("new messageUser :   ");
                messageUser.setRead(true);
            }
            if (messageUser.getToWhom().equals(Application.currentUser)) {
                System.out.println(messageUser);
            }
        }
    }
}



