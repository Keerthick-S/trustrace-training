import java.util.*;
public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number");
        int ans = 1;
        int num = sc.nextInt();
        while(num > 0) {
            ans = num * ans;
            num--;
        }
        System.out.println(ans);
    }
}
