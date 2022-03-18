package uz.pdp.controller;

import uz.pdp.Application;
import uz.pdp.service.GroupService;
import uz.pdp.service.UserService;
import uz.pdp.utills.Constants;

public class GroupController {

    public static void groupCRUD() {
        System.out.println("********* GROUP CRUD ***********\n");
        System.out.println("1. Create Group ");
        System.out.println("2. Show Group ");
        System.out.println("3. Update Group ");
        System.out.println("4. Delete Group ");
        System.out.println("0. Exit ");

        int operationNum;
        do {
            System.out.print("\nEnter Operation Number :  ");
            operationNum = Constants.SCANNER_NUM.nextInt();
        } while (operationNum<0 || operationNum>4);

        switch (operationNum) {
            case 1 -> GroupService.create(Application.currentUser);
            case 2 -> GroupService.shows();
            case 3 -> GroupService.update();
            case 4 -> GroupService.delete();
            case 0 -> UserService.logout();
        }
    }
}

