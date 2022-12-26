package com.collection.practice;
import java.util.*;
public class GetInput {

    Scanner sc = new Scanner(System.in);
    private int id;
    private String name;
    public int getId() {
        System.out.println("Enter the Teacher Id");
        return id = sc.nextInt();
    }

    public String getName() {
        System.out.println("Enter the Teacher Name");
        return name = sc.next();
    }

}
