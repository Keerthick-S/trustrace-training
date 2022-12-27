package factorial;

import java.util.*;
;

public class Factorial {
    Map<Integer,Integer> factorial = new HashMap<>();
    public void factorial(int number) {
        Scanner sc = new Scanner(System.in);

        factorial.put(1,1);

        for(int i = 2; i <= number; i++) {
            int a = factorial.get(i - 1);
            factorial.put(i, a * i);
        }
    }
    public void display() {
        for(Map.Entry fact:factorial.entrySet()) {
            System.out.println(fact.getKey()+" "+ fact.getValue());
        }
    }

}
