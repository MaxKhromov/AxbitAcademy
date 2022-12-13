package hw4.numbers;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        //Напишите программу, которая выводит на экран числа от 1 до 100. При этом вместо чисел, кратных трем,
        //
        //программа должна выводить слово Fizz, а вместо чисел, кратных пяти — слово Buzz.
        //
        //Если число кратно пятнадцати, то программа должна выводить слово FizzBuzz.
        //
        //Задача может показаться очевидной, но нужно получить наиболее простое и красивое решение.
        for (int i = 1; i <= 100; i++) {
            String output = "" + (i % 3 == 0 ? "Fizz" : "") + (i % 5 == 0 ? "Buzz" : "");
            System.out.println(output.isEmpty() ? Objects.toString(i) : output);

//            if(i%3 == 0 && i%5 == 0){
//                System.out.println("FizzBuzz");
//            } else if (i%3==0){
//                System.out.println("Fizz");
//            }else if(i%5==0){
//                System.out.println("Buzz");
//            } else {
//                System.out.println(i);
//            }

//            String output = "";
//            if(i%3==0){
//                output = output + "Fizz";
//            }
//            if(i%5==0){
//                output = output + "Buzz";
//            }
//            if(output.isEmpty()){
//                output = output + Objects.toString(i);
//            }
//            System.out.println(output);

        }
    }
}
