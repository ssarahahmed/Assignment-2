import java.util.Random;

public class P7Tester {
    SortingAlgorithm sa;

    public P7Tester(SortingAlgorithm sa) {
        this.sa = sa;
    }

    public long singleTest(int size) {
        int[] A = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            A[i] = random.nextInt(10000);
        }
        long startT = System.nanoTime();
        sa.sorty(A);
        long endT = System.nanoTime();
        return (endT - startT) / 1000000;
    }
public void test(int iterations, int size){
        double totalT = 0;
        for(int i = 0; i < iterations; i++){
            totalT += singleTest(size);
        }
        double avgT = totalT / iterations;
        System.out.println("Average time = " + avgT + " milliseconds");
}
public static void main(String[] args) {
    int size = 1000;
    int iterations = 10;

    SortingAlgorithm algs[] = {
            new P6Bubble(),
            new P6Insert(),
            new P6Quick(),
            new P6Merge(),
            new P6Selection(),
            new P6Shell(),
    };

    String[] sorts = {
            "BubbleSort",
            "InsertionSort",
            "SelectionSort",
            "ShellSort",
            "QuickSort",
            "MergeSort"
    };

    System.out.println("Test results of " + iterations + " iterations of sorting an array of size " + size + ": ");
    for (int i = 0; i < algs.length; i++) {
        P7Tester tester = new P7Tester(algs[i]);
        double totalT = 0;
        for (int j = 0; j < iterations; j++) {
            totalT += tester.singleTest(size);
        }
        double avgT = totalT / iterations;
        System.out.println(sorts[i] + ": " + avgT + " milliseconds");
    }

}
    }