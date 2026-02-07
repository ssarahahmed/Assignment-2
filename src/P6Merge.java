import java.util.Arrays;

public class P6Merge implements SortingAlgorithm {
    public int[] sorty(int[] input) {
        if (input.length <= 1) {
            return input;
        }
        int[] A = Arrays.copyOf(input, input.length);
        mergeSort(A, 0, A.length - 1);
        return A;
    }

    private void mergeSort(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int mid = (startIndex + endIndex) / 2;
            mergeSort(array, startIndex, mid);
            mergeSort(array, mid + 1, endIndex);
            merge(array, startIndex, mid, endIndex);
        }
    }

    private void merge(int[] array, int leftFirst, int leftLast, int rightLast) {
        int mergedSize = rightLast - leftFirst + 1;
        int[] mergedNumbers = new int[mergedSize];
        int mergePos = 0;
        int leftPos = leftFirst;
        int rightPos = leftLast + 1;

        while (leftPos <= leftLast && rightPos <= rightLast) {
            if (array[leftPos] <= array[rightPos]) {
                mergedNumbers[mergePos] = array[leftPos];
                leftPos++;
            } else {
                mergedNumbers[mergePos] = array[rightPos];
                rightPos++;
            }
                mergePos++;
        }
        while (leftPos <= leftLast) {
            mergedNumbers[mergePos] = array[leftPos];
            leftPos++;
            mergePos++;
        }

        while (rightPos <= rightLast) {
            mergedNumbers[mergePos] = array[rightPos];
            rightPos++;
            mergePos++;
        }
        for (mergePos = 0; mergePos < mergedSize; mergePos++) {
            array[leftFirst + mergePos] = mergedNumbers[mergePos];
        }

    }

    public static void main(String[] args) {
        int A[] = {0, 1, 4, 3, 5, 3, 1, 7, 8, 1};
        System.out.println("Original array A: " + Arrays.toString(A));

        SortingAlgorithm sort = new P6Merge();
        System.out.println("Sorted array A: " + Arrays.toString(sort.sorty(A)));
    }
}
