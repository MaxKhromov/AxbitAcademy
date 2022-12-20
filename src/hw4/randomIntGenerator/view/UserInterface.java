package hw4.randomIntGenerator.view;


import hw4.randomIntGenerator.utils.RandomIntGenerator;

public class UserInterface {

    public void startUI() {
        UserInput keyBoard = new UserInput();
        String startRangeStr = keyBoard.readString("Введите начальное значение диапазона: ");
        String endRangeStr = keyBoard.readString("Введите конечное значение диапазона: ");
        String sizeStr = keyBoard.readString("Введите количество чисел: ");
        String pointSizeStr = keyBoard.readString("Введите количество чисел после запятой: ");

        try {
            Long size = Long.valueOf(sizeStr);
            Double startRange = Double.valueOf(startRangeStr);
            Double endRange = Double.valueOf(endRangeStr);
            int pointSize = Integer.parseInt(pointSizeStr);
            RandomIntGenerator.randomInt(startRange, endRange, size, pointSize).forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Что-то с вашими цифрами не так");
        }


    }
}
