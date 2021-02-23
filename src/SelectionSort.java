import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    public static void selection_sort(int[] a) {
        // Your code goes here
        int unsortedIndex = 0;
        for (int i = 0; i < a.length; i++) {
            int[] unsortedArray = Arrays.copyOfRange(a, unsortedIndex, a.length);

            int tempSlot = a[unsortedIndex];

            // smallest defaults to 10,000,000 to make sure it catches any number
            int smallestNumber = 10000000;
            int rollingIndex = 0;
            int smallestIndex = 0;

            for (int unsortedNumber : unsortedArray) {
                if (unsortedNumber < smallestNumber) {
                    smallestNumber = unsortedNumber;
                    smallestIndex = rollingIndex;
                }
                rollingIndex++;
            }

            a[unsortedIndex] = unsortedArray[smallestIndex];
            a[smallestIndex + unsortedIndex] = tempSlot;

            unsortedIndex++;
        }

    }

    public static void swap(int[] a, int i, int j) {
        // Your code goes here
    }

    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = new int[10];
        int i;

        // Fill up the array with random numbers
        for (i = 0; i < arr.length; i++)
            arr[i] = 1 + r.nextInt(100);

        // Display it
        System.out.print("before: ");
        for (i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();

        // Sort it
        selection_sort(arr);

        // Display it again to confirm that it's sorted
        System.out.print("after : ");
        for (i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}