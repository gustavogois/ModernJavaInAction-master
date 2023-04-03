package goisstudy.ch03LambdaExpressions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task03 {
    public static void main(String[] args) {
        new Task03().map(Arrays.asList("1", "22", "333"), String::length).forEach(System.out::println);
    }
    // create a method map to transform a list of Strings into a list of Integers containing the length of each String
    public <T, R> List<R> map(List<T> list, Function<T, R> function) {
        return list.stream()
                .map(e -> function.apply(e))
                .collect(Collectors.toList());
    }
}
