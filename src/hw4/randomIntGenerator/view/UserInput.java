package hw4.randomIntGenerator.view;

import java.util.Scanner;

public class UserInput {
    public UserInput() {
    }

    public String readString(String title) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println(title);
        return scanner.nextLine();
    }
}
