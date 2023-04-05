package goisstudy.ch03LambdaExpressions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Task04 {
    // Given a list of integers, write a Java stream that doubles each integer in the list using the Function interface.
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Function<Integer, Integer> doubleFunction = num -> num * 2;
        numbers.stream()
                .map(doubleFunction)
                .forEach(System.out::println);
    }
}
