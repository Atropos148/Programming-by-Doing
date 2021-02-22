public class GivingAnArrayABunchOfValuesAtOnce {
    public static void main(String[] args) {
        String[] arr1 = { "alpha", "bravo", "charlie" };

        System.out.print("The first array is filled with the following values:\n\t");
        for (int i = 0; i < arr1.length; i++)
            System.out.print(arr1[i] + " ");
        System.out.println();

    }
}