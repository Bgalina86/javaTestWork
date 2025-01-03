package validation;

import help.Validation;

import java.util.Stack;

import static constClass.CodeError.Error_StringNotValidation;

public class evaluate extends applyOp{
    public static double evaluate(String input) {
        /*
         * evaluate method takes a string input and evaluates it as a mathematical
         * expression
         * using two stacks, one for operands and one for operators.
         * It uses the Shunting Yard algorithm to convert the input string from infix
         * notation to postfix notation
         * and then evaluates it.
         */
        double result = 0;
        char[] inputArr = input.toCharArray();
        // Create two stacks, one for operands and one for operators
        Stack<Double> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        // Iterate through the input array
        for (int i = 0; i < inputArr.length; i++) {
            // If the current character is a digit, add it to the operands stack, otherwise
            // add it to the operators stack
            if (inputArr[i] == ' ') {
                continue;
            }
            if (Validation.hasValidCharsOnly(String.valueOf(inputArr[i])) == false) {return Error_StringNotValidation.ordinal();}
            // провести валидацию на ошибки в строке
            if (inputArr[i] >= '0' && inputArr[i] <= '9') {
                // if the character is a digit, push it onto the operands stack
                StringBuilder sb = new StringBuilder();
                while (i < inputArr.length && (inputArr[i] >= '0' && inputArr[i] <= '9' || inputArr[i] == '.')) {
                    sb.append(inputArr[i++]);
                }
                operands.push(Double.parseDouble(sb.toString()));
                i--;
            } else if (inputArr[i] == '(') {
                // if the character is an open parenthesis, push it onto the operators stack
                operators.push(inputArr[i]);
            } else if (inputArr[i] == ')') {
                // if the character is a close parenthesis, pop operators and operands from
                // their stacks and apply them until an open parenthesis is found
                while (operators.peek() != '(') {
                    operands.push(applyOp(operators.pop(), operands.pop(), operands.pop()));
                }
                operators.pop();
            } else if (inputArr[i] == '+' || inputArr[i] == '-' || inputArr[i] == '*' || inputArr[i] == '/') {
                // if the character is an operator, pop operators and operands from their stacks
                // and apply them until the current operator has higher precedence
                while (!operators.empty()) {
                    operands.push(applyOp(operators.pop(), operands.pop(), operands.pop()));
                }
                operators.push(inputArr[i]);
            }
        }
        // pop remaining operators and operands from their stacks and apply them
        while (!operators.empty()) {
            operands.push(applyOp(operators.pop(), operands.pop(), operands.pop()));
        }
        result = operands.pop();
        return result;
    }
}