package hw4.fileReader.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileParcer {
    private static final String COMMA_DELIMITER = ",";
    public final Scanner fileToParce;

    public FileParcer(Scanner fileToParce) {
        this.fileToParce = fileToParce;
    }

    public List<List<String>> parceCSV(){
        List<List<String>> records = new ArrayList<>();
        try (this.fileToParce) {
            while (this.fileToParce.hasNextLine()) {
                records.add(getRecordFromLine(fileToParce.nextLine()));
            }
        }
        return records;
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }
}
