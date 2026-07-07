package DSA.Stack;
import java.util.Stack;

public class PrefixToInfix {
    public static String prefixToInfix(String prefix) {
        Stack<String> st = new Stack<>();

        // Iterate from right to left
        for (int i = prefix.length()-1; i >= 0; i--) {
            char c = prefix.charAt(i);

            // If operand, push to stack
            if (Character.isLetterOrDigit(c)) {
                st.push(String.valueOf(c));
            }

            // If operator, pop two operands and combine
            else {
                String t1 = st.pop(); // First popped
                String t2 = st.pop(); // Second popped

                String combined = "(" + t1 + c + t2 + ")";
                st.push(combined);
            }
        }

        return st.pop();
    }
}
