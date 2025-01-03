package validation;



public class applyOp {
    public static double applyOp(char op, double b, double a) {
    /* applyOp method applies the operator passed as the first argument
    to the operands passed as the second and third arguments.
    It returns the result of the operation.
     */
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                return a / b;
        }
        return 0;
    }
}