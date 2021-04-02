import java.util.Arrays;
import java.util.Scanner;

public class p231_10 {
    static void swap(int[] a, int idx1, int idx2) {
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    static void quickSortMain(int[] a, int left, int right) {
        int pivot = a[(left + right) / 2];

        int pl = left;
        int pr = right;


        do {
            while (pivot > a[pl]) pl++;
            while (pivot < a[pr]) pr--;
            if (pl <= pr)
                swap(a, pl++, pr--);
        } while (pl <= pr);

        if (left < pr) quickSortMain(a, left, pr);
        if (right > pl) quickSortMain(a, pl, right);
    }

    static void quickSort(int[] a, int n) {
        int left = 0;
        int right = n - 1;

        quickSortMain(a, left, right);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("Number of items : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            x[i] = (int) (Math.random() * 100);
        }

        System.out.print("Before : ");
        for (int i : x)
            System.out.printf("%2d ", i);
        System.out.println();

        quickSort(x, nx);

        System.out.println("Ascending ordered.");
        System.out.print("After  : ");
        for (int i : x)
            System.out.printf("%2d ", i);
    }
}
