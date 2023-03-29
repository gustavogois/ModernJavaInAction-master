package goisstudy.ch02PassingCodeWithBehaviorParameterization;

import modernjavainaction.chap02.FilteringApples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static goisstudy.ch02PassingCodeWithBehaviorParameterization.Inventory.inventory;
import static modernjavainaction.chap02.FilteringApples.Color.GREEN;
import static modernjavainaction.chap02.FilteringApples.Color.RED;

public class Task01 {
    public static void main(String[] args) {
        Predicate<FilteringApples.Apple> filterRed = a -> RED.equals(a.getColor());
        Predicate<FilteringApples.Apple> filterGreenAndHeavy = a -> a.getWeight() > 100 && GREEN.equals(a.getColor());

        filter(inventory, filterRed).stream().forEach(System.out::println);
        filter(inventory, filterGreenAndHeavy).stream().forEach(System.out::println);
    }
    public static List<FilteringApples.Apple> filter(List<FilteringApples.Apple> inventory, Predicate<FilteringApples.Apple> p) {
        List result = new ArrayList<FilteringApples.Apple>();
        inventory.stream()
                .forEach(e -> {
                    if (p.test(e)) {
                        result.add(e);
                    }
                });
        return result;
    }
}
