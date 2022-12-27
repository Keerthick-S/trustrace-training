package factorial;

public class Main {
    public static void main(String[] args) {
        GetInput input = new GetInput();
        int number = input.getInput();
        Factorial fact = new Factorial();
        fact.factorial(number);
        fact.display();
    }
}