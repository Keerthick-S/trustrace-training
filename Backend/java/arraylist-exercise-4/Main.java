package com.collection.practice;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Teacher> teacherArrayList = new ArrayList<>();
        int num;
        do {
            System.out.println("Enter 1.Add Teacher 2.Display Teacher 3.Delete Teacher");
            num = sc.nextInt();
            if(num == 1) {
                GetInput input = new GetInput();
                int id = input.getId();
                String name = input.getName();
                teacherArrayList.add(addValue(id, name));
            } else if (num == 2){
                for (Teacher teacher: teacherArrayList) {
                    System.out.println(teacher.getId());
                    System.out.println(teacher.getName());
                }
            } else if (num == 3) {
                System.out.println("Enter the position of Teacher");
                int delNum = sc.nextInt();
                teacherArrayList.remove(delNum);
            }
            System.out.println("1.Continue 2.Exit");
            num = sc.nextInt();
        }while (num == 1);
    }

    public static Teacher addValue(int id, String name) {
        Teacher teacherObj = new Teacher(id, name);
        return teacherObj;
    }

}