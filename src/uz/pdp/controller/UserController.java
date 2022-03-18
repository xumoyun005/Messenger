package uz.pdp.controller;

import uz.pdp.Application;
import uz.pdp.service.*;
import uz.pdp.utills.Constants;

import java.util.List;


public class UserController {

    public static String login() {
        return UserService.login();
    }

    public static String register() {
        return UserService.register();
    }

    public static void personalCabinet() {
        List<String> roles = Application.currentUser.getRoles();

        if (roles.contains(Constants.ROLE_ADMIN)) {
            System.out.println();

            for (int i = 0; i < roles.size(); i++) {
                System.out.println((i + 1) + ". " + roles.get(i));
            }

            int roleIndex;
            do {
                System.out.print("Enter role number: ");
                roleIndex = Constants.SCANNER_NUM.nextInt();
            } while (roleIndex < 1 || roleIndex > roles.size());

            if (roles.get(roleIndex - 1).equals(Constants.ROLE_ADMIN)) {
                UserController.adminPage();
            } else {
                UserController.userPage();
            }

        } else {
            UserController.userPage();
        }
    }

    public static void userPage() {
        System.out.println("*********** USER PAGE **************\n");
        System.out.println("1.  Show groups ");
        System.out.println("2.  Sent massage to group ");
        System.out.println("3.  Sent massage to user ");
        System.out.println("4.  Requests  ");
        System.out.println("5.  Create group ");
        System.out.println("6.  Change password ");
        System.out.println("7.  Show massage in group ");
        System.out.println("8.  Show massage in user ");
        System.out.println("9.  Update group ");
        System.out.println("10. Add group ");
        System.out.println("0. Exit ");

        int operation;
        do {
            System.out.println("\nEnter operation number :   ");
            operation = Constants.SCANNER_NUM.nextInt();

        } while (operation < 0 || operation > 10);

        switch (operation) {
            case 0 -> UserService.logout();
            case 1 -> GroupService.read();
            case 2 -> MessageService.sendMassageToGroup();
            case 3 -> MessageService.sendMassageToUser();
            case 4 -> RequestService.main();
            case 5 -> GroupService.create(Application.currentUser);
            case 6 -> UserService.changePassword();
            case 7 -> MessageService.showMassGroup();
            case 8 -> MessageService.showMassUser();
            case 9 -> GroupService.update();
            case 10 -> GroupService.addGroup();
        }
    }
        public static void adminPage () {
            System.out.println("*********** ADMIN PAGE **************\n");
            System.out.println("1. Show Users");
            System.out.println("2. Block (un)User ");
            System.out.println("3. Request from Users");
            System.out.println("4. Change password");
            System.out.println("5. Group CRUD");
            System.out.println("0. Logout");

            int operation;
            do{
                System.out.print("Enter operation: ");
                operation = Constants.SCANNER_NUM.nextInt();
            }while (operation < 0 || operation > 5);

            switch (operation) {
                case 1 -> AdminService.showUsers();
                case 2 -> AdminService.blockUser();
                case 3 -> AdminService.request();
                case 4 -> UserService.changePassword();
                case 5 -> GroupController.groupCRUD();
                case 0 -> UserService.logout();
            }
        }
    }
