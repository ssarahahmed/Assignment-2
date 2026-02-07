import java.util.Arrays;

public class P6Quick implements SortingAlgorithm{

    public int[] sorty(int[] input) {
        if (input.length <= 1) {
            return input;
        }
        int[] A = Arrays.copyOf(input, input.length);
        quickSort(A, 0, A.length - 1);
        return A;
    }
    private void quickSort(int[] array, int lowIndex, int highIndex){
        if(highIndex <= lowIndex){
            return;
        }
        int lowEndIndex = partition(array, lowIndex, highIndex);
        quickSort(array, lowIndex, lowEndIndex);
        quickSort(array, lowEndIndex + 1, highIndex);
    }
    private int partition(int[] array, int lowIndex, int highIndex) {
        int midpoint = lowIndex + (highIndex - lowIndex) / 2;
        int pivot = array[midpoint];
        boolean done = false;
        while (!done) {
            while (array[lowIndex] < pivot) {
                lowIndex++;
            }
            while (pivot < array[highIndex]) {
                highIndex--;
            }
            if (lowIndex >= highIndex) {
                done = true;
            } else {
                int temp = array[lowIndex];
                array[lowIndex] = array[highIndex];
                array[highIndex] = temp;
                lowIndex++;
                highIndex--;
            }
        }
        return highIndex;
    }
    public static void main (String[]args){
        int A[] = {0, 1, 4, 3, 5, 3, 1, 7, 8, 1};
        System.out.println("Original array A: " + Arrays.toString(A));

        SortingAlgorithm sort = new P6Quick();
        System.out.println("Sorted array A: " + Arrays.toString(sort.sorty(A)));
    }
}


