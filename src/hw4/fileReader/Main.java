package hw4.fileReader;

import hw4.fileReader.view.UserInput;

public class Main {
    public static void main(String[] args) {
        UserInput keyBoard = new UserInput();
        String value = keyBoard.readString("Введи значение:");
        System.out.println(value);
    }
}
