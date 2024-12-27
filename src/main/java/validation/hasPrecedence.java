package validation;
import
  private static bullion hasPrecedence (char op1, char op2){
    /*
hasPrecedence method checks the precedence of the operators.
It returns true if the operator passed as the first argument has higher or
equal precedence than the operator passed as the second argument.
*/
    if (op1 == '(' || op2 == ')') {
        return false;
    }
    if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
        return false;
    } else {
        return true;
    }
}
