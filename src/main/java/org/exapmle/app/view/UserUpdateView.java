package org.exapmle.app.view;

import java.util.Scanner;

public class UserUpdateView {
    public String[] getData() {

        Scanner scanner = new Scanner(System.in);

        String title = "Enter contact's ID: ";
        System.out.print(title);
        String id = scanner.nextLine().trim();

        title = "Enter email in format example@mail.com:  ";
        System.out.print(title);
        String phone = scanner.nextLine().trim();

        return new String[]{id, phone};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
