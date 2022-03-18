package uz.pdp.service;

import uz.pdp.Application;
import uz.pdp.database.Database;
import uz.pdp.models.Request;
import uz.pdp.utills.Constants;

public class RequestService {
    public static void main() {
        int result = 0;
        for (Request request : Database.requests) {
            if(Application.currentUser.equals(request.getToUser()) && !request.isResult()){
                result++;
            }
        }
        if (result == 0){
            System.out.println("To You have not request!");
            return;
        }

        for (Request request : Database.requests) {
            if (!request.isResult() && request.getToUser().equals(Application.currentUser)) {
                System.out.println("You have request!");
                System.out.println("submitted a request for you to join " + request.getWhichGroup().getName()
                        + " group" + " this " + request.getFromUser());
                System.out.print("Join this user.\n1.YES\t\t2.NO ");
                if (Constants.SCANNER_NUM.nextInt() == 1) {
                    request.getWhichGroup().addMembers(request.getFromUser());
                    request.getToUser().addGroup(request.getWhichGroup());
                    System.out.println("This user add to your group succsessfully.");
                    request.setResult(true);
                } else {
                    System.out.println("This user didn't add to your group");
                    request.setResult(true);
                }

            }
        }
    }
}
