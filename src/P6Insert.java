import java.util.Arrays;

public class P6Insert implements SortingAlgorithm {

    public int[] sorty(int[] input) {
        if (input.length <= 1) {
            return input;
        }
        int[] A = Arrays.copyOf(input, input.length);
        for (int p = 1; p < A.length; p++) {
            int tmp = A[p];
            int j;
            for (j = p; j > 0 && tmp < A[j - 1]; j--) {
                A[j] = A[j - 1];
            }
            A[j] = tmp;
        }
        return A;
    }
    public static void main (String[]args){
        int A[] = {0, 1, 4, 3, 5, 3, 1, 7, 8, 1};
        System.out.println("Original array A: " + Arrays.toString(A));

        SortingAlgorithm sorted = new P6Insert();
        System.out.println("Sorted array A: " + Arrays.toString(sorted.sorty(A)));
    }
}

