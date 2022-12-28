package Hashmap;

import java.util.*;
public class Operation {
    Map<Integer,Student> hashMap = new HashMap<>();
        public void add() {
            hashMap.put(1, new Student(101,"Kavin"));
            hashMap.put(2, new Student(102, "Karthi"));
            hashMap.put(3, new Student(103, "Kanish"));
            hashMap.put(4, new Student(104, "Kamal"));
        }

        public void remove(Integer num) {
            hashMap.remove(num);
        }

        public void display() {
            System.out.println(hashMap);
        }

        public void iterate() {
            for(Map.Entry hash:hashMap.entrySet()) {
                System.out.println(hash.getKey() + " "+ hash.getValue());
            }
        }
}
