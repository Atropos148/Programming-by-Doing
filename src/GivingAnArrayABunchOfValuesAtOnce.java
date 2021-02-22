public class GivingAnArrayABunchOfValuesAtOnce {
    public static void main(String[] args) {
        String[] arr1 = { "alpha", "bravo", "charlie", "delta", "echo" };

        System.out.printf("The first array is filled with the following values:%n  ");
        for (int i = 0; i < arr1.length; i++)
            System.out.print(arr1[i] + " ");
        System.out.println();

        int[] arr2 = { 12, 24, 36, 48, 60 };

        System.out.printf("The second array is filled with the following values:%n  ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
    }
}