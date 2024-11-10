package DSA.stackPractice;

import java.util.Stack;

public class ParanthesisChecker {

    public static void main(String[] args) {
        String brackets = "[()]{}{[()()]()}";
        System.out.println(isValidParenthesis(brackets));
        brackets = "{()}[[(])";
        System.out.println(isValidParenthesis(brackets));
    }

    private static String isValidParenthesis(String brackets) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < brackets.length(); i++) {
            char ch = brackets.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if ((ch == ')' && stack.peek() == '(') ||
                    (ch == ']' && stack.peek() == '[') ||
                    (ch == '}' && stack.peek() == '{')) {
                stack.pop();
            } else {
                return "Parenthesis Sequence Is Invalid";
            }
        }
        if (stack.isEmpty()) {
            return "Parenthesis Sequence Is Valid";
        } else {
            return "Parenthesis Sequence Is Invalid";
        }
    }
}
