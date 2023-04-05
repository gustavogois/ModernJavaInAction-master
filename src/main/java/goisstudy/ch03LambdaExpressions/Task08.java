package goisstudy.ch03LambdaExpressions;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public class Task08 {
    public static void main(String[] args) {
        // Filter a stream of strings to find all pairs of strings that have the same length using the BiPredicate interface.
        BiPredicate<String, String> stringsSameLength = (s1, s2) -> s1.length() == s2.length();
        List<String> words = Arrays.asList("casa", "velho", "oi", "pato", "ok", "lixo");
        words.stream()
                .flatMap(s1 -> words.stream()
                        .filter(s2 -> !s1.equals(s2))
                        .filter(s2 -> stringsSameLength.test(s1, s2))
                        .map(s2 -> "(" + s1 + "," + s2 + ")"))
        //        .forEach(System.out::println)
        ;

    }
}
