package Main;
import java.util.*;
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the First Number");
        int a = sc.nextInt();
        System.out.println("Enter the Second Number");
        int b = sc.nextInt();
        System.out.println("Enter the Operator like + , - , * , /");
        char operator = sc.next().charAt(0);
        CalculatorOperation obj = new CalculatorOperation();
        int ans = 0;
        if(operator == '+') {
            ans = obj.addition(a,b);
        } else if (operator == '-') {
            ans = obj.subraction(a,b);
        } else if (operator == '*') {
            ans = obj.multiplication(a,b);
        } else if (operator == '/') {
            ans = obj.division(a,b);
        }
        System.out.println("Answer: " + ans);
    }
}
