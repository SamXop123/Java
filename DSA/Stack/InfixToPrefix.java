package DSA.Stack;
import java.util.*;

public class InfixToPrefix {

    static int priority(char ch) {
        if (ch == '^')
            return 3;
        if (ch == '*' || ch == '/')
            return 2;
        if (ch == '+' || ch == '-')
            return 1;
        return -1;
    }

    public static String infixToPrefix(String s) {

        // Step 1: Reverse the string and swap brackets
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(')
                sb.setCharAt(i, ')');
            else if (sb.charAt(i) == ')')
                sb.setCharAt(i, '(');
        }

        // Step 2: Convert to Postfix with conditional priority
        String postfix = "";
        Stack<Character> st = new Stack<>();
        String modifiedInfix = sb.toString();

        for (char c : modifiedInfix.toCharArray()) {

            if (Character.isLetterOrDigit(c)) {
                postfix += c;
            }

            else if (c == '(') {
                st.push(c);
            }

            else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(')
                    postfix += st.pop();
                st.pop();
            }

            else {
                // Controlled condition for Prefix conversion
                if (c == '^') {
                    while (!st.isEmpty() && priority(c) <= priority(st.peek()))
                        postfix += st.pop();
                } else {
                    while (!st.isEmpty() && priority(c) < priority(st.peek()))
                        postfix += st.pop();
                }
                st.push(c);
            }
        }

        while (!st.isEmpty()) {
            postfix += st.pop();
        }

        // Step 3: Reverse the result to get Prefix
        return new StringBuilder(postfix).reverse().toString();
    }
}
