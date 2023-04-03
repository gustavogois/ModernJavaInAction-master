package goisstudy.ch03LambdaExpressions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Task02 {
    public static void main(String[] args) {
        new Task02().forEach(Arrays.asList(1, 2, 3, 4), e -> System.out.println(e));
    }
    // create a method forEach, which takes a list of Integers and applies an operation on each element of that list
    public <T> void forEach(List<T> list, Consumer<T> c) {
        list.stream()
                .forEach(e -> c.accept(e));
    }
}
