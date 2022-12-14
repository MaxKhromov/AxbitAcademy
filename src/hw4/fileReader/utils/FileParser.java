package hw4.fileReader.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileParser {
    private static final String COMMA_DELIMITER = ",";
    private final Scanner fileToParse;

    public FileParser(Scanner fileToParse) {
        this.fileToParse = fileToParse;
    }

    public List<List<String>> parseCSV() {
        List<List<String>> records = new ArrayList<>();
        try (this.fileToParse) {
            while (this.fileToParse.hasNextLine()) {
                records.add(getRecordFromLine(fileToParse.nextLine()));
            }
        }
        return records;
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }
}
