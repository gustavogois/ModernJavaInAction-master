package goisstudy.ch03LambdaExpressions;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Task07 {
    public static void main(String[] args) {
        // Find the maximum number in a stream of integers using the BinaryOperator interface
        BinaryOperator<Integer> max = Integer::max;
        Integer integer = Stream.of(1, 7, 5, 3)
                .reduce(max)
                .orElse(-1);
        // System.out.println("Max: " + integer);

        // Find the sum of numbers in a stream of integers using the BinaryOperator interface
        BinaryOperator<Integer> sum = Integer::sum;
        Integer integer1 = Stream.of(1, 2, 3)
                .reduce(sum)
                .orElse(-1);
        //System.out.println("Integer1: " + integer1);

        // Concatenate a stream of strings using the BinaryOperator interface.
        BinaryOperator<String> concat = (str1, str2) -> str1 + str2 ;
        String result = Stream.of("Hello", " ", "world!")
                .reduce(concat)
                .orElse("");
        System.out.println("Resultado: " + result);
    }

}
