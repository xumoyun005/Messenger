package uz.pdp.service;

import uz.pdp.Application;
import uz.pdp.database.Database;
import uz.pdp.models.Request;
import uz.pdp.models.User;
import uz.pdp.utills.Constants;

import java.util.UUID;

public class AdminService {

    public static void showUsers() {
        for (User user : Database.users) {
            System.out.println(user);
        }

    }

    public static void blockUser() {
        showUsers();
        User user = null;
        do {
            System.out.print("Enter user's id :  ");
            String userIdStr = Constants.SCANNER_STR.nextLine();

            for (User user1 : Database.users) {
                if (user1.getId().equals(UUID.fromString(userIdStr))){
                    user = user1;
                    break;
                }
            }
        } while (user == null);

        System.out.printf("This user %sblocked.",(user.isBlocked() ? "un" : ""));
        System.out.println("1.YES\t\t2.NO");
        if(Constants.SCANNER_NUM.nextInt() == 1){
            user.setBlocked(!user.isBlocked());
            System.out.println("The order was executed successfully");
            return;
        }
        System.out.println("The user's data not changed ");

    }

    public static void request() {
        int result = 0;
        for (Request request : Database.requests) {
            if(!request.isResult() && request.getToUser().equals(Application.currentUser)){
             result++;
             request.setResult(true);
                System.out.println(request.getFromUser()+" this user is going to create group. ");
                System.out.println("Group name:  "+request.getWhichGroup().getName());
                System.out.println("Do you allow group opening?");
                System.out.println("1.YES\t\t2.NO");
                if(Constants.SCANNER_NUM.nextInt() == 1){
                    request.getWhichGroup().setOwner(request.getToUser());
                    Database.groups.add(request.getWhichGroup());
                    System.out.println("The order was executed successfully");
                }
            }
        }
        if(result == 0){
            System.out.println("Request list is empty.");
        }

    }
}
