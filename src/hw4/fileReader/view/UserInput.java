package hw4.fileReader.view;

import hw4.fileReader.utils.FileParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class UserInput {
    public UserInput() {
    }

    public String readString(String title) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println(title);
        return scanner.nextLine();
    }

    public List<List<String>> readCSV(String title) throws FileNotFoundException {
        String userFilePath = readString(title);  // Read user input

        Scanner file = new Scanner(new File(userFilePath));
        FileParser fileParser = new FileParser(file);
        return fileParser.parseCSV();
    }

    public void startUI() {

    }

}
