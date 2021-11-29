package com.wit.lambda.samples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

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
        //Lambda usage with a custom functional interface
        MyFunctionalInterfaceNoArg myFunctionalInterfaceNoArg = () -> System.out.println("Lambda with custom functional interface.");
        myFunctionalInterfaceNoArg.printMessage();
        
        //Lambda usage with an in-built Functional Interface - Predicate
        String name = "Sanjay";
        String startsWithChar = "S";
        //Declaring the predicate type as string and use lambda expression
        Predicate<String> predicate = s -> s.startsWith(startsWithChar);
        System.out.println("The name " + name + " starts with " + startsWithChar + " : " + predicate.test(name));
        
        //Lambda usage with an in-built Functional Interface - Consumers
        Map<String, Integer> persons = new HashMap<>();
        persons.put("Sanjay", 35);
        persons.put("Kumar", 24);
        persons.put("Samarth", 6);
        persons.forEach((names, ages) -> System.out.println(names + " is " + ages + " years old"));
        
        //Lambda usage with an in-built Functional Interface - Consumers
        Consumer<String> consumer1 = FunctionalInterfaceEx::printMessage;  
        consumer1.accept("Kumar");   //calling Consumer method
        
        //Lambda usage with an in-built Functional Interface - Operators
        List<String> people = Arrays.asList("Sanjay", "Kumar", "Samarth");
        people.replaceAll(String::toUpperCase);
        people.forEach(n -> System.out.println(n));
        
        //Lambda usage with the Legacy functional interface
        Thread thread = new Thread(() -> System.out.println("Hello from a different thread with the legacy Functional Interface!"));
        thread.start();
    }
    
    static void printMessage(String name){  
        System.out.println("Hello "+name);  
    }
}


/**
 * Approach-1: By creating a custom functional interface with no argument & no return-type method.
 */
interface MyFunctionalInterfaceNoArg {
    void printMessage();
}
