package goisstudy.ch02PassingCodeWithBehaviorParameterization;

import io.reactivex.Completable;
import modernjavainaction.chap02.FilteringApples;

import java.util.Comparator;

import static goisstudy.ch02PassingCodeWithBehaviorParameterization.Inventory.inventory;

public class Task02 {
    public static void main(String[] args) {
        inventory.sort(Comparator.comparingInt(FilteringApples.Apple::getWeight));
        inventory.forEach(System.out::println);
    }
}
