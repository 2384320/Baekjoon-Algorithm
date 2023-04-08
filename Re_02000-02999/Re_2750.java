import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        quickSort(array, 0, n-1);

        for (int i = 0; i < n; i++) {
            bw.write(array[i] + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static void quickSort(int[] array, int start, int end) {
        int part = partition(array, start, end);
        if (start < part - 1) quickSort(array, start,part - 1);
        if (end > part) quickSort(array, part, end);
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[(start + end) / 2];
        while (start <= end) {
            while (array[start] < pivot) start++;
            while (array[end] > pivot) end--;
            if (start <= end) {
                swap(array, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
        return;
    }
}