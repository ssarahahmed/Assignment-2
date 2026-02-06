import java.util.Arrays;

public class P6Bubble {

    public static void bubbleSort(int[] A){
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = 0; j < A.length - 1 - i; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }

    }
    public static void main(String[] args){
        int A[] = {0, 1, 4, 3, 5, 3, 1, 7, 8, 1};
        System.out.println("Original array A: " + Arrays.toString(A) );
        bubbleSort(A);
        System.out.println("Sorted array A: " + Arrays.toString(A) );
    }
}
