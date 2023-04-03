# Chapter 3. Lambda expressions

This chapter covers

- Lambdas in a nutshell
- Where and how to use lambdas
- The execute-around pattern
- Functional interfaces, type inference
- Method references
- Composing lambdas

## Putting lambda and behaviour parameterization in practice

[Task 01 - BufferedReader](Task01Before.java)

## Functional Interfaces

### Predicate

The java.util.function.Predicate<T> interface defines an abstract method named test that accepts an object of generic type T and returns a boolean.

You might want to use this interface when you need to represent a boolean expression that uses an object of type T.

```
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
```

### Consumer

The java.util.function.Consumer<T> interface defines an abstract method named accept that takes an object of generic type T and returns no result (void).

You might use this interface when you need to access an object of type T and perform some operations on it.

```
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
```

For example, you can use it to create a method forEach, which takes a list of Integers and applies an operation on each element of that list. See [Task 02](Task02Before.java)

### Function

The java.util.function.Function<T, R> interface defines an abstract method named apply that takes an object of generic type T as input and returns an object of generic type R.

You might use this interface when you need to define a lambda that maps information from an input object to an output (for example, extracting the weight of an apple or mapping a string to its length). 

```
@FunctionalInterface
public interface Function<T, R> {
R apply(T t);
}
```

In the listing that follows, we show how you can use it to create a method map to transform a list of Strings into a list of Integers containing the length of each String. See [Task 03](Task03Before.java)

#### Primitive specializations

We described three functional interfaces that are generic: Predicate<T>, Consumer<T>, and Function<T, R>. There are also functional interfaces that are specialized with certain types.

Boxed values are a wrapper around primitive types and are stored on the heap. Therefore, boxed values use more memory and require additional memory lookups to fetch the wrapped primitive value.

Java 8 also added a specialized version of the functional interfaces we described earlier in order to avoid autoboxing operations when the inputs or outputs are primitives.

For example,  in the following code, using an IntPredicate avoids a boxing operation of the value 1000, whereas using a Predicate<Integer> would box the argument 1000 to an Integer object: 

```
public interface IntPredicate {
    boolean test(int t);
}
IntPredicate evenNumbers = (int i) -> i % 2 == 0;           // NO BOXING
evenNumbers.test(1000);                                        1
Predicate<Integer> oddNumbers = (Integer i) -> i % 2 != 0;  // BOXING
oddNumbers.test(1000);
```

Table below summarizes the most commonly used functional interfaces available in the Java API and their function descriptors, along with their primitive specializations. 

Keep in mind that these are only a starter kit, and you can always create your own if needed. Creating your own interfaces can also help when a domain-specific name will help with program comprehension and maintenance.

Functional interface

Predicate<T>

Consumer<T>

|                     |                |    |
|---------------------|----------------|----|
| Predicate<T>        | T -> boolean   | 	IntPredicate, <BR>LongPredicate,<BR>DoublePredicate| 
| Consumer<T>         | T -> void      | 	IntConsumer,<BR>LongConsumer,<BR>DoubleConsumer |
| Function<T, R>      | T -> R         | 	IntFunction<R>, <BR>IntToDoubleFunction, <BR>IntToLongFunction, <BR>LongFunction<R>, <BR>LongToDoubleFunction, <BR>LongToIntFunction, <BR>DoubleFunction<R>, DoubleToIntFunction, <BR>DoubleToLongFunction, <BR>ToIntFunction<T>, <BR>ToDoubleFunction<T>, <BR>ToLongFunction<T> |
| Supplier<T>         | () -> T	       | BooleanSupplier, <BR>IntSupplier, <BR>LongSupplier, <BR>DoubleSupplier |
| UnaryOperator<T>    | T -> T	        | IntUnaryOperator, <BR>LongUnaryOperator, <BR>DoubleUnaryOperator |
| BinaryOperator<T>   | (T, T) -> T    |	IntBinaryOperator, <BR>LongBinaryOperator, <BR>DoubleBinaryOperator |
| BiPredicate<T, U>	  | (T, U) -> boolean | 
| BiConsumer<T, U>    | (T, U) -> void	 | ObjIntConsumer<T>, <BR>ObjLongConsumer<T>, <BR>ObjDoubleConsumer<T> |
| BiFunction<T, U, R> | (T, U) -> R    | ToIntBiFunction<T, U>, <BR>ToLongBiFunction<T, U>, <BR>ToDoubleBiFunction<T, U> |


