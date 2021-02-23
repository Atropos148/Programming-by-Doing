public class SortingValues {
    public static void main(String[] args) {
        int[] arr = { 45, 87, 39, 32, 93, 86, 12, 44, 75, 50 };

        // Display the original (unsorted values)
        System.out.print("before: ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();

        // Swap the values around to put them ascending order.

        for (int leftIndex = 0; leftIndex < arr.length; leftIndex++) {
            for (int rightIndex = leftIndex + 1; rightIndex < arr.length; rightIndex++) {
                if (arr[leftIndex] > arr[rightIndex]) {
                    // swap the values in two slots
                    int tempMovingSlot = arr[leftIndex];
                    arr[leftIndex] = arr[rightIndex];
                    arr[rightIndex] = tempMovingSlot;
                }
            }
        }

        // Display the values again, now (hopefully) sorted.
        System.out.print("after : ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}