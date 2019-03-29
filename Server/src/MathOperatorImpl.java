public class MathOperatorImpl implements MathOperator {
    @Override
    public double executeOperation(double a, double b, char operation) {
        switch (operation) {
            case '+' : {
                return a + b;
            }
            case '-' : {
                return a - b;
            }
            case '*' : {
                return a * b;
            }
            case '/' : {
                if (b != 0)
                    return a/b;
                else
                    throw new RuntimeException("Division by zero is not correct!");
            }
            default: {
                return -1;
            }
        }
    }
}
