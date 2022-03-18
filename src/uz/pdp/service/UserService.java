package uz.pdp.service;

import uz.pdp.Application;
import uz.pdp.database.Database;
import uz.pdp.models.User;
import uz.pdp.utills.Constants;

import java.util.Objects;
public class UserService {

    public static String login() {


        if (Database.users.isEmpty()) {
            return "No users";
        }

        System.out.print("Enter username: ");
        String username = Constants.SCANNER_STR.nextLine().trim();

        System.out.print("Enter password: ");
        String password = Constants.SCANNER_STR.nextLine().trim();

        if (username.isEmpty()) {
            return "Username is required";
        }

        if (password.isEmpty()) {
            return "Password is required";
        }

        for (User user : Database.users) {
            if (!user.isBlocked() && user.getUsername().equals(username) && user.getPassword().equals(password)) {
                Application.currentUser = user;
                break;
            }
        }

        if (Objects.nonNull(Application.currentUser)) {
            return String.format("Welcome, %s %s!", Application.currentUser.getFirstName(),
                    Application.currentUser.getLastName());
        }

        return "Wrong username or password";
    }

    public static String register() {

        System.out.print("Enter first name: ");
        String firstName = Constants.SCANNER_STR.nextLine().trim();

        System.out.print("Enter last name: ");
        String lastName = Constants.SCANNER_STR.nextLine().trim();

        System.out.print("Enter username: ");
        String username = Constants.SCANNER_STR.nextLine().trim();

        System.out.print("Enter password: ");
        String password = Constants.SCANNER_STR.nextLine().trim();

        System.out.print("Enter confirm password: ");
        String confirmPassword = Constants.SCANNER_STR.nextLine().trim();

        if (firstName.isEmpty()) {
            return "First name is required";
        }

        if (lastName.isEmpty()) {
            return "Last name is required";
        }

        if (username.isEmpty()) {
            return "Username is required";
        }

        if (password.isEmpty()) {
            return "Password is required";
        }
        if (confirmPassword.isEmpty()) {
            return "Confirm password is required";
        }

        if (!password.equals(confirmPassword)) {
            return "No matches passwords";
        }

        for (User user : Database.users) {
            if (user.getUsername().equals(username)) {
                return "This username already taken";
            }
        }

        User user = new User(username, password, firstName, lastName);
        Database.users.add(user);
        Application.currentUser = user;

        return "New user registered";
    }

    public static void logout() {
        Application.currentUser = null;
        System.out.println("Successfully logout");
    }

    public static void changePassword() {
        System.out.print("Enter new password : ");
        String repassword = Constants.SCANNER_STR.nextLine().trim();

        System.out.print("Enter new password again : ");
        String repassword1 = Constants.SCANNER_STR.nextLine().trim();


        if (repassword.isEmpty()) {
            System.err.println("This password empty!");
            return;
        }
        if (!repassword.equals(repassword1)) {
            System.err.println("The passwords you entered are not compatible!");
            return;
        }
        for (int i = 0; i < Database.users.size(); i++) {
            if (Database.users.get(i).getPassword().equals(repassword)) {
                System.out.println("This password already taken");
                return;
            }
        }
        Application.currentUser.setPassword(repassword);
        System.out.println("Your passwor has been successfully changed ");
    }

}