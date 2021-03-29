import java.util.Scanner;

public class p216_07 {
    static void insertionSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int j;
            a[0] = a[i];
            for (j = i; a[j - 1] > a[0]; j--) {
                a[j] = a[j - 1];
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("Bubble Sort(v1)");
        System.out.print("Number of items : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx + 1];

        for (int i = 1; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        insertionSort(x, nx);

        System.out.println("Ascending ordered.");
        for (int i = 1; i < nx; i++)
            System.out.println("x[" + i + "] = " + x[i]);
    }
}
