package goisstudy.ch03LambdaExpressions;

import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task06 {
    public static void main(String[] args) {
        // Generate a stream of even numbers between 1 and 10 using the UnaryOperator interface.
        UnaryOperator<Integer> even = n -> n + 2;
        Stream.iterate(0, even)
                .limit(5)
                //.forEach(System.out::println);
                ;

        // Generate a stream of powers of 2 from 1 to 32 using the UnaryOperator interface.
        UnaryOperator<Integer> multiplyByTwo = n -> n * 2;
        Stream.iterate(1, multiplyByTwo)
                .limit(6)
        //        .forEach(System.out::println)
        ;

        // Generate a stream of even numbers between 1 and 10 and then square them using the UnaryOperator interface.
        UnaryOperator<Integer> evens = n -> n + 2;
        UnaryOperator<Integer> square = n -> n * n;
        Stream.iterate(2, evens)
                .limit(4)
                .map(square)
        //        .forEach(System.out::println)
        ;

        // Generate a stream of lowercase letters from a to z and capitalize them using the UnaryOperator interface.
        UnaryOperator<String> capitalize = s -> s.toUpperCase();
        IntStream.rangeClosed('a','z')
                .mapToObj(c -> String.valueOf((char) c))
                .map(capitalize)
                .forEach(System.out::println);
    }


}
