package goisstudy.ch02PassingCodeWithBehaviorParameterization;

import modernjavainaction.chap02.FilteringApples;

import java.util.Arrays;
import java.util.List;

import static modernjavainaction.chap02.FilteringApples.Color.RED;

public class Inventory {
    public static final List<FilteringApples.Apple> inventory = Arrays.asList(
            new FilteringApples.Apple(80, FilteringApples.Color.GREEN),
            new FilteringApples.Apple(155, FilteringApples.Color.GREEN),
            new FilteringApples.Apple(120, RED));
}
