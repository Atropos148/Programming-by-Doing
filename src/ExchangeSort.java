import java.util.Random;

public class ExchangeSort {
    public static void exchange_sort(int[] a) {
        for (int leftIndex = 0; leftIndex < a.length; leftIndex++) {
            for (int rightIndex = leftIndex + 1; rightIndex < a.length; rightIndex++) {
                if (a[leftIndex] > a[rightIndex]) {
                    // swap the values in two slots
                    int tempMovingSlot = a[leftIndex];
                    a[leftIndex] = a[rightIndex];
                    a[rightIndex] = tempMovingSlot;
                }
            }
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
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
        exchange_sort(arr);

        // Display it again to confirm that it's sorted
        System.out.print("after : ");
        for (i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}