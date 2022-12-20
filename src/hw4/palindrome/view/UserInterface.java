package hw4.palindrome.view;

import hw4.palindrome.domain.Palindrome;

public class UserInterface {

    public void startUI() {
        UserInput keyBoard = new UserInput();
        String orderNumberStr = keyBoard.readString("Введите номер заказа: ");
        Palindrome palindrome = new Palindrome(orderNumberStr);
        System.out.println("Для числа '" + palindrome.getOriginalString() + "' ближайший полиндром это '" + palindrome.getClosestPalindrome() + "'. Необходимо подождать '" + palindrome.getOrdersNumberToWait() + "' заказов.");
    }
}
