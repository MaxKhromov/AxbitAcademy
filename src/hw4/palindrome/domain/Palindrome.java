package hw4.palindrome.domain;

public class Palindrome {
    public String originalString;
    public String lastIterationString;
    public Integer ordersNumberToWait;

    public Palindrome(String originalString) {
        this.originalString = originalString;
        this.lastIterationString = originalString;
        this.ordersNumberToWait = 0;
    }

    public Integer calculateNumberOfOrdersToWait() {

        if (checkFormat(this.lastIterationString)) {
            String orderNumberStrPart1 = this.lastIterationString.substring(0, this.lastIterationString.length() / 2);
            String orderNumberStrPart2 = this.lastIterationString.substring(this.lastIterationString.length() - orderNumberStrPart1.length());

            String expectedStrPart2 = reverseString(orderNumberStrPart1);

            //System.out.println(orderNumberStrPart1 + " - " + orderNumberStrPart2 + " - " + expectedStrPart2);

            Integer orderNumberIntPart2 = Integer.parseInt(orderNumberStrPart2);
            Integer expectedIntPart2 = Integer.parseInt(expectedStrPart2);

            if (expectedIntPart2 > orderNumberIntPart2) {
                this.ordersNumberToWait = this.ordersNumberToWait + (expectedIntPart2 - orderNumberIntPart2);
                return this.ordersNumberToWait;
            } else {
                int num = (int) Math.pow(10, orderNumberStrPart2.length());
                this.lastIterationString = Integer.toString(Integer.parseInt(this.lastIterationString) + num);
                this.ordersNumberToWait = this.ordersNumberToWait + num;
                this.calculateNumberOfOrdersToWait();
            }
        }
        return this.ordersNumberToWait;
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
