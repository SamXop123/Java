package DSA.Stack;
import java.util.Stack;

public class PostfixToPrefix {
    public static String postfixToPrefix(String postfix) {
        Stack<String> st = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            // If operand, push to stack
            if (Character.isLetterOrDigit(c)) {
                st.push(String.valueOf(c));
            }

            // If operator, pop two operands and combine
            else {
                String t1 = st.pop(); // First popped
                String t2 = st.pop(); // Second popped

                String combined = c + t2 + t1;
                st.push(combined);
            }
        }

        return st.pop();
    }
}
