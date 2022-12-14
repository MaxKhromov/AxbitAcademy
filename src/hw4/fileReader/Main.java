package hw4.fileReader;

import hw4.fileReader.domain.Address;
import hw4.fileReader.domain.Addresses;
import hw4.fileReader.view.UserInput;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        UserInput keyBoard = new UserInput();

        //C:\Users\sloop\IdeaProjects\AxbitAcademy\src\hw4\fileReader\addresses.csv
        List<List<String>> dataFromFile = keyBoard.readCSV("Enter system path to CSV file: ");

        Addresses addresses = new Addresses();
        for (List<String> addressRawLine : dataFromFile) {
            if (!addressRawLine.isEmpty()) {
                addresses.addAddress(new Address(addressRawLine));
            }
        }

        System.out.println(addresses);
    }
}
