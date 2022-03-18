package uz.pdp;

import uz.pdp.controller.UserController;
import uz.pdp.models.User;
import uz.pdp.utills.Constants;
import java.util.Objects;

public class Application {

    public static User currentUser = null;

    public static void main(String[] args) {

        while (true) {
            if (Application.currentUser == null) {

                System.out.println("\n ********** PLUS.UZ MASSAGER  **********  \n");
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("0. Exit");

                System.out.print("Enter operation number: ");
                int operation = Constants.SCANNER_NUM.nextInt();

                String result = null;

                switch (operation) {
                    case 1 -> result = UserController.login();
                    case 2 -> result = UserController.register();
                    case 0 -> Application.currentUser = null;

                }

                System.out.println("\n ************************************** \n");
                if (Objects.nonNull(result)) {
                    System.out.println(result);
                }

                if (operation == 0) break;

            } else {
                UserController.personalCabinet();
            }
        }
    }
}
