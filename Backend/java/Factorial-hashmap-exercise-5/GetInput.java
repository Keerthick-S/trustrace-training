package factorial;
import java.util.*;
public class GetInput {
    private int number;
    public int getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number");
        return number = sc.nextInt();
    }
}
