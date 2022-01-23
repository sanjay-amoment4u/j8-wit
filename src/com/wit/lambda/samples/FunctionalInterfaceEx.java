package com.wit.lambda.samples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class contains the info and examples on Functional Interface and it's usability.
 *
 * #### POINTS TO NOTE:
 * (a) Must contain exactly one abstract method,
 * (b) It can have any number of default and/or static methods,
 * (c) It helps to achieve the functional programming approach,
 * (d) @FunctionalInterface annotation is an optional to mark the interface as functional interface however, if the
 * annotation is present then the interface has to follow the contract. For example, if more than one abstract method
 * present and the it is marked a functional interface with the annotation, then compiler will claim an error,
 * (e) Runnable, Comparable are some of the examples of functional interfaces,
 * (f) The java.util.function package, included in Java 8, contains many built-in functional interfaces and it's
 * variations like - Predicate [with boolean test(T t)], BiPredicate<T,U> [with boolean test(T t, U u)] BinaryOperator
 * [with T apply(T x, T y)], Function [with R apply(T t)], Consumer<T> [with accept(T t)], Supplier<T> [with T get()]
 * etc.
 *
 * #### DEFINITIONS >> IN-BUILT FUNCTIONAL INTERFACE:
 * a) Main Types >> Consumer (Bi-Consumer), Predicate (Bi-Predicate), Function (Bi-Function), Supplier.
 *
 * b) Consumer (Bi-Consumer): It contains an abstract accept(T t) [or accept(T t, U u)] methods with NO return types.
 * It is used to print values as such or by applying some logic on the passed argument. Variety of methods in the Java
 * Stream API take the functional Consumer interface as an argument, such as collect, forEach, peek etc.
 *
 * c) Predicate (Bi-Predicate); boolean-valued function: It contains an abstract boolean test(T t) [or boolean test(T
 * t, U u)] methods with boolean return types. It is used to test any expression and return true / false. Java
 * Predicate interface helps in writing filter expressions so easy. The real-life usecases could be 1) Finding all
 * children born after a particular date, 2) Pizzas ordered within a specific time range, 3) Employees older than
 * certain age and so on. One such method is filter() method from Stream API which accepts Predicate as argument.
 *
 * d) Function (Bi-Function): It contains an abstract R apply(T t) [or R apply(T t, U u)] methods with a return type. It
 * performs some operation on the given input and return the transferred output.
 *
 * @author Sanjay
 */
public class FunctionalInterfaceEx {

    public static void main(String[] args) {

        /* ####  CUSTOM FUNCTIONAL INTERFACE EXAMPLES - STARTS */

        //Lambda usage with a custom functional interface with no-argument method
        MyFunctionalInterfaceNoArg myFunctionalInterfaceNoArg =
                () -> System.out.println("Lambda with custom & inbuilt functional interface.");
        myFunctionalInterfaceNoArg.printMessage();

        //Lambda usage with a custom functional interface with a single-argument method
        MyFunctionalInterfaceWithOneArg myFunctionalInterfaceWithOneArg = num -> (Integer) num % 2 == 0;
        int input = 16;
        System.out.println(input + " is an even number:" + myFunctionalInterfaceWithOneArg.isEvenNumber(input));

        //Lambda usage with a custom functional interface with two-arguments method and with a return type.
        MyFunctionalInterface2Arg myFunctionalInterface2Arg = (a, b) -> (Double) a + (Double) b;
        System.out.println(myFunctionalInterface2Arg.calculate(5.5, 6.3));

        /* ####  CUSTOM FUNCTIONAL INTERFACE EXAMPLES - ENDS */


        /* ####  BUILT-IN FUNCTIONAL INTERFACE EXAMPLES - STARTS */

        //Consumers - 1. Lambda usage with an in-built Functional Interface
        Consumer<String> consumer1 = FunctionalInterfaceEx::print;
        consumer1.accept("Kumar");   //calling Consumer method

        //Consumers - 2. Lambda usage with an in-built Functional Interface.
        Map<String, Integer> persons = new HashMap<>();
        persons.put("Sanjay", 35);
        persons.put("Kumar", 24);
        persons.put("Samarth", 6);
        persons.forEach((names, ages) -> System.out.println(names + " is " + ages + " years old"));

        //Predicate - 1. Lambda usage with an in-built Functional Interface.
        String name = "Sanjay";
        String startsWithChar = "S";
        //Declaring the predicate type as string and use lambda expression
        Predicate<String> predicate = s -> s.startsWith(startsWithChar);
        System.out.println("The name " + name + " starts with " + startsWithChar + " : " + predicate.test(name));

        //Predicate - 2. With Stream API filter() function.
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> result = list.stream().filter(x -> x > 5 && x < 9).collect(Collectors.toList());
        System.out.println(result); // [6, 7, 8]

        //Predicate (~BiPredicate) - 3. with BiPredicate functional interface.
        BiPredicate<String, Integer> lengthComparator = (str, len) -> {
            return str.length() == len;
        };
        System.out.println(lengthComparator.test("sanjay", 6));  // true

        //Function - 1. with Function functional interface. Return takes name (String) as input and returns the
        //length of the name as integer.
        Function<String, Integer> func = empName -> empName.length();
        Integer len = func.apply("sanjay");   // 6
        System.out.println(len);

        //Function (BiFunction) - 2. with BiFunction functional interface.
        //Takes two Integers (the operands) and returns an Integer (the sum)
        BiFunction<Integer, Integer, Integer> sum = (x1, x2) -> x1 + x2;
        Integer addition = sum.apply(2, 3);
        System.out.println(addition); // 5

        //Function (BiFunction) - 3. with Java Stream API.
        //Add all the even numbers in the input array and return an Integer.
        int[] numArray = new int[]{1, 3, 2, 8, 9, 6, 5};
        Integer evenSum = Arrays.stream(numArray).filter(num -> num % 2 == 0).sum();
        System.out.println("The sum all even = " + evenSum); // 16


        //Lambda usage with an in-built Functional Interface - Operators
        List<String> people = Arrays.asList("Sanjay", "Kumar", "Samarth");
        people.replaceAll(String::toUpperCase);
        people.forEach(n -> System.out.println(n));

        //Lambda usage with the Legacy functional interface - Runnable
        Thread thread = new Thread(
                () -> System.out.println(
                        "Hello from a different thread with the legacy Functional Interface - Runnable!"));
        thread.start();

        /* ####  BUILT-IN FUNCTIONAL INTERFACE EXAMPLES - ENDS */
    }

    static void print(String name) {
        System.out.println("Hello " + name);
    }
}

/**
 * Approach-1: By creating a custom functional interface with no argument & no return-type method.
 */
interface MyFunctionalInterfaceNoArg {
    void printMessage();
}

/**
 * Approach-2: By creating a custom functional interface with a single argument & a boolean return-type method.
 */
@FunctionalInterface
interface MyFunctionalInterfaceWithOneArg<V> {
    boolean isEvenNumber(V num);
}

/**
 * Approach-3: By creating a custom functional interface with two arguments & with Object return-type, method. Note:
 * here I have used the @FunctionalInterface to declare the interface as functional interface, which is not mandatory
 * with the Functional Interface specification.
 */
@FunctionalInterface
interface MyFunctionalInterface2Arg<T1, T2, T3> {
    T3 calculate(T1 val1, T2 val2);
}
