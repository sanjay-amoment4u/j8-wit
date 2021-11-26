package com.wit.lambda.samples;

/**
 * This class contains the info and examples on Functional Interface and it's usability.
 * 
 * POINTS TO NOTE: (a) Must contain exactly one abstract method, (b) It can have any number of
 * default and/or static methods, (c) It helps to achieve the functional programming approach,
 * (d) @FunctionalInterface annotation is an optional to mark the interface as functional interface
 * however, if the annotation is present then the interface has to follow the contract. For example,
 * if more than one abstract method present and the it is marked a functional interface with the
 * annotation, then compiler will claim an error, (e) Runnable, Comparable are some of the examples
 * of functional interfaces, (f) The java.util.function package, included in Java 8, contains many
 * built-in functional interfaces and it's variations like - Predicate [with boolean test(T t)],
 * BiPredicate<T,U> [with boolean test(T t, U u)] BinaryOperator [with T apply(T x, T y)], Function
 * [with R apply(T t)], Consumer<T> [with accept(T t)], Supplier<T> [with T get()] etc.
 * 
 * @author Sanjay
 *
 */
public class FunctionalInterfaceEx {

    public static void main(String[] args) {
        MyFunctionalInterfaceNoArg myFunctionalInterfaceNoArg = () -> System.out.println("Lambda with custom functional interface.");
        myFunctionalInterfaceNoArg.printMessage();
    }
}


/**
 * Approach-1: By creating a custom functional interface with no argument & no return-type method.
 */
interface MyFunctionalInterfaceNoArg {
    void printMessage();
}
