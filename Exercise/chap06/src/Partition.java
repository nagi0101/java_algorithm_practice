import java.util.Scanner;

public class Partition {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void partition(int[] a, int n) {
        int pl = 0;
        int pr = n - 1;
        int x = a[n / 2];

        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr--;
            if (pl <= pr)
                swap(a, pl++, pr--);
        } while (pl <= pr);


        System.out.println("Pivot is " + x);

        System.out.println("Group under the pivot");
        for (int i = 0; i <= pl - 1; i++)
            System.out.print(a[i] + " ");
        System.out.println();
        if (pl > pr + 1) {
            System.out.println("Group equals to the pivot");
            for (int i = pr + 1; i <= pl - 1; i++)
                System.out.print(a[i] + " ");
            System.out.println();
        }
        System.out.println("Group over the pivot");
        for (int i = pr + 1; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("Split the array");
        System.out.print("Number of items : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }
        partition(x, nx);
    }
}
