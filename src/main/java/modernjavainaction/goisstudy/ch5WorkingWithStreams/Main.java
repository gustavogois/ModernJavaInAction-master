package modernjavainaction.goisstudy.ch5WorkingWithStreams;

import modernjavainaction.chap04.Dish;
import modernjavainaction.chap05.Filtering;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static modernjavainaction.chap04.Dish.menu;

public class Main {
    public static void main(String[] args) {

        // 5.1 Filtering

        // 5.1.1 Filtering with a predicate

        // To filter a list of vegetarian Dish
        List<Dish> vegetarianDishes = menu.stream()
                // Use a method reference to check if a dish is vegetarian friendly.
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());

        // 5.1.2 Filtering unique elements

        // filter all even numbers from a list and then eliminates duplicates
        // (using the equals method for the comparison)

        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .distinct()
                .forEach(System.out::println);

        // 5.2. Slicing a stream

        // In this section, we’ll discuss how to select and skip elements in a stream in different ways.
        // There are operations available that let you efficiently select or drop elements using a predicate,
        // ignore the first few elements of a stream, or truncate a stream to a given size.

        // 5.2.1. Slicing using a predicate

        // Java 9 added two new methods that are useful for efficiently selecting elements in a stream: takeWhile and dropWhile.

        // Using takeWhile

        // Let’s say you have the following special list of dishes:
        //
        List<Dish> specialMenu = Arrays.asList(
            new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER));

        // How would you select the dishes that have fewer than 320 calories?

        // Instinctively, you know already from the previous section that the operation filter can be used as follows:
        //
        //List<Dish> filteredMenu
        //    = specialMenu.stream()
        //                 .filter(dish -> dish.getCalories() < 320)
        //                 .collect(toList());
        //
        // But, you’ll notice that the initial list was already sorted on the number of calories! The downside of using
        // the filter operation here is that you need to iterate through the whole stream and the predicate is applied
        // to each element. Instead, you could stop once you found a dish that is greater than (or equal to) 320 calories.
        //
        // But how do you specify this? The takeWhile operation is here to rescue you! It lets you slice any stream
        // (even an infinite stream as you will learn later) using a predicate. But thankfully, it stops once it has
        // found an element that fails to match.
        //
        //

        specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .forEach(System.out::println);

        // Using dropWhile

        // How about getting the other elements though? How about finding the elements that have greater than 320
        // calories? You can use the dropWhile operation for this:

        specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .forEach(System.out::println);

        // The dropWhile operation is the complement of takeWhile. It throws away the elements at the start where the
        // predicate is false. Once the predicate evaluates to true it stops and returns all the remaining elements,
        // and it even works if there are an infinite number of remaining elements!



        // 5.2.2 Truncating a stream
        // Streams support the limit(n) method, which returns another stream that’s no longer than a given size.
        // The requested size is passed as argument to limit. If the stream is ordered, the first elements are
        // returned up to a maximum of n.

        // For example, you can create a List by selecting the first three dishes that have more than 300 calories
        // as follows:
        List<Dish> collect = specialMenu.stream()
                .filter(d -> d.getCalories() < 300)
                .limit(3)
                .collect(Collectors.toList());

        // Note that limit also works on unordered streams (for example, if the source is a Set). In this case you
        // shouldn’t assume any order on the result produced by limit.

        // 5.2.3. Skipping elements
        //Streams support the skip(n) method to return a stream that discards the first n elements. If the stream has
        // fewer than n elements, an empty stream is returned.
        // Note that limit(n) and skip(n) are complementary!
        // For example, the following code skips the first two dishes that have more than 300 calories and returns the
        // rest.

        List<Dish> collect1 = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList());

        // Quiz 5.1:Filtering
        // How would you use streams to filter the first two meat dishes?

        menu.stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT)
                .limit(2)
                .collect(Collectors.toList());

        // 5.3 Mapping
    }
}
