package Main;

public class CalculatorOperation implements OperatingMethod {
    @Override
    public int addition(int a, int b) {
        return a + b;
    }

    @Override
    public int subraction(int a, int b) {
        return a - b;
    }

    @Override
    public int multiplication(int a, int b) {
        return a * b;
    }

    @Override
    public int division(int a, int b) {
        return a / b;
    }
}
