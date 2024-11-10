package DSA.stackPractice;

import java.util.Stack;

public class PostfixEvaluation {
    public static void main(String[] args) {
        String data = "2 3 1 * + 9 -";
        System.out.println("Answer of Expression - " + calculateResult(data));
        data = "100 + 200 2 / 5 * 7 +";
        System.out.println("Answer of Expression - " + calculateResult(data));
    }

    private static Integer calculateResult(String data) {
        Stack<Integer> numberStack = new Stack<>();
        String operator = "";
        String[] strings = data.split(" ");
        for(String s:strings) {
            if (isNumber(s)) {
                int number = Integer.parseInt(s);
                if(!operator.isEmpty()) {
                    int answer = doOpertor(number, numberStack.pop(), operator);
                    numberStack.push(answer);
                    operator = "";
                } else {
                    numberStack.push(number);
                }
            } else {
                if (numberStack.size() > 1) {
                    int operand1 = numberStack.pop();
                    int operand2 = numberStack.pop();
                    int answer = doOpertor(operand1, operand2, s);
                    numberStack.push(answer);
                } else {
                    operator = s;
                }
            }
        }
        return numberStack.pop();
    }

    private static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int doOpertor(int oper1, Integer oper2, String operator) {
        return switch (operator) {
            case "+" -> oper2 + oper1;
            case "-" -> oper2 - oper1;
            case "*" -> oper2 * oper1;
            case "/" -> oper2 / oper1;
            default -> 0;
        };
    }
}
