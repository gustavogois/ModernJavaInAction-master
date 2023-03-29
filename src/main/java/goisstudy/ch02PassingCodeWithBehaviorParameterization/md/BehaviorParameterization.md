Behavior parameterization is a software development pattern that lets you handle frequent requirement changes. In a nutshell, it means taking a block of code and making it available without executing it. This block of code can be called later by other parts of your programs, which means that you can defer the execution of that block of code. For instance, you could pass the block of code as an argument to another method that will execute it later. As a result, the method’s behavior is parameterized based on that block of code.

### Task 01: Behavior parameterization (Strategy Pattern)

What you just did is related to the strategy design pattern (see http://en.wikipedia.org/wiki/Strategy_pattern), which lets you define a family of algorithms, encapsulate each algorithm (called a strategy), and select an algorithm at run time. In this case the family of algorithms is ApplePredicate and the different strategies are AppleHeavyWeightPredicate and AppleGreenColorPredicate.

Write the method below:

```
public static List<Apple> filterApples(List<Apple> inventory, ...)
```

in such a way that we can pass a predicate as a parameter.

See [Task01.java](./Task01.java).
