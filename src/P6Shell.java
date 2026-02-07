import java.util.Arrays;

public class P6Shell implements SortingAlgorithm{
    public int[] sorty(int[] input) {
        if (input.length <= 1) {
            return input;
        }
        int[] A = Arrays.copyOf(input, input.length);
        int n = A.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int tmp = A[i];
                int j;
                for (j = i; j >= gap && A[j - gap] > tmp; j -= gap) {
                    A[j] = A[j - gap];
                }
                A[j] = tmp;
            }
        }
        return A;
    }

    public static void main (String[]args){
        int A[] = {0, 1, 4, 3, 5, 3, 1, 7, 8, 1};
        System.out.println("Original array A: " + Arrays.toString(A));

        SortingAlgorithm sort = new P6Shell();
        System.out.println("Sorted array A: " + Arrays.toString(sort.sorty(A)));
    }
}