package Ex2;

import java.util.Arrays;

public class SortingApp {
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 6, 1, 9};

        SortContext context = new SortContext();

        context.setStrategy(new BubbleSort());
        context.sortArray(arr);
        System.out.println("Bubble Sort: " + Arrays.toString(arr));

        context.setStrategy(new SelectionSort());
        context.sortArray(arr);
        System.out.println("Selection Sort: " + Arrays.toString(arr));

        class InsertionSort implements SortingStrategy {
            @Override
            public void sort(int[] arr) {
                int n = arr.length;
                for (int i = 1; i < n; i++) {
                    int key = arr[i];
                    int j = i - 1;
                    while (j >= 0 && arr[j] > key) {
                        arr[j + 1] = arr[j];
                        j--;
                    }
                    arr[j + 1] = key;
                }
            }
        }

        context.setStrategy(new InsertionSort());
        context.sortArray(arr);
        System.out.println("Insertion Sort: " + Arrays.toString(arr));
    }
}
