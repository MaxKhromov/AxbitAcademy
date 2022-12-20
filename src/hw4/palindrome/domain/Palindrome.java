package hw4.palindrome.domain;

import java.util.Arrays;
import java.util.List;


public class Palindrome {
    private final String originalString;
    private String closestPalindrome;
    private Integer ordersNumberToWait;
    private Boolean palindromeIsFound;

    public Palindrome(String originalString) {
        this.originalString = originalString;
        this.closestPalindrome = originalString;
        this.ordersNumberToWait = 0;
        this.palindromeIsFound = false;
        calculateNumberOfOrdersToWait();
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

    public void calculateNumberOfOrdersToWait() {

        if (checkFormat(this.closestPalindrome)) {
            findPalindrome();
            this.ordersNumberToWait = Integer.parseInt(this.closestPalindrome) - Integer.parseInt(this.originalString);
        } else {
            this.palindromeIsFound = true;
        }
    }

    private void findPalindrome() {
        int originalNumber = Integer.parseInt(this.closestPalindrome);
        if (!this.palindromeIsFound) {
            List<String> listOfDigits = Arrays.asList(this.closestPalindrome.split(""));
            for (int i = 0; i < listOfDigits.size(); i++) {
                if (this.palindromeIsFound) return;
                int firstDigit = Integer.parseInt(listOfDigits.get(i));
                int secondDigit = Integer.parseInt(listOfDigits.get(listOfDigits.size() - i - 1));
                int difference;
                if (firstDigit != secondDigit && (listOfDigits.size() - i - 1) > i) {
                    if (firstDigit > secondDigit) {
                        difference = firstDigit - secondDigit;
                    } else {
                        difference = firstDigit + 10 - secondDigit;
                    }
                    this.closestPalindrome = String.valueOf(originalNumber + difference * (int) Math.pow(10, i));
                    findPalindrome();
                }
            }
            this.palindromeIsFound = true;
        }
    }

    public String getOriginalString() {
        return originalString;
    }

    public String getClosestPalindrome() {
        return closestPalindrome;
    }

    public Integer getOrdersNumberToWait() {
        return ordersNumberToWait;
    }
}
