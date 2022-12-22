import java.sql.SQLOutput;
import java.util.*;

public class OddNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the First Number");
        int num1 = sc.nextInt();
        System.out.println("Enter the Second Number");
        int num2 = sc.nextInt();
        System.out.println("Odd numbers are: ");
        for(int i = num1; i <= num2; i++) {
            if(i % 2 != 0)
                System.out.println(i);
        }
=
    }
}
