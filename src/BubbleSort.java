import java.util.Random;

public class BubbleSort {
    public static void bubble_sort(int[] a) {
        // Your code goes here
        if (a.length > 1) {
            boolean swapped = true;

            while (swapped) {
                swapped = false;
                for (int i = 0; i < a.length; i++) {
                    if (i + 1 < a.length && a[i] > a[i + 1]) {
                        int tempSpot = a[i];
                        a[i] = a[i + 1];
                        a[i + 1] = tempSpot;
                        swapped = true;
                    }
                }
            }
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
        bubble_sort(arr);

        // Display it again to confirm that it's sorted
        System.out.print("after : ");
        for (i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
