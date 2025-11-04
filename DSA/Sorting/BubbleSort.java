package DSA.Sorting;

/*
notes:
bubble sort just keeps swapping adjacent elements if they are in the wrong order. 
after each pass, the largest element gets pushed to the end like a bubble rising up, 
so the inner loop gets shorter every time. 
it’s simple but slow with O(n^2) time complexity since we compare pairs repeatedly. 
still good for understanding how basic sorting works.
*/

public class BubbleSort {
    public static void main(String[] args) {

        int[] arrBubble = {1,8,2,9,5,6,1,7};

        for (int i = 0; i < arrBubble.length - 1; i++) {
            for (int j = 0; j < arrBubble.length - i - 1; j++) {
                if (arrBubble[j] > arrBubble[j + 1]) {
                    int temp = arrBubble[j];
                    arrBubble[j] = arrBubble[j + 1];
                    arrBubble[j + 1] = temp;
                }
            }
        }

        System.out.println("Sorted array:");
        for (int val : arrBubble) {
            System.out.print(val + " ");
        }
        System.out.println();

    }
}
