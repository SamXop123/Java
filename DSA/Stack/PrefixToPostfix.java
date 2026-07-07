package DSA.Stack;
import java.util.Stack;

public class PrefixToPostfix {
    public static String prefixToPostfix(String prefix) {
        Stack<String> st = new Stack<>();

        // Traverse from right to left
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

                String combined = t1 + t2 + c;
                st.push(combined);
            }
        }

        return st.pop();
    }
}
