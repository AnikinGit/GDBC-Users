package org.exapmle.app.view;

import org.exapmle.app.utils.AppStarter;
import org.exapmle.app.utils.Constants;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppView {
    Scanner scanner;
    int option;

    public int chooseOption() {
        scanner = new Scanner(System.in);
        showMenu();
        try {
            option = scanner.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println(Constants.INCORRECT_VALUE_MSG);
            AppStarter.startApp();
        }
        return option;
    }

    private void showMenu() {
        System.out.print("""
                
                ______ MENU ___________
                1 - Create a contact.
                2 - View contacts.
                3 - Update the contact's phone number.
                4 - Delete contact.
                0 - Close the App.
                """);
    }

    public void getOutput(int choice, String output) {
        if (choice == 0) System.out.println(output);
        scanner.close();
        System.exit(0);
    }
}
