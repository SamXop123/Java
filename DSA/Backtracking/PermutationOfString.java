package DSA.Strings;

import java.util.*;

// backtracking and swapping

public class Permutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        
        char c[] = s.toCharArray();
        permutation(c, 0);

        sc.close();
    }

    public static void permutation(char[] c, int fi) {
        if(fi == c.length-1) {
            System.out.println(String.valueOf(c));
            return;
        }

        for(int i = fi; i < c.length; i++) {
            swap(c, fi, i);
            permutation(c, fi+1);
            swap(c, fi, i);
        }
    }

    public static void swap(char a[], int start, int end) {
        char temp = a[start];
        a[start] = a[end];
        a[end] = temp;
    }
}
