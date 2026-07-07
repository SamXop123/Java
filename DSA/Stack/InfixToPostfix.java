package DSA.Stack;

import java.util.Stack;

public class InfixToPostfix {

    static int priority(char ch) {
        if (ch == '^') return 3;
        else if (ch == '*' || ch == '/') return 2;
        else if (ch == '+' || ch == '-') return 1;
        else return -1;
    }

    public static String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If operand, add to result
            if (Character.isLetterOrDigit(c)) {
                result += c;
            }

            // If opening bracket, push to stack
            else if (c == '(') {
                st.push(c);
            }

            // If closing bracket, pop until opening bracket is found
            else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    result += st.pop();
                }
                st.pop(); // Remove '(' from stack
            }

            // If operator
            else {
                while (!st.isEmpty() && priority(c) <= priority(st.peek())) {
                    result += st.pop();
                }
                st.push(c);
            }
        }

        // Pop remaining operators
        while (!st.isEmpty()) {
            result += st.pop();
        }

        return result;
    }
}
