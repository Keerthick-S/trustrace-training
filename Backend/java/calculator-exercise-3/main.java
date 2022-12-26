package Main;
public class main {
    public static void main(String[] args) {
        GetInput input = new GetInput();
        int a = input.getAValue();
        int b = input.getBValue();
        char operator = input.getOperator();
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
