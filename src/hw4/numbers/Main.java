package hw4.numbers;

import java.util.Objects;
import java.util.stream.IntStream;

public class Main {
    interface FizzBuzz {
        String fizzBuzzing();
    }

    public static void main(String[] args) {
        //Напишите программу, которая выводит на экран числа от 1 до 100. При этом вместо чисел, кратных трем,
        //
        //программа должна выводить слово Fizz, а вместо чисел, кратных пяти — слово Buzz.
        //
        //Если число кратно пятнадцати, то программа должна выводить слово FizzBuzz.
        //
        //Задача может показаться очевидной, но нужно получить наиболее простое и красивое решение.

        IntStream
                .rangeClosed(1, 100)
                .forEach(i -> System.out
                        .println(i % 3 == 0 ? (i % 5 == 0 ? "FizzBuzz" : "Fizz") : (i % 5 == 0 ? "Buzz" : i)));

        IntStream
                .rangeClosed(1, 100)
                .forEach(i -> fizzBuzz(() -> i % 3 == 0 ? (i % 5 == 0 ? "FizzBuzz" : "Fizz") : (i % 5 == 0 ? "Buzz" : Objects.toString(i))));


        for (int i = 1; i <= 100; i++) {
            int finalI = i;
            fizzBuzz(() ->
                    finalI % 3 == 0 ? (finalI % 5 == 0 ? "FizzBuzz" : "Fizz") : (finalI % 5 == 0 ? "Buzz" : Objects.toString(finalI))
            );
        }
    }

    public static void fizzBuzz(FizzBuzz buzzFisting) {
        System.out.println(buzzFisting.fizzBuzzing());
    }
}
