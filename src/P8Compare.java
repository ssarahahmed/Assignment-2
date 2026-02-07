import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class P8Compare {


    public static void main(String[] args) {
        int iterations = 20;
        int[] sizes = {100, 500, 1000, 2000, 10000, 20000, 75000, 150000};
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("PerformanceReport"));

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

            for (int a = 0; a < algs.length; a++) {
                writer.println("Sorting Algorithm: " + sorts[a]);



                for (int size : sizes) {
                    long totalT = 0;
                    for (int i = 0; i < iterations; i++) {
                        int[] A = new int[size];
                        Random random = new Random();
                        for (int j = 0; j < size; j++) {
                            A[j] = random.nextInt(10000);
                        }
                        long startT = System.nanoTime();
                        algs[a].sorty(A);
                        long endT = System.nanoTime();
                        totalT += (endT - startT);
                    }

                    double avgT = (totalT / iterations / 1000000);
                    writer.println(size + " elements have been sorted in " + avgT + "milliseconds(avg)");
                }
                writer.println();
            }
            writer.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }}