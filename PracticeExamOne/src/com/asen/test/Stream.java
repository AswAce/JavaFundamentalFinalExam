package com.asen.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> streamTraining=addIn(scanner);
        List<String> newArrey=new ArrayList<>();
        newArrey=streamTraining.stream().skip(streamTraining.size()-2).collect(Collectors.toList());
       streamTraining=streamTraining.stream().limit(streamTraining.size()-2).collect(Collectors.toList());

        System.out.println(String.join(", ", streamTraining));
        System.out.println(newArrey);
        streamTraining.stream().mapToInt(String::length).average();

    }

    private static ArrayList<String> addIn(Scanner scanner) {
        String[] add=scanner.nextLine().split(" ");
        return new ArrayList<>(Arrays.asList(add));
    }
}
