package goisstudy.ch03LambdaExpressions;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Task05 {

    public static void main(String[] args) {
        // Generate a stream of 10 random integers using the Supplier interface.
        Supplier<Integer> randomIntegers = () -> new Random().nextInt();
        Stream.generate(randomIntegers)
                .limit(10)
        //        .forEach(System.out::println)
        ;

        // Generate an infinite stream of even numbers using the Supplier interface.
        Supplier<Integer> evenNumbers = new Supplier<>() {
            int n = 0;
            @Override
            public Integer get() {
                n = n + 2;
                return n;
            }
        };
        Stream.generate(evenNumbers)
                .limit(5)
        //        .forEach(System.out::println)
        ;

        // Generate an infinite stream of Fibonacci numbers using the Supplier interface.
        Supplier<Integer> fibbonacci = new Supplier<>() {
            int temp, actual = 0, next = 1;

            @Override
            public Integer get() {
                temp = actual;
                actual = next;
                next = temp + next;
                return actual;
            }
        };
        Stream.generate(fibbonacci)
                .limit(10)
        //        .forEach(System.out::println)
        ;
    }
}
