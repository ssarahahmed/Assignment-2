import java.util.Arrays;

public class P6Bubble implements SortingAlgorithm {

    public int[] sorty(int[] input) {
        if(input.length <=1){
            return input;
        }
        int[] A = Arrays.copyOf(input, input.length);
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = 0; j < A.length - 1 - i; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
        return A;
    }

        public static void main (String[]args){
            int A[] = {0, 1, 4, 3, 5, 3, 1, 7, 8, 1};
            System.out.println("Original array A: " + Arrays.toString(A));

            SortingAlgorithm sorted = new P6Bubble();
            System.out.println("Sorted array A: " + Arrays.toString(sorted.sorty(A)));
        }
    }



