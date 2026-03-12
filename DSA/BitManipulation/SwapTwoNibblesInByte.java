package DSA.BitManipulation;

/*
notes:

this swaps the two 4-bit halves (nibbles) of a byte using bitwise operations. 
a byte has 8 bits, so it can be split into two nibbles: 
the left nibbleand the right nibble.

we use two bitmasks in this solution :
0x0F : 00001111
0xF0 : 11110000

first (n & 0x0F) extracts the right nibble and shifts it left by 4 bits 
so it becomes the new left nibble.

then (n & 0xF0) extracts the left nibble and shifts it right by 4 bits 
so it becomes the new right nibble.

finally both parts are combined using bitwise OR to form the swapped result.
*/

public class SwapTwoNibblesInByte {

    static int swapNibbles(int n) {
        return ((n & 0x0F) << 4) | ((n & 0xF0) >> 4);
    }

    public static void main(String[] args) {
        int num = 100;

        int result = swapNibbles(num);

        System.out.println("Original number: " + num);
        System.out.println("After swapping nibbles: " + result);
    }
}
