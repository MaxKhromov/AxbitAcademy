package hw4.fileReader.view;

import hw4.fileReader.controller.FileParcer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput {
    public void UserInput() {
    }

    public String readString(String title) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println(title);
        String userString = scanner.nextLine();  // Read user input
        return userString;
    }

    public List<List<String>> readCSV() {
        Scanner file = new Scanner(new File("book.csv");
        FileParcer filePracer = new FileParcer(file);
        List<List<String>> fileAsStrings = filePracer.parceCSV();
    }

}
