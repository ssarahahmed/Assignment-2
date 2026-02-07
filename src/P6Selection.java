import java.util.Arrays;

public class P6Selection implements SortingAlgorithm {
    public int[] sorty(int[] input) {
        if (input.length <= 1) {
            return input;
        }
        int[] A = Arrays.copyOf(input, input.length);


        for (int i = 0; i < A.length; i++) {
            int minIndex = i;
            for (int j = i; j < A.length; j++) {
                if (A[j] < A[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = A[i];
            A[i] = A[minIndex];
            A[minIndex] = tmp;
        }
        return A;
    }

    public static void main (String[]args){
        int A[] = {0, 1, 4, 3, 5, 3, 1, 7, 8, 1};
        System.out.println("Original array A: " + Arrays.toString(A));

        SortingAlgorithm sorted = new P6Selection();
        System.out.println("Sorted array A: " + Arrays.toString(sorted.sorty(A)));
    }
}
