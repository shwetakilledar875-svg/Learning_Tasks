
public class Dsa1 {
    public static void main(String[] args) {
        int[] arr = {3, 7, 2, 9, 5};
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        System.out.println("Max: " + max);
    }
}