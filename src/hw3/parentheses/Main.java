package hw3.parentheses;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        String inputString = "{()()[()()[]{}]}";
        String[] inputStringAsList = inputString.split("");

        Deque<String> validationQueue = new LinkedList<String>();
        for (var i = 0; i < inputStringAsList.length; i++) {
            switch (inputStringAsList[i]) {
                case "{":
                case "(":
                case "[":
                    validationQueue.add(inputStringAsList[i]);
                    break;
                case ")":
                    if(validationQueue.peekLast().equals("(")) {
                        validationQueue.removeLast();
                        break;
                    } else {
                        throw new IllegalStateException("Syntax error! '(' expected at line " + i);
                    }
                case "]":
                    if(validationQueue.peekLast().equals("[")) {
                        validationQueue.removeLast();
                        break;
                    } else {
                        throw new IllegalStateException("Syntax error! '[' expected at line " + i);
                    }
                case "}":
                    if(validationQueue.peekLast().equals("{")) {
                        validationQueue.removeLast();
                        break;
                    } else {
                        throw new IllegalStateException("Syntax error! '{' expected at column " + i);
                    }
                default:
                    throw new IllegalStateException("Unexpected value in inputString variable: " + inputStringAsList[i]);
            }
        }
        if(validationQueue.isEmpty()){
            System.out.println("Congratulations! Your string is well formatted!");
        } else {
            throw new IllegalStateException("Syntax error! '" + validationQueue.peekLast() + "' is never closed at column " + validationQueue.size());
        }
    }
}
