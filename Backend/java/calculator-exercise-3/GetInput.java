package Main;

import java.util.*;
public class GetInput {
    Scanner sc = new Scanner(System.in);
    public int getAValue() {
        System.out.println("Enter the First Number");
        int a = sc.nextInt();
        return a;
    }

    public int getBValue() {
        System.out.println("Enter the Second Number");
        int b = sc.nextInt();
        return b;
    }

    public char getOperator() {
        System.out.println("Enter the Operator like + , - , * , /");
        char operator = sc.next().charAt(0);
        return operator;
    }
}
