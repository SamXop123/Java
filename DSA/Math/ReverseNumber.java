package DSA.Math;

/*
notes:
this reverses a number by taking the last digit using n % 10 and 
adding it to rev after shifting rev left by one digit. 
each step removes the last digit from n by dividing it by 10. 
the loop continues until n becomes 0. 
basic math trick but useful for palindrome checks and number manipulation problems.
*/

public class ReverseNumber {
    public static int reverse(int n) {
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(reverse(12345));
    }
}

