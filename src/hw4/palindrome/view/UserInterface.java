package hw4.palindrome.view;

public class UserInterface {

    public void startUI() {
        UserInput keyBoard = new UserInput();
        String orderNumberStr = keyBoard.readString("Введите номер заказа: ");
        System.out.println("Необходимо подождать " + calculateNumberOfOrdersToWait(orderNumberStr) + " заказов");
    }

    private static Integer calculateNumberOfOrdersToWait(String orderNumberStr) {
        Integer orderNumbersToWait = 0;

        if (checkFormat(orderNumberStr)) {
            String orderNumberStrPart1 = orderNumberStr.substring(0, orderNumberStr.length() / 2);
            String orderNumberStrPart2 = orderNumberStr.substring(orderNumberStr.length() - orderNumberStrPart1.length());

            String expectedStrPart2 = reverseString(orderNumberStrPart1);

            System.out.println(orderNumberStrPart1 + " - " + orderNumberStrPart2 + " - " + expectedStrPart2);

            Integer orderNumberIntPart1 = Integer.parseInt(orderNumberStrPart1);
            Integer orderNumberIntPart2 = Integer.parseInt(orderNumberStrPart2);
            Integer expectedIntPart2 = Integer.parseInt(expectedStrPart2);

            if (expectedIntPart2 > orderNumberIntPart2) {
                orderNumbersToWait = expectedIntPart2 - orderNumberIntPart2;
                return orderNumbersToWait;
            } else {
                String newOrderNumberStr = Integer.toString(Integer.parseInt(orderNumberStr) + (int) Math.pow(10, orderNumberStrPart2.length()));
                calculateNumberOfOrdersToWait(newOrderNumberStr);
            }
        }

        return orderNumbersToWait;

    }

    private static boolean checkFormat(String orderNumberStr) {
        if (checkPalindrome(orderNumberStr)) {
            System.out.println("Input value already a palindrome!");
        } else {
            try {
                Integer.parseInt(orderNumberStr);
                return true;
            } catch (Exception e) {
                throw new RuntimeException("Input value must be integer! Your input: " + orderNumberStr);
            }
        }
        return false;
    }

    private static boolean checkPalindrome(String str) {
        if (str == null)
            return false;
        if (str.length() <= 1) {
            return true;
        }
        String first = str.substring(0, 1);
        String last = str.substring(str.length() - 1);
        if (!first.equals(last))
            return false;
        else
            return checkPalindrome(str.substring(1, str.length() - 1));
    }

    private static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }
}
