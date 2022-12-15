package hw4.fileReader;

import hw4.fileReader.domain.Address;
import hw4.fileReader.domain.Addresses;
import hw4.fileReader.view.UserInput;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserInput keyBoard = new UserInput();

        //C:\Users\sloop\IdeaProjects\AxbitAcademy\src\hw4\fileReader\addresses.csv
        //C:\repos\AxbitAcademy\src\hw4\fileReader\addresses.csv
        List<List<String>> dataFromFile = null;

        boolean continueReadFileProcess = true;
        while (continueReadFileProcess) {
            try {
                dataFromFile = keyBoard.readCSV("Enter system path to CSV file: ");
                continueReadFileProcess = false;
            } catch (Exception ex) {
                ex.printStackTrace();
                String userWantsToContinue = keyBoard.readString("Хотите повторить ввод файла? (да/нет): ");
                continueReadFileProcess = !userWantsToContinue.equals("нет");
                if(!continueReadFileProcess){
                    return;
                }
            }
        }


        Addresses addresses = new Addresses();
        for (List<String> addressRawLine : dataFromFile) {
            if (!addressRawLine.isEmpty()) {
                addresses.addAddress(new Address(addressRawLine));
            }
        }

        addresses.printAddresses();

        boolean continueSortProcess = true;
        while (continueSortProcess) {
            String sortParameter = keyBoard.readString("Введите название параметра для сортировки: ");
            String sortDirection = keyBoard.readString("Введите направление сортировки (asc, desc): ");
            try {
                addresses.sortBy(sortParameter, sortDirection);
            } catch (Exception ex) {
                ex.printStackTrace();
                String userWantsToContinue = keyBoard.readString("Хотите повторить сортировку? (да/нет): ");
                continueSortProcess = !userWantsToContinue.equals("нет");
                continue;
            }
            addresses.printAddresses();
            String userWantsToContinue = keyBoard.readString("Хотите повторить сортировку? (да/нет): ");
            continueSortProcess = !userWantsToContinue.equals("нет");
        }


    }
}
