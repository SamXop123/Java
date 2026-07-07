package DSA.Stack;
import java.util.Stack;

public class PostfixToInfix {
    public static String postfixToInfix(String postfix) {
        Stack<String> st = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            // If operand, push as string
            if (Character.isLetterOrDigit(c)) {
                st.push(String.valueOf(c));
            }

            // If operator, pop two operands and combine
            else {
                String t1 = st.pop(); // First popped
                String t2 = st.pop(); // Second popped

                String combined = "(" + t2 + c + t1 + ")";
                st.push(combined);
            }
        }

        return st.pop();
    }
}
